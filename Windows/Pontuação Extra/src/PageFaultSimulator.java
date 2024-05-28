import java.util.Random;

public class PageFaultSimulator {
    private static final int PAGE_SIZE = 1024 * 1024 * 1024; // Tamanho da página em bytes
    private static final int ARRAY_SIZE = PAGE_SIZE / Integer.BYTES; // Tamanho do array
    private static final int NUM_ITERATIONS = 1000; // Número de iterações

    public static void main(String[] args) {
        System.out.printf("%d MB %d times.\n", PAGE_SIZE / (1024 * 1024), NUM_ITERATIONS);
        System.out.println("Iniciando a geração de page faults...");
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            generatePageFaults();
        }
        System.out.println("Geração de page faults concluída.");
    }

    private static void generatePageFaults() {
        int[] data = new int[ARRAY_SIZE];
        Random rand = new Random();

        // Acessa elementos em saltos de PAGE_SIZE para garantir que cada acesso está em uma nova página
        for (int i = 0; i < ARRAY_SIZE; i += PAGE_SIZE / Integer.BYTES) {
            data[i] = rand.nextInt();
        }
    }
}
