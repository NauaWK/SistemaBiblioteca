
package com.treino.sistemabiblioteca.servicos;

import com.treino.sistemabiblioteca.entidades.Biblioteca;
import com.treino.sistemabiblioteca.entidades.Emprestimo;
import com.treino.sistemabiblioteca.entidades.Livro;
import com.treino.sistemabiblioteca.entidades.Usuario;
import java.util.List;
import java.util.Scanner;


public abstract class ServicoBiblioteca {
    
    public static List<Usuario> buscarUsuarios(){
        return Biblioteca.getUsuarios();
    }
    
    public static Usuario buscarUsuarioPorMatricula(Scanner sc){
        int matricula;
        Usuario u;
        List<Usuario> usuarios = buscarUsuarios();
        if(usuarios.size() == 1){
            System.out.println("Ainda nao ha usuarios no sistema exceto o root.");
            return null;           
        }
        do{
            System.out.println("Insira a matricula do usuario: ");
            matricula = sc.nextInt();
        } while (matricula <= 0 || matricula >= usuarios.size());
        
        u = usuarios.get(matricula);
        if(u == null) System.out.println("Usuario com a matricula " + matricula + " nao existe!");
        return u;
    }
    
    public static void adicionarUsuario(Usuario u){
        List<Usuario> usuarios = Biblioteca.getUsuarios();
        usuarios.add(u);
    }
    
    public static boolean usuarioExiste(String nome){
       List<Usuario> usuarios = Biblioteca.getUsuarios();
       return usuarios
               .stream()
               .anyMatch(u -> u.getNome().equalsIgnoreCase(nome));
    }
    
    public static void deletarUsuario(Usuario u){
        List<Usuario> usuarios = Biblioteca.getUsuarios();
        usuarios.remove(u);
        System.out.println("Usuario com matricula " + u.getMatricula() + " deletado.");
    }
    
    public static List<Livro> buscarLivros(){
        return Biblioteca.getLivros();
    }
    
    public static void exibirTodosOsLivros(){
        List<Livro> livros = buscarLivros();
        livros.forEach(l -> System.out.println(l));
    }
    
    public static Livro buscarLivroPorISBN(Scanner sc){   
        List<Livro> livros = buscarLivros();
        String isbn;
        do{
            System.out.println("Insira o ISBN do livro: ");
            isbn = sc.nextLine().strip();
        } while (isbn.isBlank());
        
        for(Livro l : livros){
            if(l.getIsbn().equals(isbn)) return l;
        }
        System.out.println("Esse livro nao existe!");
        return null;
    }
    
    public static void adicionarLivro(Livro l){
        List<Livro> livros = Biblioteca.getLivros();
        livros.add(l);
    }
    
    public static List<Emprestimo> buscarEmprestimos(){
        return Biblioteca.getEmprestimos();
    }
    
    public static void registrarEmprestimo(Emprestimo e){
        List<Emprestimo> emprestimos = Biblioteca.getEmprestimos();
        emprestimos.add(e);
    }
    
    public static List<Emprestimo> buscarEmprestimosDoUsuario(Usuario u){
        List<Emprestimo> emprestimos = Biblioteca.getEmprestimos();
        return emprestimos
                .stream()
                .filter(e -> e.getMatriculaUsuario() == u.getMatricula())
                .toList();
    }
    
}
