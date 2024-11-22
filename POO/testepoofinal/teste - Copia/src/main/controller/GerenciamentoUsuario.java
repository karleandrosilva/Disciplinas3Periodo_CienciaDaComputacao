package main.controller;

import java.util.HashMap;
import java.util.Scanner;
import main.App;
import main.model.Usuario;

public class GerenciamentoUsuario {
    
    private static HashMap<String, Usuario> usuarios = new HashMap<>(); // Mapa para armazenar os usuários comuns

    static {
        usuarios.put("user", new Usuario("user", "123"));
    }

    public static void cadastro() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n--- CADASTRO DE USUÁRIO ---");
        System.out.print("Informe seu nome de usuário: ");
        String nomeUsuario = teclado.nextLine();

        if (usuarios.containsKey(nomeUsuario)) { // Correção: adição de parêntese
            System.out.println("\nUsuário já cadastrado! Tente outro nome de usuário.");
            cadastro();
        } else {
            System.out.print("Informe sua senha: ");
            String senha = teclado.nextLine();
            usuarios.put(nomeUsuario, new Usuario(nomeUsuario, senha));
            System.out.println("Usuário cadastrado com sucesso!");
        }
        login();
    }

    public static void login() {
        Scanner teclado = new Scanner(System.in); // Scanner adicionado para este método
        System.out.println("\n--- LOGIN ---");
        System.out.print("Informe seu nome de usuário: ");
        String nomeUsuario = teclado.nextLine();

        if (usuarios.containsKey(nomeUsuario)) { 
            Usuario usuarioLogado = usuarios.get(nomeUsuario);
            realizarLoginUsuario(usuarioLogado);
        } else {
            System.out.println("\nUsuário não encontrado! Faça o cadastro primeiro.");
            cadastro();
        }
    }

    public static void realizarLoginUsuario(Usuario usuario) {
        Scanner teclado = new Scanner(System.in); 
        System.out.print("Informe sua senha: ");
        String senha = teclado.nextLine();

        if (usuario.getSenha().equals(senha)) {
            System.out.println("\nLogin realizado com sucesso! Bem-vindo, " + usuario.getNomeUsuario() + "!");
            App.menuUsuario();
        } else {
            System.out.println("\nSenha incorreta. Tente novamente.");
            login();
        }
    }


    public static void editarPerfil() {
        Scanner teclado = new Scanner(System.in); // Scanner adicionado
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
    }

    public static void main(String[] args) {
    }
}
