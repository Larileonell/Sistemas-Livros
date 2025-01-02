package com.application.view;

import com.application.controller.LivroController;
import com.application.model.Livro;

import javax.swing.*;
import java.awt.*;

public class LivrosView {
    private final LivroController controller = new LivroController();

    public void criarInterface() {
        JFrame frame = new JFrame("Gerenciamento de Livros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        JTextField tituloField = new JTextField();
        JTextField autorField = new JTextField();
        JTextField anoField = new JTextField();
        JTextField isbnField = new JTextField();


        panel.add(new JLabel("Título:"));
        panel.add(tituloField);
        panel.add(new JLabel("Autor:"));
        panel.add(autorField);
        panel.add(new JLabel("Ano:"));
        panel.add(anoField);
        panel.add(new JLabel("ISBN:"));
        panel.add(isbnField);


        JButton addButton = new JButton("Adicionar Livro");
        JButton listButton = new JButton("Listar Livros");


        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        addButton.addActionListener(e -> {
            try {
                String titulo = tituloField.getText();
                String autor = autorField.getText();
                int ano = Integer.parseInt(anoField.getText());
                String isbn = isbnField.getText();

                Livro livro = new Livro(titulo, autor, ano, isbn);
                if (controller.adicionarLivro(livro)) {
                    outputArea.append("Livro adicionado: " + titulo + "\n");
                } else {
                    outputArea.append("ISBN inválido para: " + titulo + "\n");
                }

                // Limpar campos
                tituloField.setText("");
                autorField.setText("");
                anoField.setText("");
                isbnField.setText("");
            } catch (NumberFormatException ex) {
                outputArea.append("Ano inválido. Insira um número inteiro.\n");
            }
        });

        listButton.addActionListener(e -> {
            outputArea.setText("");
            controller.listarLivros().forEach(livro -> outputArea.append(
                    "Título: " + livro.getTitulo() +
                            ", Autor: " + livro.getAutor() +
                            ", Ano: " + livro.getAno() +
                            ", ISBN: " + livro.getIsbn() + "\n"
            ));
        });

        panel.add(addButton);
        panel.add(listButton);


        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);


        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LivrosView().criarInterface());


    }
}

