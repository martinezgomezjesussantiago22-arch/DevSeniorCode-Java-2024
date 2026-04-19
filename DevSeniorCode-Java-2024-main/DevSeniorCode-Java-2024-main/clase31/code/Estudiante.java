package clase31.code;

public class Estudiante implements Comparable<Estudiante> {
    private String nombre;
    private Integer edad;

    public Estudiante(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    @Override
    public int compareTo(Estudiante o) {
        return Integer.compare(this.edad, o.edad);
    }

    @Override
    public String toString() {
        return nombre + " (Edad: " + edad + ")";
    }
}
