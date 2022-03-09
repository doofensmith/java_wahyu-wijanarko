import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.lang.model.element.Element;

public class Problem4 {
    public static void main(String[] args) {

        //input
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 3, 5, 5, 6, 7));
        int value = 8;

        //output
        System.out.println("Input : "+list);
        System.out.println("Output : "+binarySearch(list, value));
        
    }

    private static int binarySearch(List<Integer> list, int value) {
        //sort list
        list.sort(Comparator.naturalOrder());

        //mid
        int beginning = 0;
        int end = list.size()-1;
        int mid = (beginning+end)/2;

        //search
        while (beginning <= end) {
            if (list.get(mid) < value) {
                beginning = mid + 1;
            }else if(list.get(mid) == value) {
                return mid;
            }else {
                end = mid - 1;
            }
            mid = (beginning+end)/2;
        }

        if (beginning > end) {
            return -1;
        }

        return -1;
    }
}
