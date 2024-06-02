package models;
public class Nodo {
    private Student dato;
    private Nodo izq;
    private Nodo der;

    public Nodo(Student dato) {
        this.dato = dato;
    }
    public Nodo() {}
    public Student getDato() {
        return dato;
    }
    public void setDato(Student dato) {
        this.dato = dato;
    }
    public Nodo getIzq() {
        return izq;
    }
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
    public Nodo getDer() {
        return der;
    }
    public void setDer(Nodo der) {
        this.der = der;
    }
}

