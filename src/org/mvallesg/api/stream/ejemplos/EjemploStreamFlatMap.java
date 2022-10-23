package org.mvallesg.api.stream.ejemplos;

import org.mvallesg.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFlatMap {
    public static void main(String[] args) {

        /*
        flatMap() es muy parecido a map(), pero este no devuelve un objeto, sino
        un stream de ese objeto. Es decir, por cada elemento del stream, se generará
        un stream diferente.
        Es como usar un filter().
         */

        Stream<Usuario> nombres = Stream
                .of("Pato Guzmán", "Paco González", "Pepa Gutiérrez",
                        "Pepe Mena", "Pepe García")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .flatMap(usuario -> {
                    if(usuario.getNombre().equalsIgnoreCase("Pepe")){
                        return Stream.of(usuario);
                    } return Stream.empty();
                })
                .peek(System.out::println);

        System.out.println(nombres.count());
    }
}
