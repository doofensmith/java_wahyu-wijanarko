import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem4 {
    public static void main(String[] args) {

        //input
        int money = 50000;
        List<Integer> price = new ArrayList<>(Arrays.asList(25000,25000,10000,14000));

        //output
        System.out.println("Input : money = "+money+", productPrice = "+price);
        System.out.println("Output : "+maxBuyProducts(money, price));
        
    }

    //max buy
    private static int maxBuyProducts(int money, List<Integer> price) {
        int maxBuy = 0;

        //sort
        price.sort(Comparator.naturalOrder());

        for (int i = 0; i < price.size(); i++) {
            if (money-price.get(i) >= 0) {
                money -= price.get(i);
                maxBuy = i+1;
            }
        }

        return maxBuy;
    }
}
