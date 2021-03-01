package DP;
import java.io.*;

// BOJ 11055 - 가장 큰 증가하는 부분 수열
public class Main_11055{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] sum = new int[n];

        String[] line = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(line[i]);
        }

        sum[0] = array[0];
        for(int i=1;i<n;i++){
            sum[i] = array[i];
            int max = 0;
            for(int j=0;j<i;j++){
                if(array[i]>array[j]){
                    if(max<sum[j]){
                        max = sum[j];
                    }
                }
            }
            sum[i] += max;
        }

        int max=0;
        for(int i=0;i<n;i++){
            if(max<sum[i]) max = sum[i];
        }
        System.out.println(max);
    }
}