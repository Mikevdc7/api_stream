package org.mvallesg.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamDistinct {
    public static void main(String[] args) {

    /*
    El operador distinct(), agrupa todos los elementos repetidos del stream (los que sean iguales)
    en uno solo, por lo que en la salida saldrán solamente una vez.
     */

        Stream.of("Pato Guzmán", "Paco González", "Pepa Gutiérrez",
                        "Pepe Mena", "Pepe García", "Paco González", "Paco González")
                .distinct()
                .forEach(System.out::println);
    }
}