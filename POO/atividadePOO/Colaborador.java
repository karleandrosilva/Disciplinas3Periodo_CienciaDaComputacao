package atividadePOO;

import java.util.Scanner;

public abstract class Colaborador {
    protected String nome;
    protected String cpf;
    protected String setor;
    private double salario;

    // Getter e Setter para (NOME)
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para (CPF)
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Getter e Setter para (SETOR)
    public String getSetor(){
        return setor;
    }
    public void setSetor(String setor){
        this.setor = setor;
    }

    // Getter e Setter para (SALARIO)
    public double getSalario(){
        return salario;
    }
    public void setSalario(double salario){
        this.salario = salario;
    }

    public abstract double calcularSalario();

    public static void main(String[] args) {


        Tecnico tecnico = new Tecnico();
        Vendedor vendedor = new Vendedor();

        // a) Criar um objeto Colaborador;
        Scanner teclado = new Scanner(System.in);


        // b) Pedir ao usuário, dados do colaborador;
        System.out.print("Digite o nome do/a Colaborador(a): ");
        String nome = teclado.nextLine();

        System.out.print("Digite o  CPF do/a Colaborador(a): ");
        String cpf = teclado.nextLine();

        System.out.print("Digite o salario do Colaborador(a): ");
        double salario = teclado.nextDouble();

        // c) Pedir ao usuário o tipo de colaborador: vendedor ou técnico;
        System.out.print("Digite o tipo de Colaborador:\n"
                + "[1] - Vendedor\n"
                + "[2] - Técnico\n"
                + "RESPOSTA: ");
        int resposta = teclado.nextInt();
        teclado.nextLine(); 

        if (resposta == 1) {
            System.out.print("Digite a comissão do Vendedor: ");
            double comissao = teclado.nextDouble();
            vendedor.setComissao(comissao);
            vendedor.setNome(nome);
            vendedor.setCpf(cpf);
            vendedor.setSalario(salario);

            vendedor.calcularSalario();
            System.out.println(vendedor.toString());
            System.out.println( "SALARIO + COMISSAO MENOS OS IMPOSTOS: R$  "+ vendedor.calcularSalario()); 
        } else if (resposta == 2) {
            
            tecnico.setNome(nome);
            tecnico.setCpf(cpf);
            tecnico.setSalario(salario);

            tecnico.calcularSalario();
            System.out.println(tecnico.toString()); 
            System.out.println( "SALARIO MENOS OS IMPOSTOS:R$ "+ tecnico.calcularSalario());
        } else {
            teclado.close();
        }
    }
}

