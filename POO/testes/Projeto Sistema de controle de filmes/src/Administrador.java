import java.util.ArrayList;
import java.util.Scanner;

public class Administrador {

    private String nomeUsuario;
    private String senha;

    public Administrador(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static void cadastrarFilme(ArrayList<Filme> filmes) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Nome do filme: ");
        String titulo = teclado.nextLine();

        System.out.print("Duração (minutos): ");
        int duracao = teclado.nextInt();

        System.out.print("Ano de lançamento: ");
        int anoLancamento = teclado.nextInt();

        System.out.print("Escolha o gênero (0-Ação, 1-Comédia, 2-Drama, 3-Fantasia, 4-Terror, 5-Suspense, 6-Romance, 7-Animação): ");
        int generoEscolhido = teclado.nextInt();
        Genero genero = Genero.values()[generoEscolhido];

        // System.out.println("Escolha os atores (digite 00 para adicionar um novo ator, -1 para finalizar):");
        // int atorEscolhido = teclado.nextInt();
        Filme novoFilme = new Filme(titulo, duracao, anoLancamento, genero); // Cria uma nova instância do filme com os dados fornecidos
        filmes.add(novoFilme); // Adiciona o filme à lista de filmes
        System.out.println("\nFilme cadastrado com sucesso: " + titulo + " (" + anoLancamento + ")");
        App.menuAdministrador();
    }

