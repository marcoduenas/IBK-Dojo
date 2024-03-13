package org.example.reactiveprogramming;

import io.reactivex.Maybe;

public class SwitchIfEmpty {

    public static void main(String[] args) throws InterruptedException {

        Maybe<Object> observable = Maybe.empty()
                .doOnSuccess(item -> System.out.println("Observable1 entregará el item: " + item))
                .doOnSubscribe(info -> System.out.println("Alguien se subscribió al Observable1"));

        Maybe<Integer> observable2 = Maybe.just(1)
                .doOnSuccess(item -> System.out.println("Observable2 entregará el item: " + item))
                .doOnSubscribe(info -> System.out.println("Alguien se subscribió al Observable2"));


        observable
                .map(item -> (Integer)item + 10)
                .switchIfEmpty(
                        observable2
                                .map(item -> item * 10)
                )
                .subscribe(item  -> System.out.println("Elemento procesado: " + item));


    }

}
