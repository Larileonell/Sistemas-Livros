package com.application.controller;

import com.application.model.Livro;
import com.application.util.LivrosUtil;

import java.util.ArrayList;
import java.util.List;

public class LivroController {
    private List<Livro> listaLivros = new ArrayList<>();


    public boolean adicionarLivro (Livro livro){
        if (!LivrosUtil.validarISBN(livro.getIsbn())) {
            System.out.println("ISBN INVÁLIDO");
            return false;
        }
        listaLivros.add(livro);
        return true;

}
public List<Livro> listarLivros (){
        return listaLivros;
}
public Livro buscarLivro(String isbn){
        for (Livro livro : listaLivros){
            if (livro.getIsbn().equals(isbn)){
                return livro;
            }
        }
        return null;
}
public  boolean removerLivro (String isbn){
        return listaLivros.removeIf(livro -> livro.getIsbn().equals(isbn));
}
}




