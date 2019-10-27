package algoritmos;

import java.util.ArrayList;

/**
 * Classe que implementada o algoritmo de ordenação seleção
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */


public class QuicksortIterativo  implements AlgoritmoDeOrdenacao{
	
	/**
	 * Classe para guardar os valores relacionados a uma partição do Quicksort:
	 * i, j, esq, dir
	 */
	class Particao
	{
		public int i, j, esq, dir;
		/**
		 * Essa variável indicará quantas partições filhas foram feitas.
		 * Cada partição tem no máximo duas filhas, esquerda e direita.
		 */
		int particoesFilhas;
		
		public Particao(int i, int j, int esq, int dir, int particoesFilhas)
		{
			this.i = i;
			this.j = j;
			this.esq = esq;
			this.dir = dir;
			this.particoesFilhas = particoesFilhas;
		}
		
		public Particao(int esq, int dir) { this(-1, -1, esq, dir, 0); }
	}
	
    /**
     * Algoritmo de ordenacao Quicksort.
     */
    public <DADO extends Comparable<DADO>> DADO[] quicksort(DADO[] array) {
        return quicksortIterativo(0, array.length-1, array);
    }

    /**
     * Algoritmo de ordenacao Quicksort de acordo com o nome.
     * @param esq inicio do array a ser ordenado
     * @param dir fim do array a ser ordenado
     */
    private <DADO extends Comparable<DADO>> DADO[] quicksortIterativo(int esq, int dir, DADO[] array) {
        
    	ArrayList<Particao> stack = new ArrayList<>();
    	// Trocar a variável particao é equivalente a uma chamada recursiva pois
    	// o quicksort sempre estará particionando a partição dessa variável
    	Particao particao = new Particao(esq, dir);
    	
    	do
    	{
            // Checa se a participação não tem filhas à esquerda nem à direita
        	if (particao.particoesFilhas == 0)
            {
                quicksortIterativo(particao, array); // Particiona de esq a dir com base no pivo
                stack.add(particao); // Adiciona a partição na pilha
            }
        	
            if (particao.particoesFilhas == 0 && particao.esq < particao.j) {
            	particao = new Particao(particao.esq, particao.j);
            	continue;
            }
            
            if (particao.particoesFilhas <= 1 && particao.i < particao.dir) {
            	particao = new Particao(particao.i, particao.dir);
            	continue;
            }
            
            stack.remove(stack.size() - 1); // Remove a última partição da pilha
            
            if (!stack.isEmpty())
            {
            	particao = stack.get(stack.size() - 1); // Obtém a partição do topo
            	// Uma partição é recuperada do topo quando a "recursividade"
            	// volta nela. Isso significa que uma partição filha foi ordenada.
            	particao.particoesFilhas++;
            }
            
    	} while (!stack.isEmpty());

        return array;
    }

    /**
     * Faz o particionamento da partição recebida.
     * 
     * @param particao Objeto com o estado da partição atual.
     * @param array Arranjo a ser ordenado.
     */
    private <DADO extends Comparable<DADO>> void quicksortIterativo(Particao particao, DADO[] array) {
        int i = particao.esq, j = particao.dir;
        DADO pivo = array[(particao.dir + particao.esq)/2]; //pega a posição do pivo

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
        
        particao.i = i;
        particao.j = j;
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