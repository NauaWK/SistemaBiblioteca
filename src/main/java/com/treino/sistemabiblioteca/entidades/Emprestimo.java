
package com.treino.sistemabiblioteca.entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    
    private final Usuario usuario;
    private final Livro livro;
    private final LocalDateTime data_emprestimo;
    private LocalDateTime data_devolucao;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.usuario.setEmprestou_livro(true);
        this.livro = livro;
        this.livro.setEmprestado(true);
        this.data_emprestimo = LocalDateTime.now();
    }


    public Usuario getUsuario() {
        return usuario;
    }
    
    public int getMatriculaUsuario(){
        return usuario.getMatricula();
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDateTime getData_emprestimo() {
        return data_emprestimo;
    }

    public LocalDateTime getData_devolucao() {
        return data_devolucao;
    }
    
    public void setData_devolucao(LocalDateTime data_devolucao) {
        this.data_devolucao = data_devolucao;
    }   
    
    @Override
    public String toString() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return String.format("Livro: %s | Usuario: %s | Emprestimo: %s | Devolucao: %s",
            livro.getTitulo(),
            usuario.getNome(),
            data_emprestimo.format(formatador),
            data_devolucao != null ? data_devolucao.format(formatador) : "Ainda nao devolvido");
    }
    
}
