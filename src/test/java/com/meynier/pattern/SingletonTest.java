package com.meynier.pattern;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for simple App.
 */
public class SingletonTest {

    @Test
    public void shouldBeEqualsWithBasicImplem() {
        EmileZolaBasicSingleton emileZola1 = EmileZolaBasicSingleton.getInstance();

        EmileZolaBasicSingleton emileZola2 = EmileZolaBasicSingleton.getInstance();

        assertThat(emileZola1).isEqualTo(emileZola2);
    }


    @Test
    public void shouldBeSameAddressWithBasicImplem() {
        EmileZolaBasicSingleton emileZola1 = EmileZolaBasicSingleton.getInstance();

        EmileZolaBasicSingleton emileZola2 = EmileZolaBasicSingleton.getInstance();
        assertThat(emileZola1).isSameAs(emileZola2);
    }

    @Test
    public void shouldNotBeSameWithLazyImplem() {
        EmileZolaBasicSingleton instance1 = EmileZolaBasicSingleton.getInstance();
        EmileZolaBasicSingleton instance2 = null;
        try {
            Constructor[] constructors =
                    EmileZolaBasicSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instance2 = (EmileZolaBasicSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(instance1.hashCode()).isNotEqualTo(instance2.hashCode());
    }

    @Test
    @Disabled
    public void shouldNotBeEqualsWithLazyImplemAndMultithreadEnvironment() throws ExecutionException, InterruptedException {
        final Queue<Future<EmileZolaLazyBasicSingleton>> submited = new SynchronousQueue<>();
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);
        CountDownLatch latch = new CountDownLatch(1);
        Callable<EmileZolaLazyBasicSingleton> callable = () -> {
            latch.await();
            return EmileZolaLazyBasicSingleton.getInstance();
        };

        Runnable trigger = () -> {
            try {
                Thread.sleep(5000);
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(trigger);

        EmileZolaLazyBasicSingleton current = null;
        EmileZolaLazyBasicSingleton prec = threadPoolExecutor.submit(callable).get();
        boolean isDifferent = false;

        for (int i = 1; i < 500; i++) {
            current = threadPoolExecutor.submit(callable).get();
            System.out.println(current);
            if (prec != current) {
                isDifferent = true;
                break;
            }
            prec = current;
        }


        Thread.sleep(5000);
        assertThat(isDifferent).isTrue();
    }

}
