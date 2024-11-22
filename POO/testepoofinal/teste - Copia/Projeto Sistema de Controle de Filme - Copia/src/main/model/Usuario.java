package main.model;

public class Usuario {
    private String nomeUsuario;
    private String senha;

    //private static ArrayList<Filme> filmesFavoritos = new ArrayList<>();
    //private static ArrayList<Ator> atoresFavoritos = new ArrayList<>();
    //private static ArrayList<Diretor> diretoresFavoritos = new ArrayList<>();

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

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
