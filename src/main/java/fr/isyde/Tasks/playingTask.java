package fr.isyde.Tasks;

import fr.isyde.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class playingTask  extends BukkitRunnable {

    private Main main;
    public playingTask(Main main)  {
        this.main = main;
    }


    private  int timer = 15;
    @Override
    public void run() {

        System.out.println(timer);

        // Si le timer descend à 0
        if (timer == 0){


            // Si il reste 1 plus de 1 joeur
            if(main.getPlayerlistInGame().size()!=1){


                for(Player p : main.getPlayerlistInGame()) {
                    int pick = new Random().nextInt(main.getLocationArena().size());
                    p.teleport(main.getLocationArena().get(pick));
                    cancel();


                }
                playingTask startPlay = new playingTask(main);
                startPlay.runTaskTimer(main, 0, 20);
            }


            cancel();




        }


        timer--;







    }
}
