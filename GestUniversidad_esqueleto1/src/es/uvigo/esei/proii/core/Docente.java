package es.uvigo.esei.proii.core;

/*
  Representa un docente
 */
/**
 *
 * @author nrufino
 */
public class Docente {

    private String dni;
    private String nombre;
    private int despacho;
    private static enum TipoDedicacion{COMPLETA, PARCIAL};
    private TipoDedicacion dedicacion;

    /**
     * Crea un nuevo docente, con sus datos: dni, nombre, despacho y si su
     * dedicación es completa o parcial.
     *
     * @param dni D.N.I. del docente
     * @param nombre nombre completo del docente
     * @param despacho despacho del docente
     * @param dedicacion dedicacion del docente
     */
    public Docente(String dni, String nombre, int despacho,
            TipoDedicacion dedicacion) {
        this.setDni(dni);
        this.setNombre(nombre);
        this.setDespacho(despacho);
        this.setDedicacion(dedicacion);
    }

    /**
     * Devuelve el dni del docente
     *
     * @return el dni del docente, como String.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Cambia el D.N.I del docente
     *
     * @param dni el D.N.I. del docente
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve el nombre del docente
     *
     * @return el nombre del docente, como String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del docente
     *
     * @param nombre el nombre del docente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el despacho del docente
     *
     * @return el despacho del docente, como int.
     */
    public int getDespacho() {
        return despacho;
    }

    /**
     * Cambia el despacho del docente
     *
     * @param despacho el despacho del docente
     */
    public void setDespacho(int despacho) {
        this.despacho = despacho;
    }

    public TipoDedicacion getDedicacion() {
        return dedicacion;
    }
    
    public String getValueDedicacion(){
        return dedicacion.toString();
    }

    /**
     * Cambia la etiqueta dedicacion
     *
     * @param dedicacion dedicacion del docente
     */
    public void setDedicacion(TipoDedicacion dedicacion) { //TODO modificar
        this.dedicacion = dedicacion;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("Docente. ");
        toret.append("\nD.N.I.: ").append(getDni());
        toret.append("\tNombre: ").append(getNombre());
        toret.append("\tDespacho: ").append(getDespacho());
        toret.append("\tDedicacion: ").append(getDedicacion().name());

        return toret.toString();
    }
}
