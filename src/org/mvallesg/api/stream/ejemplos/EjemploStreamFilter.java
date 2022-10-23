package org.mvallesg.api.stream.ejemplos;

import org.mvallesg.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilter {
    public static void main(String[] args) {

        /*
        filter() es un método que permite "seguir circulando por la tubería" solamente a aquellos
        elementos del stream que cumplen la condición que se establece en la función lambda
        que se le pasa como argumento.
         */

        Stream<Usuario> nombres = Stream
                .of("Pato Guzmán", "Paco González", "Pepa Gutiérrez",
                        "Pepe Mena", "Pepe García")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Pepe"))
                .peek(System.out::println);

        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(System.out::println);
        //nombres.forEach(System.out::println);
    }
}
