package org.mvallesg.api.stream.ejemplos;

import org.mvallesg.api.stream.ejemplos.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamUsuarioSum {
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

        /*
        CURIOSIDAD: cuando una cadena tiene una letra con un acento, el método .length() la contará
        por dos -> gonzalez: 8; gonzález: 9
         */


        IntStream largoNombres = Stream
                .of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez",
                        "Pepe Mena", "Pepe Garcia", "Pato Guzman", "Pato Guzman")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt(usuario -> usuario.toString().length())
                .peek(System.out::println);

        //largoNombres.forEach(System.out::println);
        IntSummaryStatistics stats = largoNombres.summaryStatistics();
        System.out.println("=====\nTotal: " + stats.getSum());
        System.out.println("Máximo: " + stats.getMax());
        System.out.println("Mínimo: " + stats.getMin());
        System.out.println("Media: " + stats.getAverage());
        System.out.println("Contador: " + stats.getCount());
    }
}