package ordenacao.algoritmos;

/**
 * Classe que implementada o algoritmo de ordenação inserção
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */

public class Insercao{
    public int[] insercao(int[] array){
        for (int i = 1; i < array.length; i++) {
			int tmp = array[i]; 
            int j = i - 1;

            while ((j >= 0) && (array[j] > tmp)) {
                array[j + 1] = array[j];
                j--;
            }
        
        array[j + 1] = tmp;
        }
        
        return array;
    }
}
     