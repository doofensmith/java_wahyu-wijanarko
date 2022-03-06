import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem3 {
    public static void main(String[] args) {

        //list of dragon head diameter
        List<Integer> dragonHead = new ArrayList<>(Arrays.asList(7, 2));
        //list of knight height
        List<Integer> knighHeight = new ArrayList<>(Arrays.asList(2, 1, 8, 5));


        //output
        System.out.println("Input : "+dragonHead+", "+knighHeight);
        System.out.println("Output : "+(dragonOfLoowater(dragonHead, knighHeight) == 0?"knight fall":dragonOfLoowater(dragonHead, knighHeight)));
        
    }

    private static int dragonOfLoowater(List<Integer> dragonHead, List<Integer> knightHeight) {
        int minimumTotalHeight = 0;

        //sort
        dragonHead.sort(Comparator.naturalOrder());
        knightHeight.sort(Comparator.naturalOrder());

        //process
        if (dragonHead.size() <= knightHeight.size()) {
            for (int i = 0; i < dragonHead.size(); i++) {
                if (dragonHead.get(dragonHead.size()-(i+1)) < knightHeight.get(knightHeight.size()-(i+1))) {
                    for (int j = 0; j < knightHeight.size(); j++) {
                        if (dragonHead.get(i) <= knightHeight.get(j)) {
                            minimumTotalHeight+= knightHeight.get(j);
                            break;
                        }
                    }
                }
            }
        }

        return minimumTotalHeight;
    }

}
