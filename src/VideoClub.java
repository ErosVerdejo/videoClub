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

    /*
     * Retorna la cantidad de clientes registrados en el sistema.
     */
    public int getCantidadClientes() {
        return clientes.size();
    }

    /*
     * Retorna la cantidad de peliculas registradas en el sistema.
     */
    public int getCantidadPeliculas() {
        return peliculas.size();
    }

    /*
     * Retorna la cantidad de arriendos registrados en el sistema.
     */
    public int getCantidadArriendos() {
        return arriendos.size();
    }

    /*
     * Busca un cliente por nombre o por RUT según el parámetro indicado.
     * dato el nombre o RUT a buscar
     * buscarPorNombre true para buscar por nombre, false para buscar por RUT
     * retorna el cliente encontrado o null si no existe
     */
    public Cliente buscarCliente(String dato, boolean buscarPorNombre) {
        if (!buscarPorNombre) {
            return buscarCliente(dato);
        }

        for (Cliente cliente : clientes.values()) {
            if (cliente.getNombre().equalsIgnoreCase(dato)) {
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

        if (clientes.containsKey(cliente.getRut())) {
            return false;
        }

        clientes.put(cliente.getRut(), cliente);
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

    /*
     * Busca una película por nombre o por ID según el parámetro indicado.
     * dato el nombre o ID a buscar
     * buscarPorNombre true para buscar por nombre, false para buscar por ID
     * retorna la película encontrada o null si no existe
     */
    public Pelicula buscarPelicula(String dato, boolean buscarPorNombre) {
        if (!buscarPorNombre) {
            return buscarPelicula(dato);
        }

        for (Pelicula pelicula : peliculas.values()) {
            if (pelicula.getNombrePe().equalsIgnoreCase(dato)) {
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
    public Pelicula buscarPelicula(String idPelicula) {
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

        cliente.setNombre(nuevoNombre);
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

    /*
     * Registra un arriendo usando excepciones para informar errores específicos.
     * idArriendo el ID del arriendo
     * rutCliente el RUT del cliente
     * idPelicula el ID de la película
     * fechaArriendo fecha de arriendo
     * fechaDevolucion fecha de devolución
     * retorna true si se registró correctamente
     * throws ClienteNoEncontradoException si el cliente no existe
     * throws PeliculaSinStockException si la película no tiene stock
     */
    public boolean registrarArriendoConExcepciones(String idArriendo, String rutCliente, String idPelicula, String fechaArriendo, String fechaDevolucion)
            throws ClienteNoEncontradoException, PeliculaSinStockException {

        Cliente cliente = clientes.get(rutCliente);
        if (cliente == null) {
            throw new ClienteNoEncontradoException("Cliente con RUT " + rutCliente + " no encontrado.");
        }

        Pelicula pelicula = peliculas.get(idPelicula);
        if (pelicula == null) {
            throw new PeliculaSinStockException("Pelicula con ID " + idPelicula + " no encontrada.");
        }

        if (!pelicula.hayStock()) {
            throw new PeliculaSinStockException("La pelicula '" + pelicula.getNombrePe() + "' no tiene stock disponible.");
        }

        Arriendo arriendo = new Arriendo(idArriendo, cliente, pelicula, fechaArriendo, fechaDevolucion);
        arriendos.add(arriendo);
        cliente.agregarArriendo(arriendo);
        pelicula.disminuirStock();
        pelicula.aumentarVecesArrendada();

        return true;
    }

    /*
     * Registra la devolución de un arriendo.
     * idArriendo el ID del arriendo a devolver
     * retorna true si se registró correctamente, false si no existe o ya fue devuelto
     */
    public boolean registrarDevolucion(String idArriendo) {
        for (Arriendo arriendo : arriendos) {
            if (arriendo.getIdArriendo().equals(idArriendo)) {
                if (!arriendo.isDevuelto()) {
                    arriendo.devolver();
                    arriendo.getPelicula().aumentarStock();
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /*
     * Guarda la lista de clientes en un archivo de texto.
     * nombreArchivo el nombre del archivo donde guardar
     */
    public void guardarClientesEnArchivo(String nombreArchivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));

            for (Cliente cliente : clientes.values()) {
                writer.write(cliente.getNombre() + ";" + cliente.getRut() + ";" + cliente.getPreferencia());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
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
        } catch (IOException e) {
            System.out.println("Error al cargar clientes: " + e.getMessage());
        }
    }

    /*
     * Carga la lista de películas desde un archivo de texto.
     * Formato: id;nombre;genero;duracion;stock;vecesArrendada;tipo;campoExtra
     * tipo puede ser: general, estreno, clasica
     * campoExtra es el anio de estreno (int) para estreno, o la decada (String) para clasica
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

                    String tipo = partes.length >= 7 ? partes[6] : "general";
                    String campoExtra = partes.length >= 8 ? partes[7] : "";

                    Pelicula pelicula;

                    if (tipo.equalsIgnoreCase("estreno")) {
                        int anio = campoExtra.isEmpty() ? 2024 : Integer.parseInt(campoExtra);
                        pelicula = new PeliculaEstreno(id, nombre, genero, duracion, stock, anio);
                    } else if (tipo.equalsIgnoreCase("clasica")) {
                        String decada = campoExtra.isEmpty() ? "2000" : campoExtra;
                        pelicula = new PeliculaClasica(id, nombre, genero, duracion, stock, decada);
                    } else {
                        // Si el tipo es desconocido o "general", se trata como estreno por defecto
                        pelicula = new PeliculaEstreno(id, nombre, genero, duracion, stock, 2000);
                    }

                    pelicula.setVecesArrendada(vecesArrendada);
                    agregarPelicula(pelicula);
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error al cargar peliculas: " + e.getMessage());
        }
    }

    /*
     * Guarda la lista de películas en un archivo de texto.
     * Formato: id;nombre;genero;duracion;stock;vecesArrendada;tipo;campoExtra
     * nombreArchivo el nombre del archivo donde guardar
     */
    public void guardarPeliculasEnArchivo(String nombreArchivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));

            for (Pelicula pelicula : peliculas.values()) {
                String base = pelicula.getIdPelicula() + ";" +
                        pelicula.getNombrePe() + ";" +
                        pelicula.getGenero() + ";" +
                        pelicula.getDuracion() + ";" +
                        pelicula.getStock() + ";" +
                        pelicula.getVecesArrendada();

                if (pelicula instanceof PeliculaEstreno) {
                    writer.write(base + ";estreno;" + ((PeliculaEstreno) pelicula).getAnioEstreno());
                } else if (pelicula instanceof PeliculaClasica) {
                    writer.write(base + ";clasica;" + ((PeliculaClasica) pelicula).getDecada());
                } else {
                    writer.write(base + ";general;");
                }
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar peliculas: " + e.getMessage());
        }
    }

    /*
     * Guarda la lista de arriendos en un archivo de texto.
     * Formato: idArriendo;rutCliente;idPelicula;fechaArriendo;fechaDevolucion;devuelto
     * nombreArchivo el nombre del archivo donde guardar
     */
    public void guardarArriendosEnArchivo(String nombreArchivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));

            for (Arriendo arriendo : arriendos) {
                writer.write(
                    arriendo.getIdArriendo() + ";" +
                    arriendo.getCliente().getRut() + ";" +
                    arriendo.getPelicula().getIdPelicula() + ";" +
                    arriendo.getFechaArriendo() + ";" +
                    arriendo.getFechaDevolucion() + ";" +
                    arriendo.isDevuelto()
                );
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar arriendos: " + e.getMessage());
        }
    }

    /*
     * Carga la lista de arriendos desde un archivo de texto.
     * Requiere que clientes y peliculas ya estén cargados en el sistema.
     * Formato: idArriendo;rutCliente;idPelicula;fechaArriendo;fechaDevolucion;devuelto
     * nombreArchivo el nombre del archivo desde donde cargar
     */
    public void cargarArriendosDesdeArchivo(String nombreArchivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");

                if (partes.length == 6) {
                    String idArriendo = partes[0];
                    String rutCliente = partes[1];
                    String idPelicula = partes[2];
                    String fechaArriendo = partes[3];
                    String fechaDevolucion = partes[4];
                    boolean devuelto = Boolean.parseBoolean(partes[5]);

                    Cliente cliente = clientes.get(rutCliente);
                    Pelicula pelicula = peliculas.get(idPelicula);

                    // Solo carga si tanto el cliente como la pelicula existen en el sistema
                    if (cliente != null && pelicula != null) {
                        Arriendo arriendo = new Arriendo(idArriendo, cliente, pelicula, fechaArriendo, fechaDevolucion);
                        arriendo.setDevuelto(devuelto);
                        arriendos.add(arriendo);
                        cliente.agregarArriendo(arriendo);
                    }
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error al cargar arriendos: " + e.getMessage());
        }
    }

    /*
     * Carga datos iniciales de ejemplo al sistema.
     * Incluye clientes, películas y algunos arriendos.
     */
    public void cargarDatosIniciales() {
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
    public ArrayList<Pelicula> sugerirPeliculas(String rutCliente) {
        ArrayList<Pelicula> sugerencias = new ArrayList<Pelicula>();
        Cliente cliente = clientes.get(rutCliente);

        if (cliente == null) {
            return sugerencias;
        }

        String preferencia = cliente.getPreferencia();
        Collection<Pelicula> coleccionPeliculas = peliculas.values();

        for (Pelicula pelicula : coleccionPeliculas) {
            if (pelicula.getStock() > 0) {
                if (pelicula.getGenero().equalsIgnoreCase(preferencia)) {
                    sugerencias.add(pelicula);
                }
            }
        }
        return sugerencias;
    }

    /*
     * Sugiere películas populares (más arrendadas) con stock disponible.
     * retorna lista de películas populares ordenadas por veces arrendadas
     */
    public ArrayList<Pelicula> sugerirPeliculasPopulares() {
        ArrayList<Pelicula> populares = new ArrayList<Pelicula>();
        Collection<Pelicula> coleccionPeliculas = peliculas.values();

        for (Pelicula pelicula : coleccionPeliculas) {
            if (pelicula.getStock() > 0) {
                populares.add(pelicula);
            }
        }

        for (int i = 0; i < populares.size(); i++) {
            for (int j = i + 1; j < populares.size(); j++) {
                if (populares.get(j).getVecesArrendada() > populares.get(i).getVecesArrendada()) {
                    Pelicula temp = populares.get(i);
                    populares.set(i, populares.get(j));
                    populares.set(j, temp);
                }
            }
        }

        return populares;
    }

    /*
     * Sugiere películas estrenos (nuevas) con stock disponible.
     * retorna lista de películas de tipo PeliculaEstreno
     */
    public ArrayList<Pelicula> sugerirPeliculasEstrenos() {
        ArrayList<Pelicula> estrenos = new ArrayList<Pelicula>();
        Collection<Pelicula> coleccionPeliculas = peliculas.values();

        for (Pelicula pelicula : coleccionPeliculas) {
            if (pelicula instanceof PeliculaEstreno && pelicula.getStock() > 0) {
                estrenos.add(pelicula);
            }
        }
        return estrenos;
    }

    /*
     * Sugiere películas clásicas con stock disponible.
     * retorna lista de películas de tipo PeliculaClasica
     */
    public ArrayList<Pelicula> sugerirPeliculasClasicas() {
        ArrayList<Pelicula> clasicas = new ArrayList<Pelicula>();
        Collection<Pelicula> coleccionPeliculas = peliculas.values();

        for (Pelicula pelicula : coleccionPeliculas) {
            if (pelicula instanceof PeliculaClasica && pelicula.getStock() > 0) {
                clasicas.add(pelicula);
            }
        }
        return clasicas;
    }

    /*
     * Sugiere películas por género específico con stock disponible.
     * genero el género de películas a sugerir
     * retorna lista de películas del género especificado
     */
    public ArrayList<Pelicula> sugerirPeliculasPorGenero(String genero) {
        ArrayList<Pelicula> porGenero = new ArrayList<Pelicula>();
        Collection<Pelicula> coleccionPeliculas = peliculas.values();

        for (Pelicula pelicula : coleccionPeliculas) {
            if (pelicula.getStock() > 0 && pelicula.getGenero().equalsIgnoreCase(genero)) {
                porGenero.add(pelicula);
            }
        }
        return porGenero;
    }
}