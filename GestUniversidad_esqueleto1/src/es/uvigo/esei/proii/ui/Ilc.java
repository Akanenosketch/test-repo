package es.uvigo.esei.proii.ui;

import es.uvigo.esei.proii.core.Universidad;
import es.uvigo.esei.proii.core.Docente;
import es.uvigo.esei.proii.core.Estudiante;
import es.uvigo.esei.proii.core.Asignatura;

import static es.uvigo.esei.proii.ui.Entrada.*;

/**
 * Interfaz de línea de comandos
 */
public class Ilc {

    /**
     * Realiza el reparto de la funcionalidad ler = lee, evalua, repite
     */
    public void ler() {
        int opcion = 0;

        Universidad coleccion = crearUniversidad();

        do {

            opcion = menuPrincipal(coleccion);

            switch (opcion) {
                case 1 -> gestionDocentes(coleccion);
                case 2 -> gestionEstudiantes(coleccion);
                case 3 -> gestionAsignaturas(coleccion);
                case 4 -> visualizarUniversidad(coleccion);
            }

        } while (opcion != 0);
    }

    /**
     * Crea un objeto Universidad leyendo del teclado sus datos
     *
     * @return Universidad Objeto Universidad
     */
    private Universidad crearUniversidad() {
        String nombre = leeCadena("Nombre universidad: ");
        int maxDocentes = leeEntero("Num. max. docentes: ");
        int maxEstudiantes = leeEntero("Num. max. estudiantes: ");
        int maxAsignaturas = leeEntero("Num. max. asignaturas: ");

        return new Universidad(nombre, maxDocentes,
                maxEstudiantes, maxAsignaturas);
    }
    
    //AAAAAAAAAAAAAAAAAAAAAAAA
    /**
     * Visualiza los datos de la Universidad
     *
     * @param coleccion Objeto Universidad
     */
    private void visualizarUniversidad(Universidad coleccion) {
        System.out.println("La universidad " + coleccion.getNombre());
        System.out.println(coleccion.toString());
    }

    /**
     * Presenta un menu principal con las opciones, y permite seleccionar una.
     *
     * @return la opcion seleccionada, como entero
     */
    private int menuPrincipal(Universidad coleccion) {
        int toret;

        do {
            System.out.println("""
                               
                               
                               \tGESTI\u00d3N UNIVERSIDAD
                               
                               1. Gesti\u00f3n docentes 
                               2. Gesti\u00f3n estudiantes 
                               3. Gesti\u00f3n asignaturas
                               4. Listar datos universidad
                               0. Salir
                               """);
            System.out.println("Numero de estudiantes : " + coleccion.getNumEstudiantes());
            System.out.println("Maxima capacidad de estudiantes : " + coleccion.getMaxEstudiantes());
            System.out.println("Numero de docentes : " + coleccion.getNumDocentes());
            System.out.println("Maxima capacidad de docentes : " + coleccion.getMaxDocentes());  //TODO organise this part
            
            toret = leeEntero("Selecciona: ");
            if (toret < 0 || toret > 4) {
                System.out.println("Opción inválida: " + toret + "\n");
            }
            System.out.println();
        } while (toret < 0 || toret > 4);

        return toret;
    }

    /**
     *   * INTERFAZ/LÓGICA/CONTROL DOCENTES *
     */
    /**
     * Muestra las distintas opciones para gestionar los docentes y lanza los
     * métodos que realiza cada operación
     *
     * @param coleccion La Universidad sobre la que actua
     */
    private void gestionDocentes(Universidad coleccion) {
        int opcion = 0;

        do {
            opcion = menuGestionDocentes();
            switch (opcion) {
                case 1 -> insertaDocente(coleccion);
                case 2 -> modificaDocente(coleccion);
                case 3 -> eliminaDocente(coleccion);
                case 4 -> listarDocentes(coleccion);
                case 5 -> System.out.println(listarDocentesDedicacion(coleccion));
            }
        } while (opcion != 0);
    }

