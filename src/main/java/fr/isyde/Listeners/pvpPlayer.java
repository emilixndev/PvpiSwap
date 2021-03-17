package fr.isyde.Listeners;

import fr.isyde.Main;
import fr.isyde.State;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.concurrent.Delayed;

public class pvpPlayer implements Listener {
    private  Main main;
    public pvpPlayer(Main main)  {
        this.main = main;
    }



@EventHandler
    public void onPvp(EntityDamageByEntityEvent event){

        if (event.getEntity() instanceof Player && main.isState(State.WAITING) || event.getEntity() instanceof Player && main.isState(State.STARTING)){
            
            
            
            event.setCancelled(true);

        }
        
        if (event.getEntity() instanceof Player && main.isState(State.PLAYING) && event.getDamager() instanceof Player){

            Player killer = (Player) event.getDamager();
            Player victim = (Player) event.getEntity();

            if (victim.getHealth()<= event.getDamage()){



                Bukkit.broadcastMessage(ChatColor.RED+"Le joueur "+victim.getDisplayName()+" a été tué par "+killer.getDisplayName());


            }
        }
        
        



    }




    @EventHandler
    public void onDeath(PlayerDeathEvent event){

        event.setDeathMessage("");
        if(main.isState(State.PLAYING)){



            Player p = event.getEntity();



            p.setGameMode(GameMode.SPECTATOR);
            main.getPlayerlistInGame().remove(p);
            p.sendMessage(ChatColor.BLUE+ "Tu as perdu");

            //p.teleport(new Location(p.getWorld(), -24, 56.5,19));

            if(main.getPlayerlistInGame().size()<=1){

                main.setState(State.FINISH);

                Bukkit.broadcastMessage(ChatColor.AQUA+"===============================");
                Bukkit.broadcastMessage(ChatColor.AQUA+"Le vainqueur est "+main.getPlayerlistInGame().get(0).getDisplayName());
                Bukkit.broadcastMessage(ChatColor.AQUA+"===============================");


            }

        }





    }


    @EventHandler
    public void onRespawn(PlayerRespawnEvent event){
        event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), -24, 56.5,19));



    }




}
