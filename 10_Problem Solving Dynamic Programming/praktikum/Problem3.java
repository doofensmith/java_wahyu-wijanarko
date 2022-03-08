import java.util.Arrays;

public class Problem3 {
    public static void main(String[] args) {

        //input
        int[] stone = {10, 30, 40, 20};
        int[] stone2 = {30, 10, 60, 10, 60, 50};

        //output
        System.out.println("Input : "+ Arrays.toString(stone));
        System.out.println("Output : "+frog2(stone));

        System.out.println("\nInput : "+ Arrays.toString(stone2));
        System.out.println("Output : "+frog2(stone2));

    }

    private static int frog(int[] arr) {

        int frogJump = 0;
        int position = 0;
        while (position < arr.length-2) {

            if (position == arr.length-2) {
                frogJump+=Math.abs(arr[position]-arr[position+1]);
            }

            if (Math.abs(arr[position+2]-arr[position]) <= Math.abs(arr[position+1]-arr[position])) {
                frogJump+=Math.abs(arr[position+2]-arr[position]);
                position+=2;
            }else {
                frogJump+=Math.abs(arr[position+1]-arr[position]);
                position+=1;
            }
        }

        return frogJump;
    }

    //lompatan katak maju atau mundur batu
    private static int frog2(int[] arr) {

        int prevStone1 = 0;
        int prevStone2 = 0;
        for (int i = 1; i < arr.length; i++) {

            int doubleJump = Integer.MAX_VALUE;
            int singleJump = prevStone1 + Math.abs(arr[i] - arr[i-1]);
            if (i>1) {
                doubleJump = prevStone2 + Math.abs(arr[i] - arr[i-2]);
            }
            int currentStone = Math.min(singleJump,doubleJump);
            prevStone2 = prevStone1;
            prevStone1 = currentStone;

        }


        return prevStone1;
    }
}
