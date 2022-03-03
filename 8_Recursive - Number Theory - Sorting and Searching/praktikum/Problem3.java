import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static void main(String[] args) {
        
        //input
        List<Integer> inputList = new ArrayList<>(Arrays.asList(5,7,4,-2,-1,8));


        System.out.println("Input : "+inputList);

        //process
        findMinMax(inputList);
        

    }

    //find minimum and maximum
    private static void findMinMax(List<Integer> arr) {

        int min = Math.min(arr.get(0), arr.get(1));
        int max = Math.max(arr.get(0), arr.get(1));
        int minIdx = 0;
        int maxIdx = 0;
        for (int i = 0; i < arr.size(); i++) {
            min = Math.min(min, arr.get(i));
            max = Math.max(max, arr.get(i));
            minIdx = arr.indexOf(min);
            maxIdx = arr.indexOf(max);
        }

        System.out.println("Output : \n |Minimum: "+min+" Index: "+minIdx+"| |Maximum: "+max+" Index: "+maxIdx+"|");
    }
}
