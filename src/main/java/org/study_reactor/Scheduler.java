package org.study_reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Scheduler {
    // 비동기 작업을 실행, 관리, 조절
    // 쓰레드풀 관리, 동시어 제어 등
    
    public Flux<Integer> fluxMapWithSubscribeOn() {
        // 일련의 절차를 해당 스케쥴러로 사용
        return Flux.range(1, 10)
            .map(i -> i * 2)
            .subscribeOn(Schedulers.boundedElastic())
            .log();
    }
    
    public Flux<Integer> fluxMapWithPublisher() {
        // 해당 메서드를 실행한 다음 구문부터 해당 Elastic 사용
        // 다양한 스케쥴러를 결합하여 사용 가능
        return Flux.range(1, 10)
            .map(i -> i + 1)
            .publishOn(Schedulers.boundedElastic())
            .log()
            .publishOn(Schedulers.parallel())
            .log()
            .map(i -> i * 2);
    }
}
