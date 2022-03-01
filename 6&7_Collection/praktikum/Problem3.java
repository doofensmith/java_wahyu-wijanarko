import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    //main
    public static void main(String[] args) {
        
        //input
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);
        inputList.add(4);
        inputList.add(6);

        //target
        Integer target = 6;

        //process
        List<Integer> result = new ArrayList<>();
        mainLoop:
        for (int i = 0; i < inputList.size(); i++) {
            for (int j = 0; j < inputList.size(); j++) {
                if ((inputList.get(i)+inputList.get(j)) == target) {
                    result.add(i);
                    result.add(j);
                    break mainLoop;
                }
            }
        }

        //output
        System.out.println("Input : "+inputList);
        System.out.println("Target : "+target);
        System.out.println("Output : "+result);

    }
}
