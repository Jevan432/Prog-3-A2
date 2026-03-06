import java.io.File;
import java.util.Scanner;

public class A1 {
    
    private String filepath = "A1/res/test.txt";

    public void run() throws Exception{
        
        test(fileReader(this.filepath));
    }
    
    /**
     * Reads text from a file by line and creates a row from each line then inserts each row into a table
     * 
     * @param filePath
     * @return
     * @throws Exception
     */
    public Table fileReader(String filePath) throws Exception {

        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);
        int idTracker = 0;
        Table table = new Table();
        
        while (fileScanner.hasNextLine()){
            idTracker++;
            String line = fileScanner.nextLine();
            Row row = new Row(line, idTracker);
            table.addRow(row);
        }

        fileScanner.close();

        return table;
    }

    /**
     * This is a test function to verify the requirments of Assignment 1
     * 
     * @param table
     */
    public void test(Table table){

        System.out.println("The total number of rows is: "  + table.getSize());
        System.out.println("\n-------------------------------------------\n");

        table.sort(table);
        table.printTable(10);
        System.out.println("\n-------------------------------------------\n");
        
        Table theTable = table.select("the");
        theTable.printTable(10);
        System.out.println("The total number of rows is: "  + table.getSize());
    }

    public static void main(String[] args) throws Exception {
        
        A1 app = new A1();
        app.run();
    }
}
