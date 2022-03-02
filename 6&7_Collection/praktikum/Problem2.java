import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem2 {
    //main
    public static void main(String[] args) {
        
        //nput
        String input = "76523752";

        //process
        List<Integer> inputToList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            inputToList.add(Character.getNumericValue(input.charAt(i)));
        }

        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < inputToList.size(); i++) {
            if (Collections.frequency(inputToList, inputToList.get(i)) == 1) {
                result.add(inputToList.get(i));
            }
        }

        //output
        System.out.println("Input : "+input);
        System.out.println("Output : "+result);


    }
}
