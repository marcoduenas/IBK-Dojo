package org.example.reactiveprogramming;

import io.reactivex.Completable;

public class EjemploCompletable {

    public static void main(String[] args) throws InterruptedException {

        Completable actualizarRegistroEnBD = Completable
                .fromAction(() -> {
                    // Se realizan
                    // varias tareas
                    // envuelto en un bloque completable
//                    System.out.println("Se realizan algunas tareas envueltas en completable");
                    throw new Exception("Server error");
                })
                .doOnError(error -> System.out.println("Ocurrió un error al ActualizarRegistro " + error.getMessage()))
                .doOnSubscribe(info -> System.out.println("Alguien se subscribió al observable"));

        actualizarRegistroEnBD
                .doOnComplete(() -> System.out.println("Observador recibió ejecucón completa"))
                .doOnError(error -> System.out.println("Observador recibió un error " + error.getMessage()))
                .retry(1)
                .subscribe();

    }

}
