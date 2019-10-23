import java.util.Random;

import algoritmos.*;

public class Ordenacao
{
    private AlgoritmoDeOrdenacao algoritmo;
    private String nomeAlgoritmo;
    private int quantidadeDeDados;
    private int tipoEntrada;
    private int[] array;

    public Ordenacao(
        AlgoritmoDeOrdenacao algoritmo, int quantidadeDeDados, int tipoEntrada)
    {
        this.algoritmo = algoritmo;
        this.nomeAlgoritmo = algoritmo.getClass().getSimpleName();
        setQuantidadeDeDados(quantidadeDeDados);
        this.tipoEntrada = tipoEntrada;
        lerDados();
    }

    private void setQuantidadeDeDados(int quantidadeDeDados)
    {
        this.quantidadeDeDados = quantidadeDeDados;
        this.array = new int[quantidadeDeDados];
    }

    private void lerDados()
    {
        switch (tipoEntrada)
        {
            case 1:
                geraArrayAleatorio();
                break;

            case 2:
                lerArray();
                break;

            default:
                IO.printlnerr("Tipo de entrada inválido.");
                break;
        }
    }

    public void geraArrayAleatorio()
    {
        Random random = new Random();

        for(int i=0; i < this.array.length; i++){
            array[i] = random.nextInt(this.quantidadeDeDados);
        }

        if (Sort.print)
        {
            System.out.println("\nArray gerado");
            printArray();
        }
    }

    private void lerArray()
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = IO.scanint(
                "Informe o " + (i + 1) + "º número inteiro: ",
                "Entrada inválida\n\n");
        }

        if (Sort.print)
        {
            System.out.println("\nArray gerado");
            printArray();
        }
    }

    public void printArray()
    {
        if (Sort.print)
        {
            for (int var : this.array)
            {
                System.out.print(var + " ");
            }
            System.out.println("\n\n");
        }
    }

    private static long medirTempo(Runnable funcao)
    {
        long start = System.currentTimeMillis();
        funcao.run();
        return System.currentTimeMillis() - start;
    }

    /**
     * Método que irá ordenar o vetor de acordo com o tipo de algoritmo 
     * passado no construtor
     */
    public void ordenar(){
        long tempo = medirTempo( () -> array = algoritmo.ordenar(array) );

        System.out.println(
            "Array ordenado pelo algoritmo " + nomeAlgoritmo + " (" + tempo + "ms)");

        printArray();
    }
}
