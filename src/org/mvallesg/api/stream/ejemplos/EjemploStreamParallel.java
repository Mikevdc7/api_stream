package org.mvallesg.api.stream.ejemplos;

import org.mvallesg.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploStreamParallel {
    public static void main(String[] args) {

        /*
        parallel() hace que el stream se procese a una velocidad mucho mayor, pero con un
        coste en rendimiento. Se utilizará cuando se tenga una gran cantidad de elementos que
        procesar en el flujo, o el procesamiento de cada elemento lleve un tiemp importante.
         */

        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Mike", "Valles"));
        lista.add(new Usuario("Serry", "Vdc"));
        lista.add(new Usuario("Marc", "Van Bommel"));
        lista.add(new Usuario("Daniel", "De Sole"));
        lista.add(new Usuario("Vincent", "El Sola"));
        lista.add(new Usuario("Hector", "Pana"));
        lista.add(new Usuario("Bruce", "Lee"));
        lista.add(new Usuario("bruce", "Willis"));

        long t1 = System.currentTimeMillis();
        String resultado = lista.stream()
                .parallel()
                .map(usuario -> usuario.toString().toUpperCase())
                .peek(n -> {
                    System.out.println("Nombre Thread: " + Thread.currentThread().getName()
                    + " - " + n);
                })
                .flatMap(usuario -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if(usuario.contains("bruce".toUpperCase())){
                        return Stream.of(usuario);
                    }return Stream.empty();
                })
                .findAny().orElse("");
        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (t2-t1));
        System.out.println(resultado);
    }
}