package org.mvallesg.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduce {
    public static void main(String[] args) {

        /*
        reduce() es un operador terminal, que reduce un flujo de varios elementos
        en un solo elemento.
        Tiene dos argumentos: el primero es un valor inicial, y el segundo es una función
        lambda con dos argumentos (a, b) que va a ir rellenando dicho valor.
        a: elemento sacado anterior. (es por ello que en este ejemplo se imprime primero de todo
        una coma, ya que cuando saco el primer elemento se guarda en b, y en a no hay nada.
        b: elemento sacado actual.
        */

        Stream<String> nombres = Stream
                .of("Pato Guzmán", "Paco González", "Pepa Gutiérrez",
                        "Pepe Mena", "Pepe García", "Paco González", "Paco González")
                .distinct();

        String resultado = nombres.reduce("resultado contatenación = ", (a, b) -> a + ", " + b);
        System.out.println(resultado);
    }
}