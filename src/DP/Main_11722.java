package DP;
import java.io.*;

// BOJ 11722 - 가장 긴 감소하는 부분 수열
public class Main_11722{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] decrease = new int[n];
        String[] line = br.readLine().split(" ");

        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(line[i]);
        }

        for(int i=0;i<n;i++){
            decrease[i] = 1;
            int temp = 0;
            for(int j=0;j<i;j++){
                if(array[i]<array[j] && temp<decrease[j]){
                    temp = decrease[j];
                    decrease[i] = 1 + temp;
                }
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            if(max<decrease[i]) max = decrease[i];
        }
        System.out.println(max);
    }
}