package org.study_reactor;

public class Main {
    public static void main(String[] args) {
        
        var publisher = new Publisher();
        
        publisher.startFlux()
                .subscribe(System.out::print);
        
        publisher.startMono()
                .subscribe();
        
        publisher.startMonoEmpty()
                .subscribe();
        
        System.out.print("Hello and welcome!");
    }
}