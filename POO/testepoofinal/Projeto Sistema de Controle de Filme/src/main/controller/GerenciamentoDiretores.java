package main.controller;

import main.App;
import main.model.Diretor;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class GerenciamentoDiretores {
    private static ArrayList<Diretor> diretores = new ArrayList<Diretor>();
    public static ArrayList<Diretor> diretoresFavoritos = new ArrayList<>();

    public static void cadastrarDiretor(String nome, String dataNascimento) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Nome do Diretor: ");
        nome = teclado.nextLine();

        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        dataNascimento = teclado.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate data = LocalDate.parse(dataNascimento, formatter);
            System.out.println("Data válida: " + data);
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida. Por favor, use o formato dd/MM/yyyy."); 
            cadastrarDiretor(null, null);
        }

        Diretor novoDiretor = new Diretor(nome, dataNascimento);
        diretores.add(novoDiretor);
        System.out.println("\nDiretor cadastrado com sucesso: " + nome + " - (" + dataNascimento + ")");
        App.dadosDiretores();
    }

    public static void editarDiretor() {
        if (diretores.isEmpty()) {
            System.out.println("\nNenhum diretor cadastrado.");
            cadastrarDiretor(null, null);
        } else {
            Scanner teclado = new Scanner(System.in);
            listarDiretores(); 
            System.out.print("\nDigite o nome do diretor que deseja editar: ");
            String nomeDiretor = teclado.nextLine();
    
            Diretor diretorParaEditar = null;
            for (Diretor diretor : diretores) {
                if (diretor.getNome().equalsIgnoreCase(nomeDiretor)) {
                    diretorParaEditar = diretor;
                    break; 
                }
            }

            if (diretorParaEditar != null) {
                System.out.print("Novo nome do diretor: ");
                String novoNome = teclado.nextLine();
                diretorParaEditar.setNome(novoNome);

                System.out.print("Nova data de nascimento (dd/MM/yyyy): ");
                String novaDataNascimento = teclado.nextLine();
                diretorParaEditar.setDataNascimento(novaDataNascimento);

                System.out.println("\nDiretor atualizado com sucesso: " + novoNome + " - (" + novaDataNascimento + ")");
                App.dadosDiretores();
            } else {
                System.out.println("\nDiretor não encontrado. Verifique o nome e tente novamente.");
                editarDiretor();
            }
        } 
    }

    public static void removerDiretor() {
        if (diretores.isEmpty()) {
            System.out.println("\nNenhum diretor cadastrado.");
            cadastrarDiretor(null, null);
        } else {
            Scanner teclado = new Scanner(System.in);
            listarDiretores(); 
            System.out.print("\nDigite o nome do diretor que deseja remover: ");
            String nomeDiretor = teclado.nextLine();

            boolean removido = diretores.removeIf(diretor -> diretor.getNome().equalsIgnoreCase(nomeDiretor));

            if (removido) {
                System.out.println("\nDiretor removido com sucesso: " + nomeDiretor);
                App.dadosDiretores();
            } else {
                System.out.println("\nDiretor não encontrado. Verifique o nome e tente novamente.");
                removerDiretor();
            }
        }
    }
    
    public static void listarDiretores() {
        if (diretores.isEmpty()) {
            System.out.println("\nNenhum diretor cadastrado.");
        } else {
            System.out.println("\n--- DIRETORES CADASTRADOS ---");
            for (Diretor diretor : diretores) {
                System.out.println("- " + diretor.getNome() + " - (" + diretor.getDataNascimento() + ")");
            }
        }
        App.dadosDiretores();
    }
    
    public static void adicionarDiretorFavorito() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n--- DIRETORES CADASTRADOS ---");
        for (Diretor diretor : diretores) {
            System.out.println(diretor.getNome());
        }

        System.out.print("\nDigite o nome do Diretor que deseja adicionar aos favoritos: ");
        String nomeDiretor = teclado.nextLine();
        Diretor diretorDesejado = buscarDiretorPorNome(diretores, nomeDiretor);

        if (diretorDesejado != null) {
            if (diretoresFavoritos.contains(diretorDesejado)) {
                System.out.println("\nO diretor já está nos favoritos.");
                App.dadosFavoritos();
            } else {
                diretoresFavoritos.add(diretorDesejado);
                System.out.println("\nDiretor adicionado aos Favoritos!");
                App.dadosFavoritos();
            }
        } else {
            System.out.println("Diretor não encontrado, tente novamente.");
            adicionarDiretorFavorito();
        }
    }

    public static void removerDiretorFavorito() {
        Scanner teclado = new Scanner(System.in);
    
        if (diretoresFavoritos.isEmpty()) {
            System.out.println("\nNão há diretores nos favoritos.");
            return;
        }
    
        System.out.println("\n--- DIRETORES FAVORITOS ---");
        for (Diretor diretor : diretoresFavoritos) {
            System.out.println(diretor.getNome());
        }
    
        System.out.print("\nDigite o nome do Diretor que deseja remover dos favoritos: ");
        String nomeDiretor = teclado.nextLine();
        Diretor diretorRemover = buscarDiretorPorNome(diretoresFavoritos, nomeDiretor);
    
        if (diretorRemover != null) {
            diretoresFavoritos.remove(diretorRemover);
            System.out.println("\nDiretor removido dos favoritos com sucesso!");
            App.dadosFavoritos();
        } else {
            System.out.println("Diretor não encontrado nos favoritos, tente novamente.");
            removerDiretorFavorito();
        }
    }
    
    public static Diretor buscarDiretorPorNome(ArrayList<Diretor> diretores, String nome) {
        for (Diretor diretor : diretores) {
            if (diretor.getNome().equalsIgnoreCase(nome)) {
                return diretor;
            }
        }
        return null;
    }

    public static void listarDiretoresFavoritos() {
        if (diretoresFavoritos.isEmpty()) {
            System.out.println("\nNão há diretores nos favoritos.");
        } else {
            System.out.println("\n--- DIRETORES FAVORITOS ---");
            for (Diretor diretor : diretoresFavoritos) {
                System.out.println(diretor.getNome() + " - Data de Nascimento: " + diretor.getDataNascimento());
            }
        }
    }
    
    public static void main(String[] args) {
    }
}