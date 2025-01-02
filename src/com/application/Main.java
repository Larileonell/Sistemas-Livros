package com.application;

import com.application.controller.LivroController;
import com.application.model.Livro;
import com.application.util.LivrosUtil;
import com.application.view.LivrosView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LivrosView view = new LivrosView();
        view.criarInterface();
    }
}