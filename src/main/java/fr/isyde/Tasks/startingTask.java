package fr.isyde.Tasks;

import fr.isyde.Main;
import fr.isyde.State;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class startingTask  extends BukkitRunnable {

    private Main main;
    public startingTask(Main main)  {
        this.main = main;
    }




    private int timer = 20;
    @Override
    public void run() {



        //On recupe la liste des joueur :
        List<Player> plist = main.getPlayerlistInGame();



            for (Player p : plist){

                p.setLevel(timer);
            }


            if(timer == 20 ||timer == 10 || timer == 5 ||timer == 4 ||timer == 3 ||timer == 2 ||timer == 1 ){

                Bukkit.broadcastMessage(ChatColor.GREEN+"Début du jeu dans "+timer+"s");


                //Pour jouer des sons
//                for (Player p : plist){
//
//                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,1f,1f);
//                }




            }

            if (timer ==0){
                Bukkit.broadcastMessage(ChatColor.GREEN+"Lancement du PvpiSwap");

// Téléport les joueurs
                for (Player p : plist){

                    int pick = new Random().nextInt(main.getLocationArena().size());
                    p.teleport(main.getLocationArena().get(pick));

                    p.setFoodLevel(20);
                    p.setGameMode(GameMode.SURVIVAL);
                    // Donne une Hache
                    p.getInventory().setItemInMainHand(new ItemStack(Material.IRON_AXE));

                }

                main.setState(State.PLAYING);


                playingTask startPlay = new playingTask(main);
                startPlay.runTaskTimer(main, 0, 20);


                cancel();
            }


            timer--;



    }
}
