package com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands;

import com.sebastiangrupo.studios.BungeePlayerSpoof.PlayerCounter;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.utils.BungeeSend;

public class AddPlayers extends Command {
    private final PlayerCounter counter;
    public AddPlayers(PlayerCounter counter) {
        super("addPlayers", "bungeeplayerspoof.admin");
        this.counter = counter;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length != 1) {
            BungeeSend.send(sender, "Usage: /addPlayers <number>");
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
