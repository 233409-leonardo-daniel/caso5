import models.ArbolBinario;
import models.Student;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();
        int opc;
        do {
            System.out.println("O P C I O N E S ");
            System.out.println("1. Crear Árbol\n2. lista de tutorados\n3. visualizar estadisticas\n4. Salir");
            opc = entrada.nextInt();
            entrada.nextLine();
            switch (opc) {
                case 1:
                        Student student = ArbolBinario.crearEstudiante(entrada);
                            arbol.crearRaiz(student);
                    break;
                case 2:
                    arbol.visualizarRecorridos();
                    break;
                case 3:
                    arbol.visualizarEstadisticas();
                    break;
            }
        } while (opc != 4);
        arbol.guardarEnTxt();
    }
}