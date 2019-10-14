package algoritmos;

/**
 * Classe que implementada o algoritmo de ordenação bubble sort
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 * @author Axell Brendow ( https://github.com/axell-brendow )
 */

public class Bubblesort<DADO extends Comparable<DADO>> implements AlgoritmoDeOrdenacao<DADO> {
    public DADO[] bubblesort(DADO[] array){
        return bubblesort(array.length, array);
    }
    
    public DADO[] bubblesort(int tam, DADO[] array){
        if(tam > 0){
            for(int i=0; i < array.length-1; i++){
                if(array[i+1].compareTo(array[i]) < 0){
                    swap(i+1, i, array);
                }
            }
            bubblesort(tam-1, array);
        }

        return array;
    }

    public void swap(int i, int j, DADO[] array) {
        DADO temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public void ordenar(DADO[] array)
    {
        bubblesort(array);
    }
}