    /**
     * Presenta un menu con las opciones para gestionar docentes, y permite
     * seleccionar una.
     *
     * @param coleccion La Universidad sobre la que se realizan las operaciones
     * @return la opcion seleccionada, como entero
     */
    private int menuGestionDocentes() {
        int toret;

        do {
            System.out.println("GESTION DOCENTES");
            System.out.println("""
                               
                               1. Insertar docente
                               2. Modificar docente
                               3. Eliminar docente
                               4. Listar docentes
                               5. Listar docentes por dedicacion
                               0. Volver al men\u00fa principal
                               """);
            toret = leeEntero("Selecciona: ");
        } while (toret < 0
                || toret > 5);

        System.out.println();
        return toret;
    }

    /**
     * Crea un nuevo docente y lo inserta en la coleccion
     *
     * @param coleccion La coleccion en la que se inserta el docente.
     */
    private void insertaDocente(Universidad coleccion) {
        System.out.println("\n-------------");
        System.out.println("\nAlta docente");

        Docente p = leeDocente();
        coleccion.insertaDocente(p);
    }

    /**
     * Lee del teclado los datos de un docente.
     *
     * @return El objeto Docente creado
     */
    private Docente leeDocente() {
        System.out.println("\nIntroduce los datos del nuevo docente:");

        String dni = leeCadena("\tD.N.I.: ");
        String nombre = leeCadena("\tNombre: ");
        int despacho = leeEntero("\tDespacho: ");
        int dedicacionDocente = leeDedicacionDocente("\nIntroduce el tipo de dedicacion del docente : "
                                           + "\n\t(0)Completa \n\t(1)Parcial\n");
       
        return new Docente(dni, nombre, despacho, dedicacionDocente);
    }
    
    public int leeDedicacionDocente(String msg){
        int opt;
        do{
            opt = leeEntero(msg);
            if(opt!=0&&opt!=1){
                System.err.println("El valor introducido no es una opción válida");
            }
        }while(opt!=0&&opt!=1);
        return opt;
    }

    /**
     * Borra un docente por su posicion en la colección.
     *
     * @param coleccion La coleccion en la que se elimina el docente
     */
    private void eliminaDocente(Universidad coleccion) {
        if (coleccion.getNumDocentes() > 0) {
            coleccion.eliminaDocente(leePosDocente(coleccion));
        } else {
            System.out.println("La coleccion no contiene docentes.");
        }
    }

    /**
     * Modifica un docente existente.
     *
     * @param coleccion La coleccion de la cual modificar un docente.
     */
    private void modificaDocente(Universidad coleccion) {
        System.out.println("\n---------------------");
        System.out.println("\nModificación docente");

        if (coleccion.getNumDocentes() > 0) {
            this.modificaDocente(coleccion.getDocente(this.leePosDocente(coleccion)));
        } else {
            System.out.println("La coleccion no contiene docentes.");
        }
    }

    private void modificaDocente(Docente p) {
        boolean vacio = false;
        String info;

        System.out.println("\nModificando los datos del siguiente docente:");
        System.out.println(p);
        System.out.println();

        // D.N.I.
        System.out.print("D.N.I. ");
        if (p.getDni().length() > 0) {
            System.out.print("[" + p.getDni() + "]");
            vacio = true;
        }
        info = leeCadena(": ", vacio);
        if (info.length() > 0) {
            p.setDni(info);
        }

        // Nombre
        System.out.print("Nombre ");
        if (p.getNombre().length() > 0) {
            System.out.print("[" + p.getNombre() + "]");
            vacio = true;
        }
        info = leeCadena(": ", vacio);
        if (info.length() > 0) {
            p.setNombre(info);
        }

        // Despacho
        System.out.print("Despacho ");
        if (Integer.toString(p.getDespacho()).length() > 0) {
            System.out.print("[" + p.getDespacho() + "]");
            vacio = true;
        }
        info = leeCadena(": ", vacio);
        if (info.length() > 0) {
            p.setDespacho(Integer.parseInt(info));
        }

        // Dedicacion. ES OBLIGATORIO MODIFICAR (INTRODUCIR) LA DEDICACION
        
    }

