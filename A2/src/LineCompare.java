import java.util.Comparator;

/**
 * Comparator that sorts tables alphabetically
 */
public class LineCompare implements Comparator<Row>{

    public int compare(Row rowA, Row rowB){
        
        return rowA.getData(0).compareTo(rowB.getData(0));
    }
    
}
