package org.mvallesg.api.stream.ejemplos;

import org.mvallesg.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamDistinctUsuario {
    public static void main(String[] args) {


        /*
        Si el distinct() lo pongo antes del map(), los elementos del stream que sean iguales
        (que en este punto son Strings) se agrupan en uno solo; en cambio, si se pone
        después del map(), mostrará los elementos duplicados, ya que en este punto se han convertido
        a Usuario, y ahora son instancias distintas.
        Para aplicar el distinct() de forma efectiva, tendremos que implementar el método equals() en
        la clase Usuario y comparar por los elementos que correspondan.
        Por ejemplo, en este caso, por nombre y apellido.
         */


        Stream<Usuario> nombres = Stream
                .of("Pato Guzmán", "Paco González", "Pepa Gutiérrez",
                        "Pepe Mena", "Pepe García", "Pato Guzmán", "Pato Guzmán")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct();

        nombres.forEach(System.out::println);
    }
}