    /**
     * Lee del teclado la posición de un docente en la colección
     *
     * @param coleccion La colección de la que se obtiene el max.
     * @return la posición del docente, como entero.
     */
    private int leePosDocente(Universidad coleccion) {
        final int numDocentes = coleccion.getNumDocentes();
        int toret;

        do {
            toret = leeEntero("Introduzca posición del docente (1..."
                    + numDocentes + "): ");

            if (toret < 1 || toret > numDocentes) {
                System.err.println("Posición inválida. "
                        + "Por favor, introdúzcala de nuevo.");
            }
        } while (toret < 1 || toret > numDocentes);

        return toret - 1;
    }

    /**
     * Visualiza los docentes almacenados en la coleccion por la salida std.
     *
     * @param coleccion El objeto Universidad del que visualizar sus docentes.
     */
    private void listarDocentes(Universidad coleccion) {
        final int numDocentes = coleccion.getNumDocentes();

        if (numDocentes > 0) {
            System.out.print("\nDocentes:\n");
            for (int i = 0; i < numDocentes; i++) {
                System.out.print((i + 1) + ". ");
                System.out.println(coleccion.getDocente(i).toString());
                System.out.println("\n");
            }
        } else {
            System.out.println("No hay docentes.");
        }

    }

    /**
     * Lista los docentes de la universidad por dedicacion
     *
     * @param coleccion La universidad de la que se listan los docentes
     * @return temp message
     */
    public String listarDocentesDedicacion(Universidad coleccion) {
        StringBuilder sb = new StringBuilder();
        int tipo = leeDedicacionDocente("""
                                        Introduce el tipo de dedicacion del docente a buscar: 
                                        \t(0)Completa 
                                        \t(1)Parcial
                                        """);
        String dedicacion = " ";
        String opt = " ";
        if(tipo==0){
            opt = "COMPLETA";
        }else{
            opt = "PARCIAL";
        }
        
        for (int i = 0; i < coleccion.getNumDocentes(); i++) {
            dedicacion = coleccion.getDocente(i).getValueDedicacion();
            if(dedicacion.equals(opt)){
              sb.append(coleccion.getDocente(i)).append(" \n");  
            }
        }
        return sb.toString();
    }

    /**
     * INTERFAZ/LÓGICA/CONTROL ESTUDIANTES *
     */
    /**
     * Muestra las distintas opciones para gestionar los estudiantes y lanza los
     * métodos que realiza cada operación
     *
     * @param coleccion La Universidad sobre la que actua
     */
    private void gestionEstudiantes(Universidad coleccion) {
        int opcion = 0;

        do {
            opcion = menuGestionEstudiantes();
            switch (opcion) {
                case 1 -> insertaEstudiante(coleccion);
                case 2 -> modificaEstudiante(coleccion);
                case 3 -> eliminaEstudiante(coleccion);
                case 4 -> listarEstudiantes(coleccion);
                case 5 -> System.out.println(listarEstudiantesErasmus(coleccion));
            }
        } while (opcion != 0);
    }

    /**
     * Presenta un menu con las opciones para gestionar estudiantes, y permite
     * seleccionar una.
     *
     * @param coleccion La Universidad sobre la que se realizan las operaciones
     * @return la opcion seleccionada, como entero
     */
    private int menuGestionEstudiantes() {
        int toret;

        do {
            System.out.println("GESTION ESTUDIANTES");
            System.out.println("""
                               
                               1. Insertar estudiante
                               2. Modificar estudiante
                               3. Eliminar estudiante
                               4. Listar estudiantes
                               5. Listar estudiantes erasmus
                               0. Volver al men\u00fa principal
                               """);
            toret = leeEntero("Selecciona: ");
        } while (toret < 0 || toret > 5);

        System.out.println();
        return toret;
    }

    /**
     * Crea un nuevo estudiante y lo inserta en la coleccion
     *
     * @param coleccion La coleccion en la que se inserta el estudiante.
     */
    private void insertaEstudiante(Universidad coleccion) {
        System.out.println("\n-------------");
        System.out.println("\nAlta estudiante");

        Estudiante a = leeEstudiante();
        coleccion.insertaEstudiante(a);
    }

