/**
 * Classe que implementada o algoritmo de ordenação seleção
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */

public class Selecao{
    /**
    * Algoritmo de ordenacao por seleção para um array de inteiros
    */
    public int[] selecao(int[] array) {
        for (int i = 0; i < (array.length - 1); i++) {
           int menor = i;
           for (int j = (i + 1); j < array.length; j++){ //procura o menor elemento do array
              if (array[menor] > array[j]){
                 menor = j;
              }
           }
           swap(menor, i, array);
        }

        return array;
     }

    public void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}