package main.controller;

import main.App;
import main.model.Ator;

import java.util.ArrayList;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class GerenciamentoAtores {
    private static ArrayList<Ator> atores = new ArrayList<Ator>();
    public static ArrayList<Ator> atoresFavoritos = new ArrayList<>();
    
    public static void cadastrarAtor(String nome, String dataNascimento) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Nome do Ator: ");
        nome = teclado.nextLine();

        System.out.print("Data de nascimento (dd/MM/yyyy): "); // tratatamento de excessão
        dataNascimento = teclado.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate data = LocalDate.parse(dataNascimento, formatter);
            System.out.println("Data válida: " + data);
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida. Por favor, use o formato dd/MM/yyyy."); 
            cadastrarAtor(null, null);
        }

        Ator novoAtor = new Ator(nome, dataNascimento);
        atores.add(novoAtor);
        System.out.println("\nAtor cadastrado com sucesso: " + nome + " - (" + dataNascimento + ")");
        App.dadosAtores();
    }


    public static void editarAtor() {
        if (atores.isEmpty()) {
            System.out.println("\nNenhum ator cadastrado.");
            cadastrarAtor(null, null);
        } else {
            Scanner teclado = new Scanner(System.in);
            listarAtores(); 
            System.out.print("\nDigite o nome do ator que deseja editar: ");
            String nomeAtor = teclado.nextLine();
    
            Ator atorParaEditar = null;
            for (Ator ator : atores) {
                if (ator.getNome().equalsIgnoreCase(nomeAtor)) {
                    atorParaEditar = ator;
                    break; 
                }
            }

            if (atorParaEditar != null) {
                System.out.print("Novo nome do ator: ");
                String novoNome = teclado.nextLine();
                atorParaEditar.setNome(novoNome);

                System.out.print("Nova data de nascimento (dd/MM/yyyy): ");
                String novaDataNascimento = teclado.nextLine();
                atorParaEditar.setDataNascimento(novaDataNascimento);

                System.out.println("\nAtor atualizado com sucesso: " + novoNome + " - (" + novaDataNascimento + ")");
                App.dadosAtores();
            } else {
                System.out.println("\nAtor não encontrado. Verifique o nome e tente novamente.");
                editarAtor();
            }
        } 
    }

    public static void removerAtor() {
        if (atores.isEmpty()) {
            System.out.println("\nNenhum ator cadastrado.");
            cadastrarAtor(null, null);
        } else {
            Scanner teclado = new Scanner(System.in);
            listarAtores(); 
            System.out.print("\nDigite o nome do ator que deseja remover: ");
            String nomeAtor = teclado.nextLine();

            boolean removido = atores.removeIf(ator -> ator.getNome().equalsIgnoreCase(nomeAtor));

            if (removido) {
                System.out.println("\nAtor removido com sucesso: " + nomeAtor);
                App.dadosAtores();
            } else {
                System.out.println("\nAtor não encontrado. Verifique o nome e tente novamente.");
                removerAtor();
            }
        }
    }
    
    public static void listarAtores() {
        if (atores.isEmpty()) {
            System.out.println("\nNenhum ator cadastrado.");
        } else {
            System.out.println("\n--- ATORES CADASTRADOS ---");
            for (Ator ator : atores) {
                System.out.println("- " + ator.getNome() + " - (" + ator.getDataNascimento() + ")");
            }
        }
        App.dadosAtores();
    }

    public static void adicionarAtorFavorito() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n--- ATORES CADASTRADOS ---");
        for (Ator ator : atores) {
            System.out.println(ator.getNome());
        }

        System.out.print("\nDigite o nome do Ator que deseja adicionar aos favoritos: ");
        String nomeAtor = teclado.nextLine();
        Ator atorDesejado = buscarAtorPorNome(atores, nomeAtor);

        if (atorDesejado != null) {
            if (atoresFavoritos.contains(atorDesejado)) {
                System.out.println("\nO ator já está nos favoritos.");
                App.dadosFavoritos();
            } else {
                atoresFavoritos.add(atorDesejado);
                System.out.println("\nAtor adicionado aos Favoritos!");
                App.dadosFavoritos();
            }
        } else {
            System.out.println("Ator não encontrado, tente novamente.");
            adicionarAtorFavorito();
        }
    }

    public static void removerAtorFavorito() {
        Scanner teclado = new Scanner(System.in);
    
        if (atoresFavoritos.isEmpty()) {
            System.out.println("\nNão há atores nos favoritos.");
            return;
        }
    
        System.out.println("\n--- ATORES FAVORITOS ---");
        for (Ator ator : atoresFavoritos) {
            System.out.println(ator.getNome());
        }
    
        System.out.print("\nDigite o nome do Ator que deseja remover dos favoritos: ");
        String nomeAtor = teclado.nextLine();
        Ator atorRemover = buscarAtorPorNome(atoresFavoritos, nomeAtor);
    
        if (atorRemover != null) {
            atoresFavoritos.remove(atorRemover);
            System.out.println("\nAtor removido dos favoritos com sucesso!");
            App.dadosFavoritos();
        } else {
            System.out.println("Ator não encontrado nos favoritos, tente novamente.");
            removerAtorFavorito();
        }
    }
    
    public static Ator buscarAtorPorNome(ArrayList<Ator> atores, String nome) {
        for (Ator ator : atores) {
            if (ator.getNome().equalsIgnoreCase(nome)) {
                return ator;
            }
        }
        return null;
    }

    public static void listarAtoresFavoritos() {
        if (atoresFavoritos.isEmpty()) {
            System.out.println("\nNão há atores nos favoritos.");
        } else {
            System.out.println("\n--- ATORES FAVORITOS ---");
            for (Ator ator : atoresFavoritos) {
                System.out.println(ator.getNome() + " - Data de Nascimento: " + ator.getDataNascimento());
            }
        }
    }
    
    public static void main(String[] args) { 
    }
}