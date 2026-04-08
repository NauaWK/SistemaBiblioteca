
package com.treino.sistemabiblioteca.servicos;

import com.treino.sistemabiblioteca.entidades.Usuario;
import java.util.Scanner;


public abstract class ServicoLogin {
    
    public static Usuario registrar(Usuario u) {
        ServicoBiblioteca.adicionarUsuario(u);
        System.out.println("Usuario registrado.");
        System.out.println(u);
        return u;
    }
    
    public static Usuario login(Scanner sc) {
        String nome;
        String senha;
        nome = Utils.capturarNome(sc);
        senha = Utils.capturarSenha(sc);
        
        for(Usuario u : ServicoBiblioteca.buscarUsuarios()){
            if(u.getNome().equals(nome) && u.getSenha().equals(senha)){
                return u;
            }
        }
        System.out.println("Credenciais invalidas!");
        return null;
    }
    
}
