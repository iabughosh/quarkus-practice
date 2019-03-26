package org.ibra.quickstart.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.reactivex.Flowable;

@ApplicationScoped
public class PriceGenerator {

    private Random random = new Random();
    
    @Outgoing("generated-price")
    public Flowable<Integer> generate() {
        
        return Flowable.interval(10, TimeUnit.SECONDS).map(
                    tick -> random.nextInt(100)
               );
    }
}
