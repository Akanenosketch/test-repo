/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uvigo.esei.proii.core;

/**
 *
 * @author Tatiana
 */
public class Asignatura {
    private int codigo;
    private String nombre;
    private enum tipoAsignatura{BASICA, OBLIGATORIA, OPTATIVA};
    private tipoAsignatura tipo;
    
    /**
     * Crea una nueva asignatura, con sus datos: codigo, nombre y el tipo de la asignatura.
     *
     * @param codigo el codigo que identifica a la asignatura.
     * @param nombre nombre completo de la asignatura.
     * @param tipo naturaleza de la asignatura
     */
    public Asignatura(int codigo, String nombre,int tipo){
        this.setCodigo(codigo);
        this.setNombre(nombre);
        this.setTipoAsignatura(tipo);
    }
    
    /**
     * Devuelve el codigo de la asignatura.
     *
     * @return el codigo de la asignatura, como int.
     */
    public int getCodigo() {
        return this.codigo;
    }

    /**
     * Cambia el codigo de la asignatura.
     *
     * @param codigo el codigo de la asignaura, como int.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
        /**
     * Devuelve el nombre de la asignatura.
     *
     * @return el nombre de la asignatura, como String.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Cambia el nombre de la asignatura.
     *
     * @param nombre de la asignatura
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Devuelve el tipo de la asignatura
     *
     * @return el tipo de asignatura, como tipoAsignatura.
     */
    public tipoAsignatura getTipoAsignatura() {
        return this.tipo;
    }

    /**
     * Cambia el tipo de la asignatura
     *
     * @param tipo tipo de la asignatura.
     */
    public void setTipoAsignatura(int tipo) {
        switch (tipo){
            case 0 -> this.tipo = tipoAsignatura.BASICA;
            case 1 -> this.tipo= tipoAsignatura.OBLIGATORIA;
            case 2 -> this.tipo = tipoAsignatura.OPTATIVA;
        }
        
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre asignatura : ").append(this.nombre);
        sb.append("\nCodigo asignatura : ").append(this.codigo);
        sb.append("\nTipo asignatura : ").append(this.tipo);
        return sb.toString();
    }
}
