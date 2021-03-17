package fr.isyde.Commands;

import fr.isyde.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class addChestCommands implements CommandExecutor {

    private Main main;

    public addChestCommands(Main main) {
        this.main = main;

    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {


            Player p = (Player) sender;
            Location loc = p.getLocation();


            if (args != null) {
                if (args[0].equalsIgnoreCase("final")) {


                    main.setLocArenaFinal(loc);

                    p.sendMessage(ChatColor.GREEN + "Votre location a été ajouté dans la liste des spawns de l'arène final");

                } else if (args[0].equalsIgnoreCase("arena")) {

                    main.setlocArena(loc);
                } else {

                    p.sendMessage(ChatColor.GREEN + "Votre location a été ajouté dans la liste des spawns de l'arène");
                    return false;
                }


            } else {
                p.sendMessage("Veuillez faire /addspawn <arena/final>");

                return false;
            }


        }

        return false;
    }
}

