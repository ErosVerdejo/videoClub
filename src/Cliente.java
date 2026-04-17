

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eros-
 */
import java.util.ArrayList;

public class Cliente extends Persona {
    private String preferencia;
    private ArrayList<Arriendo> historial;

    /*
     * Constructor de la clase Cliente.
     * nombre el nombre del cliente
     * rut el RUT del cliente
     * preferencia la preferencia de género del cliente
     */
    public Cliente(String nombre, String rut, String preferencia) {
        super(nombre, rut);
        this.preferencia = preferencia;
        this.historial = new ArrayList<Arriendo>();
    }

    public String getPreferencia() {
        return preferencia;
    }

    public ArrayList<Arriendo> getHistorial() {
        return historial;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }

    public void setHistorial(ArrayList<Arriendo> historial) {
        this.historial = historial;
    }

    /*
     * Agrega un arriendo al historial del cliente.
     * arriendo el arriendo a agregar
     */
    public void agregarArriendo(Arriendo arriendo) {
        historial.add(arriendo);
    }

    /*
     * Crea y agrega un nuevo arriendo al historial del cliente.
     * idArriendo el ID del arriendo
     * pelicula la película arrendada
     * fechaArriendo fecha de arriendo
     * fechaDevolucion fecha de devolución
     */
    public void agregarArriendo(String idArriendo, Pelicula pelicula, String fechaArriendo, String fechaDevolucion) {
        Arriendo nuevoArriendo = new Arriendo(idArriendo, this, pelicula, fechaArriendo, fechaDevolucion);
        historial.add(nuevoArriendo);
    }

    /*
     * Obtiene la cantidad total de arriendos realizados por el cliente.
     * retorna el número de arriendos
     */
    public int getCantidadArriendos() {
        return historial.size();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + getnombre() + '\'' +
                ", rut='" + getrut() + '\'' +
                ", preferencia='" + preferencia + '\'' +
                ", cantidadArriendos=" + historial.size() +
                '}';
    }
}