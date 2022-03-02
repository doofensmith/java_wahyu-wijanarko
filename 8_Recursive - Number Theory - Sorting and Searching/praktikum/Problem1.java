public class Problem1 {
    public static void main(String[] args) {

        //input
        int inputNumber = 5;

        //output
        System.out.println("Input : "+inputNumber);
        System.out.println("Output : "+primeX(inputNumber));
        
    }

    //prima ke x
    private static int primeX(int n) {
        int output = 0;

        int xPrimeNumber = 0;
        while (xPrimeNumber != n) {
            if (isPrime(output)) {
                xPrimeNumber++;
            }
            output++;
        }

        return output-1;
    }

    // is prime
    private static Boolean isPrime(int number) {
        Boolean isPrime = true;

        if (number%2 == 0) {
            isPrime = false;
        }else {
            for (int i = 3; i < Math.sqrt(number)+1; i=i+2) {
                if (number%i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        return isPrime;
    }
}
