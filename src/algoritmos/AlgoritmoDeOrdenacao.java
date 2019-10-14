package algoritmos;

public interface AlgoritmoDeOrdenacao<DADO extends Comparable<DADO>>
{
    void ordenar(DADO[] array);
}
