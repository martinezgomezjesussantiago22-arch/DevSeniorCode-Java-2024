package clase31.code;

import java.util.Arrays;

public class UsoComparator {
    public static void main(String[] args) {
        // Crear lista de estudiantes
        var estudiantes = Arrays.asList(
                new Estudiante("Ana", 21),
                new Estudiante("Carlos", 23),
                new Estudiante("Luis", 20),
                new Estudiante("María", 23));

        System.out.println("Lista original:");
        estudiantes.forEach(System.out::println);

        // 1. Ordenar por nombre (alfabético)
        System.out.println("\nOrdenado por nombre (alfabético):");
        estudiantes.sort((e1, e2) -> e1.getNombre().compareTo(e2.getNombre()));
        estudiantes.forEach(System.out::println);

        // 2. Ordenar por edad (descendente)
        System.out.println("\nOrdenado por edad (descendente):");
        estudiantes.sort((e1, e2) -> Integer.compare(e2.getEdad(), e1.getEdad()));
        estudiantes.forEach(System.out::println);
    }
}
