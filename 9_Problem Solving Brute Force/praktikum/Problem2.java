import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        //pecahan uang
        List<Integer> money = new ArrayList<>(Arrays.asList(1, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000));

        //input jumlah uang
        int moneySum = 432;

        //output
        System.out.println("Input : "+moneySum);
        System.out.println("Output : "+moneyExchange(money, moneySum));
    }

    private static List<Integer> moneyExchange(List<Integer> money, int moneySum) {
        List<Integer> result = new ArrayList<>();

        while (moneySum != 0) {
            for (int i = 0; i < money.size(); i++) {
                if (moneySum >= money.get(i)) {
                    //do nothing
                }else {
                    result.add(money.get(i-1));
                    moneySum -= money.get(i-1);
                    break;
                }
            }
        }

        return result;
    }
}
