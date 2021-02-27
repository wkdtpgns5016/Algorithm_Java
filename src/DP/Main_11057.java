package DP;
import java.io.*;

// BOJ 11057 - 오르막 수
public class Main_11057 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int upperNum[][] = new int[n][10];
        int sum = 0;

        for(int i=0;i<10;i++){
            upperNum[0][i] = 1;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<10;j++){
                for(int k=j;k<10;k++){
                    upperNum[i][j] = (upperNum[i][j] + upperNum[i-1][k]) % 10007;
                }
            }
        }
        for(int i=0;i<10;i++){
            sum = (sum + upperNum[n-1][i]) % 10007;
        }
        System.out.println(sum);
    }
}