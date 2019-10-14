package algoritmos;

/**
 * Classe que implementada o algoritmo de ordenação seleção
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */

public class Shellsort<DADO extends Comparable<DADO>> implements AlgoritmoDeOrdenacao<DADO> {
    /**
    * Algoritmo de ordenacao Shellsort.
    */
    public int[] shellsort(int[] array) {
        int h = 1; //valor que irá dar o salto para ir ordenando por partes 

        do { 
            h = (h * 3) + 1; //sequência do Knuth 
        } while (h < array.length);

        do {
            h /= 3; //volta o h para ficar dentro do tamanho do array
            for(int cor = 0; cor < h; cor++){
                array = insercaoPorCor(cor, h, array);
            }
        } while (h != 1);
        
        return array;
    }


    /**
     * Metodo que efetua a insercao nos pseudo-arrays do Shellsort.
    * @param int cor cor do pseudo array.
    * @param int h passo do shelsort
    * @return int[] array ordenado
    */
    public int[] insercaoPorCor(int cor, int h, int[] array){
        for (int i = (h + cor); i < array.length; i+=h) {
            int tmp = array[i];
            int j = i - h;
            while ((j >= 0) && tmp < array[j]){ //se a instituiao tmp for menor que a instituição j
                array[j + h] = array[j];
                j-=h;
            }
            array[j + h] = tmp;
        }

        return array;
    }
    
    
}