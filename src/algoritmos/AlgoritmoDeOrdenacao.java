package algoritmos;

import java.util.Arrays;

public interface AlgoritmoDeOrdenacao
{
    <DADO extends Comparable<DADO>> void ordenar(DADO[] array);

    default int[] ordenar(int[] array)
    {
        // Cria um fluxo de ints embrulhados como Integer e cria um Integer[] disso.
        Integer[] newArray = Arrays.stream(array).boxed().toArray(Integer[]::new);
        ordenar(newArray);

        // Cria um fluxo de Integers e mapeia-os para int chamando o método
        // intValue de cada um. Gera um int[] disso.
        int[] sortedArray =
            Arrays.stream(newArray).mapToInt(Integer::intValue).toArray();

        return sortedArray;
    }

    default char[] ordenar(char[] array)
    {
        int[] newArray = new int[array.length];
        char[] newSortedArray = new char[array.length];

        for (int i = 0; i < array.length; i++) newArray[i] = array[i];

        int[] sortedArray = ordenar(newArray);

        for (int i = 0; i < array.length; i++)
            newSortedArray[i] = (char) sortedArray[i];

        return newSortedArray;
    }

    default byte[] ordenar(byte[] array)
    {
        int[] newArray = new int[array.length];
        byte[] newSortedArray = new byte[array.length];

        for (int i = 0; i < array.length; i++) newArray[i] = array[i];

        int[] sortedArray = ordenar(newArray);

        for (int i = 0; i < array.length; i++)
            newSortedArray[i] = (byte) sortedArray[i];

        return newSortedArray;
    }

    default short[] ordenar(short[] array)
    {
        int[] newArray = new int[array.length];
        short[] newSortedArray = new short[array.length];

        for (int i = 0; i < array.length; i++) newArray[i] = array[i];

        int[] sortedArray = ordenar(newArray);

        for (int i = 0; i < array.length; i++)
            newSortedArray[i] = (short) sortedArray[i];

        return newSortedArray;
    }

    default long[] ordenar(long[] array)
    {
        // Cria um fluxo de longs embrulhados como Long e cria um Long[] disso.
        Long[] newArray = Arrays.stream(array).boxed().toArray(Long[]::new);
        ordenar(newArray);

        // Cria um fluxo de Longs e mapeia-os para long chamando o método
        // longValue de cada um. Gera um long[] disso.
        long[] sortedArray =
            Arrays.stream(newArray).mapToLong(Long::longValue).toArray();

        return sortedArray;
    }

    default double[] ordenar(double[] array)
    {
        // Cria um fluxo de doubles embrulhados como Double e cria um Double[] disso.
        Double[] newArray = Arrays.stream(array).boxed().toArray(Double[]::new);
        ordenar(newArray);

        // Cria um fluxo de Doubles e mapeia-os para double chamando o método
        // doubleValue de cada um. Gera um double[] disso.
        double[] sortedArray =
            Arrays.stream(newArray).mapToDouble(Double::doubleValue).toArray();

        return sortedArray;
    }

    default float[] ordenar(float[] array)
    {
        Float[] newArray = new Float[array.length];
        float[] newSortedArray = new float[array.length];

        for (int i = 0; i < array.length; i++) newArray[i] = array[i];

        ordenar(newArray);

        for (int i = 0; i < array.length; i++)
            newSortedArray[i] = newArray[i];

        return newSortedArray;
    }

    // Todos os métodos abaixo evitam converter para int[] para depois ordenar.
    // Eles priorizam a conversão para o tipo wrapper correspondente.
    // (Ex.: byte -> Byte) e então passa o wrapper[] para o ordenar geral.
    // O problema disso é que o Radixsort deixaria de poder ordenar arranjos
    // do tipo char[] byte[] e short[].

    /*default byte[] ordenar(byte[] array)
    {
        Byte[] newArray = new Byte[array.length];
        byte[] sortedArray = new byte[array.length];

        for (int i = 0; i < array.length; i++) newArray[i] = array[i];

        ordenar(newArray);

        for (int i = 0; i < array.length; i++)
            sortedArray[i] = newArray[i];

        return sortedArray;
    }

    default short[] ordenar(short[] array)
    {
        Short[] newArray = new Short[array.length];
        short[] sortedArray = new short[array.length];

        for (int i = 0; i < array.length; i++) newArray[i] = array[i];

        ordenar(newArray);

        for (int i = 0; i < array.length; i++)
            sortedArray[i] = newArray[i];

        return sortedArray;
    }

    default int[] ordenar(int[] array)
    {
        // Cria um fluxo de ints embrulhados como Integer e cria um Integer[] disso.
        Integer[] newArray = Arrays.stream(array).boxed().toArray(Integer[]::new);
        ordenar(newArray);

        // Cria um fluxo de Integers e mapeia-os para int chamando o método
        // intValue de cada um. Gera um int[] disso.
        int[] sortedArray =
            Arrays.stream(newArray).mapToInt(Integer::intValue).toArray();

        return sortedArray;
    }

    default long[] ordenar(long[] array)
    {
        // Cria um fluxo de longs embrulhados como Long e cria um Long[] disso.
        Long[] newArray = Arrays.stream(array).boxed().toArray(Long[]::new);
        ordenar(newArray);

        // Cria um fluxo de Longs e mapeia-os para long chamando o método
        // longValue de cada um. Gera um long[] disso.
        long[] sortedArray =
            Arrays.stream(newArray).mapToLong(Long::longValue).toArray();

        return sortedArray;
    }

    default float[] ordenar(float[] array)
    {
        Float[] newArray = new Float[array.length];
        float[] sortedArray = new float[array.length];

        for (int i = 0; i < array.length; i++) newArray[i] = array[i];

        ordenar(newArray);

        for (int i = 0; i < array.length; i++)
            sortedArray[i] = newArray[i];

        return sortedArray;
    }

    default double[] ordenar(double[] array)
    {
        // Cria um fluxo de doubles embrulhados como Double e cria um Double[] disso.
        Double[] newArray = Arrays.stream(array).boxed().toArray(Double[]::new);
        ordenar(newArray);

        // Cria um fluxo de Doubles e mapeia-os para double chamando o método
        // doubleValue de cada um. Gera um double[] disso.
        double[] sortedArray =
            Arrays.stream(newArray).mapToDouble(Double::doubleValue).toArray();

        return sortedArray;
    }*/
}
