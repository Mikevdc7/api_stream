package org.mvallesg.api.stream.ejemplos;

import org.mvallesg.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamListToStream {
    public static void main(String[] args) {

        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Mike", "Valles"));
        lista.add(new Usuario("Serry", "Vdc"));
        lista.add(new Usuario("Marc", "Van Bommel"));
        lista.add(new Usuario("Daniel", "De Sole"));
        lista.add(new Usuario("Vincent", "El Sola"));
        lista.add(new Usuario("Hector", "Pana"));
        lista.add(new Usuario("Bruce", "Lee"));
        lista.add(new Usuario("bruce", "Willis"));

        Stream<String> nombres = lista.stream()
                .map(usuario -> usuario.getNombre().toUpperCase()
                        .concat(" ")
                        .concat(usuario.getApellido().toUpperCase()))
                .flatMap(usuario -> {
                    if(usuario.contains("bruce".toUpperCase())){
                        return Stream.of(usuario);
                    }return Stream.empty();
                })
                .map(String::toLowerCase)
                .peek(System.out::println);
        System.out.println(nombres.count());
    }
}