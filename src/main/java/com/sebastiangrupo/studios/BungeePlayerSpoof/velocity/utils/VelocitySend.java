package com.sebastiangrupo.studios.BungeePlayerSpoof.velocity.utils;

import com.velocitypowered.api.command.CommandSource;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class VelocitySend {
    static void send(CommandSource source, String message) {
        String prefix = "&c[BungeePlayerSpoof]&f: ";
        source.sendMessage(LegacyComponentSerializer.legacyAmpersand().deserialize(prefix + message));
    }
}
