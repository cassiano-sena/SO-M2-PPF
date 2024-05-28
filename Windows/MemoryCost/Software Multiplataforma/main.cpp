#include <iostream>
#include <vector>
#include <cstdlib>

const size_t PAGE_SIZE = 128 * 1024 * 1024; // Tamanho da página em bytes
const size_t ARRAY_SIZE = PAGE_SIZE / sizeof(int); // Tamanho do array
const size_t NUM_ITERATIONS = 300; // Número de iterações

void generate_page_faults() {
    std::vector<int> data(ARRAY_SIZE, 0);

    // Acessa elementos em saltos de PAGE_SIZE para garantir que cada acesso está em uma nova página
    for (size_t i = 0; i < ARRAY_SIZE; i += PAGE_SIZE / sizeof(int)) {
        data[i] = rand();
    }
}

int main() {
    printf("%d MB %d times.\n", PAGE_SIZE / (1024 * 1024), NUM_ITERATIONS);
    printf("Iniciando a geracao de page faults...\n");
    for (size_t i = 0; i < NUM_ITERATIONS; ++i) {
        generate_page_faults();
    }
    printf("Geracao de page faults concluida.\n");
    return 0;
}
