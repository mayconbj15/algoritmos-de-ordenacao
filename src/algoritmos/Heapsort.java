package algoritmos;

/**
 * Classe que implementada o algoritmo de ordenação heapsort
 * Implementação para inteiros
 * @author Maycon Bruno de Jesus
 */

public class Heapsort implements AlgoritmoDeOrdenacao{
    public <DADO extends Comparable<DADO>> DADO[] heapsort(DADO[] array) {
        //Alterar o vetor ignorando a posicao zero
        DADO[] tmp = (DADO[]) new Comparable[array.length+1];
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
        array = (DADO[]) new Comparable[array.length-1];
        for(int i = 0; i < array.length; i++){
            array[i] = tmp[i+1];
        }

        return array;
    } //fim de heapsort

    public <DADO extends Comparable<DADO>> DADO[] constroi(int tamHeap, DADO[] tmp){
        for(int i = tamHeap; i > 1 && tmp[i].compareTo(tmp[i/2]) > 0; i /= 2){
            swap(i, i/2, tmp);
        }

        return tmp;
    }
  
    public <DADO extends Comparable<DADO>> DADO[] reconstroi(int tamHeap, DADO[] array){
        int i = 1, filho;
        
        while(i <= (tamHeap/2)){
            if (array[2*i].compareTo(array[2*i+1]) > 0 || 2*i == tamHeap){
                filho = 2*i;
            } else {
                filho = 2*i + 1;
            }
  
            if(array[i].compareTo(array[filho]) < 0){
                swap(i, filho, array);
                i = filho;
            }else{
                i = tamHeap;
            }
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
        DADO[] dados = heapsort(array);

        System.arraycopy(dados, 0, array, 0, array.length);
    }
}