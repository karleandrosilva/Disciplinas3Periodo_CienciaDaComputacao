public class Semaforo {
    //private boolean vermelho = true;
    //private boolean amarelo = false;
    //private boolean verde = false;


    public String Vermelho = "VERMELHO";
    public String Amarelo = "AMARELO";
    public String Verde = "VERDE";

    // Atributo para armazenar o estado atual
    private String estadoAtual;
    
    // Construtor
    public Semaforo() {
        this.estadoAtual = Vermelho; // Inicializa o semáforo com a cor vermelha por padrão
    }

    // Método para obter o estado atual
    public String getEstadoAtual() {
        return estadoAtual;
    }

    // Método para avançar para o próximo estado válido
    public void avancar() {
        if (estadoAtual.equals(Verde)) {
            estadoAtual = Amarelo;
        } else if (estadoAtual.equals(Amarelo)) {
            estadoAtual = Vermelho;
        } else if (estadoAtual.equals(Vermelho)) {
            estadoAtual = Verde;
        }
    }

    // Método para definir o estado diretamente, com validação de transição
    public void setEstado(String novaCor) {
        if ((estadoAtual.equals(Verde) && novaCor.equals(Amarelo)) ||
            (estadoAtual.equals(Amarelo) && novaCor.equals(Vermelho)) ||
            (estadoAtual.equals(Vermelho) && novaCor.equals(Verde))) {
            estadoAtual = novaCor;
        } else {
            throw new IllegalArgumentException("Transição inválida para a cor: " + novaCor);
        }
    }

    @Override
    public String toString() {
        return "Semáforo [estadoAtual=" + estadoAtual + "]";
    }
}
