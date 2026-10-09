package com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands.sub;

import com.sebastiangrupo.studios.BungeePlayerSpoof.PlayerCounter;
import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands.SubCommand;
import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.utils.BungeeSend;
import net.md_5.bungee.api.CommandSender;

public class RemovePlayers implements SubCommand {
    private final PlayerCounter counter;
    public RemovePlayers(PlayerCounter counter) {
        this.counter = counter;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length != 1) {
            BungeeSend.send(sender, "Usage: /playerspoof remove <number>");
            return;
        }

        int subtractpl;

        try {
            subtractpl = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            BungeeSend.send(sender, "You must put a valid number!");
            return;
        }

        if(counter.subtract(subtractpl)) {
            BungeeSend.send(sender, "Removed " + subtractpl + " players successfully!");
        } else {
            BungeeSend.send(sender, "Could not remove " + subtractpl + " players, please use a valid number between 1 and " + counter.get() + ".");
        }
    }
}
