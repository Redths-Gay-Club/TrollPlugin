package me.redth.trollplugin;

import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Earrape implements CommandBase {
    @Override
    public String getLabel() {
        return "earrape";
    }

    @Override
    public void execute(CommandSender sender, Player player) {
        for (int i = 0; i < 10; i++) {
            player.playSound(player.getLocation(), Sound.ENDERDRAGON_DEATH, 10F, 0F);
            player.playSound(player.getLocation(), Sound.EXPLODE, 10F, 0F);
        }
    }
}
