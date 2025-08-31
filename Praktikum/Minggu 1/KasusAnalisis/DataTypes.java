// Soal 1 Data Types

package KasusAnalisis;
import java.util.Scanner;
import java.math.BigInteger;

public class DataTypes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            try {
                String nString = sc.next();
                BigInteger n = new BigInteger(nString);

                System.out.println(nString + " can be fitted in:");
                boolean fitted = false;

                // Check for byte
                if (n.compareTo(BigInteger.valueOf(Byte.MIN_VALUE)) >= 0 &&
                        n.compareTo(BigInteger.valueOf(Byte.MAX_VALUE)) <= 0) {
                    System.out.println("* byte");
                    fitted = true;
                }
                // Check for short
                if (n.compareTo(BigInteger.valueOf(Short.MIN_VALUE)) >= 0 &&
                        n.compareTo(BigInteger.valueOf(Short.MAX_VALUE)) <= 0) {
                    System.out.println("* short");
                    fitted = true;
                }
                // Check for int
                if (n.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) >= 0 &&
                        n.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0) {
                    System.out.println("* int");
                    fitted = true;
                }
                // Check for long
                if (n.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) >= 0 &&
                        n.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
                    System.out.println("* long");
                    fitted = true;
                }
                if (!fitted) {
                    System.out.println(nString + " can't be fitted anywhere");
                }
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
            T--;
        }
    }
}