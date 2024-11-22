enum Genero {
    Acao, Comédia, Drama, Fantasia, Terror, Suspense, Romance, Animacao;
}

public class Filme {
    private String titulo;
    private int duracao;
    private int anoLancamento;
    private Genero genero;

    public Filme(String titulo, int duracao, int anoLancamento, Genero genero) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }


    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
