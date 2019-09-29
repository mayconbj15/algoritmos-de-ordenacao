/**
 * Classe que implementada o algoritmo de ordenação heapsort
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */

public class Heapsort{
    public int[] heapsort(int[] array) {
        //Alterar o vetor ignorando a posicao zero
        int[] tmp = new int[array.length+1];
        for(int i = 0; i < array.length; i++){
            tmp[i+1] = array[i];
        }
        array = tmp;

        //Contrucao do heap
        for(int tamHeap = 2; tamHeap < array.length; tamHeap++){
            array = constroi(tamHeap, array);
        }

        //Ordenacao propriamente dita
        int tamHeap = array.length-1;
        while(tamHeap > 1){
            swap(1, tamHeap--, array);
            array = reconstroi(tamHeap, array);
        }

        //Alterar o vetor para voltar a posicao zero
        tmp = array;
        array = new int[array.length-1];
        for(int i = 0; i < array.length; i++){
            array[i] = tmp[i+1];
        }

        return array;
    } //fim de heapsort

    public int[] constroi(int tamHeap, int[] tmp){
        for(int i = tamHeap; i > 1 && tmp[i] > tmp[i/2]; i /= 2){
            swap(i, i/2, tmp);
        }

        return tmp;
    }
  
    public int[] reconstroi(int tamHeap, int[] array){
        int i = 1, filho;
        
        while(i <= (tamHeap/2)){
            if (array[2*i] > array[2*i+1] || 2*i == tamHeap){
                filho = 2*i;
            } else {
                filho = 2*i + 1;
            }
  
            if(array[i] < array[filho]){
                swap(i, filho, array);
                i = filho;
            }else{
                i = tamHeap;
            }
        }
        
        return array;
    }

    public void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}