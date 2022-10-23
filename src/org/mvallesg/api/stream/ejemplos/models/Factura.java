package org.mvallesg.api.stream.ejemplos.models;

public class Factura {
    private String descripcion;
    private Usuario usuario;

    public Factura(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return getDescripcion();
    }
}
