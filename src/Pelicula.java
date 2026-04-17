/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eros-
 */
public class Pelicula {
    private String idPelicula;
    private String nombrePe;
    private String genero;
    private int duracion;
    private int stock;
    private int vecesArrendada;

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
     * Obtiene el tipo de película (general, estreno, clásica).
     * retorna el tipo de película
     */
    public String getTipoPelicula() {
        return "Pelicula general";
    }
    
    public class PeliculaEstreno extends Pelicula {
    private int anioEstreno;

    /*
     * Constructor de PeliculaEstreno.
     * idPelicula el ID único
     * nombrePe el nombre
     * genero el género
     * duracion la duración
     * stock el stock
     * anioEstreno el año de estreno
     */
    public PeliculaEstreno(String idPelicula, String nombrePe, String genero, int duracion, int stock, int anioEstreno) {
        super(idPelicula, nombrePe, genero, duracion, stock);
        this.anioEstreno = anioEstreno;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    @Override
    public String getTipoPelicula() {
        return "Estreno";
    }

    @Override
    public String toString() {
        return "PeliculaEstreno{" +
                "id='" + getIdPelicula() + '\'' +
                ", nombre='" + getNombrePe() + '\'' +
                ", genero='" + getGenero() + '\'' +
                ", duracion=" + getDuracion() +
                ", stock=" + getStock() +
                ", vecesArrendada=" + getVecesArrendada() +
                ", anioEstreno=" + anioEstreno +
                ", tipo='" + getTipoPelicula() + '\'' +
                '}';
        }
    }

    public class PeliculaClasica extends Pelicula {
    private String decada;

    /*
     * Constructor de PeliculaClasica.
     * idPelicula el ID único
     * nombrePe el nombre
     * genero el género
     * duracion la duración
     * stock el stock
     * decada la década de la película
     */
    public PeliculaClasica(String idPelicula, String nombrePe, String genero, int duracion, int stock, String decada) {
        super(idPelicula, nombrePe, genero, duracion, stock);
        this.decada = decada;
    }

    public String getDecada() {
        return decada;
    }

    public void setDecada(String decada) {
        this.decada = decada;
    }

    @Override
    public String getTipoPelicula() {
        return "Clasica";
    }

    @Override
    public String toString() {
        return "PeliculaClasica{" +
                "id='" + getIdPelicula() + '\'' +
                ", nombre='" + getNombrePe() + '\'' +
                ", genero='" + getGenero() + '\'' +
                ", duracion=" + getDuracion() +
                ", stock=" + getStock() +
                ", vecesArrendada=" + getVecesArrendada() +
                ", decada='" + decada + '\'' +
                ", tipo='" + getTipoPelicula() + '\'' +
                '}';
        }
    }

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
                '}';
    }
}