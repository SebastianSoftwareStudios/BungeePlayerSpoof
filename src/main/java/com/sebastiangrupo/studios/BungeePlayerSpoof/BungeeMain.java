package com.sebastiangrupo.studios.BungeePlayerSpoof;

// all commented imports are just for the config file thing, dont mind them :)
import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands.PlayerSpoofCommand;
import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.commands.sub.*;
import com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.events.*;
import net.md_5.bungee.api.plugin.Plugin;
// import java.io.InputStream;
// import java.io.File;
// import java.io.IOException;
// import net.md_5.bungee.config.Configuration;
// import net.md_5.bungee.config.ConfigurationProvider;
// import net.md_5.bungee.config.YamlConfiguration;
// import java.io.OutputStream;
// import java.io.FileOutputStream;
// import com.google.common.io.ByteStreams;

public final class BungeeMain extends Plugin {
    @Override
    public void onEnable() {
        // This is a test for the config file, in development
        //
        // Configuration configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        // ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, new File(getDataFolder(), "config.yml"));
        // if (!getDataFolder().exists()) {
        //     getDataFolder().mkdir();
        // }
        // File configFile = new File(getDataFolder(), "config.yml");
        // if (!configFile.exists()) {
        //     try {
        //         configFile.createNewFile();
        //         try (InputStream is = getResourceAsStream("config.yml");
        //              OutputStream os = new FileOutputStream(configFile)) {
        //            ByteStreams.copy(is, os);
        //         }
        //     } catch (IOException e) {
        //         throw new RuntimeException("Unable to create configuration file", e);
        //     }
        // }
        PlayerCounter counter = new PlayerCounter();
        PlayerSpoofCommand command = new PlayerSpoofCommand();
        command.register("add", new AddPlayers(counter));
        command.register("remove", new RemovePlayers(counter));
        command.register("set", new SetPlayer(counter));
        command.register("step", new SetPlayerStep(counter));
        command.register("drop", new DropPlayers(counter));
        getProxy().getPluginManager().registerCommand(this, command);
        getProxy().getPluginManager().registerListener(this, new JoinDisconnectEvent(counter));
        getProxy().getPluginManager().registerListener(this, new PingEvent(counter));
        
        getLogger().info("PlayerSpoofer loaded");
    }




    @Override
    public void onDisable() {
        getLogger().info("PlayerSpoofer unloaded");
    }
}

