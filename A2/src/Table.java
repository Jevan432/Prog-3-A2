import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Table object that holds Row objects 
 * 
 */
public class Table{
    
    private ArrayList<Row> rows;
    private int size;

    /**
     * Simple constructor
     * 
     */
    public Table(){

        this.rows = new ArrayList<Row>();
        this.size = 0;
    }

    /**
     * Constructs a new table object, reads a csv file and adds each line to a Row then adds that Row to the Table
     * 
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public Table Table(String fileName) throws FileNotFoundException{

        File file = new File(fileName);
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

    public Table project(String[] cols){
        
        Table projectTable = new Table();

        return projectTable;
    }

    /**
     * Constructor that makes a deep copy of a table that only includes rows with the input string
     * 
     * @param line
     * @return
     */
    public Table select(String line){

        Table selectTable = new Table();
        for (Row row : this.rows){
            if (row.getData().contains(line)){
                selectTable.addRow(row);
            }
        }

        this.size = selectTable.getSize();

        return selectTable;
    }

    /**
     * Getters and setters
     * 
     * @return
     */
    public int getSize(){
        return this.size;
    }
    public void setSize(int size){
        this.size = size;
    }
    public ArrayList<Row> getRows(){
        return this.rows;
    }
    public void setRows(ArrayList<Row> rows){
        this.rows = rows;
    }

    /**
     * Overloaded methods that add a row to the table
     * 
     * @param row
     */
    public void addRow(Row row){

        this.rows.add(row);
        this.size += 1;
    }

    public void addRow(String data, int id){

        Row row = new Row(data, id);
        this.rows.add(row);
        this.size += 1; 
    }

    public void addRow(String[] cols, int id){

        Row row = new Row(cols, id);
        this.rows.add(row);
        this.size +=1;
    }

    /**
     * Sorts the input table alphabetically
     * 
     * @param table
     * @return
     */
    public Table sort(Table table){

        ArrayList<Row> list = new ArrayList<Row>();
        LineCompare lineCompare = new LineCompare();
        list = table.getRows();
        Collections.sort(list, lineCompare);
        table.setRows(list);

        return table;
    }

    /**
     * Prints prints a specified amount of rows from the table
     * 
     */
    public void printTable(int r){
        
        if (r == 0){
            for (Row row : this.rows){
                System.out.println(row.toString());
            }
        }
        else if (r > 0 && r <= this.size){
            for (int i = 0; i < r; i++){
                System.out.println(this.rows.get(i).getData());
            }
        }
        else
            System.out.print("You can not enter a number that is negative or larger than table size \n");
    }
}
