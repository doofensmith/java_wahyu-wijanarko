public class Problem2 {
    public static void main(String[] args) {

        //input
        int inputNumber = 7;

        //output
        System.out.println("Input : "+inputNumber);
        System.out.println("Output : Fibonacci ke "+inputNumber+" : "+fib(inputNumber));
        
    }

    //recursive fibonacci
    private static int fib(int number) {
        if (number <= 1) {
            return number;
        }else {
            return fib(number-1) + fib(number-2);
        }
    }

}
