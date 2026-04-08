
package com.treino.sistemabiblioteca.servicos;

import com.treino.sistemabiblioteca.entidades.Emprestimo;
import com.treino.sistemabiblioteca.entidades.Livro;
import com.treino.sistemabiblioteca.entidades.Role;
import com.treino.sistemabiblioteca.entidades.Usuario;
import java.util.List;
import java.util.Scanner;

public abstract class ServicoAdmin {
    
    public static boolean tratarOpcaoAdmin(int opcao, Scanner sc, Usuario u){
        switch(opcao){
            case 1 -> gerenciarUsuarios(sc, u);            
            case 2 -> gerenciarAcervo(sc);
            case 3 -> listarTodosEmprestimos();
            case 0 -> { return false; } 
        }    
        return true;        
    }
    
    private static void gerenciarUsuarios(Scanner sc, Usuario u){
        boolean voltar = false;
        while (!voltar) {
            int opcao = ServicoMenu.printGerenciarUsuariosAdmin(sc);
            if(opcao == 4 && u.getRole() == Role.ADMIN){   //apenas root pode deletar contas
                System.out.println("Apenas o administrador root pode remover usuarios.");
                continue;
            }
            switch(opcao){
                case 1 -> listarTodosUsuarios();
                case 2 -> registrarUsuarioAdmin(sc);
                case 3 -> editarUsuario(sc);
                case 4 -> removerUsuario(sc);
                case 0 -> voltar = true;
            }
        }
    }
    
    private static void listarTodosUsuarios(){
        List<Usuario> usuarios = ServicoBiblioteca.buscarUsuarios();
        usuarios.forEach(u -> System.out.println(u));
    }
    
    private static void registrarUsuarioAdmin(Scanner sc){
        Usuario u = Utils.criarUsuarioModoAdmin(sc);
        ServicoLogin.registrar(u);
    }
    
    private static void editarUsuario(Scanner sc){
        Usuario u = ServicoBiblioteca.buscarUsuarioPorMatricula(sc);
        if(u == null) return;

        boolean voltar = false;
        while (!voltar) {
            System.out.println("Editando usuario " + u.getNome() + " | Role " + u.getRole());
            int opcao = ServicoMenu.printEditarUsuarioAdmin(sc);

            switch(opcao){
                case 1 -> {
                    u.setNome(Utils.capturarNome(sc));
                }
                case 2 -> {
                    u.setSenha(Utils.capturarSenha(sc));
                }
                case 3 -> {
                    u.setRole(Utils.capturarRole(sc));
                }
                case 4 -> {
                    u.setNome(Utils.capturarNome(sc));
                    u.setSenha(Utils.capturarSenha(sc));
                    u.setRole(Utils.capturarRole(sc));
                }
                case 0 -> voltar = true; 
            }
        }
    }
        
    private static void removerUsuario(Scanner sc){
        Usuario u = ServicoBiblioteca.buscarUsuarioPorMatricula(sc);
        if(u == null) return; 
        ServicoBiblioteca.buscarUsuarios().remove(u);
        System.out.println("Usuario removido.");
    }
    
    private static void gerenciarAcervo(Scanner sc){
        boolean voltar = false;
        while(!voltar){
            int opcao = ServicoMenu.printGerenciarAcervoAdmin(sc);
            switch(opcao){
                case 1 -> listarTodosLivros();
                case 2 -> adicionarLivro(sc);
                case 3 -> editarLivro(sc);
                case 4 -> removerLivro(sc);
                case 0 -> voltar = true;
            }
        }
    }
    
    private static void listarTodosLivros(){
        List<Livro> livros = ServicoBiblioteca.buscarLivros();
        if(livros.isEmpty()){
            System.out.println("Ainda nao ha nenhum livro registrado!");
            return;
        }
        livros.forEach(l -> System.out.println(l));
    }
    
    private static void adicionarLivro(Scanner sc){
        Livro l = Utils.criarLivro(sc);
        ServicoBiblioteca.adicionarLivro(l);
    }
    
    private static void editarLivro(Scanner sc){
    Livro l = ServicoBiblioteca.buscarLivroPorISBN(sc);
    if(l == null) return;

        boolean voltar = false;
        while (!voltar) {
            int opcao = ServicoMenu.printEditarLivroAdmin(sc);
            switch(opcao){
                case 1 -> {
                    l.setTitulo(Utils.capturarTitulo(sc));
                }
                case 2 -> {
                    l.setAutor(Utils.capturarAutor(sc));
                }
                case 3 -> {
                    l.setPaginas(Utils.capturarPaginas(sc));
                }
                case 4 -> {
                    l.setGenero(Utils.capturarGenero(sc));
                }
                case 5 -> {
                    l.setTitulo(Utils.capturarTitulo(sc));
                    l.setAutor(Utils.capturarAutor(sc));
                    l.setPaginas(Utils.capturarPaginas(sc));
                    l.setGenero(Utils.capturarGenero(sc));
                }
                case 0 -> voltar = true; 
            }
        }
    }
    
    private static void removerLivro(Scanner sc){
        Livro l = ServicoBiblioteca.buscarLivroPorISBN(sc);
        if(l == null)  return;        
        ServicoBiblioteca.buscarLivros().remove(l);
        System.out.println("Livro removido.");
    }
    
    private static void listarTodosEmprestimos(){
        List<Emprestimo> emprestimos = ServicoBiblioteca.buscarEmprestimos();
        if(emprestimos.isEmpty()){
            System.out.println("Nao ha nenhum emprestimo ainda!");
            return;
        }
        emprestimos.forEach(e -> System.out.println(e));
    }
    
}