    /**
     * Lee del teclado los datos de un estudiante.
     *
     * @return El objeto Estudiante creado
     */
    private Estudiante leeEstudiante() {
        System.out.println("\nIntroduce los datos del nuevo estudiante:");

        String dni = leeCadena("\tD.N.I.: ");
        String nombre = leeCadena("\tNombre: ");

        String tipoEstudiante = leeTipoEstudiante("\tEl estudiante es Erasmus (S/N)?: ");
        boolean esErasmus = tipoEstudiante.equals("S");

        return new Estudiante(dni, nombre, esErasmus);
    }

    /**
     * Pregunta si el estudiante es de erasmus
     *
     * @param msg Mensaje que se muestra al usuario
     * @return La cadena que indica si el estudiante es de erasmus
     */
    private String leeTipoEstudiante(String msg) {
        String esErasmus = "";
        do {
            esErasmus = leeCadena(msg).toUpperCase();

            if (!esErasmus.equals("S")
                    && !esErasmus.equals("N")) {
                System.err.println("Contesta S: si o N: no. "
                        + "Por favor, introdúcela de nuevo.");
            }
        } while (!esErasmus.equals("S")&& !esErasmus.equals("N"));

        return esErasmus;
    }

    /**
     * Borra un estudiante por su posicion en la colección.
     *
     * @param coleccion La coleccion en la que se elimina el estudiante
     */
    private void eliminaEstudiante(Universidad coleccion) {
        if (coleccion.getNumEstudiantes() > 0) {
            coleccion.eliminaEstudiante(leePosEstudiante(coleccion));
        } else {
            System.out.println("La coleccion no contiene estudiantes.");
        }
    }

    /**
     * Modifica un estudiante existente.
     *
     * @param coleccion La coleccion de la cual modificar un estudiante.
     */
    private void modificaEstudiante(Universidad coleccion) {
        System.out.println("\n---------------------");
        System.out.println("\nModificación estudiante");

        if (coleccion.getNumEstudiantes() > 0) {
            this.modificaEstudiante(coleccion.getEstudiante(this.leePosEstudiante(coleccion)));
        } else {
            System.out.println("La coleccion no contiene estudiantes.");
        }
    }

    private void modificaEstudiante(Estudiante a) {
        boolean vacio = false;
        String info;

        System.out.println("\nModificando los datos del siguiente estudiante:");
        System.out.println(a);
        System.out.println();

        // D.N.I.
        System.out.print("D.N.I. ");
        if (a.getDni().length() > 0) {
            System.out.print("[" + a.getDni() + "]");
            vacio = true;
        }
        info = leeCadena(": ", vacio);
        if (info.length() > 0) {
            a.setDni(info);
        }

        // Nombre
        System.out.print("Nombre ");
        if (a.getNombre().length() > 0) {
            System.out.print("[" + a.getNombre() + "]");
            vacio = true;
        }
        info = leeCadena(": ", vacio);
        if (info.length() > 0) {
            a.setNombre(info);
        }

        // Es Erasmus. ES OBLIGATORIO MODIFICAR (INTRODUCIR) SI EL ALUMNO
        // ES O NO ERAMUS
        String erasmusActual = a.isErasmus() ? "Es Erasmus" : "No es Erasmus";
        String esErasmus = leeTipoEstudiante("\"\\tEl estudiante es Erasmus (S/N)?: \""
                + " [" + erasmusActual + "]: ");
        a.setErasmus(esErasmus.equals("S"));
    }

    /**
     * Lee del teclado la posición de un estudiante en la colección
     *
     * @param coleccion La colección de la que se obtiene el max.
     * @return la posición del estudiante, como entero.
     */
    private int leePosEstudiante(Universidad coleccion) {
        final int numEstudiantes = coleccion.getNumEstudiantes();
        int toret;

        do {
            toret = leeEntero("Introduzca posición del estudiante (1..."
                    + numEstudiantes + "): ");

            if (toret < 1 || toret > numEstudiantes) {
                System.err.println("Posición inválida. "
                        + "Por favor, introdúzcala de nuevo.");
            }
        } while (toret < 1 || toret > numEstudiantes);

        return toret - 1;
    }

