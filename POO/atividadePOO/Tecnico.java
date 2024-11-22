package atividadePOO;

public class Tecnico extends Colaborador {
    private String funcao;
    
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    double imposto = 0.11;
    
    public double calcularSalario() {
        return getSalario()-(getSalario()* imposto);
    }

    @Override
    public String toString() {
        return "NOME: " + nome + "\nCPF: " + cpf;
    }
}