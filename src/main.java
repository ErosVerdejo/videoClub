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
import javax.swing.JFrame;

public class main {
    // JFrame invisible para que los diálogos aparezcan en primer plano
    private static JFrame frameParent;

    /**
     * Lee un número entero desde consola de forma segura.
     * Si el usuario ingresa algo que no es número, muestra un mensaje de error
     * y retorna -1 para que el menú lo trate como opción inválida.
     * @param teclado Scanner para leer entrada del usuario
     * @return el entero ingresado, o -1 si la entrada es inválida
     */
    public static int leerEnteroConsola(Scanner teclado) {
        try {
            int valor = Integer.parseInt(teclado.nextLine().trim());
            return valor;
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un numero entero valido.");
            return -1;
        }
    }

    /**
     * Método principal que inicia el programa del VideoClub.
     * Carga los datos desde archivos, permite seleccionar entre modo consola o ventanas,
     * y guarda los datos al salir.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        frameParent = new JFrame();
        frameParent.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frameParent.setVisible(false);
        frameParent.setFocusableWindowState(true);

        Scanner teclado = new Scanner(System.in);
        VideoClub sistema = new VideoClub();

        sistema.cargarClientesDesdeArchivo("clientes.txt");
        sistema.cargarPeliculasDesdeArchivo("peliculas.txt");

        if (sistema.listarClientes().size() == 0 && sistema.listarPeliculas().size() == 0) {
            sistema.cargarDatosIniciales();
        }

        // Los arriendos se cargan DESPUÉS de clientes y peliculas, ya que los necesita
        sistema.cargarArriendosDesdeArchivo("arriendos.txt");

        int modo;

        do {
            System.out.println("\nSeleccione modo de uso:");
            System.out.println("1. Consola");
            System.out.println("2. Ventanas");
            System.out.println("0. Salir del programa");
            System.out.print("Opcion: ");
            modo = leerEnteroConsola(teclado);

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
                    sistema.guardarArriendosEnArchivo("arriendos.txt");
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
            opcionPrincipal = leerEnteroConsola(teclado);

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
            opcion = leerEnteroConsola(teclado);

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

    public static void buscarClientePorNombre(Scanner teclado, VideoClub sistema) {
        String nombre;
        Cliente cliente;

        System.out.print("Ingrese nombre del cliente: ");
        nombre = teclado.nextLine();

        cliente = sistema.buscarCliente(nombre, true);

        if (cliente != null) {
            System.out.println(cliente);
        } else {
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
            opcion = leerEnteroConsola(teclado);

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

    public static void buscarPeliculaPorNombre(Scanner teclado, VideoClub sistema) {
        String nombre;
        Pelicula pelicula;

        System.out.print("Ingrese nombre de la pelicula: ");
        nombre = teclado.nextLine();

        pelicula = sistema.buscarPelicula(nombre, true);

        if (pelicula != null) {
            System.out.println(pelicula);
        } else {
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
            opcion = leerEnteroConsola(teclado);

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
     * Pide el tipo (estreno o clasica) para instanciar la subclase correcta.
     * @param teclado Scanner para leer entrada del usuario
     * @param sistema instancia de VideoClub
     */
    public static void agregarPelicula(Scanner teclado, VideoClub sistema) {
        String id;
        String nombre;
        String genero;
        int duracion;
        int stock;
        int tipo;
        boolean agregada;

        System.out.print("ID de la pelicula: ");
        id = teclado.nextLine();
        System.out.print("Nombre de la pelicula: ");
        nombre = teclado.nextLine();
        System.out.print("Genero: ");
        genero = teclado.nextLine();
        System.out.print("Duracion (minutos): ");
        duracion = leerEnteroConsola(teclado);
        System.out.print("Stock: ");
        stock = leerEnteroConsola(teclado);

        System.out.println("Tipo de pelicula:");
        System.out.println("1. Estreno");
        System.out.println("2. Clasica");
        System.out.print("Seleccione tipo: ");
        tipo = leerEnteroConsola(teclado);

        Pelicula pelicula;

        if (tipo == 1) {
            System.out.print("Anio de estreno: ");
            int anio = leerEnteroConsola(teclado);
            pelicula = new PeliculaEstreno(id, nombre, genero, duracion, stock, anio);
        } else if (tipo == 2) {
            System.out.print("Decada (ej: 1980, 1990, 2000): ");
            String decada = teclado.nextLine();
            pelicula = new PeliculaClasica(id, nombre, genero, duracion, stock, decada);
        } else {
            System.out.println("Tipo invalido. Se creara como Estreno por defecto.");
            pelicula = new PeliculaEstreno(id, nombre, genero, duracion, stock, 2025);
        }

        agregada = sistema.agregarPelicula(pelicula);

        if (agregada) {
            System.out.println("Pelicula agregada correctamente. Precio de arriendo: $" + pelicula.calcularPrecioArriendo());
        } else {
            System.out.println("No se pudo agregar la pelicula (ID ya existe)");
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
        nuevaDuracion = leerEnteroConsola(teclado);
        System.out.print("Nuevo stock: ");
        nuevoStock = leerEnteroConsola(teclado);

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
        } catch (ClienteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (PeliculaSinStockException e) {
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
    public static void sugerirPeliculasCliente(Scanner teclado, VideoClub sistema) {
        String rut;
        ArrayList<Pelicula> sugerencias;
        int i;
        int n;

        System.out.print("Ingrese rut del cliente: ");
        rut = teclado.nextLine();

        sugerencias = sistema.sugerirPeliculas(rut);
        n = sugerencias.size();

        if (n == 0) {
            System.out.println("No hay sugerencias disponibles para este cliente");
            return;
        }

        System.out.println("Peliculas sugeridas:");
        for (i = 0; i < n; i++) {
            System.out.println(sugerencias.get(i).getNombrePe() +
                " | Tipo: " + sugerencias.get(i).getTipoPelicula() +
                " | Precio arriendo: $" + sugerencias.get(i).calcularPrecioArriendo());
        }
    }

    public static void menuVentanas(VideoClub sistema) {
        String opcion;

        do {
            opcion = JOptionPane.showInputDialog(
                frameParent,
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
                    menuSugerenciasVentana(sistema);
                    break;
                case "0":
                    JOptionPane.showMessageDialog(frameParent, "Volviendo al selector...");
                    break;
                default:
                    JOptionPane.showMessageDialog(frameParent, "Opcion invalida");
            }

        } while (!opcion.equals("0"));
    }

    public static void agregarClienteVentana(VideoClub sistema) {
        String nombre = JOptionPane.showInputDialog(frameParent, "Nombre del cliente:");
        String rut = JOptionPane.showInputDialog(frameParent, "Rut del cliente:");
        String preferencia = JOptionPane.showInputDialog(frameParent, "Preferencia del cliente:");

        Cliente cliente = new Cliente(nombre, rut, preferencia);
        boolean agregado = sistema.agregarCliente(cliente);

        if (agregado) {
            JOptionPane.showMessageDialog(frameParent, "Cliente agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(frameParent, "No se pudo agregar el cliente");
        }
    }

    public static void listarClientesVentana(VideoClub sistema) {
        ArrayList<Cliente> lista = sistema.listarClientes();
        String mensaje = "";
        int i;
        int n = lista.size();

        if (n == 0) {
            JOptionPane.showMessageDialog(frameParent, "No hay clientes registrados");
            return;
        }

        for (i = 0; i < n; i++) {
            mensaje = mensaje + lista.get(i) + "\n";
        }

        JOptionPane.showMessageDialog(frameParent, mensaje);
    }

    public static void agregarPeliculaVentana(VideoClub sistema) {
        String id = JOptionPane.showInputDialog(frameParent, "ID de la pelicula:");
        String nombre = JOptionPane.showInputDialog(frameParent, "Nombre de la pelicula:");
        String genero = JOptionPane.showInputDialog(frameParent, "Genero:");

        int duracion;
        int stock;

        try {
            duracion = Integer.parseInt(JOptionPane.showInputDialog(frameParent, "Duracion (minutos):"));
            stock = Integer.parseInt(JOptionPane.showInputDialog(frameParent, "Stock:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frameParent, "Error: Duracion y stock deben ser numeros enteros validos.");
            return;
        }

        String[] opciones = {"Estreno", "Clasica"};
        int tipoSeleccion = JOptionPane.showOptionDialog(frameParent, "Tipo de pelicula:", "Tipo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        Pelicula pelicula;

        if (tipoSeleccion == 0) {
            try {
                int anio = Integer.parseInt(JOptionPane.showInputDialog(frameParent, "Anio de estreno:"));
                pelicula = new PeliculaEstreno(id, nombre, genero, duracion, stock, anio);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frameParent, "Error: El anio debe ser un numero entero valido.");
                return;
            }
        } else {
            String decada = JOptionPane.showInputDialog(frameParent, "Decada (ej: 1980, 1990, 2000):");
            pelicula = new PeliculaClasica(id, nombre, genero, duracion, stock, decada);
        }

        boolean agregada = sistema.agregarPelicula(pelicula);

        if (agregada) {
            JOptionPane.showMessageDialog(frameParent, "Pelicula agregada correctamente.\nPrecio de arriendo: $" + pelicula.calcularPrecioArriendo());
        } else {
            JOptionPane.showMessageDialog(frameParent, "No se pudo agregar la pelicula (ID ya existe)");
        }
    }

    public static void listarPeliculasVentana(VideoClub sistema) {
        ArrayList<Pelicula> lista = sistema.listarPeliculas();
        String mensaje = "";
        int i;
        int n = lista.size();

        if (n == 0) {
            JOptionPane.showMessageDialog(frameParent, "No hay peliculas registradas");
            return;
        }

        for (i = 0; i < n; i++) {
            mensaje = mensaje + lista.get(i) + "\n";
        }

        JOptionPane.showMessageDialog(frameParent, mensaje);
    }

    public static void menuSugerenciasVentana(VideoClub sistema) {
        String opcion;

        do {
            opcion = JOptionPane.showInputDialog(
                frameParent,
                "MENU DE SUGERENCIAS\n" +
                "1. Sugerir por genero preferido\n" +
                "2. Sugerir peliculas populares\n" +
                "3. Sugerir estrenos\n" +
                "4. Sugerir peliculas clasicas\n" +
                "5. Sugerir por genero especifico\n" +
                "0. Volver",
                "Sugerencias",
                JOptionPane.PLAIN_MESSAGE);

            if (opcion == null) {
                opcion = "0";
            }

            switch (opcion) {
                case "1":
                    sugerirPeliculasVentana(sistema);
                    break;
                case "2":
                    sugerirPeliculasPopularesVentana(sistema);
                    break;
                case "3":
                    sugerirPeliculasEstenosVentana(sistema);
                    break;
                case "4":
                    sugerirPeliculasClasicasVentana(sistema);
                    break;
                case "5":
                    sugerirPeliculasPorGeneroVentana(sistema);
                    break;
                case "0":
                    break;
                default:
                    JOptionPane.showMessageDialog(frameParent, "Opcion invalida");
            }
        } while (!opcion.equals("0"));
    }

    public static void sugerirPeliculasVentana(VideoClub sistema) {
        String rut = JOptionPane.showInputDialog(frameParent, "Rut del cliente:");
        ArrayList<Pelicula> sugerencias = sistema.sugerirPeliculas(rut);
        String mensaje = "";
        int i;
        int n = sugerencias.size();

        if (n == 0) {
            JOptionPane.showMessageDialog(frameParent, "No hay sugerencias disponibles para el genero preferido");
            return;
        }

        mensaje = "SUGERENCIAS POR GENERO PREFERIDO:\n\n";
        for (i = 0; i < n; i++) {
            mensaje = mensaje + (i+1) + ". " + sugerencias.get(i).getNombrePe() + " (" + sugerencias.get(i).getGenero() + ")\n";
        }

        JOptionPane.showMessageDialog(frameParent, mensaje);
    }

    public static void sugerirPeliculasPopularesVentana(VideoClub sistema) {
        ArrayList<Pelicula> populares = sistema.sugerirPeliculasPopulares();
        String mensaje = "";
        int i;
        int n = populares.size();

        if (n == 0) {
            JOptionPane.showMessageDialog(frameParent, "No hay peliculas populares disponibles");
            return;
        }

        mensaje = "PELICULAS POPULARES (TOP " + Math.min(n, 10) + "):\n\n";
        for (i = 0; i < Math.min(n, 10); i++) {
            mensaje = mensaje + (i+1) + ". " + populares.get(i).getNombrePe() + " (" + populares.get(i).getVecesArrendada() + " arrendadas)\n";
        }

        JOptionPane.showMessageDialog(frameParent, mensaje);
    }

    public static void sugerirPeliculasEstenosVentana(VideoClub sistema) {
        ArrayList<Pelicula> estrenos = sistema.sugerirPeliculasEstrenos();
        String mensaje = "";
        int i;
        int n = estrenos.size();

        if (n == 0) {
            JOptionPane.showMessageDialog(frameParent, "No hay estrenos disponibles");
            return;
        }

        mensaje = "PELICULAS ESTRENOS DISPONIBLES:\n\n";
        for (i = 0; i < n; i++) {
            PeliculaEstreno estreno = (PeliculaEstreno) estrenos.get(i);
            mensaje = mensaje + (i+1) + ". " + estreno.getNombrePe() + " (" + estreno.getAnioEstreno() + ")\n";
        }

        JOptionPane.showMessageDialog(frameParent, mensaje);
    }

    public static void sugerirPeliculasClasicasVentana(VideoClub sistema) {
        ArrayList<Pelicula> clasicas = sistema.sugerirPeliculasClasicas();
        String mensaje = "";
        int i;
        int n = clasicas.size();

        if (n == 0) {
            JOptionPane.showMessageDialog(frameParent, "No hay peliculas clasicas disponibles");
            return;
        }

        mensaje = "PELICULAS CLASICAS DISPONIBLES:\n\n";
        for (i = 0; i < n; i++) {
            PeliculaClasica clasica = (PeliculaClasica) clasicas.get(i);
            mensaje = mensaje + (i+1) + ". " + clasica.getNombrePe() + " (" + clasica.getDecada() + ")\n";
        }

        JOptionPane.showMessageDialog(frameParent, mensaje);
    }

    public static void sugerirPeliculasPorGeneroVentana(VideoClub sistema) {
        String genero = JOptionPane.showInputDialog(frameParent, "Ingrese el genero a buscar:\n(Accion, Terror, Comedia, Ciencia Ficcion, Drama, Crimen, Romance, Animacion, Fantasia)");
        ArrayList<Pelicula> porGenero = sistema.sugerirPeliculasPorGenero(genero);
        String mensaje = "";
        int i;
        int n = porGenero.size();

        if (n == 0) {
            JOptionPane.showMessageDialog(frameParent, "No hay peliculas disponibles del genero: " + genero);
            return;
        }

        mensaje = "PELICULAS DE GENERO: " + genero.toUpperCase() + "\n\n";
        for (i = 0; i < n; i++) {
            mensaje = mensaje + (i+1) + ". " + porGenero.get(i).getNombrePe() + " (" + porGenero.get(i).getDuracion() + " min)\n";
        }

        JOptionPane.showMessageDialog(frameParent, mensaje);
    }

    public static void buscarClienteVentana(VideoClub sistema) {
        String rut = JOptionPane.showInputDialog(frameParent, "Rut del cliente:");
        Cliente cliente = sistema.buscarCliente(rut);

        if (cliente != null) {
            JOptionPane.showMessageDialog(frameParent, cliente.toString());
        } else {
            JOptionPane.showMessageDialog(frameParent, "Cliente no encontrado");
        }
    }

    public static void modificarClienteVentana(VideoClub sistema) {
        String rut = JOptionPane.showInputDialog(frameParent, "Rut del cliente a modificar:");
        String nuevoNombre = JOptionPane.showInputDialog(frameParent, "Nuevo nombre:");
        String nuevaPreferencia = JOptionPane.showInputDialog(frameParent, "Nueva preferencia:");

        boolean modificado = sistema.modificarCliente(rut, nuevoNombre, nuevaPreferencia);

        if (modificado) {
            JOptionPane.showMessageDialog(frameParent, "Cliente modificado correctamente");
        } else {
            JOptionPane.showMessageDialog(frameParent, "No se pudo modificar el cliente");
        }
    }

    public static void eliminarClienteVentana(VideoClub sistema) {
        String rut = JOptionPane.showInputDialog(frameParent, "Rut del cliente a eliminar:");
        boolean eliminado = sistema.eliminarCliente(rut);

        if (eliminado) {
            JOptionPane.showMessageDialog(frameParent, "Cliente eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(frameParent, "No se pudo eliminar el cliente");
        }
    }

    public static void buscarPeliculaVentana(VideoClub sistema) {
        String id = JOptionPane.showInputDialog(frameParent, "ID de la pelicula:");
        Pelicula pelicula = sistema.buscarPelicula(id);

        if (pelicula != null) {
            JOptionPane.showMessageDialog(frameParent, pelicula.toString());
        } else {
            JOptionPane.showMessageDialog(frameParent, "Pelicula no encontrada");
        }
    }

    public static void modificarPeliculaVentana(VideoClub sistema) {
        String id = JOptionPane.showInputDialog(frameParent, "ID de la pelicula a modificar:");
        String nuevoNombre = JOptionPane.showInputDialog(frameParent, "Nuevo nombre:");
        String nuevoGenero = JOptionPane.showInputDialog(frameParent, "Nuevo genero:");

        int nuevaDuracion;
        int nuevoStock;

        try {
            nuevaDuracion = Integer.parseInt(JOptionPane.showInputDialog(frameParent, "Nueva duracion (minutos):"));
            nuevoStock = Integer.parseInt(JOptionPane.showInputDialog(frameParent, "Nuevo stock:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frameParent, "Error: Duracion y stock deben ser numeros enteros validos.");
            return;
        }

        boolean modificada = sistema.modificarPelicula(id, nuevoNombre, nuevoGenero, nuevaDuracion, nuevoStock);

        if (modificada) {
            JOptionPane.showMessageDialog(frameParent, "Pelicula modificada correctamente");
        } else {
            JOptionPane.showMessageDialog(frameParent, "No se pudo modificar la pelicula");
        }
    }

    public static void eliminarPeliculaVentana(VideoClub sistema) {
        String id = JOptionPane.showInputDialog(frameParent, "ID de la pelicula a eliminar:");
        boolean eliminada = sistema.eliminarPelicula(id);

        if (eliminada) {
            JOptionPane.showMessageDialog(frameParent, "Pelicula eliminada correctamente");
        } else {
            JOptionPane.showMessageDialog(frameParent, "No se pudo eliminar la pelicula");
        }
    }

    public static void registrarArriendoVentana(VideoClub sistema) {
        String idArriendo = JOptionPane.showInputDialog(frameParent, "ID del arriendo:");
        String rutCliente = JOptionPane.showInputDialog(frameParent, "Rut del cliente:");
        String idPelicula = JOptionPane.showInputDialog(frameParent, "ID de la pelicula:");
        String fechaArriendo = JOptionPane.showInputDialog(frameParent, "Fecha de arriendo:");
        String fechaDevolucion = JOptionPane.showInputDialog(frameParent, "Fecha de devolucion:");

        try {
            boolean registrado = sistema.registrarArriendoConExcepciones(
                    idArriendo, rutCliente, idPelicula, fechaArriendo, fechaDevolucion);

            if (registrado) {
                JOptionPane.showMessageDialog(frameParent, "Arriendo registrado correctamente");
            }
        } catch (ClienteNoEncontradoException e) {
            JOptionPane.showMessageDialog(frameParent, "Error: " + e.getMessage());
        } catch (PeliculaSinStockException e) {
            JOptionPane.showMessageDialog(frameParent, "Error: " + e.getMessage());
        }
    }

    public static void registrarDevolucionVentana(VideoClub sistema) {
        String idArriendo = JOptionPane.showInputDialog(frameParent, "ID del arriendo a devolver:");
        boolean devuelto = sistema.registrarDevolucion(idArriendo);

        if (devuelto) {
            JOptionPane.showMessageDialog(frameParent, "Devolucion registrada correctamente");
        } else {
            JOptionPane.showMessageDialog(frameParent, "No se pudo registrar la devolucion");
        }
    }
}