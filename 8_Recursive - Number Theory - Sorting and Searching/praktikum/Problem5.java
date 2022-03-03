import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem5 {
    public static void main(String[] args) {

        //input
        List<String> inputList = new ArrayList<>(Arrays.asList("js","js","golang","ruby","ruby","js","js"));
        //output
        System.out.println("Input : "+inputList);

        mostAppearItem(inputList);
        
    }

    //most appear item
    private static void mostAppearItem(List<String> arr) {
        //set
        Set<String> keyString = new HashSet<>(arr);

        //create map
        Map<String, Integer> item = new HashMap<>();
        for (String string : keyString) {
            item.put(string, 0);
        }


        //update value of map
        for (String arrData : arr) {
            Iterator<String> iterator = keyString.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals(arrData)) {
                    item.put(arrData, item.get(arrData)+1);
                }
            }
        }

        System.out.println("Output : "+item);
    }


}
