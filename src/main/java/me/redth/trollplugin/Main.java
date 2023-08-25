package me.redth.trollplugin;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommand(new Crash());
        registerCommand(new Demo());
        registerCommand(new Earrape());
        registerCommand(new FakeOp());
        registerCommand(new Kaboom());
        registerCommand(new Spam());
        registerCommand(new Sudo());
    }

    public void registerCommand(CommandBase command) {
        PluginCommand pluginCommand = getCommand(command.getLabel());
        pluginCommand.setExecutor(command);
        pluginCommand.setTabCompleter(command);
    }
}
