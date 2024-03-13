package org.study_reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Publisher {
    // Publisher가 데이터를 발행, Subscriber가 데이터를 구독/소비
    // Flux: 다수의 아이템을 가질 수 있는 데이터 스트림
    // Mono: 단일값의 아이템을 가지는 데이터 스트림
    
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
