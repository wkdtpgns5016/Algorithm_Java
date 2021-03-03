package DP;
import java.io.*;
import java.util.*;

// BOJ 1912 - 연속합
public class Main_1912{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] sum = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = arr[0];
        /* 첫번째 정답 : 효율적이지못함
         *
        int[] temp = new int[n];
        for(int i=1;i<n;i++){
            temp[i] = Math.max(arr[i],Math.max(arr[i]+arr[i-1],temp[i-1] + arr[i]));
            sum[i] = Math.max(sum[i-1],temp[i]);
        }*/
        for(int i=1;i<n;i++){
            sum[i] = Math.max(arr[i],sum[i-1]+arr[i]);
        }

        int max = sum[0];
        for(int i=1;i<n;i++){
            if(max<sum[i]) max = sum[i];
        }
        System.out.println(max);
    }
}