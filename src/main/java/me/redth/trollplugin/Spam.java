package me.redth.trollplugin;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spam implements CommandBase {
    @Override
    public String getLabel() {
        return "spam";
    }

    @Override
    public void execute(CommandSender sender, Player player) {
        StringBuilder str = new StringBuilder("█████████████████████████████████████████████████████████████████████████████████████████████████████████████");
        for (int i = 0; i < 10; i++) {
            player.sendMessage(str.toString());
            str.append("█");
        }
    }
}
