package com.daletguimel.bookcatalog.main;

import com.daletguimel.bookcatalog.model.*;
import com.daletguimel.bookcatalog.service.BookService;
import com.daletguimel.bookcatalog.service.ClientApi;
import com.daletguimel.bookcatalog.service.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Main {

    @Autowired
    private BookService bookService;

    @Autowired
    private ClientApi clientApi;

    @Autowired
    private DataConverter dataConverter;

    Scanner scanner = new Scanner(System.in);

//    List<Book> librosConsultados = new ArrayList<>();
//    List<Author> autoresConsultados = new ArrayList<>();

    public void menuDeOpciones() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1. Búsqueda por nombre de libro o autor
                    2. Búsqueda por fecha (entre el año de nacimiento y el año de fallecimiento)
                    3. Listar todos los libros consultados
                    4. Listar los libros consultados por idioma
                    5. Listar todos los autores consultados
                    6. Listar autores vivos en un año determinado
                    
                    0. Salir
                    """;

            System.out.println(menu);
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1 -> buscarPorNombreOAutor();
                case 2 -> buscarPorFecha();
                case 3 -> listarTodosLosLibros();
                case 4 -> listarLibrosPorIdioma();
                case 5 -> listarTodosLosAutores();
                case 6 -> listarAutoresVivos();
                case 0 -> System.out.println("Saliendo. ¡Que tenga un buen día!");
                default -> System.out.println("Opción no válida. Intente nuevamente, por favor");
            }
        }

    }

    //Metodos para buscar en la API

    private void buscarPorNombreOAutor() {
        System.out.println("Ingrese el nombre del libro o autor que desea buscar: ");
        String query = scanner.nextLine();
        try {
            String jsonResponse = clientApi.getBooks("?search=" +
                    query.replace(" ", "%20"));
            BookResponse bookResponse = dataConverter.fromJson(jsonResponse, BookResponse.class);
            if (!bookResponse.getResults().isEmpty()){
                Book book = Book.fromRecord(bookResponse.getResults().get(0));
                System.out.println(book);
                bookService.saveBook(book);
            } else {
                System.out.println("No se encontraron resultados para la búsqueda");
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error en la búsqueda: " + e.getMessage());
        }
    }

    private void buscarPorFecha() {
        System.out.println("Ingrese el año de inicio de la búsqueda: ");
        int yearStart = scanner.nextInt();
        System.out.println("Ingrese el año de fin de la búsqueda: ");
        int yearEnd = scanner.nextInt();

        try {
            String jsonRespose = clientApi.getBooks("?author_year_start=" + yearStart +
                    "&author_year_end=" + yearEnd);
            BookResponse bookResponse = dataConverter.fromJson(jsonRespose, BookResponse.class);
            List<Book> books = bookResponse.getResults().stream()
                    .map(Book::fromRecord)
                    .toList();
            books.forEach(System.out::println);
            books.forEach(bookService::saveBook);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error en la búsqueda: " + e.getMessage());
        }
    }

    //Metodos para mostrar listas

    private void listarTodosLosLibros() {
        List<BookEntity> librosConsultados = bookService.getAllBooks();
        if (librosConsultados.isEmpty()) {
            System.out.println("No hay libros para mostrar aún.");
        } else {
            librosConsultados.forEach(System.out::println);
        }
    }

    private void listarLibrosPorIdioma() {
        System.out.println("Ingrese el código de dos letras del idioma ('en', 'es', 'fr', etc): ");
        String idioma = scanner.nextLine();
        List<BookEntity> librosPorIdioma = bookService.getBooksByLanguage(idioma);
        if (librosPorIdioma.isEmpty()) {
            System.out.println("No hay libros para mostrar aún.");
        } else {
            librosPorIdioma.forEach(System.out::println);
        }
    }

    private void listarTodosLosAutores(){
//        if (autoresConsultados.isEmpty()) {
//            System.out.println("No hay autores para mostrar aún.");
//        } else {
//            autoresConsultados.forEach(System.out::println);
//        }
    }

    private void listarAutoresVivos() {
//        System.out.println("Ingrese el año en el cual desea consultar autores vivos: ");
//        int year = scanner.nextInt();
//        scanner.nextLine();
//        List<Author> autoresVivos = autoresConsultados.stream()
//                .filter(author -> (author.getBirthYear() != null && author.getBirthYear() <= year) &&
//                        (author.getDeathYear() == null || author.getDeathYear() >= year))
//                .toList();
//        if (autoresVivos.isEmpty()) {
//            System.out.println("No se encontaron autores vivos para el año consultado.");
//        } else {
//            autoresVivos.forEach(System.out::println);
//        }
    }
}
