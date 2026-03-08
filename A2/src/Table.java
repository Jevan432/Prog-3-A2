import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Table object that holds ArrayList of Row objects
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
     * Constructs a new empty Table object by reading csv file
     * Splits each line of file into String[] then makes a Row from the String[] + idTracker and then adds that Row to the new Table
     * 
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public Table(String fileName) throws FileNotFoundException{

        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        int idTracker = 0;
        ArrayList<Row> list = new ArrayList<Row>();

        while (fileScanner.hasNextLine()){
            idTracker++;
            String line = fileScanner.nextLine();
            Row row = new Row(line, idTracker);
            list.add(row);
        }

        this.rows = list;
        this.size = idTracker;
        fileScanner.close();
    }

    /**
     * Returns new table with only columns matching strings in cols
     * 
     * @param cols
     * @return
     */
    public Table project(String[] cols){

        Table projectTable = new Table();
        ArrayList<Integer> selections = new ArrayList<Integer>();
        int count = 0;
        int idTracker = 0;

        for (String headerString : this.rows.get(0).getData()){
            for (String colString : cols){
                if (headerString.equals(colString)){
                    selections.add(count);
                }
            }
            count++;
        }

        for (Row row : this.rows){
            String[] projectArray = new String[this.rows.get(0).getData().length];
            for (int n : selections){
                projectArray[n] = row.getData(n);
            }
            idTracker++;
            projectTable.addRow(projectArray, idTracker);
        }

        return projectTable;
    }

    /**
     * Returns a new table with the header and only rows from the field with matching strings in value
     * 
     * @param field
     * @param value
     * @return
     */
    public Table select(String field, String value){

        Table selectTable = new Table();
        ArrayList<Integer> selections = new ArrayList<Integer>();
        int count = 0;
        selectTable.addRow(this.rows.get(0));

        for (String headerString : this.rows.get(0).getData()){
            if (headerString.equals(field)){
                selections.add(count);
            }
            count++;
        }

        for (Row row : this.rows){
            if (row.getData(selections.get(0)).equals(value)){
                selectTable.addRow(row);
            }
        }

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
     * Sorts the input table alphabetically by column provided in field
     * 
     * @param table
     * @return
     */
    public Table sort(Table table, String field){
        
        Table sortTable = new Table();
        ArrayList<String> sortList = new ArrayList<String>();
        int count = 0;
        int index = 0;

        for (String headerString : table.getRows().get(0).getData()){
            if (headerString.equals(field)){
                for (int i = 1; i < table.getSize(); i++){
                    String string = table.getRows().get(i).getData(count);
                    sortList.add(string);
                    index = count;
                }
            }
            count++;
        }

        Collections.sort(sortList);
        Set<String> set = new LinkedHashSet<>(sortList);
        ArrayList<String> cleanedList = new ArrayList<>(set);
        sortTable.addRow(this.rows.get(0));

        for (String sortString : cleanedList){
            for (Row row : table.getRows()){
                String string = row.getData(index);
                if (sortString.equals(string)){
                    sortTable.addRow(row);
                }
            }
        }

        return sortTable;
    }

    /**
     * Prints prints a specified amount (r) of rows from the table
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
                System.out.println(this.rows.get(i).toString());
            }
        }
        else
            System.out.print("You can not enter a number that is negative or larger than table size \n");
    }
}
