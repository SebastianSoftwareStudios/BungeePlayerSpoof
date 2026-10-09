package com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands;

import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.utils.BungeeSend;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class PlayerSpoofCommand extends Command {
    private final Map<String, SubCommand> subCommands = new LinkedHashMap<>();
    public PlayerSpoofCommand() {
        super("playerspoof", "bungeeplayerspoof.admin", "bps");
    }

    public void register(String name, SubCommand subCommand) {
        subCommands.put(name, subCommand);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            BungeeSend.send(sender, "Usage: /playerspoof <" + String.join("|", subCommands.keySet()) + ">");
            return;
        }

        SubCommand sub = subCommands.get(args[0].toLowerCase(Locale.ROOT));
        if (sub == null) {
            BungeeSend.send(sender, "&cUnknown command.");
            return;
        }
        sub.execute(sender, Arrays.copyOfRange(args, 1, args.length));
    }
}
