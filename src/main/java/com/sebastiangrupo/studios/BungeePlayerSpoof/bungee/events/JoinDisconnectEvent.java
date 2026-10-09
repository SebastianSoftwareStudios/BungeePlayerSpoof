package com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.events;

import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import com.sebastiangrupo.studios.BungeePlayerSpoof.PlayerCounter;

public class JoinDisconnectEvent implements Listener {
    public final PlayerCounter counter;
    public JoinDisconnectEvent(PlayerCounter counter) {
        this.counter = counter;
    }

    @EventHandler
    public void onConnect(PostLoginEvent event) {
        counter.add(1);
    }

    @EventHandler
    public void onDisconnect(PlayerDisconnectEvent event) {
        counter.subtract(1);
    }
}
