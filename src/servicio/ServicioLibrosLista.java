package servicio;

import dominio.Libro;

import java.util.ArrayList;
import java.util.List;

public class ServicioLibrosLista implements IServicioLibros{

    private final List<Libro> libros;
    public ServicioLibrosLista(){
        this.libros = new ArrayList<>();
    }

    @Override
    public void listarLibros() {
        System.out.println("Listando libros...");
        libros.forEach(System.out::println);
    }

    @Override
    public void agregarLibros(Libro libro) {
        libros.add(libro);
        System.out.println("Se ha agregado a la lista el libro: " + libro);
    }

    @Override
    public void buscarLibro(Libro libro) {
        var index = libros.indexOf(libro);
        if (index==-1){
            System.out.println("El libro no se encuentra en la lista");
        }
        else
            System.out.println("El libro se encuentra en el indice " + index);
    }
}

