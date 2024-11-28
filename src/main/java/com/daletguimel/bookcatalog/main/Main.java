package com.daletguimel.bookcatalog.main;

import com.daletguimel.bookcatalog.model.Book;
import com.daletguimel.bookcatalog.model.BookRecord;
import com.daletguimel.bookcatalog.service.ClientApi;
import com.daletguimel.bookcatalog.service.DataConverter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    ClientApi clientApi = new ClientApi();
    DataConverter dataConverter = new DataConverter();

    public void menuDeOpciones() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1. Búsqueda por nombre de libro o autor
                    2. Búsqueda por fecha (entre el año de nacimiento y el año de fallecimiento)
                    
                    0. Salir
                    """;

            System.out.println(menu);
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1 -> buscarPorNombreOAutor();
                case 2 -> buscarPorFecha();
                case 0 -> System.out.println("Saliendo. ¡Que tenga un buen día!");
                default -> System.out.println("Opción no válida. Intente nuevamente, por favor");
            }
        }

    }

    private void buscarPorNombreOAutor() {
        System.out.println("Ingrese el nombre del libro o autor que desea buscar: ");
        String query = scanner.nextLine();
        try {
            String jsonResponse = clientApi.getBooks("?search=" +
                    query.replace(" ", "%20"));
            List<BookRecord> books =
                    List.of(dataConverter.fromJson(jsonResponse, BookRecord[].class));
            books.forEach(book -> {
                Book bookObj = Book.fromRecord(book);
                System.out.println(bookObj);
            });
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
            List<BookRecord> books =
                    List.of(dataConverter.fromJson(jsonRespose, BookRecord[].class));
            books.forEach(book -> {
                Book bookObj = Book.fromRecord(book);
                System.out.println(bookObj);
            });
        } catch (IOException | InterruptedException e) {
            System.out.println("Error en la búsqueda: " + e.getMessage());
        }
    }
}
