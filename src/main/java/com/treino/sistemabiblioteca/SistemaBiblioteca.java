
package com.treino.sistemabiblioteca;

import com.treino.sistemabiblioteca.entidades.Biblioteca;
import com.treino.sistemabiblioteca.entidades.Role;
import com.treino.sistemabiblioteca.entidades.Usuario;
import com.treino.sistemabiblioteca.servicos.ServicoAdmin;
import com.treino.sistemabiblioteca.servicos.ServicoBiblioteca;
import com.treino.sistemabiblioteca.servicos.ServicoCliente;
import com.treino.sistemabiblioteca.servicos.ServicoLogin;
import com.treino.sistemabiblioteca.servicos.ServicoMenu;
import com.treino.sistemabiblioteca.servicos.Utils;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SistemaBiblioteca {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean encerrado = false;
        boolean logado = false;
        int opcao;
        Usuario usuario = null;
        Biblioteca.inicializar();
        
        while(!encerrado){  
            
            try{
                if(!logado){
                    opcao = ServicoMenu.printMenuInicial(sc); 
                    switch(opcao){
                        case 1 -> {
                            ServicoBiblioteca.exibirTodosOsLivros();
                            continue;
                        }
                        case 2 -> {
                            Usuario u = Utils.criarUsuarioCliente(sc);
                            ServicoLogin.registrar(u);
                            continue;
                        }
                        case 3 -> {
                            Usuario u = ServicoLogin.login(sc);
                            if(u == null){
                                continue;  //proxima iteracao do while (login mal sucedido)
                            }
                            else{
                                usuario = u;
                                logado = true;
                            }
                        }
                        case 0 -> {
                            encerrado = true;
                            continue;
                        }
                    }
                }
            
                System.out.println("\nLogado como " + usuario.getNome()+ " | Role " + usuario.getRole());
                if(usuario.getRole() == Role.CLIENTE){
                    opcao = ServicoMenu.printMenuCliente(sc);
                    if(!ServicoCliente.tratarOpcaoCliente(opcao, usuario, sc)) logado = false;
                }
                else{
                    opcao = ServicoMenu.printMenuAdmin(sc);
                    if(!ServicoAdmin.tratarOpcaoAdmin(opcao, sc, usuario)) logado = false;
                }
                
            } catch(InputMismatchException ex){
                System.out.println("Formato de entrada invalido.");
                sc.nextLine();  //consumindo quebra de linha do enter
            }
        }
        System.out.println("Ate mais!");
    }
}  
