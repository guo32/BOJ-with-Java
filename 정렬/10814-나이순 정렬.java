import java.util.*;
import java.io.*;

class Member implements Comparable<Member> {
    int age;
    String name;
    int sort;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
        sort++;
    }
    @Override
    public int compareTo(Member other) {
        if(this.age != other.age) return this.age - other.age;
        else return this.sort - other.sort;
    }
    @Override
    public String toString() {
      return age + " " + name;
    }
}

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        ArrayList<Member> arrayList = new ArrayList<>();
        String[] temp = new String[2];

        for(int i = 0; i < N; i++) {
            String data = fr.nextLine();
            temp = data.split(" ");
			      arrayList.add(new Member(Integer.parseInt(temp[0]), temp[1]));
        }

        Collections.sort(arrayList);
        
        for(int i = 0; i < N; i++) {
            System.out.println(arrayList.get(i));
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
