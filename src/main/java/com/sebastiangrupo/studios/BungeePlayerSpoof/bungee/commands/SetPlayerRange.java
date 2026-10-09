package com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands;


import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.utils.BungeeSend;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import com.sebastiangrupo.studios.BungeePlayerSpoof.PlayerCounter;

public class SetPlayerRange extends Command {
    private final PlayerCounter counter;
    public SetPlayerRange(PlayerCounter counter) {
        super("setplayerrange", "bungeeplayerspoof.admin");
        this.counter = counter;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length != 2) {
            BungeeSend.send(sender, "Usage: /setplayerrange <min> <max>");
            return;
        }

        int setMin;
        int setMax;

        try {
            setMin = Integer.parseInt(args[0]);
            setMax = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            BungeeSend.send(sender, "You must put a valid number!");
            return;
        }

        if (counter.setRange(setMin, setMax)) {
            BungeeSend.send(sender, "New player range set: Minimum " + counter.getMin() + " Maximum " + counter.getMax() + ".");
        } else {
            BungeeSend.send(sender, "Couldn't set the specified range, please provide a valid range.");
        }
    }
}
