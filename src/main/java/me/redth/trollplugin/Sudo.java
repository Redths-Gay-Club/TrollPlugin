package me.redth.trollplugin;

import org.apache.commons.lang3.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sudo implements CommandBase {
    @Override
    public String getLabel() {
        return "sudo";
    }

    @Override
    public void execute(CommandSender sender, Player player) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("/" + getLabel() + " <player> <message>");
            return false;
        }

        if ("*".equals(args[0])) {
            for (Player target : Bukkit.getOnlinePlayers()) {
                execute(target, args);
            }
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target != null) {
            execute(target, args);
            return true;
        }

        sender.sendMessage("offline or out of existence");
        return false;
    }

    public void execute(Player player, String[] args) {
        String[] message = ArrayUtils.subarray(args, 1, args.length);
        player.chat(String.join(" ", message));
    }
}
