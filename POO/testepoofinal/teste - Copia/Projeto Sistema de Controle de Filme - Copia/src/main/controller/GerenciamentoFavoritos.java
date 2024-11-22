package main.controller;

import java.util.ArrayList;
import java.util.Scanner;
import main.model.Ator;
import main.model.Diretor;
import main.model.Filme;

public class GerenciamentoFavoritos {
    public static ArrayList<Filme> filmes = new ArrayList<>();
    public static ArrayList<Filme> filmesFavoritos = new ArrayList<>();
    public static ArrayList<Ator> atoresFavoritos = new ArrayList<>();
    public static ArrayList<Diretor> diretoresFavoritos = new ArrayList<>();

    public static void adicionarFilmeFavorito() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n--- FILMES CADASTRADOS ---");
        for (Filme filme : filmes) {
            System.out.println(filme.getTitulo() + " - (" + filme.getAnoLancamento() + ")");
        }

        System.out.print("\nDigite o nome do Filme que deseja adicionar aos favoritos: ");
        String nomeFilme = teclado.nextLine();
        Filme filmeDesejado = buscarFilmePorTitulo(filmes, nomeFilme);

        if (filmeDesejado != null) {
            if (filmesFavoritos.contains(filmeDesejado)) {
                System.out.println("\nO filme já está nos favoritos.");
            } else {
                filmesFavoritos.add(filmeDesejado);
                System.out.println("\nFilme adicionado aos Favoritos!");
            }
        } else {
            System.out.println("Filme não encontrado, tente novamente.");
            adicionarFilmeFavorito(); 
        }
    }

    public static Filme buscarFilmePorTitulo(ArrayList<Filme> filmes, String titulo) {
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                return filme; // Retorna o filme encontrado
            }
        }
        return null; // Retorna null se não encontrar
    } 
    
    public static void main(String[] args) {
        adicionarFilmeFavorito();
    } 
}
