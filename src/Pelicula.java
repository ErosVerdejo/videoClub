/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eros-
 */
public abstract class Pelicula {
    private String idPelicula;
    private String nombrePe;
    private String genero;
    private int duracion;
    private int stock;
    private int vecesArrendada;

    // Precio base de arriendo en pesos para todas las peliculas
    protected static final int PRECIO_BASE = 2000;

    /*
     * Constructor de la clase Pelicula.
     * idPelicula el ID único de la película
     * nombrePe el nombre de la película
     * genero el género de la película
     * duracion la duración en minutos
     * stock la cantidad disponible en stock
     */
    public Pelicula(String idPelicula, String nombrePe, String genero, int duracion, int stock) {
        this.idPelicula = idPelicula;
        this.nombrePe = nombrePe;
        this.genero = genero;
        this.duracion = duracion;
        this.stock = stock;
        this.vecesArrendada = 0;
    }

    public String getIdPelicula() {
        return idPelicula;
    }

    public String getNombrePe() {
        return nombrePe;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getStock() {
        return stock;
    }

    public int getVecesArrendada() {
        return vecesArrendada;
    }

    public void setIdPelicula(String idPelicula) {
        this.idPelicula = idPelicula;
    }

    public void setNombrePe(String nombrePe) {
        this.nombrePe = nombrePe;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setVecesArrendada(int vecesArrendada) {
        this.vecesArrendada = vecesArrendada;
    }

    /*
     * Incrementa el contador de veces que ha sido arrendada la película.
     */
    public void aumentarVecesArrendada() {
        this.vecesArrendada++;
    }

    /*
     * Verifica si la película tiene stock disponible.
     * retorna true si hay stock, false si no
     */
    public boolean hayStock() {
        return stock > 0;
    }

    /*
     * Disminuye el stock de la película en 1, si hay disponible.
     */
    public void disminuirStock() {
        if (stock > 0) {
            stock--;
        }
    }

    /*
     * Aumenta el stock de la película en 1.
     */
    public void aumentarStock() {
        stock++;
    }

    /*
     * Obtiene el tipo de película (estreno, clásica).
     * Cada subclase define su propio tipo.
     * retorna el tipo de película
     */
    public abstract String getTipoPelicula();

    /*
     * Calcula el precio de arriendo de la película.
     * Cada subclase implementa su propia lógica de precio.
     * retorna el precio en pesos
     */
    public abstract int calcularPrecioArriendo();

    @Override
    public String toString() {
        return "Pelicula{" +
                "id='" + idPelicula + '\'' +
                ", nombre='" + nombrePe + '\'' +
                ", genero='" + genero + '\'' +
                ", duracion=" + duracion +
                ", stock=" + stock +
                ", vecesArrendada=" + vecesArrendada +
                ", tipo='" + getTipoPelicula() + '\'' +
                ", precioArriendo=$" + calcularPrecioArriendo() +
                '}';
    }
}