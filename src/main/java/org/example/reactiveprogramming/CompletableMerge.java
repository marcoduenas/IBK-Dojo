package org.example.reactiveprogramming;

import io.reactivex.Completable;

public class CompletableMerge {

    public static void main(String[] args) throws InterruptedException {

        Completable actualizarRegistroEnBD = Completable
                .fromAction(() -> {
                    // Se realizan
                    // varias tareas
                    // envuelto en un bloque completable
                    System.out.println("Se realizan algunas tareas envueltas en completable");
                })
                .doOnError(error -> System.out.println("Ocurrió un error al ActualizarRegistro " + error.getMessage()))
                .doOnSubscribe(info -> System.out.println("Alguien se subscribió al observable ActualizarRegistro"));

        Completable enviarCorreoDeConfirmacion = Completable
                .fromAction(() -> {
                    throw new Exception("Internal Server Error");
                })
                .doOnError(error -> System.out.println("Ocurrió un error al EnviarCorreo " + error.getMessage()))
                .doOnSubscribe(info -> System.out.println("Alguien se subscribió al observable EnvioCorreo"))
                .onErrorComplete();

        actualizarRegistroEnBD
                .andThen(enviarCorreoDeConfirmacion)
                .doOnComplete(() -> System.out.println("Observador recibió ejecucón completa"))
                .doOnError(error -> System.out.println("Observador recibió un error " + error.getMessage()))
                .retry(1)
                .subscribe();

    }

}
