/** Class that prints the Collatz sequence starting from a given number.
 *  @author YOUR NAME HERE
 */
public class Collatz {

    /**
     *
     * @param n input number
     * @return  return a nextNumber
     */
    public static int nextNumber(int n) {
        //buggy version
//        if (n  == 128) {
//            return 1;
//        } else if (n == 5) {
//            return 3 * n + 1;
//        } else {
//            return n * 2;
//        }
        if(n==1)return n;
        if(n%2==0) return n/2;
        else return 3*n+1;
    }


    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

