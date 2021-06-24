package org.acme;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Payload {
    final private long input;
    final private Set<Long> results;
    final private Duration duration;

    private Payload(long input, Set<Long> results, Duration duration){
        this.input = input;
        this.results = results;
        this.duration = duration;
    }
    
    public static Payload generate(long input){
        Instant started = Instant.now();
        Set<Long> results = LongStream.rangeClosed(1, input)
                .filter(i -> BigInteger.valueOf(i).isProbablePrime(1))
                .boxed()
                .collect(Collectors.toSet());
        Duration duration = Duration.between(started, Instant.now());
        
        return new Payload(input,results,duration);
    }
    
    public long getInput(){
        return input;
    }

    public Duration getDuration() {
        return duration;
    }

    public Set<Long> getResults() {
        return results;
    }
}
