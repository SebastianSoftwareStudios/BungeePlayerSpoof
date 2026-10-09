package com.sebastiangrupo.studios.BungeePlayerSpoof;

import com.google.common.eventbus.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.proxy.ProxyServer;
import com.google.inject.Inject;
import org.slf4j.Logger;

public class VelocityMain {
    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public VelocityMain(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialize(ProxyInitializeEvent event) {
        logger.info("Player Spoofed loaded.");
    }
}
