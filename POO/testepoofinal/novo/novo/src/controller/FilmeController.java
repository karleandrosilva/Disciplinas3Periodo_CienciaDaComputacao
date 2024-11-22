package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Filme;
import model.Genero;
import view.FilmeView;

public class FilmeController {
    private ArrayList<Filme> filmes = new ArrayList<>();
    private FilmeView view = new FilmeView();

    public FilmeController() {
        inicializarFilmes(); // Opcional, se quiser adicionar filmes predefinidos
    }

    public void inicializarFilmes() {
        filmes.add(new Filme("Matrix", 1999, Genero.Fantasia));
        filmes.add(new Filme("O Poderoso Chefão", 1972, Genero.Drama));
        filmes.add(new Filme("Titanic", 1997, Genero.Romance));
        filmes.add(new Filme("Toy Story", 1995, Genero.Animação));
    }

    public void cadastrarFilme(String titulo, int anoLancamento, Genero genero) {
        Filme novoFilme = new Filme(titulo, anoLancamento, genero);
        filmes.add(novoFilme);
        view.mostrarMensagem("Filme cadastrado com sucesso: " + titulo + " - (" + anoLancamento + ")");
    }

    public void editarFilme(String tituloAntigo) {
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(tituloAntigo)) {
                String novoTitulo = view.obterTitulo();
                int novoAnoLancamento = view.obterAnoLancamento();
                Genero novoGenero = view.obterGenero();

                filme.setTitulo(novoTitulo);
                filme.setAnoLancamento(novoAnoLancamento);
                filme.setGenero(novoGenero);

                view.mostrarMensagem("Filme atualizado com sucesso: " + novoTitulo);
                return;
            }
        }
        view.mostrarMensagem("Filme não encontrado.");
    }

    public void removerFilme(String titulo) {
        boolean removido = filmes.removeIf(filme -> filme.getTitulo().equalsIgnoreCase(titulo));
        if (removido) {
            view.mostrarMensagem("Filme: " + titulo + " removido com sucesso!");
        } else {
            view.mostrarMensagem("Filme: " + titulo + " não encontrado!");
        }
    }

    public void listarFilmes() {
        if (filmes.isEmpty()) {
            view.mostrarMensagem("Nenhum filme cadastrado.");
        } else {
            view.mostrarMensagem("\n--- FILMES CADASTRADOS ---");
            for (Filme filme : filmes) {
                view.exibirFilme(filme.getTitulo(), filme.getAnoLancamento());
            }
        }
    }

    public FilmeView getView() {
        return view;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        FilmeController controller = new FilmeController();

        System.out.println("\n--- MENU FILMES ---");
        System.out.print("[1] - Cadastrar Filmes\n"
                + "[2] - Listar Filmes\n"
                + "[3] - Editar Filmes\n"
                + "[4] - Excluir Filmes\n"
                + "[5] - Editar Perfil\n"
                + "[6] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();

        switch (opcao) {
            case 1:
                controller.cadastrarFilme(obterTitulo, );
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
        }

        
        // Coleta os dados da View
        String titulo = controller.getView().obterTitulo();
        int anoLancamento = controller.getView().obterAnoLancamento();
        Genero genero = controller.getView().obterGenero();
        
        
        // Exemplo de listar filmes após cadastro
        controller.listarFilmes();
    }
    
}
