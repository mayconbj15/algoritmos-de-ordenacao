package algoritmos;

/**
 * Classe que implementada o algoritmo de ordenação inserção
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */

public class Insercao  implements AlgoritmoDeOrdenacao{
    public <DADO extends Comparable<DADO>> DADO[] insercao(DADO[] array){
        for (int i = 1; i < array.length; i++) {
			DADO tmp = array[i];
            int j = i - 1;

            while ((j >= 0) && (array[j].compareTo(tmp) > 0)) {
                array[j + 1] = array[j];
                j--;
            }
        
            array[j + 1] = tmp;
        }
        
        return array;
    }

    @Override
    public <DADO extends Comparable<DADO>> void ordenar(DADO[] array)
    {
        insercao(array);
    }
}
