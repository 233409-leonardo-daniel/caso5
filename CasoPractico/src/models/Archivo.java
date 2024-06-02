package models;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class Archivo {
    private String ruta;
    public Archivo(String ruta) {
        this.ruta = ruta;
    }
    public void escribirInformacion(String[] registros) {
        try (FileWriter fichero = new FileWriter(ruta, true);
             PrintWriter pw = new PrintWriter(fichero)) {
            for (String registro : registros) {
                pw.println(registro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}