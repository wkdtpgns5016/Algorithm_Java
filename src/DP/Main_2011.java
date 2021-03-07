package DP;
import java.io.*;

// BOJ 2011 - 암호코드
public class Main_2011{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        int[] d = new int[n+1];
        int[] arr = new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i] = str.charAt(i-1) - '0';
        }

        d[0] = 1;
        for(int i=1;i<=n;i++){
            if(arr[i] != 0){
                d[i] = (d[i] + d[i-1]) % 1000000;
            }

            int x = arr[i] + arr[i - 1] * 10;
            if(x >= 10 && x <= 26){
                d[i] = (d[i] + d[i-2]) % 1000000;
            }

        }
        System.out.println(d[n]);
    }
}