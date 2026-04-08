
package com.treino.sistemabiblioteca.entidades;

public class Usuario {
    
    private static int id_sequencial = 0;
    
    private final int matricula;
    private String nome;
    private String senha;
    private Role role = Role.CLIENTE;
    private boolean emprestou_livro = false;

    public Usuario(String nome, String senha) {
        this.matricula = id_sequencial++;
        this.nome = nome;
        this.senha = senha;
    }
    
    public Usuario(String nome, String senha, Role role) {
        this.matricula = id_sequencial++;
        this.nome = nome;
        this.senha = senha;
        this.role = role;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean emprestou_livro() {
        return emprestou_livro;
    }

    public void setEmprestou_livro(boolean emprestou_livro) {
        this.emprestou_livro = emprestou_livro;
    }
    
    @Override
    public String toString() {
        return String.format("Matricula: %d | Usuario: %s | Role: %s | Emprestou livro: %s",
            matricula,
            nome,
            role,
            emprestou_livro == true ? "SIM" : "NAO");
    }

}
