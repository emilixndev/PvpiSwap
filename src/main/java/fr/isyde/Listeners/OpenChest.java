package fr.isyde.Listeners;

import fr.isyde.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class OpenChest implements Listener {



    private  Main main;
    public OpenChest(Main main)  {
        this.main = main;
    }





    @EventHandler
    public void onChest(PlayerInteractEvent event){

        if (event.getClickedBlock().getType().name().equalsIgnoreCase("Chest")) {

            Chest ch = (Chest) event.getClickedBlock().getState();
            ch.getInventory().addItem(new ItemStack(Material.IRON_AXE));
            if(ch.getInventory().isEmpty()){

                ch.getInventory().addItem(new ItemStack(Material.IRON_AXE));

            }else{
                Player p = event.getPlayer();
                p.sendMessage("yo");

            }


        }





    }



}
