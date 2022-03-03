import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

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

        //sort map by value
        LinkedHashMap<String, Integer> sortedMapByValue = new LinkedHashMap<>();
        Stream<Map.Entry<String, Integer>> sort = item.entrySet().stream().sorted(Map.Entry.comparingByValue());
        sort.forEach(v -> sortedMapByValue.put(v.getKey(), v.getValue()));
        
        //output
        System.out.println("Output : "+sortedMapByValue);
    }


}
