package modelo;


public class Materia {

    private String nombre;

    private double notaFinal;

    
    public Materia() {
    }

    
    public Materia(String nombre, double notaFinal) {
        this.nombre = nombre;
        this.notaFinal = notaFinal;
    }


    public String getNombre() {
        return nombre;
    }

  
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public double getNotaFinal() {
        return notaFinal;
    }

    
    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    
    public void mostrar() {
        System.out.printf("materia: %s | Nota: %.2f%n", nombre, notaFinal);
    }

    
    public boolean estaAprobada() {
        return notaFinal >= 70.0;
    }

    @Override
    public String toString() {
        return "materia{nombre='" + nombre + "', notaFinal=" + notaFinal + "}";
    }
}