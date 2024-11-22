package atividadePOO;

public class Vendedor extends Colaborador {
    private double comissao;
    double imposto = 0.11;

    public double getComissao(){
        return comissao;
    }

    public void setComissao(double comissao){
        this.comissao = comissao;
    }

    @Override
    public double calcularSalario() {
        return getSalario() + getComissao() - ((getSalario() + getComissao()) * imposto);
    }

    public String toString() {
        return "NOME: " + nome + "\nCPF: " + cpf;
    }
}
