package DP;
import java.io.*;

// BOJ 9095 - 1,2,3 더하기
public class Main_9095{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            int[] d = new int[11];
            d[0] = 1;
            d[1] = 2;
            d[2] = 4;
            for(int j = 3;j<num;j++){
                d[j] = d[j-1]+d[j-2]+d[j-3];
            }
            System.out.println(d[num-1]);
        }
    }
}