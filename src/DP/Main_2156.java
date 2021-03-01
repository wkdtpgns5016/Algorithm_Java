package DP;
import java.io.*;

// BOJ 2156 - 포도주 시식
public class Main_2156{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n+1];
        int[] eat = new int[n+1];
        for(int i=1;i<n+1;i++){
            wine[i] = Integer.parseInt(br.readLine());
        }
        eat[1] = wine[1];
        if(n>1) eat[2] = wine[1] + wine[2];

        for(int i=3;i<n+1;i++){
            eat[i] = Math.max(eat[i-1],Math.max(wine[i]+eat[i-2],wine[i]+wine[i-1]+eat[i-3]));
        }

        System.out.println(eat[n]);
    }
}