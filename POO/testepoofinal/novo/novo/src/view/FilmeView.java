package view;

import java.util.Scanner;
import model.Genero;

public class FilmeView {
    private Scanner teclado = new Scanner(System.in);

    public String obterTitulo() {
        System.out.print("Nome do filme: ");
        return teclado.nextLine();
    }

    public int obterAnoLancamento() {
        System.out.print("Ano de lançamento: ");
        return teclado.nextInt();
    }

    public Genero obterGenero() {
        System.out.print("Escolha o gênero:\n0-Ação\n1-Comédia\n2-Drama\n3-Fantasia\n4-Terror\n5-Suspense\n6-Romance\n7-Animação\nDigite o número correspondente ao gênero: ");
        int generoEscolhido = teclado.nextInt();
        teclado.nextLine(); // Limpa o buffer

        if (generoEscolhido >= 0 && generoEscolhido < Genero.values().length) {
            return Genero.values()[generoEscolhido];
        } else {
            System.out.println("Opção de gênero inválida!");
            return obterGenero();
        }
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirFilme(String titulo, int ano) {
        System.out.println("Filme: " + titulo + " - (" + ano + ")");
    }
}

