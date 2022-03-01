import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Problem1 {
    //main
    public static void main(String[] args) {
        //input1
        List<String> input1 = new ArrayList<>();
        input1.add("kazuya");
        input1.add("jin");
        input1.add("lee");

        //input2
        List<String> input2 = new ArrayList<>();
        input2.add("kazuya");
        input2.add("feng");

        //merge
        Set<String> merge = new HashSet<>();
        merge.addAll(input1);
        merge.addAll(input2);

        //output
        System.out.println("Input : "+input1+", "+input2);
        System.out.println("Output : "+merge);

    }
    
}
