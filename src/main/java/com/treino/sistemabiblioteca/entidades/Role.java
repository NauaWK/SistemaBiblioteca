
package com.treino.sistemabiblioteca.entidades;

public enum Role {
    
    ROOT, ADMIN, CLIENTE;

    public static Role verificarRole(String r){
        try{
            return Role.valueOf(r.toUpperCase());
        } catch(IllegalArgumentException ex){
            System.out.println("Role invalida!");
            return null;
        }
    }
    
}
