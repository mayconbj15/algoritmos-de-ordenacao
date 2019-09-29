/**
 * Classe que implementada o algoritmo de ordenação inserção
 * Implementação para inteiros e para a classe Instituição
 * @author Maycon Bruno de Jesus
 */
public class Insercao{
    /*public void insercao() {
        for (int i = 1; i < n; i++) {
			Instituicao tmp = instituicoes[i]; 
            int j = i - 1;

         while ((j >= 0) && (instituicoes[j].getCodigoMantenedora() > tmp.getCodigoMantenedora())) {
            instituicoes[j + 1] = instituicoes[j];
            j--;
         }
         instituicoes[j + 1] = tmp;
      }
    }*/

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
     