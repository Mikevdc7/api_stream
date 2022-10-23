package org.mvallesg.api.stream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class EjemploStreamRange {
    public static void main(String[] args) {

        /*
        La diferencia entre range() y rangeClosed(), es que el primero excluye
        del rango el segundo valor, mientras que el segundo lo incluye.
         */

        IntStream numeros = IntStream.range(5, 20)
                .peek(System.out::println);

        IntStream numerosClosed = IntStream.rangeClosed(5, 20)
                .peek(System.out::println);

        //int resultado = numeros.reduce(1, (a, b) -> a+b);
        //int resultado = numeros.sum();
        IntSummaryStatistics stats = numeros.summaryStatistics();
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Media: " + stats.getAverage());
        System.out.println("Suma: " + stats.getSum());
        System.out.println("Contador: " + stats.getCount());
    }
}