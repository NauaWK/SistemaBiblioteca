
package com.treino.sistemabiblioteca.servicos;

import com.treino.sistemabiblioteca.entidades.Livro;
import com.treino.sistemabiblioteca.entidades.Role;
import com.treino.sistemabiblioteca.entidades.Usuario;
import java.util.Scanner;

public abstract class Utils {
    
    
    public static String capturarNome(Scanner sc){
        String nome;
        do{
            System.out.println("Nome: ");
            nome = sc.nextLine().strip();
            if (!nome.matches("^[A-Za-zÀ-ÿ ]+$")) {
                System.out.println("Entrada inválida. O nome deve conter apenas letras e espaços.");
                nome = null;
            }

        } while (nome == null);
        return nome;
    } 
    
    public static String capturarSenha(Scanner sc){
        String senha;
        do{
            System.out.println("Senha: ");
            senha = sc.nextLine().strip();
        } while (senha.isBlank());
        return senha;
    }   
    
    public static Role capturarRole(Scanner sc){
        Role role;
        do{
            System.out.println("Role de usuario: ");
            role = Role.verificarRole(sc.nextLine().strip());
        } while (role == null);
        return role;
    }
    
    public static Usuario criarUsuarioCliente(Scanner sc){
        String nome;
        do{
            nome = capturarNome(sc);
            if(ServicoBiblioteca.usuarioExiste(nome)) System.out.println("Usuario com nome " + nome + " ja existe.");
        } while (ServicoBiblioteca.usuarioExiste(nome));
        String senha = capturarSenha(sc);
        return new Usuario(nome, senha);       
    }
    
    public static Usuario criarUsuarioModoAdmin(Scanner sc){
        String nome = capturarNome(sc);
        String senha = capturarSenha(sc);
        Role role;
        do{
            role = capturarRole(sc);
            if(role == Role.ROOT) System.out.println("So pode haver 1 usuario root no sistema!");
        } while (role == Role.ROOT);   // so pode haver 1 root
        
         
        return new Usuario(nome, senha, role);       
    }
    
    public static String capturarTitulo(Scanner sc) {
        String titulo;
        do {
            System.out.println("Insira o titulo do livro: ");
            titulo = sc.nextLine().strip();
        } while (titulo.isBlank());
        return titulo;
    }

    public static String capturarAutor(Scanner sc) {
        String autor;
        do {
            System.out.println("Insira o autor do livro: ");
            autor = sc.nextLine().strip();
        } while (autor.isBlank());
        return autor;
    }

    public static int capturarPaginas(Scanner sc) {
        int paginas;
        do {
            System.out.println("Insira o numero de paginas: ");
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, insira um numero valido.");
                sc.nextLine();
            }
            paginas = sc.nextInt();
            sc.nextLine(); 
        } while (paginas <= 0);
        return paginas;
    }

    public static String capturarGenero(Scanner sc) {
        String genero;
        do {
            System.out.println("Insira o genero do livro: ");
            genero = sc.nextLine().strip();
        } while (genero.isBlank());
        return genero;
    }

    public static Livro criarLivro(Scanner sc) {
        String titulo = capturarTitulo(sc);
        String autor = capturarAutor(sc);
        int paginas = capturarPaginas(sc);
        String genero = capturarGenero(sc);
        return new Livro(titulo, autor, paginas, genero);
    }

}
