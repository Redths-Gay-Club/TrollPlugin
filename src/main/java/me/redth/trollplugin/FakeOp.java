package me.redth.trollplugin;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FakeOp implements CommandBase {
    @Override
    public String getLabel() {
        return "fakeop";
    }

    @Override
    public void execute(CommandSender sender, Player player) {
        player.sendMessage("§7§o[" + sender.getName() + ": Opped " + player.getName() + "]");
    }
}
