package servicio;

import dominio.Libro;

public interface IServicioLibros {
    void listarLibros();
    void agregarLibros(Libro libro);
    void buscarLibro(Libro libro);
}
