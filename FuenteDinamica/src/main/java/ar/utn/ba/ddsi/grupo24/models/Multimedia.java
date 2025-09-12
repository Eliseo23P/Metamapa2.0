package ar.utn.ba.ddsi.grupo24.models;

public class Multimedia {
    private String titulo;
    private String path;
    private Double duracion; // se tiene que poner?

    public  Multimedia(String titulo, String path, Double duracion) {
        this.titulo = titulo;
        this.path = path;
        this.duracion = duracion;
    }
}
