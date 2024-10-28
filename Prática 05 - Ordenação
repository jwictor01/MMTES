import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface EstrategiaOrdenacao {
    void ordenar(List<Integer> numeros);
}

class OrdenacaoBubbleSort implements EstrategiaOrdenacao {
    @Override
    public void ordenar(List<Integer> numeros) {
        int n = numeros.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numeros.get(j) > numeros.get(j + 1)) {
                    int temp = numeros.get(j);
                    numeros.set(j, numeros.get(j + 1));
                    numeros.set(j + 1, temp);
                }
            }
        }
    }
}

class OrdenacaoSelectionSort implements EstrategiaOrdenacao {
    @Override
    public void ordenar(List<Integer> numeros) {
        int n = numeros.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (numeros.get(j) < numeros.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = numeros.get(minIndex);
            numeros.set(minIndex, numeros.get(i));
            numeros.set(i, temp);
        }
    }
}

class OrdenacaoInsertionSort implements EstrategiaOrdenacao {
    @Override
    public void ordenar(List<Integer> numeros) {
        int n = numeros.size();
        for (int i = 1; i < n; i++) {
            int key = numeros.get(i);
            int j = i - 1;
            while (j >= 0 && numeros.get(j) > key) {
                numeros.set(j + 1, numeros.get(j));
                j = j - 1;
            }
            numeros.set(j + 1, key);
        }
    }
}

class ContextoDeOrdenacao {
    private EstrategiaOrdenacao estrategia;

    public void setEstrategia(EstrategiaOrdenacao estrategia) {
        this.estrategia = estrategia;
    }

    public void executarOrdenacao(List<Integer> numeros) {
        if (estrategia != null) {
            estrategia.ordenar(numeros);
        } else {
            System.out.println("Nenhuma estratégia de ordenação definida!");
        }
    }
}

class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        System.out.println("Digite os números para ordenar: ");
        String[] entrada = scanner.nextLine().split(" ");
        for (String numero : entrada) {
            numeros.add(Integer.parseInt(numero));
        }

        ContextoDeOrdenacao contexto = new ContextoDeOrdenacao();

        System.out.println("Escolha o algoritmo de ordenação:");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Selection Sort");
        System.out.println("3 - Insertion Sort");
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1 -> contexto.setEstrategia(new OrdenacaoBubbleSort());
            case 2 -> contexto.setEstrategia(new OrdenacaoSelectionSort());
            case 3 -> contexto.setEstrategia(new OrdenacaoInsertionSort());
            default -> System.out.println("Opção inválida.");
        }

        contexto.executarOrdenacao(numeros);
        System.out.println("Lista ordenada: " + numeros);
        scanner.close();
    }
}
