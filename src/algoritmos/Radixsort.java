package algoritmos;

/**
 * Classe que implementada o algoritmo de ordenação Radix sort
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */

public class Radixsort<DADO extends Comparable<DADO>> implements AlgoritmoDeOrdenacao<DADO> {
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    public int[] countSort(int[] array, int exp){
        int output[] = new int[array.length]; // output array
        int i;
        int count[] = new int[10];

        // Store count of occurrences in count[]
        for (i = 0; i < array.length; i++)
            count[ (array[i]/exp)%10 ]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = array.length - 1; i >= 0; i--){
            output[count[ (array[i]/exp)%10 ] - 1] = array[i];
            count[ (array[i]/exp)%10 ]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < array.length; i++)
            array[i] = output[i];

        return array;
    }

    /**
     * Método que ordena um array de instituição com RadixSort
     * @param array - array de instituições que será ordenado
     */
    // Radix Sort
    public int[] radixsort(int[] array){
        /* Encontra o menor elemento do array */
        int m = maior(array);

        /* Faz um counting sort para cada digito */
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            array = countSort(array, exp);

        return array;
    }

    public int maior(int[] array){
        int maior = array[0];

        for (int n : array) {
            if(n > maior)
                maior = n;
        }

        return maior;
    }

}