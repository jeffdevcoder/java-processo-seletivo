import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        imprimirSelecionados();

    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;

            if (continuarTentando) 
                tentativasRealizadas++;
            else 
                System.out.println("CONTATO REALIZADO COM SUCESSO.");
        } while (continuarTentando && tentativasRealizadas < 3);
    }

    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados() {
        String [] candidatos = {
            "Gabrielly",
            "Chris",
            "Camila",
            "Leonardo",
            "João Marcos",
            "Daniel",
            "Richard",
            "José",
            "Spinola"
        };
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

        for(int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidato de numero: " + i + " é " + candidatos[i]);
        }

    }

    static void selecaoCandidatos() {
        String [] candidatos = {
            "Felipe",
            "Chris",
            "Maurício",
            "Leonardo",
            "Gabrielly",
            "João",
            "Camila",
            "Monica",
            "Richard",
            "José",
            "Daniel"
        };

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");            
        } else if (salarioBase == salarioPretendido) 
            System.out.println("AGUARDANDO DEMAIS CANDIDATOS");
        else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
