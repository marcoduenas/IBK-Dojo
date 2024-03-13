package org.example.reactiveprogramming;

import io.reactivex.Observable;

public class ErrorHandlingResumen {

    public static void main(String[] args) throws InterruptedException {

        Observable<Integer> observable = Observable.just(1,2,3,4,5)
                .map(item -> {
                    if (item == 3) {
                        throw new Exception("Internal Server Error");
                    }
                    return item * 10;
                })
                .doOnNext(item -> System.out.println("Observable1 entregará el item: " + item))
                .doOnSubscribe(info -> System.out.println("Alguien se subscribió al Observable1"));

        Observable<Integer> observable2 = Observable.just(1,2,3,4,5)
                .doOnNext(item -> System.out.println("Observable2 entregará el item: " + item))
                .doOnSubscribe(info -> System.out.println("Alguien se subscribió al Observable2"));


        observable
                .doOnError(error -> System.out.println("ocurrio un error al recibir item desde observable: " + error.getMessage()))
                .doOnComplete(() ->System.out.println("Se recibieron todos los valores del observable"))
                .retry(1)
                .onExceptionResumeNext(error -> observable2.subscribe())
                .subscribe( item -> System.out.println("Observador procesó elemento: " + item),
                            error ->  System.out.println("Observador procesó error: "+ error.getMessage()));


    }

}
