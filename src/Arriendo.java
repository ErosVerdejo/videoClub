/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eros-
 */
public class Arriendo {
    private String idArriendo;
    private Cliente cliente;
    private Pelicula pelicula;
    private String fechaArriendo;
    private String fechaDevolucion;
    private boolean devuelto;

    /*
     * Constructor de la clase Arriendo.
     * idArriendo el ID único del arriendo
     * cliente el cliente que realiza el arriendo
     * pelicula la película arrendada
     * fechaArriendo fecha de inicio del arriendo
     * fechaDevolucion fecha de devolución esperada
     */
    public Arriendo(String idArriendo, Cliente cliente, Pelicula pelicula, String fechaArriendo, String fechaDevolucion) {
        this.idArriendo = idArriendo;
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.fechaArriendo = fechaArriendo;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = false;
    }

    public String getIdArriendo() {
        return idArriendo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public String getFechaArriendo() {
        return fechaArriendo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setIdArriendo(String idArriendo) {
        this.idArriendo = idArriendo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setFechaArriendo(String fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    /*
     * Marca el arriendo como devuelto.
     */
    public void devolver() {
        this.devuelto = true;
    }

    @Override
    public String toString() {
        return "Arriendo{" +
                "idArriendo='" + idArriendo + '\'' +
                ", cliente='" + cliente.getnombre() + '\'' +
                ", pelicula='" + pelicula.getNombrePe() + '\'' +
                ", fechaArriendo='" + fechaArriendo + '\'' +
                ", fechaDevolucion='" + fechaDevolucion + '\'' +
                ", devuelto=" + devuelto +
                '}';
    }
}