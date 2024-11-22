import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cardapio {

    static class Lanche {
        int indice;
        String nome;
        double preco;

        Lanche(int indice, String nome, double preco) {
            this.indice = indice;
            this.nome = nome;
            this.preco = preco;
        }
    }

    static ArrayList<Lanche> listaLanches = new ArrayList<>(); // cria nova lista com os lanches
    static int indiceLanche = 1; // início do índice dos lanches
    static Scanner teclado = new Scanner(System.in); // entrada de dados (input)

    public static void main(String[] args) {
        while (true) {
            System.out.print("\nEscolha uma das opções abaixo:\n"
                    + "[1] - Adicionar Lanche;\n"
                    + "[2] - Remover Lanche;\n"
                    + "[3] - Listar Lanches;\n"
                    + "[4] - Atualizar Lanche;\n"
                    + "[5] - Sair;\nRESPOSTA: ");
    
            int opcao = teclado.nextInt();
            teclado.nextLine(); 
            processarOpcao(opcao);
        }
    }

    static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionaLanche();
                break;
            case 2:
                removerLanche();
                break;
            case 3:
                listarLanches();
                break;
            case 4:
                atualizaLanche();
                break;
            case 5:
                sairMenu();
                return; // Sai do loop e encerra o programa
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
        }
    }

    public static void adicionaLanche() {
        System.out.print("Informe o nome do lanche: ");
        String nome = teclado.nextLine();

        double preco = 0;

        while (true) {
                try {
                    System.out.print("Informe o valor do lanche: ");
                    preco = teclado.nextDouble();
                    teclado.nextLine();
                    break;
                } catch (Exception e) { // Verificaçao para inserir um valor válido
                    System.out.println("Por favor, insira um valor válido.");
                    teclado.nextLine(); // Limpa o buffer do scanner
                }
        }

        Lanche lanche = new Lanche(indiceLanche++, nome, preco);
        listaLanches.add(lanche);
        System.out.println("Você adicionou: " + nome + " com sucesso!");
    }

    public static void listarLanches() {
        if (listaLanches.isEmpty()) {
            System.out.println("Nenhum lanche cadastrado.");
        } else {
            System.out.println("=== Lista de Lanches ===");
            for (Lanche lanche : listaLanches) {
                System.out.println("Índice: " + lanche.indice + " | Nome: " + lanche.nome + " | Preço: R$ " + lanche.preco);
            }
        }
    }

    public static void atualizaLanche() {
        System.out.print("Digite o nome do lanche que deseja atualizar: ");
        String nome = teclado.nextLine();
        Lanche lancheEncontrado = null;

        for (Lanche lanche : listaLanches) {
            if (lanche.nome.equals(nome)) {
                lancheEncontrado = lanche;
                break;
            }
        }

        if (lancheEncontrado != null) {
            System.out.print("Digite o novo nome do lanche: ");
            String novoNome = teclado.nextLine();

            System.out.print("Digite o novo preço do lanche: ");
            double novoPreco = teclado.nextDouble();
            teclado.nextLine();
            lancheEncontrado.nome = novoNome;
            lancheEncontrado.preco = novoPreco;
            System.out.println("Lanche atualizado com sucesso!");
        } else {
            System.out.println("Lanche não encontrado.");
            System.out.print("Deseja adicionar o lanche? (sim/não): ");
            String resposta = teclado.nextLine();
            if (resposta.equalsIgnoreCase("sim")) {
                adicionaLanche();
            }
        }
    }

     public static void removerLanche() {
        listarLanches(); 
        System.out.print("Informe o índice do lanche que deseja remover: ");
        int indiceRemover = -1;
        try {
            indiceRemover = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
            teclado.nextLine(); 
            return;
        }
        teclado.nextLine(); 

        Lanche lancheRemovido = null;
        for (Lanche lanche : listaLanches) {
            if (lanche.indice == indiceRemover) {
                lancheRemovido = lanche;
                break;
            }
        }

        if (lancheRemovido != null) {
            listaLanches.remove(lancheRemovido);
            System.out.println("Lanche removido com sucesso!");
            int novoIndice = 1;
            for (Lanche lanche : listaLanches) {
                lanche.indice = novoIndice++;
            }
            indiceLanche = novoIndice; // Atualiza o valor do próximo índice a ser adicionado
        } else {
            System.out.println("Lanche não encontrado.");
        }
    }

    public static void sairMenu() {
        System.out.print("Saindo...");
        teclado.close();
        System.exit(0); // Encerra o programa
    }
}
