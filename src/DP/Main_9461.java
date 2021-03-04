package DP;
import java.io.*;

// BOJ 9461 - 파도반 수열
public class Main_9461{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            long[] d = new long[num+1];

            d[1] = 1;
            if(num>=2) d[2] = 1;
            if(num>=3) d[3] = 1;
            if(num>=4) d[4] = 2;

            for(int j=5;j<=num;j++){
                d[j] = d[j-1] + d[j-5];
            }
            System.out.println(d[num]);
        }
    }
}