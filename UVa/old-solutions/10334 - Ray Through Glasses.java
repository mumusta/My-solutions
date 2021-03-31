import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner ner = new Scanner(System.in);

        BigInteger f[] = new BigInteger[1010];
        f[0] = BigInteger.ZERO; f[1] = BigInteger.ONE;

        for (int i = 2; i < 1010; i ++){
            f[i] = f[i - 1].add(f[i - 2]);
        }

        while (ner.hasNextInt()){
            Integer n = ner.nextInt();
            System.out.printf("%s\n", f[n + 2].toString());
        }
    }
}

