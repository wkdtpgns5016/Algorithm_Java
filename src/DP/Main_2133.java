package DP;
import java.io.*;

// BOJ 2133 - 타일 채우기
public class Main_2133{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n+1];

        d[0] = 1;
        d[1] = 0;
        if(n>1) d[2] = 3;

        for(int i=4;i<=n;i+=2) {
            d[i] = d[i - 2] * d[2];
            for (int j = 0; j < i - 2; j += 2) {
                d[i] += 2 * d[j];
            }

        }
        System.out.println(d[n]);
    }
}