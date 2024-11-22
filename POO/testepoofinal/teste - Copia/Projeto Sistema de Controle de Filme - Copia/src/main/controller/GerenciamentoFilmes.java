package main.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import main.App;
import main.model.Filme;
import main.model.Genero;

public class GerenciamentoFilmes {
    public static ArrayList<Filme> filmes = new ArrayList<>(); // Lista de filmes compartilhada

    public static void cadastrarFilme(String titulo, int anoLancamento, Genero genero) {
        Scanner teclado = new Scanner(System.in);
        
        try {
            System.out.print("Nome do filme: ");
            titulo = teclado.nextLine();

            System.out.print("Ano de lançamento: ");
            anoLancamento = teclado.nextInt();

            // Mostrar as opções de gênero
            System.out.print("\nEscolha o gênero:\n0-Ação\n1-Comédia\n2-Drama\n3-Fantasia\n4-Terror\n5-Suspense\n6-Romance\n7-Animação\nDigite o número correspondente ao gênero: ");
            int generoEscolhido = teclado.nextInt();

            // Verifica se o valor está dentro do intervalo
            if (generoEscolhido >= 0 && generoEscolhido < Genero.values().length) {
                genero = Genero.values()[generoEscolhido];
                System.out.println("Gênero escolhido: " + genero);
            } else {
                System.out.println("Opção de gênero inválida! Tente novamente.");
                cadastrarFilme(titulo, anoLancamento, genero);
                return; 
            }

            Filme novoFilme = new Filme(titulo, anoLancamento, genero); 
            filmes.add(novoFilme);
            System.out.println("\nFilme cadastrado com sucesso: " + titulo + " (" + anoLancamento + ")");
            App.dadosFilmes();

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira números onde solicitado.");
            teclado.nextLine(); 
            cadastrarFilme(titulo, anoLancamento, genero); // Recomeça o cadastro

        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            teclado.close(); 
        }
    }

    public static void editarFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("\nNenhum filme cadastrado.");
            App.dadosFilmes();
        } else {
            System.out.println("\n--- FILMES CADASTRADOS ---");
            for (Filme filme : filmes) {
                System.out.println("- " + filme.getTitulo() + " (" + filme.getAnoLancamento() + ")");
            }
            Scanner teclado = new Scanner(System.in);
            System.out.print("\nDigite o nome do filme que deseja editar: ");
            String nomeFilme = teclado.nextLine();
            // Procurar o filme na lista
            Filme filmeParaEditar = null;
            for (Filme filme : filmes) {
                if (filme.getTitulo().equalsIgnoreCase(nomeFilme)) {
                    filmeParaEditar = filme;
                    break;
                }
            } 
            if (filmeParaEditar != null) {
                // Editando informações
                System.out.print("Novo título do filme: ");
                String novoTitulo = teclado.nextLine();
                filmeParaEditar.setTitulo(novoTitulo);
    
                System.out.print("Novo ano de lançamento: ");
                int novoAnoLancamento = teclado.nextInt();
                filmeParaEditar.setAnoLancamento(novoAnoLancamento);

                System.out.print("\nEscolha o gênero:\n0-Ação\n1-Comédia\n2-Drama\n3-Fantasia\n4-Terror\n5-Suspense\n6-Romance\n7-Animação\nDigite o número correspondente ao gênero: ");
                int generoEscolhido = teclado.nextInt();

                if (generoEscolhido >= 0 && generoEscolhido < Genero.values().length) {
                    Genero novoGenero = Genero.values()[generoEscolhido];
                    System.out.println("Gênero escolhido: " + novoGenero);
                    filmeParaEditar.setGenero(novoGenero);
                } else {
                    System.out.println("Opção de gênero inválida!");
                    editarFilmes();
                }
                System.out.println("\nFilme atualizado com sucesso: " + novoTitulo + " (" + novoAnoLancamento + ")");
                App.dadosFilmes();
            } else {
                System.out.println("\nFilme não encontrado. Verifique o nome e tente novamente.");
                editarFilmes();
            }
        }
    }

    public static void removerFilme() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            cadastrarFilme(null, 0, null);
        } else {
            System.out.println("\n--- FILMES CADASTRADOS ---");
            for (Filme filme : filmes) {
                System.out.println("- " + filme.getTitulo() + " (" + filme.getAnoLancamento() + ")");
            }
            Scanner teclado = new Scanner(System.in);
            System.out.print("\nInforme o nome do filme a ser removido: ");
            String nome = teclado.nextLine();

            boolean removido = filmes.removeIf(filme -> filme.getTitulo().equalsIgnoreCase(nome)); // Remove o filme da lista com base no nome
            
            if (removido) {
                System.out.println("\nFilme: " + nome + " removido com sucesso!");
                App.dadosFilmes();
            } else {
                System.out.println("\nFilme: '"+ nome + "' não encontrado!");
                removerFilme();
            }
        }
    }

    public static void listarFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            App.menuUsuario();
        } else {
            System.out.println("\n--- FILMES CADASTRADOS ---");
            for (Filme filme : filmes) {
                System.out.println("- " + filme.getTitulo() + " (" + filme.getAnoLancamento() + ")");
            }
        }
        App.dadosFilmes();
    }

    public static void inicializarFilmes() {
        filmes.add(new Filme("Matrix", 1999, Genero.Fantasia));
        filmes.add(new Filme("O Poderoso Chefão", 1972, Genero.Drama));
        filmes.add(new Filme("Titanic", 1997, Genero.Romance));
        filmes.add(new Filme("Toy Story", 1995, Genero.Animação));
    }

    public static void main(String[] args) {
        inicializarFilmes();
    }
}