package com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;

public class BungeeSend {
    public static void send(CommandSender sender, String message) {
        String prefix = "&c[BungeePlayerSpoof]&f: ";
        sender.sendMessage(TextComponent.fromLegacy(ChatColor.translateAlternateColorCodes('&', prefix + message)));
    }
}
