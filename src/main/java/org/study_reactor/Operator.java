package org.study_reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

public class Operator {
    // Flux, Mono의 데이터를 가공, 변환, 필터, 변환하는 다양한 메서드들
    
    public Flux<Integer> fluxMap() {
        return Flux.range(1, 5)
            .map(i -> i * 2)
            .log();
    }
    
    public Flux<Integer> fluxFilter() {
        return Flux.range(1, 10)
            .filter(i -> i > 5)
            .log();
    }
    
    public Flux<Integer> fluxFilterTake() {
        return Flux.range(1, 10)
            .filter(i -> i > 5)
            .take(3)
            .log();
    }
    
    public Flux<Integer> fluxFlatMap() {
        // does not necessarily preserve original ordering
        int randomInt = (int) (Math.random() * 10);
        
        return Flux.range(1, 10)
            .flatMap(i -> Flux.range(i * 10, 10)
                .delayElements(Duration.ofMillis(randomInt))
            )
            .log();
    }
    
    public Flux<Integer> concatMap() {
        // naturally preserves the same order as the source elements
        int randomInt = (int) (Math.random() * 10);
        
        return Flux.range(1, 10)
            .concatMap(i -> Flux.range(i * 10, 10)
                .delayElements(Duration.ofMillis(randomInt))
            )
            .log();
    }
    
    
    // mono to flux
    public Flux<Integer> monoFlatMapMany() {
        return Mono.just(10)
            .flatMapMany(i -> Flux.range(1, i))
            .log();
    }
    
    public Mono<Integer> defaultIfEmpty() {
        return Mono.just(1)
            .filter(i -> i > 1)
            .defaultIfEmpty(10)
            .log();
    }
    
    public Mono<Integer> switchIfEmpty() {
        return Mono.just(1)
            .filter(i -> i > 1)
            .switchIfEmpty(Mono.just(10)).map(i -> i * 2)
            .log();
    }
    
    public Mono<Integer> switchIfEmptyExcept() {
        return Mono.just(1)
            .filter(i -> i > 1)
            .switchIfEmpty(Mono.error(new Exception("value not exist...")))
            .log();
    }
    
    public Flux<Integer> fluxMerge() {
        return Flux.merge(Flux.fromIterable(List.of(1, 2, 3)), Flux.just(4))
            .log();
    }
    
    public Flux<Integer> monoMerge() {
        return Mono.just(1).mergeWith(Mono.just(2))
            .log();
    }
    
    public Flux<Integer> fluxZip() {
        return Flux.zip(Flux.just(1, 2, 3), Flux.just(4, 5, 6))
            .map(i -> i.getT1() + i.getT2())
            .log();
    }
    
    public Mono<Integer> monoZip() {
        return Mono.zip(Mono.just(1), Mono.just(2))
            .map(i -> i.getT1() + i.getT2())
            .log();
    }
    
    public Mono<Long> fluxCount() {
        return Flux.range(1, 10)
            .count()
            .log();
    }
    
    public Flux<Integer> fluxDistinct() {
        return Flux.fromIterable(List.of(1, 2, 3, 1, 2, 3))
            .distinct()
            .log();
    }
    
    public Mono<Integer> fluxReduce() {
        return Flux.range(1, 10)
            // .reduce((i, j) -> i + j)
            .reduce(Integer::sum)
            .log();
    }
    
    public Flux<Integer> fluxGroupBy() {
        return Flux.range(1, 10)
            .groupBy(i -> (i % 2 == 0) ? "even" : "odd")
            .flatMap(group -> group.reduce(Integer::sum))
            .log();
    }
    
    public Flux<Integer> fluxDelayAndLimit() {
        return Flux.range(1, 10)
            .delaySequence(Duration.ofSeconds(1))
            .log()
            .limitRate(2);
    }
    
    public Flux<Integer> fluxSample() {
        return Flux.range(1, 100)
            .delayElements(Duration.ofMillis(100))
            .sample(Duration.ofMillis(300))
            .log();
    }
}
