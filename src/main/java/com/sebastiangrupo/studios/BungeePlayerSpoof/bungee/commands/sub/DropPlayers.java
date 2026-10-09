package com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands.sub;

import com.sebastiangrupo.studios.BungeePlayerSpoof.PlayerCounter;
import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands.SubCommand;
import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.utils.BungeeSend;
import net.md_5.bungee.api.CommandSender;

public class DropPlayers implements SubCommand {
    private final PlayerCounter counter;
    public DropPlayers(PlayerCounter counter) {
        this.counter = counter;
    }

    public void execute(CommandSender sender, String[] args) {
        counter.drop();
        BungeeSend.send(sender, "There's no players now!");
    }
}
