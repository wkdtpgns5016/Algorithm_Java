package DP;
import java.io.*;

// BOJ 2193 - 이친수
public class Main_2193{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] d = new long[n];

        d[0] = 1;
        if(n>1) d[1] = 1;

        for(int i=2;i<n;i++){
            d[i] = d[i-1]+d[i-2];
        }
        System.out.println(d[n-1]);
    }
}