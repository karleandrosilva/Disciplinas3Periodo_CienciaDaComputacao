import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    static Scanner teclado = new Scanner(System.in); // entrada de dados (input)
    static HashMap<String, Usuario> usuarios = new HashMap<>(); // Mapa para armazenar os usuários comuns
    static HashMap<String, Administrador> administradores = new HashMap<>(); // Mapa para armazenar os administradores
    static ArrayList<Filme> filmes = new ArrayList<>();
    static ArrayList<Ator> atores = new ArrayList<>();
    static ArrayList<Diretor> diretores = new ArrayList<>();

    public static void main(String[] args) {
        inicializarFilmes();
        boolean continuar = true;

        while (continuar) { // Loop principal
            telaLogin();

            System.out.print("Deseja continuar usando o programa? [S/N]: ");
            String respostaContinuar = teclado.nextLine();
            if (respostaContinuar.equalsIgnoreCase("N")) {
                continuar = false;
            } else {
                continuar = true;
            }    
        }

        System.out.println("Programa encerrado. Até mais!");
        teclado.close();
        System.exit(0); // Encerra o programa
    }

    public static void inicializarFilmes() {
        filmes.add(new Filme("Interestelar", 169, 2014, Genero.Fantasia));
        filmes.add(new Filme("As Branquelas", 109, 2004, Genero.Comédia));
        filmes.add(new Filme("Titanic", 194, 1997, Genero.Romance));
    }

    static void telaLogin() {
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
                cadastro();
                break;
            case 2:
                login();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
        }
    }

    public static void cadastro(){
        System.out.println("\n--- CADASTRO DE USUÁRIO ---");
        System.out.print("Informe seu nome de usuário: ");
        String nomeUsuario = teclado.nextLine();

        if (usuarios.containsKey(nomeUsuario) || administradores.containsKey(nomeUsuario)) {
            System.out.println("\nUsuário já cadastrado! Tente outro nome de usuário.");
            cadastro();
        } else {
            System.out.print("Informe sua senha: ");
            String senha = teclado.nextLine();

            System.out.print("Você será um administrador? (S/N): ");
            String resposta = teclado.nextLine();

            if (resposta.equalsIgnoreCase("S")) {
                administradores.put(nomeUsuario, new Administrador(nomeUsuario, senha)); // o put insere uma nova entrada no mapa(dicionario)
                System.out.println("Administrador cadastrado com sucesso!");
            } else {
                usuarios.put(nomeUsuario, new Usuario(nomeUsuario, senha));
                System.out.println("Usuário cadastrado com sucesso!");
            }
        }
        
        login();
    }

    public static void login(){
        System.out.println("\n--- LOGIN ---");
        System.out.print("Informe seu nome de usuário: ");
        String nomeUsuario = teclado.nextLine();

        if (administradores.containsKey(nomeUsuario)) { //Login para administrador
            Administrador adminLogado = administradores.get(nomeUsuario);
            realizarLoginAdmin(adminLogado);
        } else if (usuarios.containsKey(nomeUsuario)) { // Login para usuário comum
            Usuario usuarioLogado = usuarios.get(nomeUsuario);
            realizarLoginUsuario(usuarioLogado);
        } else {
            System.out.println("\nUsuário não encontrado! Faça o cadastro primeiro.");
            cadastro();
        }
    }

    public static void realizarLoginAdmin(Administrador admin) {
        System.out.print("Informe sua senha: ");
        String senha = teclado.nextLine();

        if (admin.getSenha().equals(senha)) {
            System.out.println("\nLogin realizado com sucesso! Bem-vindo, Administrador " + admin.getNomeUsuario() + "!");
            menuAdministrador();
        } else {
            System.out.println("\nSenha incorreta. Tente novamente.");
            login();
        }
    }

    public static void realizarLoginUsuario(Usuario usuario) {
        System.out.print("Informe sua senha: ");
        String senha = teclado.nextLine();

        if (usuario.getSenha().equals(senha)) {
            System.out.println("\nLogin realizado com sucesso! Bem-vindo, " + usuario.getNomeUsuario() + "!");
            menuUsuario();
        } else {
            System.out.println("\nSenha incorreta. Tente novamente.");
            login();
        }
    }

    public static void menuAdministrador() {
        System.out.println("\n--- MENU ADMINISTRADOR ---");
        System.out.print("[1] - Cadastrar Dados\n"
                + "[2] - Listar Dados\n"
                + "[3] - Editar Dados\n"
                + "[4] - Excluir Dados\n"
                + "[5] - Editar Perfil\n"
                + "[6] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();

        switch (opcao) {
            case 1:
                cadastrarDados();
                break;
            case 2:
                listarDados();
                break;
            case 3:
                editarDados();
                break;
            case 4:
                excluirDados();
                break;
            case 5:
                editarPerfilAdm();
                break;
            case 6:
                telaLogin();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                menuAdministrador();
        }
    }

    public static void editarPerfilAdm() {
        System.out.print("Deseja mudar a sua senha (S/N): ");
        String resposta = teclado.nextLine();
        if (resposta.equalsIgnoreCase("S")) {
            System.out.println("\n--- ALTERAÇÃO DE SENHA ---");
            System.out.print("Informe seu nome de usuário: ");
            String nomeUsuario = teclado.nextLine();

            if (administradores.containsKey(nomeUsuario)) { // Se for um administrador
                Administrador admin = administradores.get(nomeUsuario);
                System.out.print("Informe sua senha atual: ");
                String senhaAtual = teclado.nextLine();
                if (admin.getSenha().equals(senhaAtual)) {
                    System.out.print("Informe a nova senha: ");
                    String novaSenha = teclado.nextLine();
                    admin.setSenha(novaSenha);
                    System.out.println("Senha alterada com sucesso!");
                } else {
                    System.out.println("Senha atual incorreta!");
                }
            } else if (usuarios.containsKey(nomeUsuario)) { // Se for um usuário
                Usuario usuario = usuarios.get(nomeUsuario);
                System.out.print("Informe sua senha atual: ");
                String senhaAtual = teclado.nextLine();
        
                if (usuario.getSenha().equals(senhaAtual)) {
                    System.out.print("Informe a nova senha: ");
                    String novaSenha = teclado.nextLine();
                    usuario.setSenha(novaSenha);
                    System.out.println("Senha alterada com sucesso!");
                } else {
                    System.out.println("Senha atual incorreta!");

                }
            } else {
                System.out.println("Usuário não encontrado!");
            }
        }
        menuAdministrador();
    }

    public static void cadastrarDados() {
        System.out.println("\n--- CADASTRAR DADOS ---");
        System.out.print("[1] - Cadastrar Filme\n"
                + "[2] - Cadastrar Ator\n"
                + "[3] - Cadastrar Diretor\n"
                + "[4] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1:
                Administrador.cadastrarFilme(filmes);
                break;
            case 2:
                Administrador.cadastrarAtor(atores);
                break;
            case 3:
                Administrador.cadastrarDiretor(diretores);
                break;
            case 4:
                menuAdministrador();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                menuAdministrador();
        }
    }

    public static void listarDados() {
        System.out.println("\n--- LISTAR DADOS ---");
        System.out.print("[1] - Listar Filmes\n"
                + "[2] - Listar Atores\n"
                + "[3] - Listar Diretores\n"
                + "[4] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1:
                Administrador.listarFilmes(filmes);
                break;
            case 2:
                Administrador.listarAtores(atores);
                break;
            case 3:
                Administrador.listarDiretores(diretores);
                break;
            case 4:
                menuAdministrador();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                menuAdministrador();
        }
    }

    public static void editarDados() {
        System.out.println("\n--- EDITAR DADOS ---");
        System.out.print("[1] - Editar Filmes\n"
                + "[2] - Editar Atores\n"
                + "[3] - Editar Diretores\n"
                + "[4] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1:
                Administrador.editarFilmes(filmes);
                break;
            case 2:
                Administrador.editarAtor(atores);
                break;
            case 3:
                Administrador.editarDiretor(diretores);
                break;
            case 4:
                menuAdministrador();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                menuAdministrador();
        }
    }

    public static void excluirDados() {
        System.out.println("\n--- EXCLUIR DADOS ---");
        System.out.print("[1] - Remover Filme\n"
                + "[2] - Remover Ator\n"
                + "[3] - Remover Diretor\n"
                + "[4] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1:
                Administrador.removerFilme(filmes);
                break;
            case 2:
                Administrador.removerAtor(atores);
                break;
            case 3:
                Administrador.removerDiretor(diretores);
                break;
            case 4:
                menuAdministrador();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                menuAdministrador();
        }
    }

    public static void menuUsuario() {
        System.out.println("\n--- MENU USUÁRIO ---");
        System.out.print("[1] - Buscar Dados\n"
                + "[2] - Favoritos\n"
                + "[3] - Editar Perfil\n"
                + "[4] - Sair\nRESPOSTA: ");
        int opcao = teclado.nextInt();
        teclado.nextLine();

        switch (opcao) {
            case 1:
                buscarDados();
                break;
            case 2:
                Favoritos();
                break;
            case 3:
                editarPerfil();
                break;
            case 4:
                telaLogin();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                menuUsuario();
        }
    }

    public static void buscarDados() {
        System.out.println("\n-- O QUE DESEJA PESQUISAR? --");
        System.out.print("[1] - Filme \n"
        + "[2] - Filme por Genero \n"
        + "[3] - Filme por Ano \n"
        + "[4] - Atores \n"
        + "[5] - Diretores  \n"
        + "[6] - Sair\nRESPOSTA: "); 

        int opcao = teclado.nextInt();
        teclado.nextLine();
        
        switch (opcao) {
            case 1:
                Usuario.buscarFilme(filmes, teclado);
                break;
            case 2:
                Usuario.buscarFilmePorGenero(filmes, teclado);
                break;
            case 3:
                Usuario.buscarFilmePorAno(filmes, teclado);
                break;
            case 4:
                Usuario.buscarAtor(atores, teclado);
                break;
            case 5:
                Usuario.buscarDiretor(diretores, teclado);
                break;
            case 6:
                System.out.println("Saindo da pesquisa...");
                menuUsuario();
            default:
                System.out.println("Opção inválida, tente novamente.");
                buscarDados();
        }  
    }
    
    public static void Favoritos(){
        System.out.println("\n--- FAVORITOS ---");
        System.out.print("[1] - Adicionar Filme Favorito\n"
                + "[2] - Adicionar Ator Favorito\n"
                + "[3] - Adicionar Diretor Favorito\n"
                + "[4] - Ver Filmes Favoritos\n"
                + "[5] - Ver Atores Favoritos\n"
                + "[6] - Ver Diretores Favoritos\n"
                + "[7] - Remover Filme Favorito\n"
                + "[8] - Remover Ator Favorito\n"
                + "[9] - Remover Diretor Favorito\n"
                + "[10] - Sair\nRESPOSTA: ");

        int opcao = teclado.nextInt();
        teclado.nextLine();
    
        switch (opcao) {
            case 1:
                Usuario.adicionarFilmeFavorito(filmes);
                break;
            case 2:
                Usuario.adicionarAtorFavorito(atores);
                break;
            case 3:
                Usuario.adicionarDiretorFavorito(diretores);
                break;
            case 4:
                Usuario.verFilmesFavoritos(filmes);
                break;
            case 5:
                Usuario.verAtoresFavoritos(atores);
                break;
            case 6:
                Usuario.verDiretoresFavoritos(diretores);
                break;
            case 7:
                Usuario.removerFilmeFavorito(filmes);
                break;
            case 8:
                Usuario.removerAtorFavorito(atores);
                break;
            case 9:
                Usuario.removerDiretorFavorito(diretores);
                break;
            case 10:
                menuUsuario();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                Favoritos();
        }
    }

    public static void editarPerfil() {
        System.out.print("Deseja mudar a sua senha (S/N): ");
        String resposta = teclado.nextLine();
        if (resposta.equalsIgnoreCase("S")) {
            System.out.println("\n--- ALTERAÇÃO DE SENHA ---");
            System.out.print("Informe seu nome de usuário: ");
            String nomeUsuario = teclado.nextLine();

            if (usuarios.containsKey(nomeUsuario)) { 
                Usuario usuarioComum = usuarios.get(nomeUsuario);
                System.out.print("Informe sua senha atual: ");
                String senhaAtual = teclado.nextLine();
                if (usuarioComum.getSenha().equals(senhaAtual)) {
                    System.out.print("Informe a nova senha: ");
                    String novaSenha = teclado.nextLine();
                    usuarioComum.setSenha(novaSenha);
                    System.out.println("Senha alterada com sucesso!");
                } else {
                    System.out.println("Senha atual incorreta!");
                }
            } else if (usuarios.containsKey(nomeUsuario)) { // Se for um usuário
                Usuario usuario = usuarios.get(nomeUsuario);
                System.out.print("Informe sua senha atual: ");
                String senhaAtual = teclado.nextLine();
        
                if (usuario.getSenha().equals(senhaAtual)) {
                    System.out.print("Informe a nova senha: ");
                    String novaSenha = teclado.nextLine();
                    usuario.setSenha(novaSenha);
                    System.out.println("Senha alterada com sucesso!");
                } else {
                    System.out.println("Senha atual incorreta!");

                }
            } else {
                System.out.println("Usuário não encontrado!");
            }
        }
        menuUsuario();
    }
}