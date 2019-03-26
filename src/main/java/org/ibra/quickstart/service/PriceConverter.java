package org.ibra.quickstart.service;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Broadcast;

@ApplicationScoped
public class PriceConverter {

    private static final double CONVERSTION_RATE = .88;
    
    @Incoming("prices")
    @Outgoing("my-data-stream")
    @Broadcast
    public double process(int priceInUsd) {
        
        return priceInUsd * CONVERSTION_RATE;
    }
}
