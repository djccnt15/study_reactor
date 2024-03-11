package org.study_reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Publisher {
    
    public Flux<Integer> startFlux() {
        // return Flux.just(1, 2, 3, 4, 5);
        return Flux.range(1, 5).log();
    }
    
    public Flux<Integer> startFluxWithIterable() {
        return Flux.fromIterable(List.of(1, 2, 3, 4)).log();
    }
    
    public Mono<Integer> startMono() {
        // return Mono.justOrEmpty(1);
        return Mono.just(1).log();
    }
    
    public Mono<?> startMonoEmpty() {
        return Mono.empty().log();
    }
    
    public Mono<?> startMonoException() {
        return Mono.error(new Exception("reactor exception")).log();
    }
}
