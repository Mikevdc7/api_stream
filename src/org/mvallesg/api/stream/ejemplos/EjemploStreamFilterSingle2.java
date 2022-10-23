package org.mvallesg.api.stream.ejemplos;

import org.mvallesg.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFilterSingle2 {
    public static void main(String[] args) {

        /*
        findFirst() es un operador final (o terminal) que convierte el flujo a un
        sólo objeto. De esta forma, buscar un objeto en particular dentro de una lista
        (en combinación del filter() con el findFirst()) se hace muy sencillo.
         */

        Usuario usuario = Stream
                .of("Pato Guzmán", "Paco González", "Pepa Gutiérrez",
                        "Pepe Mena", "Pepe García")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .filter(u -> u.getId().equals(40))
                .findFirst().orElseGet(() -> new Usuario("John", "Doe"));

        System.out.println(usuario);
    }
}
