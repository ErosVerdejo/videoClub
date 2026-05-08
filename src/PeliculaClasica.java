/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author veget
 */
public class PeliculaClasica extends Pelicula {
    private String decada;

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

    /*
     * Las películas clásicas tienen un descuento del 30% sobre el precio base,
     * ya que son títulos antiguos con menor demanda actual.
     * retorna el precio en pesos
     */
    @Override
    public int calcularPrecioArriendo() {
        return (int)(PRECIO_BASE * 0.7);
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