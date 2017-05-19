import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SubSum {
    static  int SUM = 10;
   static  int[] a = new int[10];
     static final int m = 10;
     static int[] pole = new int[m];
     static ArrayList<ArrayList<Integer>> summs = new ArrayList<ArrayList<Integer>>();
     static int s = 0;
     static ArrayList<Integer> v = new ArrayList<Integer>();

    public static void perest(int n, int[] r) {
        int[] r1 = new int[m];
        if (s == SUM) {
            sum();
        }

        for (int i = 0; i < m - n; i++) {
            pole[n] = r[i];
            if (s < SUM && !v.contains(pole[i])) {
                s += pole[n];
                v.add(pole[n]);
                Collections.sort(v);

                int k = 0;
                for (int j = 0; j < m - n; j++) {
                    if (j != i) {
                        r1[k] = r[j];
                        k++;
                    }
                }
                perest(n + 1, r1);
                s = 0;
                v.clear();
            }
        }
    }

    private static void sum() {
        if (!summs.contains(v)) {
            summs.add(new ArrayList<Integer>(v));
            v.clear();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SUM = sc.nextInt();
        for (int i = 0; i < 10; i++){
            a[i]= sc.nextInt();
        }
        perest(0, a);
        for(ArrayList<Integer> v : summs) {
            System.out.println(v);
        }
    }
}
