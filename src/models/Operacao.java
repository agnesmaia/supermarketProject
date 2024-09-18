package models;

public class Operacao {
    private double valor;
    private String tipo;

    public Operacao(double valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }
}
