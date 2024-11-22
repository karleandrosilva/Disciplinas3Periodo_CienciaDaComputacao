import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    private String nomeUsuario;
    private String senha;
    private static ArrayList<Filme> filmesFavoritos = new ArrayList<>();
    private static ArrayList<Ator> atoresFavoritos = new ArrayList<>();
    private static ArrayList<Diretor> diretoresFavoritos = new ArrayList<>();

    public Usuario(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static void buscarFilme(ArrayList<Filme> filmes, Scanner teclado) {
        System.out.print("Digite o nome do filme: ");
        String nomeFilme = teclado.nextLine();
        boolean encontrado = false;
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(nomeFilme)) {
                System.out.println("Filme encontrado: " + filme.getTitulo() + " (" + filme.getAnoLancamento() + ")");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Filme não encontrado.");
        }
        App.menuUsuario();
    }
    
    public static void buscarFilmePorGenero(ArrayList<Filme> filmes, Scanner teclado) {
        System.out.println("Escolha o gênero (0-Ação, 1-Comédia, 2-Drama, 3-Fantasia, 4-Terror, 5-Suspense, 6-Romance, 7-Animação): ");
        int generoEscolhido = teclado.nextInt();
        Genero genero = Genero.values()[generoEscolhido];
        boolean encontrado = false;
        for (Filme filme : filmes) {
            if (filme.getGenero() == genero) {
                System.out.println("Filme: " + filme.getTitulo() + " (" + filme.getAnoLancamento() + ")");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum filme encontrado para o gênero selecionado.");
        }
        App.menuUsuario();
    }

    public static void buscarFilmePorAno(ArrayList<Filme> filmes, Scanner teclado) {
        System.out.print("Digite o ano do filme: ");
        int ano = teclado.nextInt();
        boolean encontrado = false;
        for (Filme filme : filmes) {
            if (filme.getAnoLancamento() == ano) {
                System.out.println("Filme: " + filme.getTitulo() + " (" + filme.getAnoLancamento() + ")");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum filme encontrado para o ano selecionado.");
        }
        App.menuUsuario();
    }

    public static void buscarAtor(ArrayList<Ator> atores, Scanner teclado) {
        System.out.print("Digite o nome do ator: ");
        String nomeAtor = teclado.nextLine();
        boolean encontrado = false;
        for (Ator ator : atores) {
            if (ator.getNome().equalsIgnoreCase(nomeAtor)) {
                System.out.println("Ator encontrado: " + ator.getNome() + " - (" + ator.getDataNascimento() + ")");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Ator não encontrado.");
        }
        App.menuUsuario();
    }
    
    public static void buscarDiretor(ArrayList<Diretor> diretores, Scanner teclado) {
        System.out.print("Digite o nome do diretor: ");
        String nomeDiretor = teclado.nextLine();
        boolean encontrado = false;
        for (Diretor diretor : diretores) {
            if (diretor.getNome().equalsIgnoreCase(nomeDiretor)) {
                System.out.println("Diretor encontrado: " + diretor.getNome() + " - (" + diretor.getDataNascimento() + ")");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Diretor não encontrado.");
        }
        App.menuUsuario();
    }

    public static void adicionarFilmeFavorito(ArrayList<Filme> filmes) {
        System.out.println("\n--- FILMES CADASTRADOS ---");
            for (int i = 0; i < filmes.size(); i++) {
                Filme filme = filmes.get(i);
                System.out.println("[" + (i + 1) + "] - " + filme.getTitulo() + " (" + filme.getAnoLancamento() + ")");
            }
        System.out.print("\nDigite o número do Filme que deseja adicionar aos favoritos: ");
        Scanner teclado = new Scanner(System.in);
        int numeroFilme = teclado.nextInt();
        teclado.nextLine(); 
        
        if (numeroFilme > 0 && numeroFilme <= filmes.size()) { // Verifica se o número inserido está dentro do intervalo válido
            Filme filmeDesejado = filmes.get(numeroFilme - 1);
            if (filmesFavoritos.contains(filmeDesejado)) { 
                System.out.println("\nO filme já está nos favoritos.");
            } else {
                filmesFavoritos.add(filmeDesejado);
                System.out.println("\nFilme adicionado aos Favoritos!");
            }
        } else {
            System.out.println("Número inválido, tente novamente.");
            adicionarFilmeFavorito(filmes);
        }
        App.menuUsuario();
    }

    public static void adicionarAtorFavorito(ArrayList<Ator> atores) {
        System.out.println("\n--- ATORES CADASTRADOS ---");
            for (int i = 0; i < atores.size(); i++) {
                Ator ator = atores.get(i);
                System.out.println("[" + (i + 1) + "] - " + ator.getNome() + " (" + ator.getDataNascimento() + ")");
            }
        System.out.print("\nDigite o número do Ator que deseja adicionar aos favoritos: ");
        Scanner teclado = new Scanner(System.in);
        int numeroAtor = teclado.nextInt();
        teclado.nextLine(); 
        
        if (numeroAtor > 0 && numeroAtor <= atores.size()) { 
            Ator atorDesejado = atores.get(numeroAtor - 1);
            if (atoresFavoritos.contains(atorDesejado)) { 
                System.out.println("\nO diretor já está nos favoritos.");
            } else {
                atoresFavoritos.add(atorDesejado);
                System.out.println("\nAtor adicionado aos Favoritos!");
            }  
        } else {
            System.out.println("Número inválido, tente novamente.");
            adicionarAtorFavorito(atores);
        }
        App.menuUsuario();
    }

    public static void adicionarDiretorFavorito(ArrayList<Diretor> diretores) {
        System.out.println("\n--- DIRETORES CADASTRADOS ---");
            for (int i = 0; i < diretores.size(); i++) {
                Diretor diretor = diretores.get(i);
                System.out.println("[" + (i + 1) + "] - " + diretor.getNome() + " (" + diretor.getDataNascimento() + ")");
            }
        System.out.print("\nDigite o número do Diretor que deseja adicionar aos favoritos: ");
        Scanner teclado = new Scanner(System.in);
        int numeroDiretor = teclado.nextInt();
        teclado.nextLine(); 
        
        if (numeroDiretor > 0 && numeroDiretor <= diretores.size()) { 
            Diretor diretorDesejado = diretores.get(numeroDiretor - 1);
            if (diretoresFavoritos.contains(diretorDesejado)) { 
                System.out.println("\nO diretor já está nos favoritos.");
            } else {
                diretoresFavoritos.add(diretorDesejado);
                System.out.println("\nDiretor adicionado aos Favoritos!");
            }
        } else {
            System.out.println("Número inválido, tente novamente.");
            adicionarDiretorFavorito(diretores);
        }
        App.menuUsuario();
    }

    static void verFilmesFavoritos(ArrayList<Filme> filmes) {
        if (filmesFavoritos.isEmpty()) {
            System.out.println("\nVocê não tem filmes favoritos."); 
        } else {
            System.out.println("\n--- FILMES FAVORITOS ---");
            for (Filme filme : filmesFavoritos) {
                System.out.println("- " + filme.getTitulo() + " (" + filme.getAnoLancamento() + ")");
            }
        }
        App.menuUsuario();
    }

    public static void verAtoresFavoritos(ArrayList<Ator> atores) {
        if (atoresFavoritos.isEmpty()) {
            System.out.println("\nVocê não tem atores favoritos."); 
        } else {
            System.out.println("\n--- ATORES FAVORITOS ---");
            for (Ator ator : atoresFavoritos) {
                System.out.println("- " + ator.getNome() + " (" + ator.getDataNascimento() + ")");
            }
        }
        App.menuUsuario();
    }

    public static void verDiretoresFavoritos(ArrayList<Diretor> diretores) {
        if (diretoresFavoritos.isEmpty()) {
            System.out.println("\nVocê não tem diretores favoritos."); 
        } else {
            System.out.println("\n--- DIRETORES FAVORITOS ---");
            for (Diretor diretor : diretoresFavoritos) {
                System.out.println("- " + diretor.getNome() + " (" + diretor.getDataNascimento() + ")");
            }
        }
        App.menuUsuario();
    }

    public static void removerFilmeFavorito(ArrayList<Filme> filmes) {
        if (filmesFavoritos.isEmpty()) {
            System.out.println("\nVocê não tem filmes favoritos para remover.");
            App.menuUsuario(); 
        }
        System.out.println("\n--- FILMES FAVORITOS ---");
        for (int i = 0; i < filmesFavoritos.size(); i++) {
            Filme filme = filmesFavoritos.get(i);
            System.out.println("[" + (i + 1) + "] - " + filme.getTitulo() + " (" + filme.getAnoLancamento() + ")");
        }
        System.out.print("\nDigite o número do Filme que deseja remover dos favoritos: ");
        Scanner teclado = new Scanner(System.in);
        int numeroFilme = teclado.nextInt();
        teclado.nextLine();
    
        if (numeroFilme > 0 && numeroFilme <= filmesFavoritos.size()) {
            Filme filmeDesejado = filmesFavoritos.get(numeroFilme - 1);
            filmesFavoritos.remove(filmeDesejado);
            System.out.println("\nFilme removido dos Favoritos!");
        } else {
            System.out.println("Número inválido, tente novamente.");
            removerFilmeFavorito(filmesFavoritos); 
        }
        App.menuUsuario();
    }

    public static void removerAtorFavorito(ArrayList<Ator> atores) {
        if (atoresFavoritos.isEmpty()) {
            System.out.println("\nVocê não tem atores favoritos para remover.");
            App.menuUsuario(); 
        }
        System.out.println("\n--- ATORES FAVORITOS ---");
        for (int i = 0; i < atoresFavoritos.size(); i++) {
            Ator ator = atoresFavoritos.get(i);
            System.out.println("[" + (i + 1) + "] - " + ator.getNome() + " (" + ator.getDataNascimento() + ")");
        }
        System.out.print("\nDigite o número do Ator que deseja remover dos favoritos: ");
        Scanner teclado = new Scanner(System.in);
        int numeroAtor = teclado.nextInt();
        teclado.nextLine();
        if (numeroAtor > 0 && numeroAtor <= atoresFavoritos.size()) {
            Ator atorDesejado = atoresFavoritos.get(numeroAtor - 1);
            atoresFavoritos.remove(atorDesejado);
            System.out.println("\nAtor removido dos Favoritos!");
        } else {
            System.out.println("Número inválido, tente novamente.");
            removerAtorFavorito(atoresFavoritos); 
        }
        App.menuUsuario(); 
    }

    public static void removerDiretorFavorito(ArrayList<Diretor> diretores) {
        if (diretoresFavoritos.isEmpty()) {
            System.out.println("\nVocê não tem diretores favoritos para remover.");
            App.menuUsuario(); 
        }
        System.out.println("\n--- DIRETORES FAVORITOS ---");
        for (int i = 0; i < diretoresFavoritos.size(); i++) {
            Diretor diretor = diretoresFavoritos.get(i);
            System.out.println("[" + (i + 1) + "] - " + diretor.getNome() + " (" + diretor.getDataNascimento() + ")");
        }
        System.out.print("\nDigite o número do Diretor que deseja remover dos favoritos: ");
        Scanner teclado = new Scanner(System.in);
        int numeroDiretor = teclado.nextInt();
        teclado.nextLine();
        if (numeroDiretor > 0 && numeroDiretor <= diretoresFavoritos.size()) {
            Diretor diretorDesejado = diretoresFavoritos.get(numeroDiretor - 1);
            diretoresFavoritos.remove(diretorDesejado);
            System.out.println("\nDiretor removido dos Favoritos!");
        } else {
            System.out.println("Número inválido, tente novamente.");
            removerDiretorFavorito(diretoresFavoritos); 
        }
        App.menuUsuario();
    }
}