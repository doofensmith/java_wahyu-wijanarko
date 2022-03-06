public class Problem2 {
    public static void main(String[] args) {

        //input
        int n = 5;

        //output
        System.out.println("Input = "+n);
        System.out.println("Output = "+fib(n));
    }

    //bottom up fibonacci
    private static int fib(int n) {

        int[] fib = new int[n+1];

        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i-2] + fib[i-1];
        }

        return fib[n];
    }
}
