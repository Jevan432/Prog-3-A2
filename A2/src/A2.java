/**
 * Joe Evans comp 2503
 * Assignment 2
 */
public class A2 {

    public void run(String filePath) throws Exception{
        
        System.out.println(filePath);
        Table testTable = new Table(filePath);
        test(testTable);
    }

    /**
     * This is a test function to verify the requirments of Assignment 2
     * 
     * @param table
     */
    public void test(Table table){

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Number of rows: " + table.getSize());
        System.out.println("-----------------------------------------------------------------");
        table.printTable(10);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Number of rows: " + table.getSize());
        System.out.println("-----------------------------------------------------------------");
        table.sort(table, "colour").printTable(10);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Number of rows: " + table.getSize());
        System.out.println("-----------------------------------------------------------------");
        table.select("colour", "black").printTable(0);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Number of rows: " + table.getSize());
        System.out.println("-----------------------------------------------------------------");
        String[] cols = {"species", "count", "notes"};
        table.project(cols).printTable(10);
        System.out.println("-----------------------------------------------------------------");
    }

    public static void main(String[] args) throws Exception {
        
        String filePath = args[0];
        A2 app = new A2();
        app.run(filePath);
    }
}
