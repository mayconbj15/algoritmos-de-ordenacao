package algoritmos;

/**
 * Classe que implementada o algoritmo de ordenação bubble sort
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */

public class Bubblesort  implements AlgoritmoDeOrdenacao{
    public <DADO extends Comparable<DADO>> DADO[] bubblesort(DADO[] array){
        return bubblesort(array.length, array);
    }
    
    public <DADO extends Comparable<DADO>> DADO[] bubblesort(int tam, DADO[] array){
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

    public <DADO extends Comparable<DADO>> void swap(int i, int j, DADO[] array) {
        DADO temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public <DADO extends Comparable<DADO>> void ordenar(DADO[] array)
    {
        bubblesort(array);
    }
}