    /**
     * Visualiza los estudiantes almacenados en la coleccion por la salida std.
     *
     * @param coleccion El objeto Universidad del que visualizar sus
     * estudiantes.
     */
    private void listarEstudiantes(Universidad coleccion) {
        final int numEstudiantes = coleccion.getNumEstudiantes();

        if (numEstudiantes > 0) {
            System.out.print("\nEstudiantes:\n");
            for (int i = 0; i < numEstudiantes; i++) {
                System.out.print((i + 1) + ". ");
                System.out.println(coleccion.getEstudiante(i).toString());
                System.out.println("\n");
            }
        } else {
            System.out.println("No hay estudiantes.");
        }

    }

    /**
     * Lista los estudiantes de la universidad que son erasmus
     *
     * @param coleccion La universidad de la que se listan los estudiantes
     * erasmus
     * @return lista en la que figuran los estudiantes que están dentro del 
     * programa erasmus
     */
    public String listarEstudiantesErasmus(Universidad coleccion) {
        final int numEstudiantes = coleccion.getNumEstudiantes();
        boolean esta = false;
        StringBuilder sb = new StringBuilder();
        if(numEstudiantes > 0){
            for (int i = 0; i < numEstudiantes; i++) {
                if(coleccion.getEstudiante(i).isErasmus()==true){
                    esta = true;
                    sb.append(i + 1).append(" . ");
                    sb.append(coleccion.getEstudiante(i).toString());
                    sb.append("\n");
                }
                
            }
            if(esta == false){
                sb.append("No hay estudiantes registrados detro del programa Erasmus");
            }
            
        }else{
            sb.append("No hay estudiantes registrados en la base de datos\n");
        }
        return sb.toString();
    }
    
    //TODO GESTION ASIGNATURAS   
    
        /**
     * INTERFAZ/LÓGICA/CONTROL ASIGNATURAS *
     */
    /**
     * Muestra las distintas opciones para gestionar las asignaturas y lanza los
     * métodos que realiza cada operación
     *
     * @param coleccion La Universidad sobre la que actua
     */
    private void gestionAsignaturas(Universidad coleccion) {
        int opcion = 0;

        do {
            opcion = menuGestionAsignaturas();
            switch (opcion) {
                case 1 -> insertaAsignatura(coleccion);
                case 2 -> modificaAsignatura(coleccion);
                case 3 -> eliminaAsignatura(coleccion);
                case 4 -> listarAsignaturas(coleccion);
            }
        } while (opcion != 0);
    }

    /**
     * Presenta un menu con las opciones para gestionar asignatures, y permite
     * seleccionar una.
     *
     * @param coleccion La Universidad sobre la que se realizan las operaciones
     * @return la opcion seleccionada, como entero
     */
    private int menuGestionAsignaturas() {
        int toret;

        do {
            System.out.println("GESTION ASIGNATURAS");
            System.out.println("""
                               
                               1. Insertar asignatura
                               2. Modificar asignatura
                               3. Eliminar asignatura
                               4. Listar asignaturas
                               0. Volver al men\u00fa principal
                               """);
            toret = leeEntero("Selecciona: ");
        } while (toret < 0 || toret > 4);

        System.out.println();
        return toret;
    }

    /**
     * Crea una nueva asignatura y lo inserta en la coleccion
     *
     * @param coleccion La coleccion en la que se inserta el estudiante.
     */
    private void insertaAsignatura(Universidad coleccion) {
        System.out.println("\n-------------");
        System.out.println("\nRegistro asignatura");

        Asignatura a = leeAsignatura();
        coleccion.insertaAsignatura(a);
    }

    /**
     * Lee del teclado los datos de un estudiante.
     *
     * @return El objeto Estudiante creado
     */
    private Asignatura leeAsignatura() {
        System.out.println("\nIntroduce los datos de la nueva materia: ");

        int codigo = leeEntero("\tCodigo de la asignatura: ");
        String nombre = leeCadena("\tNombre de la asignatura: ");

        
        int tipoAsignatura =leeTipoAsignatura("\nEs una asignatura \n(0)Basica?\n(1)Obligatoria?\n(2)Optativa? \n");
        

        return new Asignatura(codigo, nombre, tipoAsignatura);
    }

