package org.mvallesg.api.stream.ejemplos;

import org.mvallesg.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {
    public static void main(String[] args) {

        /*
        peek() es una especie de "debugger", el cual muestra el estado de los elementos del stream
        en el momento en que se invoca. Es un operador intermedio, no es final ni inicial.
        map() es un método cuyo argumento es una función lambda para operar sobre los elementos
        del stream. Siempre debe tener un return. Es un operador inicial.
         */

        Stream<Usuario> nombres = Stream
                .of("Pato Guzmán", "Paco González", "Pepa Gutiérrez", "Pepe Mena")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .map(usuario -> {
                    String nombre = usuario.getNombre().toUpperCase();
                    usuario.setNombre(nombre);
                    return usuario;
                });

        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(System.out::println);
        //nombres.forEach(System.out::println);

        /*
        forEach() es un operador final (o terminal), es decir, a partir del cual no se puede
        operar más sobre el stream (o flujo). Este "dispara" las "partículas" (o elementos)
        que queden en el stream en el momento de invocarlo.
         */

        /*
        Cuando se tiene un operador final, debe ser único; no se puede colocar otro.
        Dicho de otra forma, siempre hay que poner UN solo operador final, no más.
         */
    }
}
