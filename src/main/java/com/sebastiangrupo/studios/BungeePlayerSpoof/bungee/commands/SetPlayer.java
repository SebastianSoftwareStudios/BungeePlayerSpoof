package com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands;

import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.utils.BungeeSend;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import com.sebastiangrupo.studios.BungeePlayerSpoof.PlayerCounter;

public class SetPlayer extends Command {
    private final PlayerCounter counter;
    public SetPlayer(PlayerCounter counter) {
        super("setplayer", "bungeeplayerspoof.admin");
        this.counter = counter;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length != 1) {
            BungeeSend.send(sender, "Usage: /setplayer <number>");
            return;
        }
        int playersset;

        try {
            playersset = Integer.parseInt(args[0]);
        } catch(NumberFormatException e) {
            BungeeSend.send(sender, "Please put a valid number.");
            return;
        }

        if(counter.set(playersset)) {
            BungeeSend.send(sender, "Successfully set the player count to " + playersset + "!");
        } else {
            BungeeSend.send(sender, "Could not set the player count to " + playersset + ". Please provide a valid number.");
        }
    }
}
