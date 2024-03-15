package org.study_reactor;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class SchedulerTest {
    
    private final Scheduler scheduler = new Scheduler();
    
    @Test
    void fluxMapWithSubscribeOn() {
        StepVerifier.create(scheduler.fluxMapWithSubscribeOn())
            .expectNextCount(10)
            .verifyComplete();
    }
    
    @Test
    void fluxMapWithPublisher() {
        StepVerifier.create(scheduler.fluxMapWithPublisher())
            .expectNextCount(10)
            .verifyComplete();
    }
}