import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputf = null;
        PrintWriter outputf = null;
        int numNodes=0;
        //case: input file and/or output file missing
        if (args.length<2){
            System.out.println("PLEASE SPECIFY THE ARGUMENTS: INPUT FILE , OUTPUT FILE!");
            System.exit(1);
        }
        try {
            inputf = new Scanner(new FileReader(args[0]));
            outputf = new PrintWriter(args[1]);
            System.out.println("FILES :"+args[0]+" AND "+args[1]+" OPENED SUCCESSFULLY ");
            //reading total nodes from (first line)file
            numNodes = inputf.nextInt();
        }  
        // Throwing I/O exception
        catch (IOException e) {
            System.out.println("COULD NOT OPEN THE FILES");
            System.exit(1);
        }
        //Instanciation
        mapColoring mColoring = new mapColoring(numNodes, inputf, outputf);
        //Start process
        mColoring.start();
        //Close files 
        inputf.close();
        outputf.close();
    }
}
