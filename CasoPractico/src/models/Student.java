package models;
public class Student {
    private int matricula;
    private String nombre;
    private String status;
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Student(int matricula, String nombre, String status) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.status = status;
    }
}