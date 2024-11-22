package SistemaControleFilmes;

import java.util.*;
import java.util.stream.Collectors;

// Classe Diretor
class Diretor {
    private String nome;
    @SuppressWarnings("unused")
    private String dataNascimento;
    private boolean favorito;

    public Diretor(String nome, String dataNascimento, boolean favorito) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.favorito = favorito;
    }

    public String getNome() {
        return nome;
    }

    public boolean isFavorito() {
        return favorito;
    }
}

// Classe Ator
class Ator {
    private String nome;
    @SuppressWarnings("unused")
    private String dataNascimento;
    private boolean favorito;

    public Ator(String nome, String dataNascimento, boolean favorito) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.favorito = favorito;
    }

    public String getNome() {
        return nome;
    }

    public boolean isFavorito() {
        return favorito;
    }
}

// Enum Gênero
enum Genero {
    Acao, Comedia, Drama, Fantasia, Terror, Suspense, Romance, Animacao;
}

// Classe Filme
class Filme {
    private String titulo;
    @SuppressWarnings("unused")
    private int duracao;
    private int anoLancamento;
    private Genero genero;
    private Diretor diretor;
    private List<Ator> elenco;

    public Filme(String titulo, int duracao, int anoLancamento, Genero genero, Diretor diretor, List<Ator> elenco) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.diretor = diretor;
        this.elenco = elenco;
    }

    public Genero getGenero() {
        return genero;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public List<Ator> getElenco() {
        return elenco;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDetalhes() {
        return "Título: " + titulo + ", Diretor: " + diretor.getNome() + ", Gênero: " + genero + ", Ano: " + anoLancamento;
    }
}

// Classe SistemaControleFilmes
public class SistemaControleFilmes {

    private static List<Filme> filmes = new ArrayList<>();
    private static List<Diretor> diretores = new ArrayList<>();
    private static List<Ator> atores = new ArrayList<>();

    public static void main(String[] args) {
        adicionarFilmesIniciais();
        menu();
    }

    public static void adicionarFilmesIniciais() {
        Diretor diretor1 = new Diretor("Christopher Nolan", "30/07/1970", true);
        Diretor diretor2 = new Diretor("Steven Spielberg", "18/12/1946", true);
        Diretor diretor3 = new Diretor("Quentin Tarantino", "27/03/1963", false);
        Diretor diretor4 = new Diretor("James Cameron", "16/08/1954", false);
        Diretor diretor5 = new Diretor("Martin Scorsese", "17/11/1942", true);
        Diretor diretor6 = new Diretor("Wes Craven", "02/08/1939", true);
        Diretor diretor7 = new Diretor("Francis Ford Coppola", "07/04/1939", true);
        Diretor diretor8 = new Diretor("Greta Gerwig", null, false);

        diretores.addAll(Arrays.asList(diretor1, diretor2, diretor3, diretor4, diretor5, diretor6, diretor7, diretor8));

        Ator ator1 = new Ator("Leonardo DiCaprio", "11/11/1974", true);
        Ator ator2 = new Ator("Tom Hanks", "09/07/1956", false);
        Ator ator3 = new Ator("Samuel L. Jackson", "21/12/1948", false);
        Ator ator4 = new Ator("Arnold Schwarzenegger", "30/07/1947", false);
        Ator ator5 = new Ator("Robert De Niro", "17/08/1943", true);
        Ator ator6 = new Ator("Neve Campbell", "03/10/1973", true);
        Ator ator7 = new Ator("Margot Robbie", "02/07/1990", true);
        Ator ator8 = new Ator("Brad Pitt", "18/12/1963", true);

        atores.addAll(Arrays.asList(ator1, ator2, ator3, ator4, ator5, ator6, ator7, ator8));

        filmes.add(new Filme("Inception", 148, 2010, Genero.Acao, diretor1, Arrays.asList(ator1)));
        filmes.add(new Filme("Jurassic Park", 127, 1993, Genero.Fantasia, diretor2, Arrays.asList(ator2)));
        filmes.add(new Filme("Pulp Fiction: Tempo de Violência", 154, 1994, Genero.Drama, diretor3, Arrays.asList(ator3)));
        filmes.add(new Filme("Exterminador 2 do Futuro II: Juízo Final", 137, 1991, Genero.Acao, diretor4, Arrays.asList(ator4)));
        filmes.add(new Filme("Taxi Driver: Motorista de Táxi", 114, 1976, Genero.Drama, diretor5, Arrays.asList(ator5)));
        filmes.add(new Filme("Pânico", 110, 1996, Genero.Terror, diretor6, Arrays.asList(ator6)));
        filmes.add(new Filme("Django Livre", 165, 2010, Genero.Acao, diretor3, Arrays.asList(ator1)));
        filmes.add(new Filme("Era Uma Vez Em HollyWood", 162, 2019, Genero.Drama, diretor3, Arrays.asList(ator1, ator7, ator8)));
        filmes.add(new Filme("Bastardos Inglórios", 165, 2009, Genero.Acao, diretor3, Arrays.asList(ator8)));
        
    }

    public static void menu() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n----- Sistema de Controle de Filmes -----");
            System.out.println("1. Adicionar Filme");
            System.out.println("2. Filtrar Filmes por Gênero");
            System.out.println("3. Listar Diretores Favoritos");
            System.out.println("4. Listar Atores Favoritos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarFilme();
                    break;
                case 2:
                    filtrarPorGenero();
                    break;
                case 3:
                    listarDiretoresFavoritos();
                    break;
                case 4:
                    listarAtoresFavoritos();
                    break;
                case 5:
                    System.out.println("Encerrando o sistema...");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    public static void adicionarFilme() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o título do filme: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite a duração do filme (em minutos): ");
        int duracao = scanner.nextInt();

        System.out.print("Digite o ano de lançamento: ");
        int anoLancamento = scanner.nextInt();

        System.out.print("Escolha o gênero (0-Ação, 1-Comédia, 2-Drama, 3-Fantasia, 4-Terror, 5-Suspense, 6-Romance, 7-Animação): ");
        int generoEscolhido = scanner.nextInt();
        Genero genero = Genero.values()[generoEscolhido];

        System.out.println("Escolha o diretor (ou digite 00 para adicionar um novo diretor):");
        for (int i = 0; i < diretores.size(); i++) {
            System.out.println(i + ". " + diretores.get(i).getNome());
        }
        int diretorEscolhido = scanner.nextInt();
        Diretor diretor;System.out.println("Escolha os atores (digite 00 para adicionar um novo ator, -1 para finalizar):");

        if (diretorEscolhido == 00) {
            System.out.print("Digite o nome do novo diretor: ");
            scanner.nextLine();  // Consumir a nova linha
            String nomeDiretor = scanner.nextLine();

            System.out.print("Digite a data de nascimento do diretor: ");
            String dataNascimentoDiretor = scanner.nextLine();

            System.out.print("O diretor é um favorito? (true/false): ");
            boolean favoritoDiretor = scanner.nextBoolean();

            diretor = new Diretor(nomeDiretor, dataNascimentoDiretor, favoritoDiretor);
            diretores.add(diretor);
            System.out.println("Diretor " + nomeDiretor + " adicionado com sucesso!");
        } else {
            diretor = diretores.get(diretorEscolhido);
        }

        List<Ator> elenco = new ArrayList<>();
        
        for (int i = 0; i < atores.size(); i++) {
            System.out.println(i + ". " + atores.get(i).getNome());
        }

        while (true) {
            int atorEscolhido = scanner.nextInt();
            if (atorEscolhido == -1) break;

            if (atorEscolhido == 00) {
                scanner.nextLine(); // Consumir a nova linha
                System.out.print("Digite o nome do novo ator: ");
                String nomeAtor = scanner.nextLine();

                Optional<Ator> atorExistente = atores.stream()
                        .filter(ator -> ator.getNome().equalsIgnoreCase(nomeAtor))
                        .findFirst();

                if (atorExistente.isPresent()) {
                    System.out.println("O ator/atriz já existe em nosso sistema.");
                    elenco.add(atorExistente.get());
                } else {
                    System.out.print("Digite a data de nascimento do ator: ");
                    String dataNascimentoAtor = scanner.nextLine();

                    System.out.print("O ator/atriz é favorito? (true/false): ");
                    boolean favoritoAtor = scanner.nextBoolean();

                    Ator novoAtor = new Ator(nomeAtor, dataNascimentoAtor, favoritoAtor);
                    atores.add(novoAtor);
                    elenco.add(novoAtor);
                    System.out.println("Ator " + nomeAtor + " adicionado com sucesso!");
                }
            } else {
                elenco.add(atores.get(atorEscolhido));
            }
        }

        filmes.add(new Filme(titulo, duracao, anoLancamento, genero, diretor, elenco));
        System.out.println("Filme adicionado com sucesso!");
    }

    @SuppressWarnings("resource")
    public static void filtrarPorGenero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escolha o gênero para filtrar (0-Ação, 1-Comédia, 2-Drama, 3-Fantasia, 4-Terror, 5-Suspense, 6-Romance, 7-Animação): ");
        int generoEscolhido = scanner.nextInt();
        Genero genero = Genero.values()[generoEscolhido];

        List<Filme> filmesFiltrados = filmes.stream()
                .filter(filme -> filme.getGenero().equals(genero))
                .collect(Collectors.toList());

        if (filmesFiltrados.isEmpty()) {
            System.out.println("Nenhum filme encontrado para o gênero " + genero);
        } else {
            filmesFiltrados.forEach(filme -> System.out.println(filme.getDetalhes()));
        }
    }

    public static void listarDiretoresFavoritos() {
        List<Diretor> diretoresFavoritos = diretores.stream()
                .filter(Diretor::isFavorito)
                .collect(Collectors.toList());

        if (diretoresFavoritos.isEmpty()) {
            System.out.println("Nenhum diretor favorito encontrado.");
        } else {
            diretoresFavoritos.forEach(diretor -> System.out.println(diretor.getNome()));
        }
    }

    public static void listarAtoresFavoritos() {
        List<Ator> atoresFavoritos = atores.stream()
                .filter(Ator::isFavorito)
                .collect(Collectors.toList());

        if (atoresFavoritos.isEmpty()) {
            System.out.println("Nenhum ator favorito encontrado.");
        } else {
            atoresFavoritos.forEach(ator -> System.out.println(ator.getNome()));
        }
    }
}
