import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        // Criando uma instância da classe Vector
        Vector vetor = new Vector();

        // Adicionando elementos ao vetor
        vetor.add("Maria da Silva");
        vetor.add("Joao dos Santos");

        // Exibindo o tamanho do vetor
        System.out.println("Tamanho da lista: " + vetor.size());

        // Exibindo os elementos nas posições 0 e 1
        //System.out.println("Elemento na posição 0: " + vetor.elementAt(0));
        //System.out.println("Elemento na posição 1: " + vetor.elementAt(1));

        for (int i = 0; c < vetor.size(); c++) {
            System.out.println("Elemento na posição " + c + ": " + vetor.get(c));
        }
    }
}