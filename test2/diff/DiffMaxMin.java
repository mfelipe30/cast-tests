public class DiffMaxMin {
  
    public static void main(final String[] args) {
        int array[]       = {7, 9, 5, 6, 3, 2};
        int min           = array[0];
        int max           = array[0];
        
        long tempoInicial = System.currentTimeMillis();

        quickSort(array,0,array.length-1);
        min = array[0];
        max = array[array.length-1];
        long tempoFinal = System.currentTimeMillis();

        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
        System.out.println(max - min);
    }

    private static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }

    private static int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo)
                    i++;
            else if (pivo < vetor[f])
                    f--;
            else {
                    int troca = vetor[i];
                    vetor[i] = vetor[f];
                    vetor[f] = troca;
                    i++;
                    f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }

}