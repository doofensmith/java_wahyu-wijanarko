import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem5 {
    //main
    public static void main(String[] args) {
        
        //input
        List<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(3);
        input.add(3);
        input.add(3);
        input.add(6);
        input.add(9);
        input.add(9);

        //process
        Set<Integer> noDupplicateList = new HashSet<>(input);

        //output
        System.out.println("Input : "+input);
        System.out.println("Output : "+noDupplicateList.size());


    }
}
