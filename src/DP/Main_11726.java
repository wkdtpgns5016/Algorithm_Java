package DP;
import java.io.*;

// BOJ 11726 - 2 X n 타일링
public class Main_11726{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n+1];
        d[1] = 1;
        if(n > 1)
            d[2] = 2;

        for(int i = 3;i<n+1;i++){
            d[i] = (d[i-1] + d[i-2]) % 10007;
        }
        System.out.println(d[n]);
    }
}