package main.controller;

import main.App;
import main.model.Ator;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoAtores {
    private static ArrayList<Ator> atores = new ArrayList<Ator>();
    
    public static void cadastrarAtor(String nome, String dataNascimento) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Nome do Ator: ");
        nome = teclado.nextLine();

        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        dataNascimento = teclado.nextLine();

        teclado.close();
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
    
    public static void main(String[] args) {
        
    }
}