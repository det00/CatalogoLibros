package presentacion;

import dominio.Libro;
import servicio.IServicioLibros;
import servicio.ServicioLibrosArchivo;
import servicio.ServicioLibrosLista;

import java.util.Scanner;

public class CatalogoLibrosApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        IServicioLibros servicioLibros = new ServicioLibrosArchivo();
        while (!salir) {
            mostrarMenu();
            salir = ejecutarOpciones(consola, servicioLibros);
        }
    }

    private static boolean ejecutarOpciones(Scanner consola, IServicioLibros servicioLibros) {
        System.out.print("Selecciona una opcion:");
        var salir = false;
        try {
            var opcion = Integer.parseInt(consola.nextLine());
            switch (opcion){
                case 1 -> {
                    System.out.println("Introduce el título:");
                    servicioLibros.agregarLibros(new Libro(consola.nextLine()));
                }
                case 2 -> servicioLibros.listarLibros();
                case 3 -> {
                    System.out.println("Introduce el título:");
                    servicioLibros.buscarLibro(new Libro(consola.nextLine()));
                }
                case 4 -> {
                    System.out.println("Saliendo del programa...");
                    salir = true;
                }
                default -> System.out.println("Opcion incorrecta -> " + opcion);
            }
        } catch (Exception e){
            System.out.println("Ha ocurrido un error " + e.getMessage());
        }
        return salir;
    }

    private static void mostrarMenu() {
        System.out.println("""
                **********************************
                *      Catalogo libros APP ]]    *
                **********************************
                * 1. Agregar un libro a la lista *
                * 2. Listar libros               *
                * 3. Buscar un libro             *
                * 4. Salir                       *
                **********************************
                """);
    }
}