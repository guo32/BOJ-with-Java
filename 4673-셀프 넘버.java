import java.util.*;
import java.io.*;

public class Main {  
    public static int d(int n) {
        int res = n;
        while(n!=0) {
          res += n % 10;
          n /= 10;
        }
      return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[10050];
        
        for(int i = 1; i < 10000; i++)
            arr[d(i)]++;
        for(int i = 1; i < 10000; i++)
            if(arr[i] == 0)
                System.out.println(i);
    }
}
