package main;

import java.util.ArrayList;
import java.util.Scanner;
import main.controller.GerenciamentoAtores;
import main.controller.GerenciamentoDiretores;
import main.controller.GerenciamentoFavoritos;
import main.controller.GerenciamentoFilmes;
import main.controller.GerenciamentoUsuario;
import main.model.Ator;
import main.model.Diretor;
import main.model.Filme;

public class App {
    static ArrayList<Filme> filmes = new ArrayList<>();
    static ArrayList<Ator> atores = new ArrayList<>();
    static ArrayList<Diretor> diretores = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        GerenciamentoFilmes.inicializarFilmes();
        
        telaLogin();

        //GerenciamentoFilmes gerenciamentoFilme = new GerenciamentoFilmes();
        //gerenciamentoFilme.cadastrarFilme(null, 0, null);
        //GerenciamentoFilmes.cadastrarFilme(null, 0, null);
    }

    static void telaLogin() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("\nSEJA BEM VINDO! AO SISTEMA DE CONTROLE DE FILMES");
        System.out.print("\nEscolha uma das opções abaixo:\n"
                    + "[1] - CRIAR CADASTRO\n"
                    + "[2] - FAZER LOGIN\nRESPOSTA: "); 

        int opcao = teclado.nextInt();
        teclado.nextLine();

        while (opcao > 2) { 
            if (opcao == 2 || opcao == 1) {
                break;
            } else {
                System.out.print("OPÇÃO INVALIDA!\n" 
                    + "[1] - CRIAR CADASTRO\n" 
                    + "[2] - FAZER LOGIN\nRESPOSTA: "); 
                opcao = teclado.nextInt();
                teclado.nextLine();
            } 
        }
        processarOpcao(opcao);
    }

    static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                GerenciamentoUsuario.cadastro();
                break;
            case 2:
                GerenciamentoUsuario.login();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
        }
    }

    public static void menuUsuario() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n--- MENU ---");
        System.out.print("[1] - Filmes\n"
                + "[2] - Atores\n"
                + "[3] - Diretores\n"
                + "[4] - Favoritos\n"
                + "[5] - Editar Perfil\n"
                + "[6] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1:
                dadosFilmes();
                break;
            case 2:
                dadosAtores();
                break;
            case 3:
                dadosDiretores();
                break;
            case 4:
                dadosFavoritos();
                break;
            case 5:
                GerenciamentoUsuario.editarPerfil();
                break;
            case 6:
                telaLogin();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                menuUsuario();
        }
    }

    public static void dadosFilmes() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n--- DADOS FILMES ---");
        System.out.print("[1] - Cadastrar Filme\n"
                + "[2] - Editar Filme\n"
                + "[3] - Remover Filme\n"  
                + "[4] - Listar Filme\n"
                + "[5] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1:
                GerenciamentoFilmes.cadastrarFilme(null, 0, null);
                break;
            case 2:
                GerenciamentoFilmes.editarFilmes();
                break;
            case 3:
                GerenciamentoFilmes.removerFilme();
                break;
            case 4:
                GerenciamentoFilmes.listarFilmes();
                break;
            case 5:
                menuUsuario();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                menuUsuario();
        }
    }

    public static void dadosAtores() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n--- DADOS ATORES ---");
        System.out.print("[1] - Cadastrar Ator\n"
                + "[2] - Editar Ator\n"
                + "[3] - Remover Ator\n"  
                + "[4] - Listar Atores\n"
                + "[5] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1:
                GerenciamentoAtores.cadastrarAtor(null, null);
                break;
            case 2:
                GerenciamentoAtores.editarAtor();
                break;
            case 3:
                GerenciamentoAtores.removerAtor();
            case 4:
                GerenciamentoAtores.listarAtores();
                break;
            case 5:
                menuUsuario();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                menuUsuario();
        }
    }

    public static void dadosDiretores() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n--- DADOS DIRETORES ---");
        System.out.print("[1] - Cadastrar Diretor\n"
                + "[2] - Editar Diretor\n"
                + "[3] - Remover Diretor\n"  
                + "[4] - Listar Diretores\n"
                + "[5] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1:
                GerenciamentoDiretores.cadastrarDiretor(null, null);
                break;
            case 2:
                GerenciamentoDiretores.editarDiretor();
                break;
            case 3:
                GerenciamentoDiretores.removerDiretor();
            case 4:
                GerenciamentoDiretores.listarDiretores();
                break;
            case 5:
                menuUsuario();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                menuUsuario();
        }
    }

    public static void dadosFavoritos() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n--- DADOS FAVORITOS ---");
        System.out.print("[1] - Favoritar Filme\n"
                + "[2] - Editar Diretor\n"
                + "[3] - Remover Diretor\n"  
                + "[4] - Listar Diretores\n"
                + "[5] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1:
                GerenciamentoFavoritos.adicionarFilmeFavorito();
                break;
            case 2:
                
                break;
            case 3:
                GerenciamentoDiretores.removerDiretor();
            case 4:
                GerenciamentoDiretores.listarDiretores();
                break;
            case 5:
                menuUsuario();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                menuUsuario();
        }
    }
}