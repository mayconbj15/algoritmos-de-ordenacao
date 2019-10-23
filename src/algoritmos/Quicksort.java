package algoritmos;

import java.util.ArrayList;

/**
 * Classe que implementada o algoritmo de ordenação seleção
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */


public class Quicksort  implements AlgoritmoDeOrdenacao{
	
	class Status<DADO extends Comparable<DADO>>
	{
		public int i, j, esq, dir;
		/**
		 * Essa variável
		 */
		int particoes;
		
		public Status(int i, int j, int esq, int dir, int particoes)
		{
			this.i = i;
			this.j = j;
			this.esq = esq;
			this.dir = dir;
			this.particoes = particoes;
		}
		
		public Status(int esq, int dir) { this(-1, -1, esq, dir, 0); }
	}
	
    /**
     * Algoritmo de ordenacao Quicksort.
     */
    public <DADO extends Comparable<DADO>> DADO[] quicksort(DADO[] array) {
        return quicksort(0, array.length-1, array);
    }

    /**
     * Algoritmo de ordenacao Quicksort de acordo com o nome.
     * @param esq inicio do array a ser ordenado
     * @param dir fim do array a ser ordenado
     */
    private <DADO extends Comparable<DADO>> DADO[] quicksort(int esq, int dir, DADO[] array) {
        
    	ArrayList<Status<DADO>> stack = new ArrayList<>();
    	// Trocar a variável status é equivalente a uma chamada recursiva pois
    	// o quicksort sempre estará particionando a partição do status
    	Status<DADO> status = new Status<>(esq, dir);
    	// Entrada problemática: 2 3 3 1 3
    	do
    	{
        	quicksort(status, array); // Particiona de esq a dir com base no pivo
        	// Adiciona as variáveis da partição na pilha caso essa
        	// participação não tenha filhas à esquerda nem à direita
        	if (status.particoes == 0) stack.add(status);
        	
            if (status.particoes == 0 && status.esq < status.j) {
            	status = new Status<>(status.esq, status.j);
            	continue;
            }
            
            status.particoes++;
            
            if (status.particoes == 1 && status.i < status.dir) {
            	status = new Status<>(status.i, status.dir);
            	continue;
            }
            
            status.particoes++;
            stack.remove(stack.size() - 1); // Remove o último status da pilha
            
            // Obtém o status no topo
            if (!stack.isEmpty()) status = stack.get(stack.size() - 1);
            
    	} while (!stack.isEmpty());

        return array;
    }

    /**
     * Faz o particionamento da parte indica no status.
     * 
     * @param status Objeto com o estado da partição atual.
     * @param array Arranjo a ser ordenado.
     */
    private <DADO extends Comparable<DADO>> void quicksort(Status<DADO> status, DADO[] array) {
        int i = status.esq, j = status.dir;
        DADO pivo = array[(status.dir + status.esq)/2]; //pega a posição do pivo

        while (i <= j) {
            while (array[i].compareTo(pivo) < 0){
                i++;
            }

            while (array[j].compareTo(pivo) > 0){
                j--;
            }

            if (i <= j) {
                swap(i, j, array);
                i++;
                j--;
            }
        }
        
        status.i = i;
        status.j = j;
    }

    public <DADO extends Comparable<DADO>> void swap(int i, int j, DADO[] array) {
        DADO temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public <DADO extends Comparable<DADO>> void ordenar(DADO[] array)
    {
        quicksort(array);
    }
}