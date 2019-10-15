package algoritmos;

/**
 * Classe que implementada o algoritmo de ordenação seleção
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */

public class Shellsort  implements AlgoritmoDeOrdenacao{
    /**
     * Algoritmo de ordenacao Shellsort.
     */
    public <DADO extends Comparable<DADO>> DADO[] shellsort(DADO[] array) {
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
     * @param cor cor do pseudo array.
     * @param h passo do shelsort
     * @return DADO[] array ordenado
     */
    public <DADO extends Comparable<DADO>> DADO[] insercaoPorCor(int cor, int h, DADO[] array){
        for (int i = (h + cor); i < array.length; i+=h) {
            DADO tmp = array[i];
            int j = i - h;
            while ((j >= 0) && tmp.compareTo(array[j]) < 0){
                array[j + h] = array[j];
                j-=h;
            }
            array[j + h] = tmp;
        }

        return array;
    }


    @Override
    public <DADO extends Comparable<DADO>> void ordenar(DADO[] array)
    {
        shellsort(array);
    }
}