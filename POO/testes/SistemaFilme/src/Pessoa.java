public abstract class Pessoa {
    protected String nome;
    protected String dataNascimento;
    protected boolean favorito;

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
  
    public String getNome() {
        return nome;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, String dataNascimento, boolean favorito) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.favorito = favorito;
    }
}
