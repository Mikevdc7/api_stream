package org.mvallesg.api.stream.ejemplos;

import org.mvallesg.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFilterCount {
    public static void main(String[] args) {

        /*
        count() es un operador final (o terminal) que devuelve un long
        con la cantidad de elementos que están en ese momento en el stream.
         */

        long cantidad = Stream
                .of("Pato Guzmán", "Paco González", "Pepa Gutiérrez",
                        "Pepe Mena", "Pepe García")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .count();

        System.out.println(cantidad);
    }
}
