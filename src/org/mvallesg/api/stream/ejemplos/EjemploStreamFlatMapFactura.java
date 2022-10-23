package org.mvallesg.api.stream.ejemplos;

import org.mvallesg.api.stream.ejemplos.models.Factura;
import org.mvallesg.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {

        Usuario usuario1 = new Usuario("Mike", "Valles");
        Usuario usuario2 = new Usuario("Pepe", "Perez");

        usuario1.addFactura(new Factura("Compras tecnologias"));
        usuario1.addFactura(new Factura("Compras muebles"));

        usuario2.addFactura(new Factura("Bicicleta"));
        usuario2.addFactura(new Factura("Notebook gamer"));

        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);

        /* De la manera tradicional:
        for(Usuario u: usuarios){
            for(Factura f: u.getFacturas()){
                System.out.println(f.getDescripcion());
            }
        } */

        // Con el Api Stream:
/*
        usuarios.stream()
                .map(Usuario::getFacturas)
                .flatMap(List::stream)
                .forEach(f -> System.out.println(f.getDescripcion()
                        .concat(": cliente-> ")
                        .concat(f.getUsuario().getNombre())));

Esto es lo mismo que lo de abajo, pero arriba el map saca una lista de facturas por cada usuario
y luego esta lista hay que convertirla en stream para poder recorrerla por el forEach.
Abajo, en cambio, directamente sacas la lista de facturas del usuario y la conviertes en
un stream para poder recorrerla.
 */
        usuarios.stream()
                .flatMap(usuario -> usuario.getFacturas().stream())
                .forEach(factura -> System.out.println(factura.getDescripcion()
                        .concat(": cliente-> ")
                        .concat(factura.getUsuario().getNombre())));
    }
}
