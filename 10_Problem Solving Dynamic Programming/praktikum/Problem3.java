import java.util.Arrays;

public class Problem3 {
    public static void main(String[] args) {

        //input
        int[] stone = {10, 30, 40, 20};

        //output
        System.out.println("Input : "+ Arrays.toString(stone));
        System.out.println("Output : "+frog(stone));

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
//            System.out.println(position);
//            System.out.println("fj = "+frogJump);
//            System.out.println("p2 - p1 "+Math.abs(arr[position+2]-arr[position+1]));
//            System.out.println("p1 - p "+Math.abs(arr[position+1]-arr[position]));
        }

        return frogJump;
    }
}
