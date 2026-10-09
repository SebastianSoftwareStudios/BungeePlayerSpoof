package com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands.sub;

import com.sebastiangrupo.studios.BungeePlayerSpoof.PlayerCounter;
import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands.SubCommand;
import net.md_5.bungee.api.CommandSender;
import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.utils.BungeeSend;

public class AddPlayers implements SubCommand {
    private final PlayerCounter counter;
    public AddPlayers(PlayerCounter counter) {
        this.counter = counter;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length != 1) {
            BungeeSend.send(sender, "Usage: /playerspoof add <number>");
            return;
        }
        int addingpl;

        try {
            addingpl = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            BungeeSend.send(sender, "You must put a valid number!");
            return;
        }

        if(counter.add(addingpl)) {
            BungeeSend.send(sender, "Added " + addingpl + " players successfully!");
        } else {
            BungeeSend.send(sender, "Could not add " + addingpl + " players. Please use a valid number greater than 0.");
        }
    }
}
