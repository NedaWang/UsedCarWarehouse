import java.io.*;
import java.util.*;

/**
 * The IOManager class takes responsible for I/O manage.
 * 
 * @author (Miao Wang) 
 * @version (2.1)
 */
public class IOManager
{
    private FileReader reader;
    private Scanner scanner;
    private PrintWriter writer;

    /**
     * Constructor of the IOManager class.
     */
    public IOManager() throws IOException
    {
        reader = new FileReader("usedcars.txt");
        scanner = new Scanner(reader);
    }

    /**
     * Close The input streams.
     */
    public void closeInputStream()
    {
        try
        {
            scanner.close();
            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("IOException in closeStream of IOManager");
            System.out.println();
        }
    }

    /**
     * Close The output stream.
     */
    public void closeOutputStream()
    {
        writer.close();
    }

    /**
     * Get the scanner which used to read from the aimed file.
     * 
     * @return the scanner
     */
    public Scanner getScanner()
    {
        return scanner;
    }

    /**
     * Get the printwriter which used to write to the aimed file.
     * 
     * @return the printwriter
     */
    public PrintWriter getWriter() throws IOException
    {
        writer = new PrintWriter("usedcars.txt");
        return writer;
    }

}
