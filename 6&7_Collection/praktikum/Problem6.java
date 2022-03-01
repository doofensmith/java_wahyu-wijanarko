import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    //main
    public static void main(String[] args) {
        
        //input
        List<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(1);
        input.add(5);
        input.add(1);
        input.add(3);
        input.add(2);

        //sub array
        Integer subArraySize = 3;

        //process
        List<Integer> sumOfSubArray = new ArrayList<>();
        for (int i = 0; i <= input.size()-subArraySize; i++) {
            sumOfSubArray.add(sum(input.subList(i, (i+subArraySize))));
        }

        //output
        System.out.println("Input : "+input+", k = "+subArraySize);
        System.out.println("sub array sum : "+sumOfSubArray);
        System.out.println("Output : "+Collections.max(sumOfSubArray));

    }

    //method sum of list element
    private static int sum(List<Integer> list) {
        Integer result = 0;
        for (Integer integer : list) {
            result+=integer;
        }
        return result;
    }
}
