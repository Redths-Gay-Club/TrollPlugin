package me.redth.trollplugin;

import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Demo implements CommandBase {
    @Override
    public String getLabel() {
        return "demo";
    }

    @Override
    public void execute(CommandSender sender, Player player) {
        CraftPlayer craftPlayer = (CraftPlayer) player;
        PacketPlayOutGameStateChange demo = new PacketPlayOutGameStateChange(5, 0);
        craftPlayer.getHandle().playerConnection.sendPacket(demo);
    }
}
