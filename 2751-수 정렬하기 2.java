import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = fr.nextInt();
        int[] arr = new int[n];
        int[] sorted = new int[n];
        
        for(int i = 0; i < n; i++)
            arr[i] = fr.nextInt();
        
        mergeSort(arr, sorted, 0, n - 1);
        
        for(int i = 0; i < n; i++) bw.write(arr[i] + "\n");
        bw.flush();
    }
    public static void merge(int arr[], int sorted[], int m, int middle, int n) {
        int i = m, j = middle + 1, k = m;

        while(i <= middle && j <= n) {
            if(arr[i] <= arr[j]) sorted[k] = arr[i++];
            else sorted[k] = arr[j++];
            k++;
        }
        if(i > middle) for(int t = j; t <= n; t++, k++) sorted[k] = arr[t];
        else for(int t = i; t <= middle; t++, k++) sorted[k] = arr[t];

        for(int t = m; t <= n; t++) arr[t] = sorted[t];
    }
    public static void mergeSort(int arr[], int sorted[], int m, int n) {
        int middle;
        if(m < n) {
            middle = (m + n) / 2;
            mergeSort(arr, sorted, m, middle);
            mergeSort(arr, sorted, middle + 1, n);
            merge(arr, sorted, m, middle, n);
        }
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
