import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO
{
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static boolean inputError;

    public static boolean hasError() { return inputError; }

    public static void print(Object msg) { System.out.print(msg); }

    public static void printlnerr(Object msg) { System.err.println(msg); }

    public static String readLine()
    {
        String line = null;

        try
        {
            line = reader.readLine();
            inputError = false;
        }

        catch (IOException e)
        {
            inputError = true;
            e.printStackTrace();
        }

        return line;
    }

    public static String readLine(Object msg)
    {
        print(msg);
        return readLine();
    }

    public static int readint()
    {
        int value = Integer.MIN_VALUE;

        try
        {
            value = Integer.parseInt(readLine());
            inputError = false;
        }

        catch (NumberFormatException e)
        {
            inputError = true;
//            e.printStackTrace();
        }

        return value;
    }

    public static int readint(Object msg)
    {
        print(msg);
        return readint();
    }

    public static int readint(Object msg, Object errorMsg)
    {
        int value;

        do
        {
            value = readint(msg);

            if (hasError()) print(errorMsg);

        } while (hasError());

        return value;
    }
}
