/*
 Representa la Universidad
 */
package es.uvigo.esei.proii.core;

/**
 *
 * @author Nanny Glez
 */
public class Universidad {

    private String nombre;
    private Docente[] docentes;
    private int numDocentes;
    private Estudiante[] estudiantes;
    private int numEstudiantes;
    private Asignatura[] asignaturas;
    private int numAsignaturas;

    public Universidad(String nombre, int numMaxDocentes,
            int numMaxEstudiantes, int numMaxAsignaturas) {
        this.nombre = nombre;
        this.docentes = new Docente[numMaxDocentes];
        this.numDocentes = 0;
        this.estudiantes = new Estudiante[numMaxEstudiantes];
        this.numEstudiantes = 0;
        this.asignaturas = new Asignatura[numMaxAsignaturas];
        this.numAsignaturas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * GESTIÓN DE DOCENTES
     *
     */
    /**
     * Devuelve el num. de docentes creados.
     *
     * @return el num. de docentes existentes, como entero.
     */
    public int getNumDocentes() {
        return numDocentes;
    }

    /**
     * Devuelve el max. de numDocentees
     *
     * @return el num. de docentes max,, como entero
     */
    public int getMaxDocentes() {
        return docentes.length;
    }

    /**
     * Devuelve el docente situado en pos
     *
     * @param pos el lugar del docente en el vector de docentes
     * @return el objeto Docente correspondiente.
     */
    public Docente getDocente(int pos) {
        if (pos < 0 || pos >= getNumDocentes()) {
            System.err.println("get(): sobrepasa la pos: " + (pos + 1) + " / "
                    + getMaxDocentes());
            System.exit(-1);
        }

        return this.docentes[pos];
    }

    /**
     * Inserta un nuevo docente.
     *
     * @param p el nuevo objeto Docente
     */
    public void insertaDocente(Docente p) {
        if (getNumDocentes() == docentes.length) {
            System.err.println("Ya no queda espacio para mas docentes.");
            System.exit(-1);
        }
        docentes[numDocentes++] = p;
    }

    /**
     * Elimina el docente que se encuentra en la posición indicada.
     *
     * @param pos la posición del docente a eliminar
     */
    public void eliminaDocente(int pos) {
        if(pos<0||pos>=docentes.length){
            System.err.println("La posicion introducida no es válida");
        
        }else{
            for (int i = pos; i < docentes.length; i++) {
                docentes[i]=docentes[i+1];
            }
            this.numDocentes--;
        }
        //System.err.println("Funcionalidad no implementada");
    }

    /**
     * GESTIÓN DE ESTUDIANTES
     *
     */
    /**
     * Devuelve el num. de estudiantes creados.
     *
     * @return el num. de estudiantes existentes, como entero.
     */
    public int getNumEstudiantes() {
        return numEstudiantes;
    }

    /**
     * Devuelve el max. de numEstudiantes
     *
     * @return el num. de estudiantes max,, como entero
     */
    public int getMaxEstudiantes() {
        return estudiantes.length;
    }

    /**
     * Devuelve el estudiante situado en pos
     *
     * @param pos el lugar del estudiante en el vector de estudiantes
     * @return el objeto Estudiante correspondiente.
     */
    public Estudiante getEstudiante(int pos) {
        if (pos < 0 || pos >= getNumEstudiantes()) {
            System.err.println("get(): sobrepasa la pos: " + (pos + 1) + " / "
                    + getMaxEstudiantes());
            System.exit(-1);
        }

        return estudiantes[pos];
    }

    /**
     * Inserta un nuevo estudiante.
     *
     * @param a el nuevo objeto Estudiante
     */
    public void insertaEstudiante(Estudiante a) {
        if (getNumEstudiantes() == estudiantes.length) {
            System.err.println("Ya no queda espacio para mas estudiantes.");
            System.exit(-1);
        }
        estudiantes[numEstudiantes++] = a;
    }

    /**
     * Elimina el estudiante que se encuentra en la posición indicada.
     *
     * @param pos la posición del estudiante a eliminar
     */
    public void eliminaEstudiante(int pos) {
        if(pos<0||pos>=estudiantes.length){
            System.err.println("La posicion introducida no es válida");
        
        }else{
            for (int i = pos; i < estudiantes.length; i++) {
                estudiantes[i]=estudiantes[i+1];
            }
            this.numEstudiantes--;
        }
        //System.err.println("Funcionalidad no implementada");
    }
    
    
    /**
     * GESTIÓN DE ASIGNATURAS
     *
     */
    /**
     * Devuelve el num. de asignaturas creadas.
     *
     * @return el num. de asignaturas existentes, como entero.
     */
    public int getNumAsignaturas() {
        return numAsignaturas;
    }

    /**
     * Devuelve el max. de numAsignaturas
     *
     * @return el num. de asignaturas max, como entero
     */
    public int getMaxAsignaturas() {
        return asignaturas.length;
    }

    /**
     * Devuelve la asignatura situada en pos
     *
     * @param pos el lugar de la asignatura en el vector de asignaturas
     * @return el objeto Asignatura correspondiente.
     */
    public Asignatura getAsignatura(int pos) {
        if (pos < 0 || pos >= getNumAsignaturas()) {
            System.err.println("get(): sobrepasa la pos: " + (pos + 1) + " / "
                    + getMaxAsignaturas());
            System.exit(-1);
        }

        return asignaturas[pos];
    }

    /**
     * Inserta una nueva asignatura.
     *
     * @param a el nuevo objeto Asignatura
     */
    public void insertaAsignatura(Asignatura a) {
        if (getNumAsignaturas() == asignaturas.length) {
            System.err.println("Ya no queda espacio para mas asignaturas.");
            System.exit(-1);
        }
        asignaturas[numAsignaturas++] = a;
    }

    /**
     * Elimina la asignatura que se encuentra en la posición indicada.
     *
     * @param pos la posición de la asignatura a eliminar
     */
    public void eliminaAsignatura(int pos) {
        if(pos<0||pos>=asignaturas.length){
            System.err.println("La posicion introducida no es válida");
        
        }else{
            for (int i = pos; i < asignaturas.length; i++) {
                asignaturas[i]=asignaturas[i+1];
            }
            this.numAsignaturas--;
        }
        //System.err.println("Funcionalidad no implementada");
    }
    
    /**
     * Muestra una lista con todos los estudiantes, docentes y asignaturas
     * registradas.
     * 
     * @return lista de docentes, estudiantes y asignaturas
     */
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("DOCENTES REGISTRADOS\n");
        for (int i = 0; i < this.numDocentes ; i++) {
            sb.append(docentes[i].toString()).append("\n");
            
        }
        
        sb.append("ESTUDIANTES REGISTRADOS\n");
        for (int i = 0; i < this.numEstudiantes; i++) {
            sb.append(estudiantes[i].toString()).append("\n");
            
        }
        
        sb.append("ASIGNATURAS REGISTRADAS\n");
        for (int i = 0; i < this.numAsignaturas; i++) {
            sb.append(asignaturas[i].toString()).append("\n");
            
        }
        
        return sb.toString();
    }

}
