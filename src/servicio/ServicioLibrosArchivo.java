package servicio;

import dominio.Libro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioLibrosArchivo implements IServicioLibros{

    private final String NOMBRE_ARCHIVO = "libros.txt";
    public ServicioLibrosArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            if(archivo.exists())
                System.out.println("El archivo ya existe");
            else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("El archivo se ha creado");
            }
        }catch (Exception e){
            System.out.println("Hay un error " + e.getMessage());
        }
    }

    @Override
    public void listarLibros() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //abrir archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            //leer linea a linea
            String linea = entrada.readLine();
            //leer todas las lineas
            while(linea != null){
                var libro = new Libro(linea);
                System.out.println(libro);
                linea = entrada.readLine();
            }
            //cerrar archivo
            entrada.close();
        }catch (Exception e){
            System.out.println("Error al abrir el archivo" + e.getMessage());
        }
    }

    @Override
    public void agregarLibros(Libro libro) {
        //compruebo si esta el archivo vacio
        boolean anexar = false;
        //abro el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //compruebo si esta el archivo vacio
            anexar = archivo.exists();
            //recibe 2, la lista y si esta vacia o no
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            //escribe la linea
            salida.println(libro);
            //cierro la lista
            salida.close();
            //informa de lo ocurrido
            System.out.println("Se ha añadido el libro: " + libro);
        }catch (Exception e){
            System.out.println("Ha ocurrido un error " + e.getMessage());
        }
    }

    @Override
    public void buscarLibro(Libro libro) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try (var entrada = new BufferedReader(new FileReader(archivo))){
            String linea;
            var index = 0;
            while ((linea = entrada.readLine()) != null){
                if (linea.equalsIgnoreCase(libro.getNombre())) {
                    index++;
                    System.out.println("El libro se encuentra en el indice: " + index);
                    return;
                }
                index++;
            }
            System.out.println("No se ha encontrado el libro " + libro);
        }catch (Exception e){
            System.out.println("Ocurrio un error " + e.getMessage());
        }
    }
}
