package DP;
import java.io.*;

// BOJ 2579 - 계단 오르기
public class Main_2579{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] d = new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        d[1] = arr[1];
        if(n > 1) d[2] = arr[1] + arr[2];
        for(int i=3;i<=n;i++){
            d[i] = Math.max(arr[i]+arr[i-1]+d[i-3],arr[i]+d[i-2]);
        }

        System.out.println(d[n]);
    }
}