
package com.treino.sistemabiblioteca.entidades;

import java.util.Random;

public abstract class ISBNGerador {    
    
    public static String gerarISBN(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder("978-");
        for (int i = 0; i < 9; i++) {
            sb.append(random.nextInt(10));
            if (i == 0 || i == 3 || i == 6) sb.append("-");
        }
        return sb.toString();
    }       
    
}
