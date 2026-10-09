package com.sebastiangrupo.studios.BungeePlayerSpoof.bungee.events;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import com.sebastiangrupo.studios.BungeePlayerSpoof.PlayerCounter;

public class PingEvent implements Listener {
    private final PlayerCounter counter;
    public PingEvent(PlayerCounter counter) {
        this.counter = counter;
    }

    @EventHandler
    public void onPing(ProxyPingEvent event) {
        counter.nextChange();
        ServerPing ping = event.getResponse();
        ServerPing.Players current = ping.getPlayers();
        ping.setPlayers(new ServerPing.Players(current.getMax(), counter.get(), current.getSample()));
        event.setResponse(ping);
    }
}
