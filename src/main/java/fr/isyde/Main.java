package fr.isyde;

import fr.isyde.Listeners.joinPlayer;
import fr.isyde.Listeners.leftPlayer;
import fr.isyde.Listeners.pvpPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    public List<Location> LocArena = new ArrayList<>();
    public List<Location> LocArenaFinal = new ArrayList<>();
    public List<Player> PlayerInGame = new ArrayList<>();

    private State state;

    @Override
    public void onEnable() {

        addLocation();

        System.out.println("Le plugin PvpSwap viens de ce lancer");




        setState(State.WAITING);

        getServer().getPluginManager().registerEvents(new joinPlayer(this),this);
        getServer().getPluginManager().registerEvents(new leftPlayer(this),this);
        getServer().getPluginManager().registerEvents(new pvpPlayer(this),this);


        // Plugin startup logic

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public void setState(State state){
        this.state = state;
    }

    public boolean isState(State state){
        return this.state == state;
    }

    public List<Player> getPlayerlistInGame(){
        return PlayerInGame;

    }

    public void setPlayerListInGame(Player p){

        PlayerInGame.add(p);



    }

    public List<Location> getLocationArena(){

        return LocArena;
    }

    private void addLocation() {

        LocArena.add(0, new Location(Bukkit.getWorld("world"), 8, 56, 11.4, 0.4f, 12.2f));
        LocArena.add(1, new Location(Bukkit.getWorld("world"), 15.5, 56, 11.4, 0.4f, 12.2f));
        LocArena.add(2, new Location(Bukkit.getWorld("world"), 8, 56, 26.4, 177.6f, -2.2f));
        LocArena.add(3, new Location(Bukkit.getWorld("world"), 15.5, 56, 26.4, 177.6f, -2.2f));

        LocArenaFinal.add(0, new Location(Bukkit.getWorld("world"), 42, 56, 11, 3.5f, 4.1f));
        LocArenaFinal.add(1, new Location(Bukkit.getWorld("world"), 42, 56, 26.4, 177.6f, 0.8f));

    }
}
