package org.study_reactor;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class OperatorTest {
    
    private final Operator operator = new Operator();
    
    @Test
    void fluxMap() {
        StepVerifier.create(operator.fluxMap())
            .expectNext(2, 4, 6, 8, 10)
            .verifyComplete();
    }
    
    @Test
    void fluxFilter() {
        StepVerifier.create(operator.fluxFilter())
            .expectNext(6, 7, 8, 9, 10)
            .verifyComplete();
    }
    
    @Test
    void fluxFilterTake() {
        StepVerifier.create(operator.fluxFilterTake())
            .expectNext(6, 7, 8)
            .verifyComplete();
    }
    
    @Test
    void fluxFlatMap() {
        StepVerifier.create(operator.fluxFlatMap())
            .expectNextCount(100)
            .verifyComplete();
    }
    
    @Test
    void concatMap() {
        StepVerifier.create(operator.concatMap())
            .expectNextCount(100)
            .verifyComplete();
    }
    
    @Test
    void monoFlatMapMany() {
        StepVerifier.create(operator.monoFlatMapMany())
            .expectNextCount(10)
            .verifyComplete();
    }
    
    @Test
    void defaultIfEmpty() {
        StepVerifier.create(operator.defaultIfEmpty())
            .expectNext(10)
            .verifyComplete();
    }
    
    @Test
    void switchIfEmpty() {
        StepVerifier.create(operator.switchIfEmpty())
            .expectNext(20)
            .verifyComplete();
    }
    
    @Test
    void switchIfEmptyExcept() {
        StepVerifier.create(operator.switchIfEmptyExcept())
            .expectError()
            .verify();
    }
    
    @Test
    void fluxMerge() {
        StepVerifier.create(operator.fluxMerge())
            .expectNext(1, 2, 3, 4)
            .verifyComplete();
    }
    
    @Test
    void monoMerge() {
        StepVerifier.create(operator.monoMerge())
            .expectNext(1, 2)
            .verifyComplete();
    }
    
    @Test
    void fluxZip() {
        StepVerifier.create(operator.fluxZip())
            .expectNext(5, 7, 9)
            .verifyComplete();
    }
    
    @Test
    void monoZip() {
        StepVerifier.create(operator.monoZip())
            .expectNext(3)
            .verifyComplete();
    }
}