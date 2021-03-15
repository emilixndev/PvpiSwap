package fr.isyde.Listeners;

import fr.isyde.Main;
import fr.isyde.State;
import fr.isyde.Tasks.playingTask;
import fr.isyde.Tasks.startingTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.util.io.BukkitObjectInputStream;

import java.util.List;
import java.util.Random;

public class joinPlayer implements Listener {

    private  Main main;
    public joinPlayer(Main Main) {
        this.main = Main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        
        Player p = event.getPlayer();
        // Si le joueur ce connect quand le jeu est en attente
        if(main.isState(State.WAITING) || main.isState(State.STARTING)){
            main.setPlayerListInGame(p);
            event.setJoinMessage(ChatColor.GOLD+p.getDisplayName()+" à rejoint la partie ("+main.getPlayerlistInGame().size()+"/"+Bukkit.getMaxPlayers()+")");
            p.setGameMode(GameMode.ADVENTURE);
            p.getInventory().clear();
            p.setHealth(20);
            p.setFoodLevel(20);
            p.teleport(new Location(p.getWorld(), -24, 56.5,19));
            p.sendMessage(ChatColor.AQUA+"Bienvenue dans le PvpiSwap \nLa partie va bientôt commencer !!!");
        }


        if( main.isState(State.WAITING) && main.getPlayerlistInGame().size()==3){



            main.setState(State.STARTING);
            startingTask start = new startingTask(main);
            start.runTaskTimer(main, 0, 20);















        }





        // Si le jeu à commencer le joueur ce mes en gm 3
        if(main.isState(State.PLAYING )){
            p.setGameMode(GameMode.SPECTATOR);
            p.sendMessage(ChatColor.RED+"Le PvpiSwap à déja start, attend la partie suivante ");
        }












    }














}
//
//
//
// for (Player unJoueur : main.getPlayerlistInGame() ){
//
//
//         int pick = new Random().nextInt(main.getLocationArena().size());
//
//         p.teleport(main.getLocationArena().get(pick));
//
//         }