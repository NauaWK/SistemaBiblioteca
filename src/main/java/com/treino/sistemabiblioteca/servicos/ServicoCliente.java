
package com.treino.sistemabiblioteca.servicos;

import com.treino.sistemabiblioteca.entidades.Emprestimo;
import com.treino.sistemabiblioteca.entidades.Livro;
import com.treino.sistemabiblioteca.entidades.Usuario;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public abstract class ServicoCliente {
    
    public static boolean tratarOpcaoCliente(int opcao, Usuario u, Scanner sc){
        switch(opcao){
            case 1 -> consultarAcervo(); 
            case 2 -> consultarMeusEmprestimos(u);            
            case 3 -> solicitarEmprestimo(sc, u);
            case 4 -> devolverLivro(u);
            case 5 -> mudarSenha(sc, u);
            case 6 -> { return deletarConta(u); }
            case 0 -> { return deslogar(); }
        }    
        return true;
    }
    
    private static void consultarAcervo(){
        ServicoBiblioteca.exibirTodosOsLivros();
    }
    
    private static void consultarMeusEmprestimos(Usuario u){
        List<Emprestimo> emprestimos = ServicoBiblioteca.buscarEmprestimosDoUsuario(u);
        if(emprestimos.isEmpty()){
            System.out.println("Voce nao tem emprestimos ainda!");
            return;
        }
        System.out.println("===== Meus Emprestimos =====");
        emprestimos.forEach(x -> System.out.println(x));             
    }
    
    private static void solicitarEmprestimo(Scanner sc, Usuario u){

        Livro l = ServicoBiblioteca.buscarLivroPorISBN(sc);
        if(l == null) return;
        
        if(l.isEmprestado() || u.emprestou_livro()){
            System.out.println("O livro ja esta emprestado por alguem ou voce ja tem algum livro emprestado!");
            return;
        }
        
        Emprestimo e = new Emprestimo(u, l);
        u.setEmprestou_livro(true);
        l.setEmprestado(true);
        ServicoBiblioteca.registrarEmprestimo(e);
        System.out.println("Emprestimo do livro " + l.getIsbn() + " realizado.");
    }
    
    private static void devolverLivro(Usuario u){
        if(!u.emprestou_livro()){
            System.out.println("Voce nao possui nenhum livro emprestado no momento!");
            return;
        }
        List<Emprestimo> emprestimos = ServicoBiblioteca.buscarEmprestimosDoUsuario(u);
        Emprestimo emprestimo_atual = emprestimos.getLast();
        emprestimo_atual.getLivro().setEmprestado(false);
        u.setEmprestou_livro(false);
        emprestimo_atual.setData_devolucao(LocalDateTime.now());
        System.out.println("O livro " + emprestimo_atual.getLivro().getIsbn() + " foi devolvido.");
    }
    
    private static void mudarSenha(Scanner sc, Usuario u){
        String senhaAntiga = u.getSenha();
        String novaSenha;
        
        do{
            novaSenha = Utils.capturarSenha(sc);
        } while (senhaAntiga.equals(novaSenha));
        
        u.setSenha(novaSenha);    
        System.out.println("Sua senha " + senhaAntiga + " foi alterada para " + novaSenha);
    }   
    
    private static boolean deletarConta(Usuario u){
        if(u.emprestou_livro()) devolverLivro(u);
        ServicoBiblioteca.deletarUsuario(u);
        return deslogar();
    }
    
    private static boolean deslogar(){
        return false;
    }
    
} 
    
    
