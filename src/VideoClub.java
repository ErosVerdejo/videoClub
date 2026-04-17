

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
import java.util.Collection;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VideoClub {
    private HashMap<String, Cliente> clientes;
    private HashMap<String, Pelicula> peliculas;
    private ArrayList<Arriendo> arriendos;

    /*
     * Constructor de la clase VideoClub.
     * Inicializa las estructuras de datos para clientes, películas y arriendos.
     */
    public VideoClub() {
        clientes = new HashMap<String, Cliente>();
        peliculas = new HashMap<String, Pelicula>();
        arriendos = new ArrayList<Arriendo>();
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public HashMap<String, Pelicula> getPeliculas() {
        return peliculas;
    }

    public ArrayList<Arriendo> getArriendos() {
        return arriendos;
    }
    
    public Cliente buscarCliente(String dato, boolean buscarPorNombre) 
    {
        if (!buscarPorNombre) 
        {
        return buscarCliente(dato);
        }

        for (Cliente cliente : clientes.values()) 
        {
            if (cliente.getnombre().equalsIgnoreCase(dato)) 
            {
                return cliente;
            }
        }
        return null;
    }

    /*
     * Agrega un cliente al sistema si no existe ya.
     * cliente el cliente a agregar
     * retorna true si se agregó correctamente, false si ya existe o es null
     */
    public boolean agregarCliente(Cliente cliente) {
        if (cliente == null) {
            return false;
        }

        if (clientes.containsKey(cliente.getrut())) {
            return false;
        }

        clientes.put(cliente.getrut(), cliente);
        return true;
    }

    /*
     * Agrega una película al sistema si no existe ya.
     * pelicula la película a agregar
     * retorna true si se agregó correctamente, false si ya existe o es null
     */
    public boolean agregarPelicula(Pelicula pelicula) {
        if (pelicula == null) {
            return false;
        }

        if (peliculas.containsKey(pelicula.getIdPelicula())) {
            return false;
        }

        peliculas.put(pelicula.getIdPelicula(), pelicula);
        return true;
    }

    /*
     * Busca un cliente por su RUT.
     * rut el RUT del cliente
     * retorna el cliente encontrado o null si no existe
     */
    public Cliente buscarCliente(String rut) {
        return clientes.get(rut);
    }

    public Pelicula buscarPelicula(String dato, boolean buscarPorNombre) 
    {
        if (!buscarPorNombre) 
        {
            return buscarPelicula(dato);
        }

        for (Pelicula pelicula : peliculas.values()) 
        {
            if (pelicula.getNombrePe().equalsIgnoreCase(dato)) 
            {
                return pelicula;
            }
        }
        return null;
    }
    
    /*
     * Busca una película por su ID.
     * idPelicula el ID de la película
     * retorna la película encontrada o null si no existe
     */
    public Pelicula buscarPelicula(String idPelicula) 
    {
        return peliculas.get(idPelicula);
    }

    /*
     * Elimina un cliente del sistema por su RUT.
     * rut el RUT del cliente a eliminar
     * retorna true si se eliminó correctamente, false si no existe
     */
    public boolean eliminarCliente(String rut) {
        if (clientes.containsKey(rut)) {
            clientes.remove(rut);
            return true;
        }
        return false;
    }

    /*
     * Elimina una película del sistema por su ID.
     * idPelicula el ID de la película a eliminar
     * retorna true si se eliminó correctamente, false si no existe
     */
    public boolean eliminarPelicula(String idPelicula) {
        if (peliculas.containsKey(idPelicula)) {
            peliculas.remove(idPelicula);
            return true;
        }
        return false;
    }

    /*
     * Modifica los datos de un cliente existente.
     * rut el RUT del cliente a modificar
     * nuevoNombre el nuevo nombre
     * nuevaPreferencia la nueva preferencia
     * retorna true si se modificó correctamente, false si el cliente no existe
     */
    public boolean modificarCliente(String rut, String nuevoNombre, String nuevaPreferencia) {
        Cliente cliente = clientes.get(rut);

        if (cliente == null) {
            return false;
        }

        cliente.setnombre(nuevoNombre);
        cliente.setPreferencia(nuevaPreferencia);
        return true;
    }

    /*
     * Modifica los datos de una película existente.
     * idPelicula el ID de la película a modificar
     * nuevoNombre el nuevo nombre
     * nuevoGenero el nuevo género
     * nuevaDuracion la nueva duración
     * nuevoStock el nuevo stock
     * retorna true si se modificó correctamente, false si la película no existe
     */
    public boolean modificarPelicula(String idPelicula, String nuevoNombre, String nuevoGenero, int nuevaDuracion, int nuevoStock) {
        Pelicula pelicula = peliculas.get(idPelicula);

        if (pelicula == null) {
            return false;
        }

        pelicula.setNombrePe(nuevoNombre);
        pelicula.setGenero(nuevoGenero);
        pelicula.setDuracion(nuevaDuracion);
        pelicula.setStock(nuevoStock);
        return true;
    }

    /*
     * Lista todos los clientes registrados.
     * retorna una lista con todos los clientes
     */
    public ArrayList<Cliente> listarClientes() {
        return new ArrayList<Cliente>(clientes.values());
    }

    /*
     * Lista todas las películas registradas.
     * retorna una lista con todas las películas
     */
    public ArrayList<Pelicula> listarPeliculas() {
        return new ArrayList<Pelicula>(peliculas.values());
    }

    /*
     * Registra un arriendo de película para un cliente.
     * idArriendo el ID del arriendo
     * rutCliente el RUT del cliente
     * idPelicula el ID de la película
     * fechaArriendo fecha de arriendo
     * fechaDevolucion fecha de devolución
     * retorna true si se registró correctamente, false si hay error
     */
    public boolean registrarArriendo(String idArriendo, String rutCliente, String idPelicula, String fechaArriendo, String fechaDevolucion) {
        Cliente cliente = clientes.get(rutCliente);
        Pelicula pelicula = peliculas.get(idPelicula);

        if (cliente == null || pelicula == null) {
            return false;
        }

        if (!pelicula.hayStock()) {
            return false;
        }

        Arriendo arriendo = new Arriendo(idArriendo, cliente, pelicula, fechaArriendo, fechaDevolucion);

        arriendos.add(arriendo);
        cliente.agregarArriendo(arriendo);
        pelicula.disminuirStock();
        pelicula.aumentarVecesArrendada();

        return true;
    }
    
    public boolean registrarArriendoDirectoEnCliente(String idArriendo, String rutCliente, String idPelicula, String fechaArriendo, String fechaDevolucion) {
        Cliente cliente = clientes.get(rutCliente);
        Pelicula pelicula = peliculas.get(idPelicula);

        if (cliente == null || pelicula == null) {
            return false;
        }

        if (!pelicula.hayStock()) {
            return false;
        }

        cliente.agregarArriendo(idArriendo, pelicula, fechaArriendo, fechaDevolucion);

        Arriendo arriendo = new Arriendo(idArriendo, cliente, pelicula, fechaArriendo, fechaDevolucion);
        arriendos.add(arriendo);
        pelicula.disminuirStock();
        pelicula.aumentarVecesArrendada();

        return true;
    }

    /*
     * Registra la devolución de una película arrendada.
     * idArriendo el ID del arriendo a devolver
     * retorna true si se registró la devolución, false si no se encontró
     */
    public boolean registrarDevolucion(String idArriendo) {
        int i;
        int n = arriendos.size();

        for (i = 0; i < n; i++) {
            Arriendo arriendo = arriendos.get(i);

            if (arriendo.getIdArriendo().equals(idArriendo) && !arriendo.isDevuelto()) {
                arriendo.devolver();
                arriendo.getPelicula().aumentarStock();
                return true;
            }
        }

        return false;
    }

    /*
     * Registra un arriendo con manejo de excepciones.
     * idArriendo el ID del arriendo
     * rutCliente el RUT del cliente
     * idPelicula el ID de la película
     * fechaArriendo fecha de arriendo
     * fechaDevolucion fecha de devolución
     * retorna true si se registró correctamente
     * lanza ClienteNoEncontradoException si el cliente no existe
     * lanza PeliculaSinStockException si la película no tiene stock
     */
    public boolean registrarArriendoConExcepciones(String idArriendo, String rutCliente, String idPelicula,
        String fechaArriendo, String fechaDevolucion)
        throws ClienteNoEncontradoException, PeliculaSinStockException {

        Cliente cliente = clientes.get(rutCliente);
        Pelicula pelicula = peliculas.get(idPelicula);

        if (cliente == null) {
            throw new ClienteNoEncontradoException("El cliente no existe en el sistema");
        }

        if (pelicula == null) {
            throw new PeliculaSinStockException("La pelicula no existe en el sistema");
        }

        if (!pelicula.hayStock()) {
            throw new PeliculaSinStockException("La pelicula no tiene stock disponible");
        }

        Arriendo arriendo = new Arriendo(idArriendo, cliente, pelicula, fechaArriendo, fechaDevolucion);

        arriendos.add(arriendo);
        cliente.agregarArriendo(arriendo);
        pelicula.disminuirStock();
        pelicula.aumentarVecesArrendada();

        return true;
    }

    /*
     * Guarda la lista de clientes en un archivo de texto.
     * nombreArchivo el nombre del archivo donde guardar
     */
    public void guardarClientesEnArchivo(String nombreArchivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));

            for (Cliente cliente : clientes.values()) {
                writer.write(cliente.getnombre() + ";" + cliente.getrut() + ";" + cliente.getPreferencia());
                writer.newLine();
            }

            writer.close();
        } 
        catch (IOException e) {
            System.out.println("Error al guardar clientes: " + e.getMessage());
        }
    }

    /*
     * Carga la lista de clientes desde un archivo de texto.
     * nombreArchivo el nombre del archivo desde donde cargar
     */
    public void cargarClientesDesdeArchivo(String nombreArchivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");

                if (partes.length == 3) {
                    String nombre = partes[0];
                    String rut = partes[1];
                    String preferencia = partes[2];

                    Cliente cliente = new Cliente(nombre, rut, preferencia);
                    agregarCliente(cliente);
                }
            }

            reader.close();
        } 
        catch (IOException e) {
            System.out.println("Error al cargar clientes: " + e.getMessage());
        }
    }

    /*
     * Carga la lista de películas desde un archivo de texto.
     * nombreArchivo el nombre del archivo desde donde cargar
     */
    public void cargarPeliculasDesdeArchivo(String nombreArchivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");

                if (partes.length >= 6) {
                    String id = partes[0];
                    String nombre = partes[1];
                    String genero = partes[2];
                    int duracion = Integer.parseInt(partes[3]);
                    int stock = Integer.parseInt(partes[4]);
                    int vecesArrendada = Integer.parseInt(partes[5]);

                    Pelicula pelicula = new Pelicula(id, nombre, genero, duracion, stock);
                    pelicula.setVecesArrendada(vecesArrendada);
                    agregarPelicula(pelicula);
                }
            }

            reader.close();
        } 
        catch (IOException e) {
            System.out.println("Error al cargar peliculas: " + e.getMessage());
        }
    }

    /*
     * Carga datos iniciales de ejemplo al sistema.
     * Incluye clientes, películas y algunos arriendos.
     */
    public void cargarDatosIniciales() 
    {
    Cliente c1 = new Cliente("Isaias", "11111111-1", "Accion");
    Cliente c2 = new Cliente("Martin", "22222222-2", "Terror");
    Cliente c3 = new Cliente("Valentina", "33333333-3", "Comedia");

    Pelicula p1 = new PeliculaEstreno("P001", "John Wick", "Accion", 120, 3, 2024);
    Pelicula p2 = new PeliculaEstreno("P002", "El Conjuro", "Terror", 110, 2, 2025);
    Pelicula p3 = new PeliculaClasica("P003", "Son Como Ninos", "Comedia", 95, 4, "2010");
    Pelicula p4 = new PeliculaEstreno("P004", "Rapidos y Furiosos", "Accion", 130, 1, 2023);
    Pelicula p5 = new PeliculaClasica("P005", "La Monja", "Terror", 100, 2, "2000");

    agregarCliente(c1);
    agregarCliente(c2);
    agregarCliente(c3);

    agregarPelicula(p1);
    agregarPelicula(p2);
    agregarPelicula(p3);
    agregarPelicula(p4);
    agregarPelicula(p5);

    registrarArriendo("A001", "11111111-1", "P001", "10-04-2026", "15-04-2026");
    registrarArriendo("A002", "11111111-1", "P004", "11-04-2026", "16-04-2026");
    registrarArriendo("A003", "22222222-2", "P002", "12-04-2026", "17-04-2026");
    }

    /*
     * Sugiere películas a un cliente basado en su preferencia de género.
     * Solo incluye películas con stock disponible.
     * rutCliente el RUT del cliente
     * retorna lista de películas sugeridas
     */
    public ArrayList<Pelicula> sugerirPeliculas(String rutCliente) 
    {

        ArrayList<Pelicula> sugerencias = new ArrayList<Pelicula>();
        Cliente cliente = clientes.get(rutCliente);

            if (cliente == null) 
            {
                return sugerencias;
            }

            String preferencia = cliente.getPreferencia();
            Collection<Pelicula> coleccionPeliculas = peliculas.values();

            for (Pelicula pelicula : coleccionPeliculas) 
            {
                if (pelicula.getStock() > 0) 
                {
                    if (pelicula.getGenero().equalsIgnoreCase(preferencia)) 
                    {
                    sugerencias.add(pelicula);
                    }
                }
            }
        return sugerencias;
    }

    /*
     * Guarda la lista de películas en un archivo de texto.
     * nombreArchivo el nombre del archivo donde guardar
     */
    public void guardarPeliculasEnArchivo(String nombreArchivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));

            for (Pelicula pelicula : peliculas.values()) {
                writer.write(pelicula.getIdPelicula() + ";" +
                        pelicula.getNombrePe() + ";" +
                        pelicula.getGenero() + ";" +
                        pelicula.getDuracion() + ";" +
                        pelicula.getStock() + ";" +
                        pelicula.getVecesArrendada());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar peliculas: " + e.getMessage());
        }
    }

}
