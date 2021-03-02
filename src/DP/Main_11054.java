package DP;
import java.io.*;

// BOJ 11054 - 가장 긴 바이토닉 부분 수열
public class Main_11054{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] bitonic = new int[n];
        String[] line = br.readLine().split(" ");

        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(line[i]);
        }

        int[] increase = lis(array);
        int[] decrease = lds(array);

        int max = 0;
        for(int i=0;i<n;i++){
            bitonic[i] = increase[i] + decrease[i];
            if(max<bitonic[i]) max = bitonic[i];
        }

        System.out.println(max-1);
    }
    public static int[] lis(int[] array){
        int[] increase = new int[array.length];

        for(int i=0;i<increase.length;i++){
            increase[i] = 1;
            int max = 0;
            for(int j=0;j<i;j++){
                if(array[i] > array[j] && max<increase[j]){
                    max = increase[j];
                    increase[i] = 1 + max;
                }
            }
        }
        return increase;
    }
    public static int[] lds(int[] array){
        int[] decrease = new int[array.length];

        for(int i=decrease.length-1;i>=0;i--){
            decrease[i] = 1;
            int max = 0;
            for(int j=decrease.length-1;j>=i;j--){
                if(array[i] > array[j] && max<decrease[j]){
                    max = decrease[j];
                    decrease[i] = 1 + max;
                }
            }
        }
        return decrease;
    }
}