package algoritmos;

/**
 * Classe que implementada o algoritmo de ordenação seleção
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */

public class Selecao  implements AlgoritmoDeOrdenacao{
    /**
    * Algoritmo de ordenacao por seleção para um array de inteiros
    */
    public <DADO extends Comparable<DADO>> DADO[] selecao(DADO[] array) {
        for (int i = 0; i < (array.length - 1); i++) {
           int menor = i;
           for (int j = (i + 1); j < array.length; j++){ //procura o menor elemento do array
              if (array[menor].compareTo(array[j]) > 0){
                 menor = j;
              }
           }
           swap(menor, i, array);
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
        selecao(array);
    }
}