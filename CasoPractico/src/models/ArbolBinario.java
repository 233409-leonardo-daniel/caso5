package models;
import java.util.Scanner;
public class ArbolBinario {
    private Nodo raiz = null;
    private Archivo archivo;
    private int activoCount;
    private int inactivoCount;
    private int bajaDefinitivaCount;
    private int bajaAcademicaCount;
    private int bajaTemporalCount;
    private int egresadoCount;
    private int tituladoCount;
    public ArbolBinario() {
        this.archivo = new Archivo("Alumnos.txt");
    }
    public void crearRaiz(Student student) {
        if (raiz == null) {
            raiz = new Nodo(student);
            incrementarContador(student.getStatus());
            crearArbol(raiz);
        }
    }
    public void preorden(Nodo raiz) {
        if (raiz != null) {
            System.out.println("Matrícula: " + raiz.getDato().getMatricula() + ", Nombre: " + raiz.getDato().getNombre());
            preorden(raiz.getIzq());
            preorden(raiz.getDer());
        }
    }
    public void inorden(Nodo raiz) {
        if (raiz != null) {
            inorden(raiz.getIzq());
            System.out.println("Matrícula: " + raiz.getDato().getMatricula() + ", Nombre: " + raiz.getDato().getNombre());
            inorden(raiz.getDer());
        }
    }
    public void postorden(Nodo raiz) {
        if (raiz != null) {
            postorden(raiz.getIzq());
            postorden(raiz.getDer());
            System.out.println("Matrícula: " + raiz.getDato().getMatricula() + ", Nombre: " + raiz.getDato().getNombre());
        }
    }
    public void crearArbol(Nodo nodo) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Existe nodo por la izquierda de " + nodo.getDato().getNombre() + "? (1) Sí (2) No");
        int respuesta = entrada.nextInt();
        if (respuesta == 1) {
            Student subIzqStudent = crearEstudiante(entrada);
            if (subIzqStudent != null) {
                if (buscarMatricula(subIzqStudent.getMatricula(), raiz) == null) {
                    Nodo subizq = new Nodo(subIzqStudent);
                    nodo.setIzq(subizq);
                    incrementarContador(subIzqStudent.getStatus());
                    crearArbol(subizq);
                } else {
                    System.out.println("La matrícula " + subIzqStudent.getMatricula() + " ya existe.");
                }
            }
        }


        System.out.println("¿Existe nodo por la derecha de " + nodo.getDato().getNombre() + "? (1) Sí (2) No");
        respuesta = entrada.nextInt();
        if (respuesta == 1) {
            Student subDerStudent = crearEstudiante(entrada);
            if (subDerStudent != null ) {
                if (buscarMatricula(subDerStudent.getMatricula(), raiz) == null) {
                    Nodo subderecho = new Nodo(subDerStudent);
                    nodo.setDer(subderecho);
                    incrementarContador(subDerStudent.getStatus());
                    crearArbol(subderecho);
                } else {
                    System.out.println("La matrícula " + subDerStudent.getMatricula() + " ya existe.");
                }
            }
        }
    }
    public static Student crearEstudiante(Scanner entrada) {
        System.out.println("Ingrese matrícula del estudiante");
        int matricula = entrada.nextInt();
        entrada.nextLine();

        if (!matriculaValida(matricula)) {
            System.out.println("Matrícula no válida. Debe comenzar con 201, 203, 211, 213, 221, 223, 231, o 233.");
            return null;
        }

        System.out.println("Ingrese nombre del estudiante");
        String nombre = entrada.nextLine();

        System.out.println("Ingrese status del estudiante");
        String status = entrada.nextLine().toLowerCase();

        if (!statusValido(status)) {
            System.out.println("Status no válido. Debe ser uno de los siguientes: activo, inactivo, baja definitiva, baja académica, baja temporal, egresado, titulado.");
            return null;
        }

        return new Student(matricula, nombre, status);
    }
    public static boolean matriculaValida(int matricula) {
        String matriculaStr = String.valueOf(matricula);
        return matriculaStr.startsWith("201") ||
                matriculaStr.startsWith("203") ||
                matriculaStr.startsWith("211") ||
                matriculaStr.startsWith("213") ||
                matriculaStr.startsWith("221") ||
                matriculaStr.startsWith("223") ||
                matriculaStr.startsWith("231") ||
                matriculaStr.startsWith("233");
    }
    public static boolean statusValido(String status) {
        return status.equals("activo") ||
                status.equals("inactivo") ||
                status.equals("baja definitiva") ||
                status.equals("baja académica") ||
                status.equals("baja temporal") ||
                status.equals("egresado") ||
                status.equals("titulado");
    }

    public void incrementarContador(String status) {
        switch (status) {
            case "activo":
                activoCount++;
                break;
            case "inactivo":
                inactivoCount++;
                break;
            case "baja definitiva":
                bajaDefinitivaCount++;
                break;
            case "baja académica":
                bajaAcademicaCount++;
                break;
            case "baja temporal":
                bajaTemporalCount++;
                break;
            case "egresado":
                egresadoCount++;
                break;
            case "titulado":
                tituladoCount++;
                break;
        }
    }
    public void visualizarRecorridos() {
        System.out.println("Preorden");
        preorden(raiz);
        System.out.println("Inorden");
        inorden(raiz);
        System.out.println("Postorden");
        postorden(raiz);
    }
    public void visualizarEstadisticas() {
        System.out.println("Estadísticas de estatus:");
        System.out.println("Activo: " + activoCount);
        System.out.println("Inactivo: " + inactivoCount);
        System.out.println("Baja definitiva: " + bajaDefinitivaCount);
        System.out.println("Baja académica: " + bajaAcademicaCount);
        System.out.println("Baja temporal: " + bajaTemporalCount);
        System.out.println("Egresado: " + egresadoCount);
        System.out.println("Titulado: " + tituladoCount);
    }
    public void guardarEnTxt() {
        guardarEnArchivo(raiz);
    }
    public void guardarEnArchivo(Nodo raiz) {
        if (raiz != null) {
            String registro = "Matrícula: " + raiz.getDato().getMatricula() + ", Nombre: " + raiz.getDato().getNombre() + ", Status: " + raiz.getDato().getStatus();
            archivo.escribirInformacion(new String[]{registro});
            guardarEnArchivo(raiz.getIzq());
            guardarEnArchivo(raiz.getDer());
        }
    }
    public Nodo buscarMatricula(int matricula, Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        if (nodo.getDato().getMatricula() == matricula) {
            return nodo;
        }
        Nodo foundNode = buscarMatricula(matricula, nodo.getIzq());
        if (foundNode == null) {
            foundNode = buscarMatricula(matricula, nodo.getDer());
        }
        return foundNode;
    }
}