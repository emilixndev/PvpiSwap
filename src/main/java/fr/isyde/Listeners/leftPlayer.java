package fr.isyde.Listeners;

import fr.isyde.Main;
import fr.isyde.State;
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
    public leftPlayer(Main main)  {
        this.main = main;
    }




    @EventHandler
    public void onLeft(PlayerQuitEvent event){


        Player p = event.getPlayer();

        if(main.isState(State.WAITING)){

            List<Player> pa = main.getPlayerlistInGame();

            pa.remove(p);

            event.setQuitMessage(ChatColor.GOLD+p.getDisplayName()+" a quitté la partie ("+main.getPlayerlistInGame().size()+"/"+ Bukkit.getMaxPlayers()+")");


        }

        if(main.isState(State.PLAYING)){

            event.setQuitMessage(null);

        }



    }
}
