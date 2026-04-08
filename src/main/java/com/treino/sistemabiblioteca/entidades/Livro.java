
package com.treino.sistemabiblioteca.entidades;

public class Livro {
    
    private String titulo;
    private String autor;
    private int paginas;
    private String genero;
    private final String isbn;
    private boolean emprestado = false;

    public Livro(String titulo, String autor, int paginas, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.genero = genero;
        this.isbn = ISBNGerador.gerarISBN();
    }
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
    
    @Override
    public String toString() {
        return String.format(
            "Titulo: %s | Autor: %s | Paginas: %d | Genero: %s | ISBN: %s | Status: %s",
            titulo,
            autor,
            paginas,
            genero,
            isbn,
            emprestado ? "Emprestado" : "Disponivel"
        );
    }
    
}
