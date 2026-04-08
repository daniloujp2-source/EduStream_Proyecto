package modelo;


public class Principal {

    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("danilo quiros");
        estudiante.setIdentificacion("1234-4321");

        Materia espanol = new Materia("español", 85.0);
        Materia matematicas = new Materia("matemáticas", 65.5);



        estudiante.agregarMateria(espanol);
        estudiante.agregarMateria(matematicas);

        estudiante.mostrarInformacionBasica();
        estudiante.mostrarMateriasConEstado();

        System.out.println("\n detalle por materia");
        for (Materia m : estudiante.getMaterias()) {
            m.mostrar();
        }
    }
}