package DP;
import java.io.*;

// BOJ 1463 - 1 만들기
public class Main_1463{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        int[] d = new int[n+1];

        System.out.println(d(n,d));
    }
    public static int d(int n, int[] d){
        if(n == 1)
            return 0;
        if (d[n] > 0)
            return d[n];
        d[n] = d(n-1,d) + 1;
        if(n % 2 == 0){
            int temp = d(n/2,d) + 1;
            if(d[n]>temp){
                d[n] = temp;
            }
        }
        if(n % 3 == 0){
            int temp = d(n/3,d) + 1;
            if(d[n]>temp){
                d[n] = temp;
            }
        }
        return d[n];
    }
}