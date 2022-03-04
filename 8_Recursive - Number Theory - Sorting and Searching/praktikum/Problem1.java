public class Problem1 {
    public static void main(String[] args) {

        //input
        int inputNumber = 1;

        //output
        System.out.println("Input : "+inputNumber);
        System.out.println("Output : "+primeX(inputNumber));
        
        // for (int i = 0; i < 10; i++) {
        //     System.out.println(i+" "+isPrime(i));
        // }

    }

    //prima ke x
    private static int primeX(int n) {
        int output = 0;

        int xPrimeNumber = 0;
        while (true) {

            if (xPrimeNumber == n) {
                break;
            }else {
                if (isPrime(output)) {
                    xPrimeNumber++;
                    output++;
                }else {
                    output++;
                }                            
            }            
        }

        return output-1;
    }

    // is prime
    private static Boolean isPrime(int number) {
        Boolean isPrime = true;

        if (number == 2) {
            isPrime = true;
        }else if (number%2 == 0) {
            isPrime = false;
        }else if (number < 2) {
            isPrime = false;
        } else {
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
