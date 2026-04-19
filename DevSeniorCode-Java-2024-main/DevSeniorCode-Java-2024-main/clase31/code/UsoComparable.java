package clase31.code;

import java.util.Arrays;
import java.util.Collections;

public class UsoComparable {
    public static void main(String[] args) {
        // Crear lista de estudiantes
        var estudiantes = Arrays.asList(
                new Estudiante("Ana", 21),
                new Estudiante("Carlos", 23),
                new Estudiante("Luis", 20),
                new Estudiante("María", 23));

        // Ordenar por edad (Comparable)
        System.out.println("Ordenado por edad (Comparable):");
        Collections.sort(estudiantes);
        estudiantes.forEach(System.out::println);

        // Ordenar por nombre (Comparator)
        System.out.println("\nOrdenado por nombre (Comparator):");
        estudiantes.sort((e1, e2) -> e1.getNombre().compareTo(e2.getNombre()));
        estudiantes.forEach(System.out::println);
    }
}
