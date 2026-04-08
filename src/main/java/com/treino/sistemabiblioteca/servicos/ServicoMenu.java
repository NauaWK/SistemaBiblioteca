
package com.treino.sistemabiblioteca.servicos;

import java.util.Scanner;

public abstract class ServicoMenu {
    
    public static int printMenuInicial(Scanner sc) {
        System.out.println("\n======== Biblioteca Virtual ========");
        System.out.println("1 - Consultar o acervo de livros");
        System.out.println("2 - Registrar-se");
        System.out.println("3 - Login");
        System.out.println("0 - Sair");
        int opcao;
        do{
            opcao = sc.nextInt();
        } while (opcao < 0 || opcao > 3);
        sc.nextLine(); //consome quebra de linha
        return opcao;
    }  
    
    public static int printMenuCliente(Scanner sc) {
        System.out.println("======== Menu Cliente ========");
        System.out.println("1 - Consultar o acervo de livros");
        System.out.println("2 - Consultar meus emprestimos");
        System.out.println("3 - Solicitar emprestimo");
        System.out.println("4 - Devolver livro");
        System.out.println("5 - Mudar senha");
        System.out.println("6 - Deletar conta");
        System.out.println("0 - Logout");
        int opcao;
        do{
            opcao = sc.nextInt();
        } while (opcao < 0 || opcao > 6);
        sc.nextLine();
        return opcao;
    } 
       
    public static int printMenuAdmin(Scanner sc) {
        System.out.println("======== Menu Administrador ========");
        System.out.println("1 - Gerenciar usuarios");
        System.out.println("2 - Gerenciar acervo de livros");
        System.out.println("3 - Listar todos os emprestimos");
        System.out.println("0 - Logout");
        int opcao;
        do{
            opcao = sc.nextInt();
        } while (opcao < 0 || opcao > 3);
        sc.nextLine();
        return opcao;
    }
    
    public static int printGerenciarUsuariosAdmin(Scanner sc) {
        System.out.println("\n======== Gerenciamento de Usuarios ========");
        System.out.println("1 - Listar todos os usuarios");
        System.out.println("2 - Registrar usuario");
        System.out.println("3 - Editar usuario");
        System.out.println("4 - Remover usuario");
        System.out.println("0 - Voltar");
        int opcao;
        do{
            opcao = sc.nextInt();
        } while (opcao < 0 || opcao > 4);
        sc.nextLine();
        return opcao;
    }
    
    public static int printEditarUsuarioAdmin(Scanner sc) {
        System.out.println("======== Editar Usuario ========");
        System.out.println("1 - Editar nome");
        System.out.println("2 - Editar senha");
        System.out.println("3 - Editar role");
        System.out.println("4 - Editar todos os campos");
        System.out.println("0 - Voltar");
        int opcao;
        do{
            opcao = sc.nextInt();
        } while (opcao < 0 || opcao > 4);
        sc.nextLine();
        return opcao;
    }

    
    public static int printGerenciarAcervoAdmin(Scanner sc) {
        System.out.println("\n======== Gerenciamento de Acervo ========");
        System.out.println("1 - Listar todos os livros");
        System.out.println("2 - Adicionar livro");
        System.out.println("3 - Editar livro");
        System.out.println("4 - Remover livro");
        System.out.println("0 - Voltar");
        int opcao;
        do{
            opcao = sc.nextInt();
        } while (opcao < 0 || opcao > 4);
        sc.nextLine();
        return opcao;
    }
    
    public static int printEditarLivroAdmin(Scanner sc) {
        System.out.println("\n======== Editar Livro ========");
        System.out.println("1 - Editar titulo");
        System.out.println("2 - Editar autor");
        System.out.println("3 - Editar numero de paginas");
        System.out.println("4 - Editar genero");
        System.out.println("5 - Editar todos os campos");
        System.out.println("0 - Voltar");
        int opcao;
        do {
            opcao = sc.nextInt();
        } while (opcao < 0 || opcao > 5);
        sc.nextLine();
        return opcao;
    }
    
}
