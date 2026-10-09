package com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands;

import com.sebastiangrupo.studios.BungeePlayerSpoof.PlayerCounter;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.utils.BungeeSend;

public class AddPlayer extends Command {
    private final PlayerCounter counter;
    public AddPlayer(PlayerCounter counter) {
        super("addPlayer", "bungeeplayerspoof.admin");
        this.counter = counter;
    }
    public void execute(CommandSender sender, String[] args) {
        if(counter.add(1)) {
            BungeeSend.send(sender, "Added 1 Player successfully!");
        } else {
            BungeeSend.send(sender, "Could not add a player, sorry :(");
        }
    }
}
