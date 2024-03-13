package org.example.reactiveprogramming;

import io.reactivex.Observable;

public class ErrorHandling {

    public static void main(String[] args) throws InterruptedException {

        Observable<Object> observable = Observable.error(new Exception("Internal Server Error"))
                .doOnNext(item -> System.out.println("Observable entregará el item: " + item))
                .doOnSubscribe(info -> System.out.println("Alguien se subscribió al observable"));

        observable
                .doOnError(error -> System.out.println("ocurrio un error"))
                .doOnComplete(() ->System.out.println("Se recibieron todos los valores del observable"))
//                .retry(1)
                .subscribe(item  -> System.out.println("Elemento procesado: " + item));
//                .subscribe( item -> System.out.println("Elemento procesado: " + item),
//                            error ->  System.out.println("Error procesado: "+ error.getMessage()));


    }

}
