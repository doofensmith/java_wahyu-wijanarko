public class Task1PrimeNumber {
    //main
    public static void main(String[] args) {
        
        long startTime = System.nanoTime();
        System.out.println(primeNumber2(1000000007));
        System.out.println(primeNumber2(13));
        System.out.println(primeNumber2(17));
        System.out.println(primeNumber2(20));
        System.out.println(primeNumber2(35));
        long endTime = System.nanoTime();
        System.out.println("Time : "+(endTime-startTime));

    }


    //Time Complexity = O(n/2)
    static Boolean primeNumber(Integer number) {

        Boolean isPrime = true;

        if (number%2 ==  0) {
            isPrime = false;
        }else {
            for (int i = 2; i <= number/2; i++) {
                if (number%i == 0) {
                    isPrime = false;
                    break;
                }
            }  
        }

            

        return isPrime;
    }

    //Time Complexity = O(sqrt(n))
    static Boolean primeNumber2(Integer number) {
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