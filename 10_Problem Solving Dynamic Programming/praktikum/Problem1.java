public class Problem1 {
    public static void main(String[] args) {

        //input
        int n = 5;

        //output
        System.out.println("Input : "+n);
        System.out.println("Output : "+fib(n));

    }

    //top - down fibonacci
    private static int fib(int n) {
        if (n <= 1) {
            return n;
        }else {
            return fib(n-2) + fib(n-1);
        }
    }
}