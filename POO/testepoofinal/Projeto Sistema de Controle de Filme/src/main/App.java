package main;

import java.util.ArrayList;
import java.util.Scanner;
import main.controller.GerenciamentoAtores;
import main.controller.GerenciamentoDiretores;
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
        System.out.print("[1] - Favoritar Dados\n"
                + "[2] - Remover Favoritos\n"
                + "[3] - Listar Favoritos\n"  
                + "[4] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1:
                favoritar();
                break;
            case 2:
                removerFavoritos();
            case 3:
                listarFavoritos();
                break;
            case 4:
                menuUsuario();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                menuUsuario();
        }
    }

    public static void favoritar() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n--- FAVORITAR ---");
        System.out.print("[1] - Favoritar Filme\n"
                + "[2] - Favoritar Ator\n"
                + "[3] - Favoritar Diretor\n"  
                + "[4] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1:
                GerenciamentoFilmes.adicionarFilmeFavorito();
                break;
            case 2:
                GerenciamentoAtores.adicionarAtorFavorito();
                break;
            case 3:
                GerenciamentoDiretores.adicionarDiretorFavorito();
                break;
            case 4:
                menuUsuario();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                menuUsuario();
        }
    }

    public static void removerFavoritos() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n--- REMOVER FAVORITOS ---");
        System.out.print("[1] - Remover Filme Favorito\n"
                + "[2] - Remover Ator Favorito\n"
                + "[3] - Remover Diretor Favorito\n"  
                + "[4] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1:
                GerenciamentoFilmes.removerFilmeFavorito();
                break;
            case 2:
                GerenciamentoAtores.removerAtorFavorito();
                break;
            case 3:
                GerenciamentoDiretores.removerDiretorFavorito();
                break;
            case 4:
                menuUsuario();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                menuUsuario();
        }
    }

    public static void listarFavoritos() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n--- LISTAR FAVORITOS ---");
        System.out.print("[1] - Listar filmes\n"
                + "[2] - Listar Ator\n"
                + "[3] - Listar Diretor\n"  
                + "[4] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1:
                GerenciamentoFilmes.listarFilmesFavoritos();
                break;
            case 2:
                GerenciamentoAtores.listarAtoresFavoritos();
                break;
            case 3:
                GerenciamentoDiretores.listarDiretoresFavoritos();
                break;
            case 4:
                menuUsuario();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                menuUsuario();
        }
    }
}