package algoritmos;

/**
 * Classe que implementada o algoritmo de ordenação bubble sort
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */

public class Mergesort<DADO extends Comparable<DADO>> implements AlgoritmoDeOrdenacao<DADO> {
    /**
     * Concatena um array de instituição em dois subarray de instituições
     * @param array array que irá geras os dois subarrays
     * @param l - valor do lado esquerdo do array de instituição 
     * @param m - meio do array de instituição
     * @param r - valor do lado direito do array de instituição 
     */
    private int[] merge(int array[], int l, int m, int r){ 
        /* Encontra o tamanho dos array que serão concatenados */
        int n1 = m - l + 1; //tamanho do array da esquerda
        int n2 = r - m; //tamanho do array da direita
  
        /* Cria array temporários */
        int[] L = new int[n1]; 
        int[] R = new int[n2]; 
  
        /* Copia os dados para os array temporários */
        for (int i=0; i<n1; ++i) 
            L[i] = array[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = array[m + 1+ j]; 
  
  
        /* Concatena os array secundários */
  
        // Posiçoes iniciais do primeiro e segundo subarray 
        int i = 0, j = 0; 
  
        // Posição inicial do array que será concatenado
        int k = l; 
        while (i < n1 && j < n2){ 
            if (L[i] < R[j]){ 
                array[k] = L[i]; 
                i++; 
            } 
            else
            { 
                array[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copia os elementos restantes do array L[], se existir */
        while (i < n1){ 
            array[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copia os elementos restantes do array R[], se existir */
        while (j < n2){ 
            array[k] = R[j]; 
            j++; 
            k++; 
        } 

        return array;
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    private int[] mergesortRec(int array[], int l, int r) { 
        if (l < r){ 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            mergesortRec(array, l, m); 
            mergesortRec(array , m+1, r); 
  
            // Merge the sorted halves 
            merge(array, l, m, r); 
        } 
        
        return array;
    }
    
    public int[] mergesort(int[] array){
       return mergesortRec(array,0,array.length-1); 
    }
}