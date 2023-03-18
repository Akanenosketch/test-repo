package es.uvigo.esei.proii.core;

/*
 Representa a un estudiante
 */
/**
 *
 * @author nrufino
 */
public class Estudiante {

    private String dni;
    private String nombre;
    private boolean esErasmus;

    /**
     * Crea un nuevo estudiante, con sus datos: dni, nombre, y si es erasmus o no.
     *
     * @param dni D.N.I. del estudiante
     * @param nombre nombre completo del estudiante
     * @param esErasmus si es de Erasmus
     */
    public Estudiante(String dni, String nombre, boolean esErasmus) {
        this.setDni(dni);
        this.setNombre(nombre);
        this.setErasmus(esErasmus);
    }

    /**
     * Devuelve el dni del estudiante
     *
     * @return el dni del estudiante, como String.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Cambia el D.N.I del estudiante
     *
     * @param dni el D.N.I. del estudiante
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve el nombre del estudiante
     *
     * @return el nombre del estudiante, como String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del estudiante
     *
     * @param nombre el nombre del estudiante
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el valor de la etiqueta esErasmus
     *
     * @return true si se encuentra activa, false en otro caso
     */
    public boolean isErasmus() {
        return esErasmus;
    }

    /**
     * Cambia la etiqueta esErasmus
     *
     * @param esErasmus El nuevo valor, como boolean
     */
    public void setErasmus(boolean esErasmus) {
        this.esErasmus = esErasmus;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("Estudiante.");
        toret.append("\nD.N.I.: ").append(getDni());
        toret.append("\tNombre: ").append(getNombre());
        toret.append("\tErasmus: ");
        if (isErasmus()) {
            toret.append("si");
        } else {
            toret.append("no");
        }

        return toret.toString();
    }
}
