/**
 * Row class that holds a string and has an id
 * 
 */
public class Row implements Comparable<Row>{
    
    private String[] data;
    private int id;

    /**
     * Simple constructor
     * 
     * @param data
     * @param id
     */
    public Row (String[] data, int id){

        this.data = data;
        this.id = id;
    }

    /**
     * Constructor that takes data string splits it by comma then adds sections to array of strings
     * 
     * @param data
     * @param id
     */
    public Row (String data, int id){

        String[] splitted = data.split(",");
        this.data = splitted;
        this.id = id;
    }

    /**
     * Getters and setters
     * 
     * @return
     */
    public String[] getData(){
        return this.data;
    }
    public String getData(int n){
        return this.data[n];
    }
    public void setData(String[] data){
        this.data = data;
    }
    public void setData(String data, int n){
        this.data[n] = data;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    /**
     * Natural comparable that sorts rows by their id
     * 
     */
    public int compareTo(Row other){

        if (this.id == other.getId()){
            return 0;
        }
        else if (this.id > other.getId()){
            return -1;
        }
        else
            return 1;
    }


    public boolean equals(Object other){

        if (other == null){
            return false;
        }
        if (other == this){
            return true;
        }
        Row r = (Row) other;
        
        return this.id == r.getId();
    }

    /**
     * overides toString to instead print the string in the row
     * 
     */
    public String toString(){

        StringBuilder stringBuilder = new StringBuilder();
        for (String string : this.data){
            stringBuilder.append(string + " ");
        }
        String data = stringBuilder.toString();
        return data;
    }

}
