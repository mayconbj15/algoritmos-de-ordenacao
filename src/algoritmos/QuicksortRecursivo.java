package algoritmos;

/**
 * Classe que implementada o algoritmo de ordenação seleção
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */


public class QuicksortRecursivo  implements AlgoritmoDeOrdenacao{
	
    /**
     * Algoritmo de ordenacao Quicksort.
     */
    public <DADO extends Comparable<DADO>> DADO[] quicksort(DADO[] array) {
        return quicksortRecursivo(0, array.length-1, array);
    }

    /**
     * Algoritmo de ordenacao Quicksort de acordo com o nome.
     * @param esq inicio do array a ser ordenado
     * @param dir fim do array a ser ordenado
     */
    private <DADO extends Comparable<DADO>> DADO[] quicksortRecursivo(int esq, int dir, DADO[] array) {
        int i = esq, j = dir;
        DADO pivo = array[(dir+esq)/2]; //pega a posição do pivo

        while (i <= j) {
            while (array[i].compareTo(pivo) < 0){
                i++;
            }

            while (array[j].compareTo(pivo) > 0){
                j--;
            }

            if (i <= j) {
                swap(i, j, array);
                i++;
                j--;
            }
        }
        if (esq < j) {
            array = quicksortRecursivo(esq, j, array);
        }
        if (i < dir) {
            array = quicksortRecursivo(i, dir, array);
        }

        return array;
    }

    public <DADO extends Comparable<DADO>> void swap(int i, int j, DADO[] array) {
        DADO temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public <DADO extends Comparable<DADO>> void ordenar(DADO[] array)
    {
        quicksort(array);
    }
}