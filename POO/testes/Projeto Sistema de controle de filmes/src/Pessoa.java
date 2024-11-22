public class Pessoa {
    protected String nome;
    protected String dataNascimento;
    
    public Pessoa(String nome, String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

class Diretor extends Pessoa {

    public Diretor(String nome, String dataNascimento) {
        super(nome, dataNascimento);
    } 
}

class Ator extends Pessoa {

    public Ator(String nome, String dataNascimento) {
        super(nome, dataNascimento);
    }
}