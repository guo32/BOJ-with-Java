import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader(); // 문제 해결 소스 코드
        int testCases = fr.nextInt(); // 테스트 케이스 개수

        for(int testCase = 0;testCase < testCases;testCase++) {
          // 각 테스트 케이스에 대해 값 구하기
          int n = fr.nextInt(); // 학생 수
          int[]arr = new int[n];
          int summary = 0; // 총점

          // 점수 입력 및 총점 계산
          for(int i = 0;i < n;i++) {
            arr[i] = fr.nextInt();
            summary += arr[i];
          } 
          
          // 평균 계산
          double average = (double)summary / n;
          int cnt = 0; // 평균 이상인 학생 수

          for(int i = 0;i < n;i++)
            if(average < arr[i]) cnt++;

          String res = String.format("%.3f%%", ((double)cnt * 100) / n);
          System.out.println(res);
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
