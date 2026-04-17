/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author veget
 */
public class PeliculaEstreno extends Pelicula {
    private int anioEstreno;

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
