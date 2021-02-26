package DP;
// BOJ 11726 - 2 X n 타일링 2
import java.io.*;

public class Main_11727{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n+1];
        d[1] = 1;
        if(n > 1)
            d[2] = 3;
        for(int i = 3;i<n+1;i++){
            d[i] = (d[i-1] + d[i-2] + d[i-2]) % 10007;
        }
        System.out.println(d[n]);
    }
}