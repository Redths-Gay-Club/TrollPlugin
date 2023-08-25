package me.redth.trollplugin;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kaboom implements CommandBase {
    @Override
    public String getLabel() {
        return "kaboom";
    }

    @Override
    public void execute(CommandSender sender, Player player) {
        player.setVelocity(player.getVelocity().setY(4));
        player.getWorld().strikeLightningEffect(player.getLocation());
    }
}
