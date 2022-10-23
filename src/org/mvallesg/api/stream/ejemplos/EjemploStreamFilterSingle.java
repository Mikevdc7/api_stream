package org.mvallesg.api.stream.ejemplos;

import org.mvallesg.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle {
    public static void main(String[] args) {

        /*
        findFirst() es un operador final (o terminal) que convierte el flujo a un
        sólo objeto. De esta forma, buscar un objeto en particular dentro de una lista
        (en combinación del filter() con el findFirst()) se hace muy sencillo.
         */

        Stream<Usuario> nombres = Stream
                .of("Pato Guzmán", "Paco González", "Pepa Gutiérrez",
                        "Pepe Mena", "Pepe García")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Pepex"))
                .peek(System.out::println);

        /* El objeto Optional envuelve un objeto (en este caso, al objeto Usuario) para agregar más
        funcionalidad. Por ejemplo, cuando buscamos un registro, objeto... dentro de una colección
        utilizando el Api Stream o en la BBDD, podría ser que este no se encuentre, que no exista,
        y devolver un null. Si luego se invoca a algún método con este null, se puede dar el NullPointerException.
        El Optional da una capa de abstracción por sobre el objeto para evitar el NullPointerException.
        Así, podemos saber si el objeto fue o no encontrado, con métodos de ayuda para saber si está presente,
        si está vacío o si no se encontró, o dar alguna alternativa en lugar de lanzar la excepción, por ejemplo,
        devolver un objeto o algún valor por defecto.
         */

        /*
        - El método orElse(), devuelve el objeto y, si no se encuentra, se devuelve lo que se le haya puesto
        en el argumento.
        - El método orElseGet(), recibe un Supplier (función lambda), el cual no recibe argumentos pero siempre devuelve un valor, es
        como una fábrica de objetos.
        - El método orElseThrow() devuelve el objeto y, si no se encuentra, lanza una excepción. De hecho, lanza la misma excepción que
        get(), es decir, NoSuchElementException. Es bastante similar a este.
         */

        Optional<Usuario> usuario = nombres.findFirst();
        //System.out.println(usuario.orElse(new Usuario("John", "Doe")));
        //System.out.println(usuario.orElseGet(() -> new Usuario("John", "Doe")));
        //System.out.println(usuario.orElseThrow());
        if (usuario.isPresent()) {
            System.out.println(usuario.get());
        } else {
            System.out.println("No se encontró el objeto!");
        }
        //nombres.forEach(System.out::println);
    }
}
