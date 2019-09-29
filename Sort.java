import java.util.Scanner;

public class Sort{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int tipoAlgoritmo;
        int quantidadeDeDados;
        int tipoEntrada;

        System.out.println("BEM VINDO AO MUNDO DA ORDENAÇÃO\n" + 
                            "AQUI VOCÊ TERA MUITOS ALGORITMOS DE ORDENAÇÃO PARA ESCOLHER\n\n");
                            
        System.out.println("Qual algoritmo deseja usar?\n");
        System.out.println("1 - Inserção\n" + 
                            "2 - Seleção\n" +
                            "3 - Shellsort\n" + 
                            "4 - Heapsort\n" + 
                            "5 - Quicksort\n" +
                            "6 - Counting sort\n" +
                            "7 - Bubble sort" +
                            "8 - Merge sort\n" +
                            "9 - Radix sort\n");
        tipoAlgoritmo = input.nextInt();

        System.out.println("Como deseja gerar os dados?\n");
        System.out.println( "1 - Aleatório\n" +  
                            "2 - Inseridos um a um\n");
        tipoEntrada = input.nextInt();

        System.out.println("Quantos dados deseja que seu vetor tenha?\n");
        quantidadeDeDados = input.nextInt();

        Ordenacao ordenacao = new Ordenacao(tipoAlgoritmo, quantidadeDeDados);
        ordenacao.ordenar();

        input.close();
    }
}