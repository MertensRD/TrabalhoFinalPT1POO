package turing.trabalhofinalpt1poo.entidades;

public class Professor {

    private String nome;
    private int id;
    private String siape; // Alterado para String
    private String uni_academica; // Adicionado private
    private String curso; // Adicionado private

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getUni_academica() {
        return uni_academica;
    }

    public void setUni_academica(String uni_academica) {
        this.uni_academica = uni_academica;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}