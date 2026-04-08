
package com.treino.sistemabiblioteca.entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Biblioteca {
    
    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final List<Livro> livros = new ArrayList<>();
    private static final List<Emprestimo> emprestimos = new ArrayList<>();
    
    public static void inicializar() {  // usuario root criado quando o programa inicia
        if (usuarios.isEmpty()) {
            Usuario root = new Usuario("root", "root123", Role.ROOT);
            usuarios.add(root);
        }
        
        if (livros.isEmpty()) {
            livros.add(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1178, "Fantasia"));
            livros.add(new Livro("Dom Casmurro", "Machado de Assis", 256, "Romance"));
            livros.add(new Livro("1984", "George Orwell", 328, "Distopia"));
            livros.add(new Livro("A Revolução dos Bichos", "George Orwell", 112, "Sátira"));
            livros.add(new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 223, "Fantasia"));
            livros.add(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 96, "Infantil"));
            livros.add(new Livro("Crime e Castigo", "Fiódor Dostoiévski", 671, "Romance"));
            livros.add(new Livro("A Metamorfose", "Franz Kafka", 201, "Ficção"));
        }
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static List<Livro> getLivros() {
        return livros;
    }

    public static List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
  
}