    public static void cadastrarAtor(ArrayList<Ator> atores) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Nome do ator: ");
        String nome = teclado.nextLine();
        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        String dataNascimento = teclado.nextLine();
        atores.add(new Ator(nome, dataNascimento));
        System.out.println("\nAtor cadastrado com sucesso: " + nome + " - (" + dataNascimento + ")");
        App.menuAdministrador();
    }

    public static void cadastrarDiretor(ArrayList<Diretor> diretores) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Nome do diretor: ");
        String nome = teclado.nextLine();
        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        String dataNascimento = teclado.nextLine();
        diretores.add(new Diretor(nome, dataNascimento));
        System.out.println("\nDiretor cadastrado com sucesso: " + nome + " - (" + dataNascimento + ")");
        App.menuAdministrador();
    }

    public static void listarFilmes(ArrayList<Filme> filmes) {
        if (filmes.isEmpty()) {
            System.out.println("\nNenhum filme cadastrado.");
        } else {
            System.out.println("\n--- FILMES CADASTRADOS ---");
            for (Filme filme : filmes) {
                System.out.println("- " + filme.getTitulo() + " (" + filme.getAnoLancamento() + ")");
            }
        }
        App.menuAdministrador();
    }

    public static void listarAtores(ArrayList<Ator> atores) {
        if (atores.isEmpty()) {
            System.out.println("\nNenhum ator cadastrado.");
        } else {
            System.out.println("\n--- ATORES CADASTRADOS ---");
            for (Ator ator : atores) {
                System.out.println("- " + ator.getNome() + " (Nascido em: " + ator.getDataNascimento() + ")");
            }
        }
        App.menuAdministrador();
    }

    public static void listarDiretores(ArrayList<Diretor> diretores) {
        if (diretores.isEmpty()) {
            System.out.println("\nNenhum diretor cadastrado.");
        } else {
            System.out.println("\n--- DIRETORES CADASTRADOS ---");
            for (Diretor diretor : diretores) {
                System.out.println("- " + diretor.getNome() + " (Nascido em: " + diretor.getDataNascimento() + ")");
            }
        }
        App.menuAdministrador();
    }

    public static void editarFilmes(ArrayList<Filme> filmes) {
        if (filmes.isEmpty()) {
            System.out.println("\nNenhum filme cadastrado.");
        } else {
            Scanner teclado = new Scanner(System.in);
            System.out.println("\n--- FILMES CADASTRADOS ---");
            for (int i = 0; i < filmes.size(); i++) {
                Filme filme = filmes.get(i);
                System.out.println("[" + (i + 1) + "] " + filme.getTitulo() + " (" + filme.getAnoLancamento() + ")");
            }
    
            System.out.print("\nDigite o número do filme que deseja editar: ");
            int numeroFilme = teclado.nextInt();
            teclado.nextLine(); 
    
            if (numeroFilme > 0 && numeroFilme <= filmes.size()) {
                Filme filmeParaEditar = filmes.get(numeroFilme - 1);
                
                // Editando informações
                System.out.print("Novo título do filme: ");
                String novoTitulo = teclado.nextLine();
                filmeParaEditar.setTitulo(novoTitulo);
    
                System.out.print("Nova duração (minutos): ");
                int novaDuracao = teclado.nextInt();
                filmeParaEditar.setDuracao(novaDuracao);
    
                System.out.print("Novo ano de lançamento: ");
                int novoAnoLancamento = teclado.nextInt();
                filmeParaEditar.setAnoLancamento(novoAnoLancamento);
    
                System.out.print("Escolha o novo gênero (0-Ação, 1-Comédia, 2-Drama, 3-Fantasia, 4-Terror, 5-Suspense, 6-Romance, 7-Animação): ");
                int generoEscolhido = teclado.nextInt();
                Genero novoGenero = Genero.values()[generoEscolhido];
                filmeParaEditar.setGenero(novoGenero);
    
                System.out.println("\nFilme atualizado com sucesso: " + novoTitulo + " (" + novoAnoLancamento + ")");
            } else {
                System.out.println("\nNúmero inválido, tente novamente.");
                editarFilmes(filmes);
            }
        }
        App.menuAdministrador();
    }    

    public static void editarAtor(ArrayList<Ator> atores) {
        if (atores.isEmpty()) {
            System.out.println("\nNenhum ator cadastrado.");
        } else {
            Scanner teclado = new Scanner(System.in);
            System.out.println("\n--- ATORES CADASTRADOS ---");
            for (int i = 0; i < atores.size(); i++) {
                Ator ator = atores.get(i);
                System.out.println("[" + (i + 1) + "] " + ator.getNome() + " (" + ator.getDataNascimento() + ")");
            }
    
            System.out.print("\nDigite o número do ator que deseja editar: ");
            int numeroAtor = teclado.nextInt();
            teclado.nextLine(); 
    
            if (numeroAtor > 0 && numeroAtor <= atores.size()) {
                Ator atorParaEditar = atores.get(numeroAtor - 1);
    
                System.out.print("Novo nome do ator: ");
                String novoNome = teclado.nextLine();
                atorParaEditar.setNome(novoNome);
    
                System.out.print("Nova data de nascimento (dd/MM/yyyy): ");
                String novaDataNascimento = teclado.nextLine();
                atorParaEditar.setDataNascimento(novaDataNascimento);
    
                System.out.println("\nAtor atualizado com sucesso: " + novoNome + " (" + novaDataNascimento + ")");
            } else {
                System.out.println("\nNúmero inválido, tente novamente.");
                editarAtor(atores);
            }
        }
        App.menuAdministrador();
    }
    
    public static void editarDiretor(ArrayList<Diretor> diretores) {
        if (diretores.isEmpty()) {
            System.out.println("\nNenhum diretor cadastrado.");
        } else {
            Scanner teclado = new Scanner(System.in);
            System.out.println("\n--- DIRETORES CADASTRADOS ---");
            for (int i = 0; i < diretores.size(); i++) {
                Diretor diretor = diretores.get(i);
                System.out.println("[" + (i + 1) + "] " + diretor.getNome() + " (" + diretor.getDataNascimento() + ")");
            }
    
            System.out.print("\nDigite o número do diretor que deseja editar: ");
            int numeroDiretor = teclado.nextInt();
            teclado.nextLine(); // Consumir quebra de linha
    
            if (numeroDiretor > 0 && numeroDiretor <= diretores.size()) {
                Diretor diretorParaEditar = diretores.get(numeroDiretor - 1);
    
                // Editando informações
                System.out.print("Novo nome do diretor: ");
                String novoNome = teclado.nextLine();
                diretorParaEditar.setNome(novoNome);
    
                System.out.print("Nova data de nascimento (dd/MM/yyyy): ");
                String novaDataNascimento = teclado.nextLine();
                diretorParaEditar.setDataNascimento(novaDataNascimento);
    
                System.out.println("\nDiretor atualizado com sucesso: " + novoNome + " (" + novaDataNascimento + ")");
            } else {
                System.out.println("\nNúmero inválido, tente novamente.");
                editarDiretor(diretores);
            }
        }
        App.menuAdministrador();
    }    

    public static void removerFilme(ArrayList<Filme> filmes) {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
        } else {
            for (Filme filme : filmes) {
                System.out.println("- " + filme.getTitulo() + " (" + filme.getAnoLancamento() + ")");
            }
            Scanner teclado = new Scanner(System.in);
            System.out.print("Informe o nome do filme a ser removido: ");
            String nome = teclado.nextLine();

            boolean removido = filmes.removeIf(filme -> filme.getTitulo().equalsIgnoreCase(nome)); // Remove o filme da lista com base no nome
    
            if (removido) {
                System.out.println("\nFilme: " + nome + " removido com sucesso!");
            } else {
                System.out.println("\nFilme: '"+ nome + "' não encontrado!");
                removerFilme(filmes);
            }
        }
        App.menuAdministrador();
    }

    public static void removerAtor(ArrayList<Ator> atores) {
        if (!atores.isEmpty()) {
            Scanner teclado = new Scanner(System.in);
            System.out.print("Informe o nome do ator a ser removido: ");
            String nome = teclado.nextLine();
            atores.removeIf(ator -> ator.getNome().equalsIgnoreCase(nome));
            System.out.println("\nAtor: " + nome + " removido com sucesso!");
        }
        App.menuAdministrador();
    }

    public static void removerDiretor(ArrayList<Diretor> diretores) {
        if (!diretores.isEmpty()) {
            Scanner teclado = new Scanner(System.in);
            System.out.print("Informe o nome do diretor a ser removido: ");
            String nome = teclado.nextLine();
            diretores.removeIf(diretor -> diretor.getNome().equalsIgnoreCase(nome));
            System.out.println("\n Diretor: " + nome + " removido com sucesso!");
        }
        App.menuAdministrador();
    }    
}
