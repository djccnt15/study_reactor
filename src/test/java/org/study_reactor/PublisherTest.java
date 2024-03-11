package org.study_reactor;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class PublisherTest {
    
    private final Publisher publisher = new Publisher();
    
    @Test
    void startFlux() {
        StepVerifier.create(publisher.startFlux())
            .expectNext(1, 2, 3, 4, 5)
            .verifyComplete();
    }
    
    @Test
    void startFluxWithIterable() {
        StepVerifier.create(publisher.startFluxWithIterable())
            .expectNext(1, 2, 3, 4)
            .verifyComplete();
    }
    
    @Test
    void startMono() {
        StepVerifier.create(publisher.startMono())
            .expectNext(1)
            .verifyComplete();
    }
    
    @Test
    void startMonoEmpty() {
        StepVerifier.create(publisher.startMonoEmpty())
            .verifyComplete();
    }
    
    @Test
    void startMonoException() {
        StepVerifier.create(publisher.startMonoException())
            .expectError(Exception.class)
            .verify();
    }
}