    /**
     * Pregunta si el estudiante es de erasmus
     *
     * @param msg Mensaje que se muestra al usuario
     * @return La cadena que indica si el estudiante es de erasmus
     */
    private int leeTipoAsignatura(String msg) {
        int tipo;
        do {
            tipo = Integer.parseInt(leeCadena(msg));

            if (tipo!=0 && tipo != 1 && tipo != 2) {
                System.err.println("Contesta 0: Basica 1:Obligatoria 2: Optativa "
                        + "Por favor, introdúcela de nuevo.");
            }
        } while (tipo!=0 && tipo != 1 && tipo != 2);

        return tipo;
    }

    /**
     * Borra un estudiante por su posicion en la colección.
     *
     * @param coleccion La coleccion en la que se elimina el estudiante
     */
    private void eliminaAsignatura(Universidad coleccion) {  //que elimine nuestras malas medias y nos regale matriculas de honor
        if (coleccion.getNumAsignaturas() > 0) {
            coleccion.eliminaAsignatura(leePosAsignatura(coleccion));
        } else {
            System.out.println("La coleccion no contiene asignaturas.");
        }
    }

    /**
     * Modifica un estudiante existente.
     *
     * @param coleccion La coleccion de la cual modificar un estudiante.
     */
    private void modificaAsignatura(Universidad coleccion) {
        System.out.println("\n---------------------");
        System.out.println("\nModificación asignatura");

        if (coleccion.getNumAsignaturas() > 0) {
            this.modificarAsignatura(coleccion.getAsignatura(this.leePosAsignatura(coleccion)));
        } else {
            System.out.println("La coleccion no contiene asignaturas.");
        }
    }

    private void modificarAsignatura(Asignatura a) {
        boolean vacio = false;
        String info;

        System.out.println("\nModificando los datos de la siguiente asignatura:");
        System.out.println(a);
        System.out.println();

        // Codigo
        System.out.print("Codigo de la asignatura ");
        if (a.getCodigo()> 0) {
            System.out.print("[" + a.getCodigo() + "]");
            vacio = true;
        }
        info = leeCadena(": ", vacio);
        if (info.length() > 0) {
            a.setCodigo(Integer.parseInt(info));
        }

        // Nombre
        System.out.print("Nombre ");
        if (a.getNombre().length() > 0) {
            System.out.print("[" + a.getNombre() + "]");
            vacio = true;
        }
        info = leeCadena(": ", vacio);
        if (info.length() > 0) {
            a.setNombre(info);
        }

        // Es Erasmus. ES OBLIGATORIO MODIFICAR (INTRODUCIR) SI EL ALUMNO
        // ES O NO ERAMUS
        int tipoAsignatura = leeTipoAsignatura("\"\\tEs una asignatura \n(0)Basica?\n(1)Obligatoria?\n(2)Optativa? \"");
        a.setTipoAsignatura(tipoAsignatura);
    }

    /**
     * Lee del teclado la posición de una asignatura en la colección
     *
     * @param coleccion La colección de la que se obtiene el max.
     * @return la posición de la asignatura, como entero.
     */
    private int leePosAsignatura(Universidad coleccion) {
        final int numAsignaturas = coleccion.getNumAsignaturas();
        int toret;

        do {
            toret = leeEntero("Introduzca posición de la asignatura (1..."
                    + numAsignaturas + "): ");

            if (toret < 1 || toret > numAsignaturas) {
                System.err.println("Posición inválida. "
                        + "Por favor, introdúzcala de nuevo.");
            }
        } while (toret < 1 || toret > numAsignaturas);

        return toret - 1;
    }

    /**
     * Visualiza las asignaturas almacenados en la coleccion por la salida std.
     *
     * @param coleccion El objeto Universidad del que visualizar sus
     * asignaturas.
     */
    private void listarAsignaturas(Universidad coleccion) {
        final int numAsignaturas = coleccion.getNumAsignaturas();

        if (numAsignaturas > 0) {
            System.out.print("\nAsignaturas:\n");
            for (int i = 0; i < numAsignaturas; i++) {
                System.out.print((i + 1) + ". ");
                System.out.println(coleccion.getAsignatura(i).toString());
                System.out.println("\n");
            }
        } else {
            System.out.println("No hay asignaturas.");
        }

    }
}