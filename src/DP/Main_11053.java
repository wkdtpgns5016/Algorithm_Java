package DP;
import java.io.*;

// BOJ 11053 - 가장 긴 증가하는 부분 수열
public class Main_11053{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] increase = new int[n];

        String[] line = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(line[i]);
        }

        increase[0] = 1;

        for(int i=1;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(array[i]>array[j]){
                    if(max<increase[j]) max = increase[j];
                }
            }
            increase[i] = max + 1;
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(max<increase[i]) max = increase[i];
        }
        System.out.println(max);
    }
}