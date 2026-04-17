/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author veget
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    /**
     * Método principal que inicia el programa del VideoClub.
     * Carga los datos desde archivos, permite seleccionar entre modo consola o ventanas,
     * y guarda los datos al salir.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        VideoClub sistema = new VideoClub();
    
        sistema.cargarClientesDesdeArchivo("clientes.txt");
        sistema.cargarPeliculasDesdeArchivo("peliculas.txt");

        if (sistema.listarClientes().size() == 0 && sistema.listarPeliculas().size() == 0) {
            sistema.cargarDatosIniciales();
        }

        int modo;

        do {
            System.out.println("\nSeleccione modo de uso:");
            System.out.println("1. Consola");
            System.out.println("2. Ventanas");
            System.out.println("0. Salir del programa");
            System.out.print("Opcion: ");
            modo = teclado.nextInt();
            teclado.nextLine();

            switch (modo) {
                case 1:
                    menuConsola(teclado, sistema);
                    break;
                case 2:
                    menuVentanas(sistema);
                    break;
                case 0:
                    sistema.guardarClientesEnArchivo("clientes.txt");
                    sistema.guardarPeliculasEnArchivo("peliculas.txt");
                    System.out.println("Datos guardados. Programa finalizado.");
                    break;
                default:
                    System.out.println("Modo invalido");
            }

        } while (modo != 0);

        teclado.close();
    }

    /**
     * Muestra el menú principal en modo consola y maneja la selección de opciones.
     * Permite gestionar clientes, películas, arriendos y sugerencias.
     * @param teclado Scanner para leer entrada del usuario
     * @param sistema instancia de VideoClub para operaciones
     */
    public static void menuConsola(Scanner teclado, VideoClub sistema) {
        int opcionPrincipal;

        do {
            System.out.println("\n========= VIDEO CLUB =========");
            System.out.println("1. Gestionar clientes");
            System.out.println("2. Gestionar peliculas");
            System.out.println("3. Gestionar arriendos");
            System.out.println("4. Sugerir peliculas a cliente");
            System.out.println("0. Volver al selector de modo");
            System.out.print("Seleccione una opcion: ");
            opcionPrincipal = teclado.nextInt();
            teclado.nextLine();

            switch (opcionPrincipal) {
                case 1:
                    menuClientes(teclado, sistema);
                    break;
                case 2:
                    menuPeliculas(teclado, sistema);
                    break;
                case 3:
                    menuArriendos(teclado, sistema);
                    break;
                case 4:
                    sugerirPeliculasCliente(teclado, sistema);
                    break;
                case 0:
                    System.out.println("Volviendo al selector de modo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcionPrincipal != 0);
    }

    public static void menuClientes(Scanner teclado, VideoClub sistema) {
        int opcion;

        do {
            System.out.println("\n------ MENU CLIENTES ------");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente por rut");
            System.out.println("4. Modificar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Buscar cliente por nombre");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    agregarCliente(teclado, sistema);
                    break;
                case 2:
                    listarClientes(sistema);
                    break;
                case 3:
                    buscarCliente(teclado, sistema);
                    break;
                case 4:
                    modificarCliente(teclado, sistema);
                    break;
                case 5:
                    eliminarCliente(teclado, sistema);
                    break;
                case 6:
                    buscarClientePorNombre(teclado, sistema);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }
    public static void buscarClientePorNombre(Scanner teclado, VideoClub sistema) 
    {
        String nombre;
        Cliente cliente;

        System.out.print("Ingrese nombre del cliente: ");
        nombre = teclado.nextLine();

        cliente = sistema.buscarCliente(nombre, true);

        if (cliente != null) 
        {
            System.out.println(cliente);
        }   
        else 
        {
            System.out.println("Cliente no encontrado");
        }
}

    public static void menuPeliculas(Scanner teclado, VideoClub sistema) {
        int opcion;

        do {
            System.out.println("\n------ MENU PELICULAS ------");
            System.out.println("1. Agregar pelicula");
            System.out.println("2. Listar peliculas");
            System.out.println("3. Buscar pelicula por ID");
            System.out.println("4. Modificar pelicula");
            System.out.println("5. Eliminar pelicula");
            System.out.println("6. Buscar pelicula por nombre");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    agregarPelicula(teclado, sistema);
                    break;
                case 2:
                    listarPeliculas(sistema);
                    break;
                case 3:
                    buscarPelicula(teclado, sistema);
                    break;
                case 4:
                    modificarPelicula(teclado, sistema);
                    break;
                case 5:
                    eliminarPelicula(teclado, sistema);
                    break;
                case 6:
                    buscarPeliculaPorNombre(teclado, sistema);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }
    
    public static void buscarPeliculaPorNombre(Scanner teclado, VideoClub sistema) 
    {
        String nombre;
        Pelicula pelicula;

        System.out.print("Ingrese nombre de la pelicula: ");
        nombre = teclado.nextLine();

        pelicula = sistema.buscarPelicula(nombre, true);

        if (pelicula != null) {
            System.out.println(pelicula);
        } 
        else 
        {
            System.out.println("Pelicula no encontrada");
        }
    }

    public static void menuArriendos(Scanner teclado, VideoClub sistema) {
        int opcion;

        do {
            System.out.println("\n------ MENU ARRIENDOS ------");
            System.out.println("1. Registrar arriendo");
            System.out.println("2. Registrar devolucion");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    registrarArriendo(teclado, sistema);
                    break;
                case 2:
                    registrarDevolucion(teclado, sistema);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }

    /**
     * Solicita datos al usuario para crear un nuevo cliente y lo agrega al sistema.
     * @param teclado Scanner para leer entrada del usuario
     * @param sistema instancia de VideoClub
     */
    public static void agregarCliente(Scanner teclado, VideoClub sistema) {
        String nombre;
        String rut;
        String preferencia;
        boolean agregado;

        System.out.print("Nombre del cliente: ");
        nombre = teclado.nextLine();
        System.out.print("Rut del cliente: ");
        rut = teclado.nextLine();
        System.out.print("Preferencia del cliente: ");
        preferencia = teclado.nextLine();

        Cliente cliente = new Cliente(nombre, rut, preferencia);
        agregado = sistema.agregarCliente(cliente);

        if (agregado) {
            System.out.println("Cliente agregado correctamente");
        } else {
            System.out.println("No se pudo agregar el cliente");
        }
    }

    /**
     * Lista todos los clientes registrados en el sistema.
     * @param sistema instancia de VideoClub
     */
    public static void listarClientes(VideoClub sistema) {
        ArrayList<Cliente> lista = sistema.listarClientes();
        int i;
        int n = lista.size();

        if (n == 0) {
            System.out.println("No hay clientes registrados");
            return;
        }

        for (i = 0; i < n; i++) {
            System.out.println(lista.get(i));
        }
    }

    /**
     * Busca un cliente por su RUT y muestra su información.
     * @param teclado Scanner para leer entrada del usuario
     * @param sistema instancia de VideoClub
     */
    public static void buscarCliente(Scanner teclado, VideoClub sistema) {
        String rut;
        Cliente cliente;

        System.out.print("Ingrese rut del cliente: ");
        rut = teclado.nextLine();

        cliente = sistema.buscarCliente(rut);

        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    /**
     * Modifica los datos de un cliente existente identificado por su RUT.
     * @param teclado Scanner para leer entrada del usuario
     * @param sistema instancia de VideoClub
     */
    public static void modificarCliente(Scanner teclado, VideoClub sistema) {
        String rut;
        String nuevoNombre;
        String nuevaPreferencia;
        boolean modificado;

        System.out.print("Ingrese rut del cliente a modificar: ");
        rut = teclado.nextLine();
        System.out.print("Nuevo nombre: ");
        nuevoNombre = teclado.nextLine();
        System.out.print("Nueva preferencia: ");
        nuevaPreferencia = teclado.nextLine();

        modificado = sistema.modificarCliente(rut, nuevoNombre, nuevaPreferencia);

        if (modificado) {
            System.out.println("Cliente modificado correctamente");
        } else {
            System.out.println("No se pudo modificar el cliente");
        }
    }

    /**
     * Elimina un cliente del sistema por su RUT.
     * @param teclado Scanner para leer entrada del usuario
     * @param sistema instancia de VideoClub
     */
    public static void eliminarCliente(Scanner teclado, VideoClub sistema) {
        String rut;
        boolean eliminado;

        System.out.print("Ingrese rut del cliente a eliminar: ");
        rut = teclado.nextLine();

        eliminado = sistema.eliminarCliente(rut);

        if (eliminado) {
            System.out.println("Cliente eliminado correctamente");
        } else {
            System.out.println("No se pudo eliminar el cliente");
        }
    }

    /**
     * Solicita datos al usuario para crear una nueva película y la agrega al sistema.
     * @param teclado Scanner para leer entrada del usuario
     * @param sistema instancia de VideoClub
     */
    public static void agregarPelicula(Scanner teclado, VideoClub sistema) {
        String id;
        String nombre;
        String genero;
        int duracion;
        int stock;
        boolean agregada;

        System.out.print("ID de la pelicula: ");
        id = teclado.nextLine();
        System.out.print("Nombre de la pelicula: ");
        nombre = teclado.nextLine();
        System.out.print("Genero: ");
        genero = teclado.nextLine();
        System.out.print("Duracion: ");
        duracion = teclado.nextInt();
        System.out.print("Stock: ");
        stock = teclado.nextInt();
        teclado.nextLine();

        Pelicula pelicula = new Pelicula(id, nombre, genero, duracion, stock);
        agregada = sistema.agregarPelicula(pelicula);

        if (agregada) {
            System.out.println("Pelicula agregada correctamente");
        } else {
            System.out.println("No se pudo agregar la pelicula");
        }
    }

    /**
     * Lista todas las películas registradas en el sistema.
     * @param sistema instancia de VideoClub
     */
    public static void listarPeliculas(VideoClub sistema) {
        ArrayList<Pelicula> lista = sistema.listarPeliculas();
        int i;
        int n = lista.size();

        if (n == 0) {
            System.out.println("No hay peliculas registradas");
            return;
        }

        for (i = 0; i < n; i++) {
            System.out.println(lista.get(i));
        }
    }

    /**
     * Busca una película por su ID y muestra su información.
     * @param teclado Scanner para leer entrada del usuario
     * @param sistema instancia de VideoClub
     */
    public static void buscarPelicula(Scanner teclado, VideoClub sistema) {
        String id;
        Pelicula pelicula;

        System.out.print("Ingrese ID de la pelicula: ");
        id = teclado.nextLine();

        pelicula = sistema.buscarPelicula(id);

        if (pelicula != null) {
            System.out.println(pelicula);
        } else {
            System.out.println("Pelicula no encontrada");
        }
    }

    /**
     * Modifica los datos de una película existente identificada por su ID.
     * @param teclado Scanner para leer entrada del usuario
     * @param sistema instancia de VideoClub
     */
    public static void modificarPelicula(Scanner teclado, VideoClub sistema) {
        String id;
        String nuevoNombre;
        String nuevoGenero;
        int nuevaDuracion;
        int nuevoStock;
        boolean modificada;

        System.out.print("Ingrese ID de la pelicula a modificar: ");
        id = teclado.nextLine();
        System.out.print("Nuevo nombre: ");
        nuevoNombre = teclado.nextLine();
        System.out.print("Nuevo genero: ");
        nuevoGenero = teclado.nextLine();
        System.out.print("Nueva duracion: ");
        nuevaDuracion = teclado.nextInt();
        System.out.print("Nuevo stock: ");
        nuevoStock = teclado.nextInt();
        teclado.nextLine();

        modificada = sistema.modificarPelicula(id, nuevoNombre, nuevoGenero, nuevaDuracion, nuevoStock);

        if (modificada) {
            System.out.println("Pelicula modificada correctamente");
        } else {
            System.out.println("No se pudo modificar la pelicula");
        }
    }

    /**
     * Elimina una película del sistema por su ID.
     * @param teclado Scanner para leer entrada del usuario
     * @param sistema instancia de VideoClub
     */
    public static void eliminarPelicula(Scanner teclado, VideoClub sistema) {
        String id;
        boolean eliminada;

        System.out.print("Ingrese ID de la pelicula a eliminar: ");
        id = teclado.nextLine();

        eliminada = sistema.eliminarPelicula(id);

        if (eliminada) {
            System.out.println("Pelicula eliminada correctamente");
        } else {
            System.out.println("No se pudo eliminar la pelicula");
        }
    }

    /**
     * Registra un nuevo arriendo de película para un cliente, manejando excepciones.
     * @param teclado Scanner para leer entrada del usuario
     * @param sistema instancia de VideoClub
     */
    public static void registrarArriendo(Scanner teclado, VideoClub sistema) {
        String idArriendo;
        String rutCliente;
        String idPelicula;
        String fechaArriendo;
        String fechaDevolucion;
        boolean registrado;

        System.out.print("ID del arriendo: ");
        idArriendo = teclado.nextLine();
        System.out.print("Rut del cliente: ");
        rutCliente = teclado.nextLine();
        System.out.print("ID de la pelicula: ");
        idPelicula = teclado.nextLine();
        System.out.print("Fecha de arriendo: ");
        fechaArriendo = teclado.nextLine();
        System.out.print("Fecha de devolucion: ");
        fechaDevolucion = teclado.nextLine();

        try {
            registrado = sistema.registrarArriendoConExcepciones(idArriendo, rutCliente, idPelicula, fechaArriendo, fechaDevolucion);

            if (registrado) {
                System.out.println("Arriendo registrado correctamente");
            }
        } 
        catch (ClienteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        catch (PeliculaSinStockException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Registra la devolución de una película arrendada.
     * @param teclado Scanner para leer entrada del usuario
     * @param sistema instancia de VideoClub
     */
    public static void registrarDevolucion(Scanner teclado, VideoClub sistema) {
        String idArriendo;
        boolean devuelto;

        System.out.print("Ingrese ID del arriendo a devolver: ");
        idArriendo = teclado.nextLine();

        devuelto = sistema.registrarDevolucion(idArriendo);

        if (devuelto) {
            System.out.println("Devolucion registrada correctamente");
        } else {
            System.out.println("No se pudo registrar la devolucion");
        }
    }
    /**
     * Sugiere películas a un cliente basado en su preferencia de género.
     * @param teclado Scanner para leer entrada del usuario
     * @param sistema instancia de VideoClub
     */
    public static void sugerirPeliculasCliente(Scanner teclado, VideoClub sistema) 
    {
        String rut;
        ArrayList<Pelicula> sugerencias;
        int i;
        int n;

        System.out.print("Ingrese rut del cliente: ");
        rut = teclado.nextLine();

        sugerencias = sistema.sugerirPeliculas(rut);
        n = sugerencias.size();

        if (n == 0) 
        {
            System.out.println("No hay sugerencias disponibles para este cliente");
            return;
        }

        System.out.println("Peliculas sugeridas:");
        for (i = 0; i < n; i++) 
        {
            System.out.println(sugerencias.get(i));
        }
    }
    public static void menuVentanas(VideoClub sistema) {
        String opcion;

        do {
            opcion = JOptionPane.showInputDialog(
                null,
                "VIDEO CLUB\n" +
                "1. Agregar cliente\n" +
                "2. Listar clientes\n" +
                "3. Buscar cliente\n" +
                "4. Modificar cliente\n" +
                "5. Eliminar cliente\n" +
                "6. Agregar pelicula\n" +
                "7. Listar peliculas\n" +
                "8. Buscar pelicula\n" +
                "9. Modificar pelicula\n" +
                "10. Eliminar pelicula\n" +
                "11. Registrar arriendo\n" +
                "12. Registrar devolucion\n" +
                "13. Sugerir peliculas\n" +
                "0. Volver al selector",
                "Menu Ventanas",
                JOptionPane.PLAIN_MESSAGE);

            if (opcion == null) {
                opcion = "0";
            }

            switch (opcion) {
                case "1":
                    agregarClienteVentana(sistema);
                    break;
                case "2":
                    listarClientesVentana(sistema);
                    break;
                case "3":
                    buscarClienteVentana(sistema);
                    break;
                case "4":
                    modificarClienteVentana(sistema);
                    break;
                case "5":
                    eliminarClienteVentana(sistema);
                    break;
                case "6":
                    agregarPeliculaVentana(sistema);
                    break;
                case "7":
                    listarPeliculasVentana(sistema);
                    break;
                case "8":
                    buscarPeliculaVentana(sistema);
                    break;
                case "9":
                    modificarPeliculaVentana(sistema);
                    break;
                case "10":
                    eliminarPeliculaVentana(sistema);
                    break;
                case "11":
                    registrarArriendoVentana(sistema);
                    break;
                case "12":
                    registrarDevolucionVentana(sistema);
                    break;
                case "13":
                    sugerirPeliculasVentana(sistema);
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Volviendo al selector...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }

        } while (!opcion.equals("0"));
    }
    
    public static void agregarClienteVentana(VideoClub sistema) {
        String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
        String rut = JOptionPane.showInputDialog("Rut del cliente:");
        String preferencia = JOptionPane.showInputDialog("Preferencia del cliente:");

        Cliente cliente = new Cliente(nombre, rut, preferencia);
        boolean agregado = sistema.agregarCliente(cliente);

        if (agregado) {
            JOptionPane.showMessageDialog(null, "Cliente agregado correctamente");
        } 
        else {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el cliente");
        }
    }

    public static void listarClientesVentana(VideoClub sistema) {
    ArrayList<Cliente> lista = sistema.listarClientes();
        String mensaje = "";
        int i;
        int n = lista.size();

        if (n == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados");
            return;
        }

        for (i = 0; i < n; i++) {
            mensaje = mensaje + lista.get(i) + "\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }  

    public static void agregarPeliculaVentana(VideoClub sistema) {
        String id = JOptionPane.showInputDialog("ID de la pelicula:");
        String nombre = JOptionPane.showInputDialog("Nombre de la pelicula:");
        String genero = JOptionPane.showInputDialog("Genero:");
        int duracion = Integer.parseInt(JOptionPane.showInputDialog("Duracion:"));
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Stock:"));

        Pelicula pelicula = new Pelicula(id, nombre, genero, duracion, stock);
        boolean agregada = sistema.agregarPelicula(pelicula);

        if (agregada) {
            JOptionPane.showMessageDialog(null, "Pelicula agregada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo agregar la pelicula");
        }
    }

    public static void listarPeliculasVentana(VideoClub sistema) {
        ArrayList<Pelicula> lista = sistema.listarPeliculas();
        String mensaje = "";
        int i;
        int n = lista.size();

        if (n == 0) {
            JOptionPane.showMessageDialog(null, "No hay peliculas registradas");
            return;
        }

        for (i = 0; i < n; i++) {
            mensaje = mensaje + lista.get(i) + "\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }    

    public static void sugerirPeliculasVentana(VideoClub sistema) {
        String rut = JOptionPane.showInputDialog("Rut del cliente:");
        ArrayList<Pelicula> sugerencias = sistema.sugerirPeliculas(rut);
        String mensaje = "";
        int i;
        int n = sugerencias.size();

        if (n == 0) {
            JOptionPane.showMessageDialog(null, "No hay sugerencias disponibles");
            return;
        }

        for (i = 0; i < n; i++) {
            mensaje = mensaje + sugerencias.get(i) + "\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }   

    public static void buscarClienteVentana(VideoClub sistema) {
        String rut = JOptionPane.showInputDialog("Rut del cliente:");
        Cliente cliente = sistema.buscarCliente(rut);

        if (cliente != null) {
            JOptionPane.showMessageDialog(null, cliente.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
        }
    }
 
    public static void modificarClienteVentana(VideoClub sistema) {
        String rut = JOptionPane.showInputDialog("Rut del cliente a modificar:");
        String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");
        String nuevaPreferencia = JOptionPane.showInputDialog("Nueva preferencia:");

        boolean modificado = sistema.modificarCliente(rut, nuevoNombre, nuevaPreferencia);

        if (modificado) {
            JOptionPane.showMessageDialog(null, "Cliente modificado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el cliente");
        }
    }

    public static void eliminarClienteVentana(VideoClub sistema) {
        String rut = JOptionPane.showInputDialog("Rut del cliente a eliminar:");
        boolean eliminado = sistema.eliminarCliente(rut);

        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el cliente");
        }
    }

    public static void buscarPeliculaVentana(VideoClub sistema) {
        String id = JOptionPane.showInputDialog("ID de la pelicula:");
        Pelicula pelicula = sistema.buscarPelicula(id);

        if (pelicula != null) {
            JOptionPane.showMessageDialog(null, pelicula.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Pelicula no encontrada");
        }
    }

    public static void modificarPeliculaVentana(VideoClub sistema) {
        String id = JOptionPane.showInputDialog("ID de la pelicula a modificar:");
        String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");
        String nuevoGenero = JOptionPane.showInputDialog("Nuevo genero:");
        int nuevaDuracion = Integer.parseInt(JOptionPane.showInputDialog("Nueva duracion:"));
        int nuevoStock = Integer.parseInt(JOptionPane.showInputDialog("Nuevo stock:"));

        boolean modificada = sistema.modificarPelicula(id, nuevoNombre, nuevoGenero, nuevaDuracion, nuevoStock);

        if (modificada) {
            JOptionPane.showMessageDialog(null, "Pelicula modificada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo modificar la pelicula");
        }
    }

    public static void eliminarPeliculaVentana(VideoClub sistema) {
        String id = JOptionPane.showInputDialog("ID de la pelicula a eliminar:");
        boolean eliminada = sistema.eliminarPelicula(id);

        if (eliminada) {
            JOptionPane.showMessageDialog(null, "Pelicula eliminada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la pelicula");
        }
    }

    public static void registrarArriendoVentana(VideoClub sistema) {
        String idArriendo = JOptionPane.showInputDialog("ID del arriendo:");
        String rutCliente = JOptionPane.showInputDialog("Rut del cliente:");
        String idPelicula = JOptionPane.showInputDialog("ID de la pelicula:");
        String fechaArriendo = JOptionPane.showInputDialog("Fecha de arriendo:");
        String fechaDevolucion = JOptionPane.showInputDialog("Fecha de devolucion:");

        try {
            boolean registrado = sistema.registrarArriendoConExcepciones(
                    idArriendo, rutCliente, idPelicula, fechaArriendo, fechaDevolucion);

            if (registrado) {
                JOptionPane.showMessageDialog(null, "Arriendo registrado correctamente");
            }
        } catch (ClienteNoEncontradoException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } catch (PeliculaSinStockException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static void registrarDevolucionVentana(VideoClub sistema) {
        String idArriendo = JOptionPane.showInputDialog("ID del arriendo a devolver:");
        boolean devuelto = sistema.registrarDevolucion(idArriendo);

        if (devuelto) {
            JOptionPane.showMessageDialog(null, "Devolucion registrada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la devolucion");
        }
    }

}