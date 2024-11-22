import java.util.List;

public class Filme {
    private String titulo;
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


    public String getDetalhes() {
        return "Título: " + titulo + ", Diretor: " + diretor.getNome() + ", Gênero: " + genero + ", Ano: " + anoLancamento;
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

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public List<Ator> getElenco() {
        return elenco;
    }

    public void setElenco(List<Ator> elenco) {
        this.elenco = elenco;
    }

    
}
