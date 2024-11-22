package main.controller;

import main.App;
import main.model.Diretor;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoDiretores {
    private static ArrayList<Diretor> diretores = new ArrayList<Diretor>();

    public static void cadastrarDiretor(String nome, String dataNascimento) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Nome do Diretor: ");
        nome = teclado.nextLine();

        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        dataNascimento = teclado.nextLine();

        Diretor novoDiretor = new Diretor(nome, dataNascimento);
        diretores.add(novoDiretor);
        System.out.println("\nDiretor cadastrado com sucesso: " + nome + " - (" + dataNascimento + ")");
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
    
    public static void main(String[] args) {
    }
}