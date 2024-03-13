package org.example.reactiveprogramming;

import io.reactivex.Observable;

public class PrimerObservable {

    public static void main(String[] args) throws InterruptedException {

        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5, 6, 7)
                .doOnNext(item -> System.out.println("Se entregará el item: " + item))
                .doOnSubscribe(info -> System.out.println("Alguien se subscribió al observable"));

        observable
                .map(item -> item * 10)
                .doOnComplete(() -> System.out.println("Se recibieron todos los valores del observable"))
                .subscribe(item  -> System.out.println("Elemento procesado: " + item));

    }

}
