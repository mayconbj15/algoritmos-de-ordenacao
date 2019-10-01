package ordenacao.algoritmos;

/**
 * Classe que implementada o algoritmo de ordenação seleção
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */


public class Quicksort{
    /**
	 * Algoritmo de ordenacao Quicksort.
	 */
	public int[] quicksort(int[] array) {
        return quicksort(0, array.length-1, array);
     }
  
      /**
       * Algoritmo de ordenacao Quicksort de acordo com o nome.
      * @param int esq inicio do array a ser ordenado
      * @param int dir fim do array a ser ordenado
       */
    private int[] quicksort(int esq, int dir, int[] array) {
        int i = esq, j = dir;
        int pivo = array[(dir+esq)/2]; //pega a posição do pivo
        
        while (i <= j) {
            while (array[i] < pivo){
            i++;
            } 
            
            while (array[j] > pivo ){
            j--;
            } 

            if (i <= j) {
                swap(i, j, array);
                i++;
                j--;
            }
        }
        if (esq < j) {
        array = quicksort(esq, j, array);
        } 
        if (i < dir) {
        array = quicksort(i, dir, array);
        } 

        return array;
    }

    public void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}