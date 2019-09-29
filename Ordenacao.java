import java.util.Scanner;
import java.util.Random;

public class Ordenacao{
    private int tipoAlgoritmo;
    private int quantidadeDeDados;
    private int[] array;

    public Ordenacao(int tipoAlgoritmo, int quantidadeDeDados){
        this.tipoAlgoritmo = tipoAlgoritmo;
        this.quantidadeDeDados = quantidadeDeDados;

        this.array = new int[this.quantidadeDeDados];
        geraArrayAleatorio();
    }

    public void geraArrayAleatorio(){
        Random random = new Random();

        for(int i=0; i < this.array.length; i++){
            array[i] = random.nextInt(this.quantidadeDeDados);
        }
        
        System.out.println("Array gerado");
        printArray();
    }

    public void printArray(){
        for (int var : this.array) {
            System.out.print(var + " ");
        }
        System.out.println("\n\n");
    }
    /**
     * Método que irá ordenar o vetor de acordo com o tipo de algoritmo 
     * passado no construtor
     */
    public void ordenar(){
        switch(this.tipoAlgoritmo){
            case 1: insercao(); break;

            case 2: selecao(); break;

            case 3: shellsort(); break;

            case 4: heapsort(); break;

            case 5: quicksort(); break;

            case 6: bubblesort(); break;

            case 7: mergesort(); break;

            case 8: radixsort(); break;

            default: System.out.println("ERRO NO PROCESSAMENTO"); break;
        }
    }

    public void insercao(){
        Insercao insercao = new Insercao();
        
        this.array = insercao.insercao(this.array);

        System.out.println("Array ordenado pelo algoritmo Inserção");
        printArray();
    }

    public void selecao(){
        Selecao selecao = new Selecao();
        
        this.array = selecao.selecao(this.array);

        System.out.println("Array ordenado pelo algoritmo Seleção");
        printArray();
    }

    public void quicksort(){
        Quicksort quicksort = new Quicksort();
        
        this.array = quicksort.quicksort(this.array);

        System.out.println("Array ordenado pelo algoritmo Quicksort");
        printArray();
    }

    public void shellsort(){
        Shellsort shellsort = new Shellsort();
        
        this.array = shellsort.shellsort(this.array);

        System.out.println("Array ordenado pelo algoritmo shellsort");
        printArray();
    }

    public void heapsort(){
        Heapsort heapsort = new Heapsort();
        
        this.array = heapsort.heapsort(this.array);

        System.out.println("Array ordenado pelo algoritmo heapsort");
        printArray();
    }

    public void bubblesort(){
        Bubblesort bubblesort = new Bubblesort();
        
        this.array = bubblesort.bubblesort(this.array);

        System.out.println("Array ordenado pelo algoritmo bubble sort");
        printArray();
    }

    public void mergesort(){
        Mergesort mergesort = new Mergesort();
        
        this.array = mergesort.mergesort(this.array);

        System.out.println("Array ordenado pelo algoritmo merge sort");
        printArray();
    }

    public void radixsort(){
        Radixsort radixsort = new Radixsort();
        
        this.array = radixsort.radixsort(this.array);

        System.out.println("Array ordenado pelo algoritmo radix sort");
        printArray();
    }
}