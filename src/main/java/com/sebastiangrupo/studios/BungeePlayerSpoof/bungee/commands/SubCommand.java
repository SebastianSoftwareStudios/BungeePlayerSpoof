package com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands;

import net.md_5.bungee.api.CommandSender;

public interface SubCommand {
    void execute(CommandSender sender, String[] args);
}
