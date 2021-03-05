package DP;
import java.io.*;
import java.util.*;

// BOJ 2225 - 합분해
public class Main_2225{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] d = new int[n+1][k+1];

        d[0][1] = 1;
        d[1][1] = 1;
        for(int i=2;i<=k;i++){
            d[0][i] = 1;
            d[1][i] = i;
        }

        for(int i=2;i<=n;i++){
            d[i][1] = 1;
            for(int j=2;j<=k;j++){
                int sum = 0;
                for(int l=0;l<=i;l++){
                    sum = (sum + d[l][j-1]) % 1000000000;
                }
                d[i][j] = d[i][j] + sum;
            }
        }
        System.out.println(d[n][k]);
    }
}