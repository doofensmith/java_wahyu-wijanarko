import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    //main
    public static void main(String[] args) {
        
        //input
        List<Integer> input1 = new ArrayList<>(Arrays.asList(1,2,3,4));

        List<Integer> input2 = new ArrayList<>();
        input2.add(1);
        input2.add(3);
        input2.add(5);
        input2.add(10);
        input2.add(16);

        //process
        List<Integer> result = new ArrayList<>();
        result.addAll(input1);
        //result.retainAll(input2);
        result.removeAll(input2);

        //output
        System.out.println("Input : "+input1+" dan "+input2);
        System.out.println("Output : "+result);

    }
    
}
