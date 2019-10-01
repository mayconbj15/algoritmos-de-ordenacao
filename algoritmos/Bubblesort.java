package ordenacao.algoritmos;

/**
 * Classe que implementada o algoritmo de ordenação bubble sort
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */

public class Bubblesort{
    public int[] bubblesort(int[] array){
        return bubblesort(array.length, array);
    }
    
    public int[] bubblesort(int tam, int[] array){
        if(tam > 0){
            for(int i=0; i < array.length-1; i++){
                if(array[i+1] < array[i]){
                    swap(i+1, i, array);
                }
            }
            bubblesort(tam-1, array);
        }
        
        return array;
    }

    public void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}