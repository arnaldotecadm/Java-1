package br.com.pucgo.atividade;

public class Evento {
    int contador;
    String nome;
    String data;

    public Evento(int contador, String nome, String data) {
        this.contador = contador;
        this.nome = nome;
        this.data = data;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
