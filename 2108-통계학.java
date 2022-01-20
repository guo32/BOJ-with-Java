import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader(); 
        int N = fr.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> modeList = new ArrayList<>(); // 최빈값 저장
        int[] count = new int[8001];
        int total = 0, max = Integer.MIN_VALUE, temp = 0;

        for(int i = 0; i < N; i++) {
            int data = fr.nextInt();

            arrayList.add(data);
            total += data;

            if(data < 0) {
                count[Math.abs(data) + 4000]++;
                temp = count[Math.abs(data) + 4000];
            }
            else { 
                count[data]++;
                temp = count[data];
            }
            max = Math.max(max, temp);
        }
        arrayList.sort(Comparator.naturalOrder()); // 정렬

        for(int i = 0; i <= 8000; i++) {
            if(count[i] == max) {
                if(i > 4000) modeList.add((i - 4000) * -1);
                else modeList.add(i);
            }
        }
        modeList.sort(Comparator.naturalOrder());     

        // 산술 평균 출력
        double avg = (double)total / N;
        System.out.println(Math.round(avg));

        // 중앙값 출력
        System.out.println(arrayList.get(N / 2)); 

        // 최빈값 출력
        if(modeList.size() == 1) System.out.println(modeList.get(0));
        else System.out.println(modeList.get(1));

        // 범위 출력
        System.out.println(arrayList.get(N - 1) - arrayList.get(0));
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
