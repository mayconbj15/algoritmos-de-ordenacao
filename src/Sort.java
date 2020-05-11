import algoritmos.*;

import java.util.Scanner;

public class Sort{
    public static boolean print = true;

    public static AlgoritmoDeOrdenacao[] algoritmos = new AlgoritmoDeOrdenacao[]{
        new Insercao(),
        new Selecao(),
        new Shellsort(),
        new Heapsort(),
        new QuicksortRecursivo(),
        new QuicksortIterativo(),
        new Bubblesort(),
        new Mergesort(),
        new Radixsort(),
    };

    public static void lerArgumentos(String[] args)
    {
        for (int i = 0; i < args.length; i++)
        {
            if (args[i].equals("--noprint")) print = false;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int tipoAlgoritmo;
        int quantidadeDeDados;
        int tipoEntrada;

        lerArgumentos(args);

        System.out.println("BEM VINDO AO MUNDO DA ORDENAÇÃO\n" + 
                            "AQUI VOCÊ TERA MUITOS ALGORITMOS DE ORDENAÇÃO PARA ESCOLHER\n\n");
                            
        System.out.println("Qual algoritmo deseja usar?\n");
        System.out.println("1 - Inserção\n" + 
                            "2 - Seleção\n" +
                            "3 - Shellsort\n" + 
                            "4 - Heapsort\n" + 
                            "5 - Quicksort Recursivo\n" +
                            "6 - Quicksort Iterativo\n" +                           
                            "7 - Bubble sort\n" +
                            "8 - Merge sort\n" +
                            "9 - Radix sort\n");
        tipoAlgoritmo = input.nextInt();

        System.out.println("Como deseja gerar os dados?\n");
        System.out.println( "1 - Aleatório\n" +
                            "2 - Inseridos um a um\n");
        tipoEntrada = input.nextInt();

        System.out.println("Quantos dados deseja que seu vetor tenha?\n");
        quantidadeDeDados = input.nextInt();

        Ordenacao ordenacao = new Ordenacao(
            algoritmos[tipoAlgoritmo - 1], quantidadeDeDados, tipoEntrada);

        ordenacao.ordenar();

        input.close();
    }
}
