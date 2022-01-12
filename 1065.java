import java.util.*;
import java.io.*;

public class Main {  
    public static boolean arith(int n) {
        if(n < 100) return true;
        else {
            int loca1 = n / 100, loca2 = (n % 100) / 10, loca3 = n % 10;
            if((loca2 - loca1) == (loca3-loca2)) return true;
            else return false;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int testCase = fr.nextInt();
        int cnt = 0;

        for(int i = 1; i <= testCase; i++)
            if(arith(i)) cnt++;

        System.out.println(cnt);
    }
    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public FastReader(String s) throws FileNotFoundException { br = new BufferedReader(new FileReader(new File(s))); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}
