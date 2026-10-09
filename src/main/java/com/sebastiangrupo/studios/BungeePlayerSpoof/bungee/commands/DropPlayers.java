package com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands;

import com.sebastiangrupo.studios.BungeePlayerSpoof.PlayerCounter;
import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.utils.BungeeSend;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class DropPlayers extends Command {
    private final PlayerCounter counter;
    public DropPlayers(PlayerCounter counter) {
        super("dropPlayers", "bungeeplayerspoof.admin");
        this.counter = counter;
    }

    public void execute(CommandSender sender, String[] args) {
        counter.drop();
        BungeeSend.send(sender, "There's no players now!");
    }
}
