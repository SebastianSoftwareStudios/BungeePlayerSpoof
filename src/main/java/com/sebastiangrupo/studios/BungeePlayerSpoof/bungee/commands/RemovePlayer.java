package com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands;

import com.sebastiangrupo.studios.BungeePlayerSpoof.PlayerCounter;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.utils.BungeeSend;

public class RemovePlayer extends Command {
    private final PlayerCounter counter;
    public RemovePlayer(PlayerCounter counter) {
        super("removeplayer", "bungeeplayerspoof.admin");
        this.counter = counter;
    }

    public void execute(CommandSender sender, String[] args) {
        if(counter.subtract(1)) {
            BungeeSend.send(sender, "Removed 1 players successfully!");
        } else {
            BungeeSend.send(sender, "Could not remove a player sorry.");
        }
    }
}
