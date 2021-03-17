package fr.isyde;


import fr.isyde.Commands.addChestCommands;
import fr.isyde.Commands.addSpawnCommands;
import fr.isyde.Listeners.OpenChest;
import fr.isyde.Listeners.joinPlayer;
import fr.isyde.Listeners.leftPlayer;
import fr.isyde.Listeners.pvpPlayer;
import fr.isyde.Tasks.startingTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    public List<Location> LocArena = new ArrayList<>();
    public List<Location> LocArenaFinal = new ArrayList<>();
    public List<Player> PlayerInGame = new ArrayList<>();

    // On défénit 3 level de stuff

    /*
    Level one => stuff de base dans les coffre au spawn et pas loin
    Level two => stuff dans les coffre du mid
    Level three => stuff dans les coffre du spawn et alentour de l'arène final
    Level four  => stuff au mid de l'arène final



     */
    public List<Location> ChestLevelOne = new ArrayList<>();


    public List<Location> ChestLevelTwo = new ArrayList<>();


    public List<Location> ChestLevelThree = new ArrayList<>();

    public List<Location> ChestLevelFour = new ArrayList<>();




    //Nombre de joueur pour démarrer la partie
    public int nbjoueur = 2;


    private State state;

    @Override
    public void onEnable() {

        addLocation();

        System.out.println("Le plugin PvpSwap viens de ce lancer");




        setState(State.WAITING);

        getServer().getPluginManager().registerEvents(new joinPlayer(this),this);
        getServer().getPluginManager().registerEvents(new leftPlayer(this),this);
        getServer().getPluginManager().registerEvents(new pvpPlayer(this),this);
        getServer().getPluginManager().registerEvents(new OpenChest(this),this);

        getCommand("addspawn").setExecutor(new addSpawnCommands(this));
        getCommand("addchest").setExecutor(new addChestCommands(this));



//On peux faire spawn des entité
        //Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"),0,56,0), EntityType.BLAZE);




        // Plugin startup logic

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    // Pour récup et recevoir les state
    public void setState(State state){
        this.state = state;
    }

    public boolean isState(State state){
        return this.state == state;
    }


    // Pour récup et set les joueurs de la partie

    public List<Player> getPlayerlistInGame(){
        return PlayerInGame;

    }

    public void setPlayerListInGame(Player p){

        PlayerInGame.add(p);



    }


    // pour recup et set les loc de l'arène
    public List<Location> getLocationArena(){

        return LocArena;
    }



    public void setlocArena(Location l){

        LocArena.add(l);



    }


    // pour recup et set les loc de l'arène final

    public void setLocArenaFinal(Location l){

        LocArenaFinal.add(l);



    }


    // ajout des location
    private void addLocation() {

        LocArena.add(0, new Location(Bukkit.getWorld("world"), 8, 56, 11.4, 0.4f, 12.2f));
        LocArena.add(1, new Location(Bukkit.getWorld("world"), 15.5, 56, 11.4, 0.4f, 12.2f));
        LocArena.add(2, new Location(Bukkit.getWorld("world"), 8, 56, 26.4, 177.6f, -2.2f));
        LocArena.add(3, new Location(Bukkit.getWorld("world"), 15.5, 56, 26.4, 177.6f, -2.2f));

        LocArenaFinal.add(0, new Location(Bukkit.getWorld("world"), 42, 56, 11, 3.5f, 4.1f));
        LocArenaFinal.add(1, new Location(Bukkit.getWorld("world"), 42, 56, 26.4, 177.6f, 0.8f));

    }

// Permet de cancel la commande

    public void cancelTestRunnable(BukkitTask testRunnable) {
        testRunnable.cancel();
    }





    // Ajout des get et set de chaque coffre
//
//
//    public List<Location> getChestList(int nb) {
//
//        switch (nb) {
//
//            case 1:
//                return ChestLevelOne;
//            break;
//
//            case 2:
//                return ChestLevelTwo;
//            break;
//            case 3:
//
//                return ChestLevelThree;
//            break;
//
//            case 4:
//                return ChestLevelFour;
//            break;
//
//            default:
//                return LocArena;
//                break;
//
//        }
//
//
//
//
//
//    }




}
