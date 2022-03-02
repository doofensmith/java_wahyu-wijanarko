public class Task2Exponentiation {
    //main
    public static void main(String[] args) {

        long startTime = System.nanoTime();
        System.out.println(pow(2, 3));  // 8
        System.out.println(pow(5, 3));  // 125
        System.out.println(pow(10, 2)); // 100
        System.out.println(pow(2, 5)); // 32
        System.out.println(pow(7, 3));  // 343
        long endTime = System.nanoTime();
        System.out.println("Time : "+(endTime-startTime));

    }
     
    //Time Complexity = O(n)
    static Integer pow(Integer x, Integer n) {
        Integer result = 1;

        if (n>0) {
            for (int i = 0; i < n; i++) {
                result *= x;
            }
        }

        return result;
    }

    //Time Complexity = O(?)
    static Integer pow2(Integer x, Integer n) {
        Integer result = (int)Math.pow(x, n);
        return result;
    }
     
}
