package fr.isyde.Listeners;

import fr.isyde.Main;
import fr.isyde.State;
import fr.isyde.Tasks.startingTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;

public class leftPlayer implements Listener {


    private  Main main;
    public leftPlayer(Main main )  {
        this.main = main;
    }

//    private startingTask t;
//    public leftPlayer(startingTask t) {
//        this.t = t;
//
//    }


    @EventHandler
    public void onLeft(PlayerQuitEvent event){


        Player p = event.getPlayer();

        if(main.isState(State.WAITING) || main.isState(State.STARTING)){

            List<Player> pa = main.getPlayerlistInGame();

            pa.remove(p);

            event.setQuitMessage(ChatColor.GOLD+p.getDisplayName()+" a quitté la partie ("+main.getPlayerlistInGame().size()+"/"+ Bukkit.getMaxPlayers()+")");

            if(main.getPlayerlistInGame().size()<main.nbjoueur && main.isState(State.STARTING)){

               main.cancelTestRunnable(Bukkit.getServer().getScheduler().getPendingTasks().get(0));
               for(Player pl : main.getPlayerlistInGame()){

                   pl.setLevel(0);
                   Bukkit.broadcastMessage(ChatColor.RED+"Le nombre de joueurs pour commencer la partie est insufisant");
                   main.setState(State.WAITING);


               }


            }
        }

        if(main.isState(State.PLAYING)){

            event.setQuitMessage(null);

        }



    }
}
