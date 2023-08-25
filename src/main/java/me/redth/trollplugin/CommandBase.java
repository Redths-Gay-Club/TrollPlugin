package me.redth.trollplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public interface CommandBase extends TabExecutor {
    String getLabel();

    void execute(CommandSender sender, Player player);

    @Override
    default boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage("/" + getLabel() + " <player>");
            return false;
        }

        if ("*".equals(args[0])) {
            for (Player target : Bukkit.getOnlinePlayers()) {
                execute(sender, target);
            }
            sender.sendMessage("§c[Troll] u /" + getLabel() + "'ed every player...");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target != null) {
            execute(sender, target);
            sender.sendMessage("§c[Troll] u /" + getLabel() + "'ed " + target.getName() + "...");
            return true;
        }

        sender.sendMessage("offline or out of existence");
        return false;
    }

    @Override
    default List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> names = new ArrayList<>();
        if (args.length == 1) {
            String str = args[0].toLowerCase();
            for (Player player : Bukkit.getOnlinePlayers()) {
                String name = player.getName();
                if (name.toLowerCase().startsWith(str)) names.add(name);
            }
            names.add("*");
        }
        return names;
    }
}
