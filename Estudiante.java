package modelo;

import java.util.ArrayList;
import java.util.List;


public class Estudiante {

    private String nombre;

    private String identificacion;

    private final List<Materia> materias;

    
    public Estudiante() {
        this.materias = new ArrayList<>();
    }

    
    public Estudiante(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.materias = new ArrayList<>();
    }

  
    public String getNombre() {
        return nombre;
    }

        public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public String getIdentificacion() {
        return identificacion;
    }

   
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

        public List<Materia> getMaterias() {
        return materias;
    }

    
    public void agregarMateria(Materia materia) {
        if (materia == null) {
            throw new IllegalArgumentException("la materia no puede ser null");
        }
        this.materias.add(materia);
    }

        public void mostrarInformacionBasica() {
        System.out.println("informacion del estudiante");
        System.out.println("nombre: " + nombre);
        System.out.println("identificacion: " + identificacion);
    }

        public void mostrarMateriasConEstado() {
        System.out.println("materias cursadas");
        if (materias.isEmpty()) {
            System.out.println("el estudiante no ha registrado materias");
            return;
        }

        for (Materia m : materias) {
            String estado = m.estaAprobada() ? "aprobada" : "reprobada";
            System.out.printf("materia: %-15s | Nota: %6.2f | estado: %s%n",
                    m.getNombre(), m.getNotaFinal(), estado);
        }
    }
}