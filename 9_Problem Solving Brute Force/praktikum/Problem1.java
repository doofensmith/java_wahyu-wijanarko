public class Problem1 {
    public static void main(String[] args) {
        //input 
        int A = 6;
        int B = 6;
        int C = 14;

        System.out.println(simpleEquation(A, B, C)); 


    }

    //simple equation
    private static String simpleEquation(int A, int B, int C) {
        // int x = 0;
        // int y = 0;
        // int z = 0;

        //((x+y+z) == A) && ((x*y*z) == B) && (((x*x) + (y*y) + (z*z)) == C)
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                for (int z = 0; z < 10; z++) {
                    if (((x+y+z) == A) && ((x*y*z) == B) && (((x*x) + (y*y) + (z*z)) == C)) {
                        return String.format("Solution : x=%s, y=%s, z=%s", x,y,z);
                    }
                }
            }
        }

        return "No solution.";


    }
}
