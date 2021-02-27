package DP;
import java.io.*;

// BOJ 10844 - 쉬운 계단 수
public class Main_10844 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int stairsNum[][] = new int[n][10];
        int sum = 0;

        for(int i=1;i<10;i++){
            stairsNum[0][i] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<10;j++){
                if(j == 0) {
                    stairsNum[i][j] = stairsNum[i-1][j+1];
                }
                else if(j>=1 && j<=8){
                    stairsNum[i][j] = (stairsNum[i-1][j-1]+stairsNum[i-1][j+1]) % 1000000000;
                }
                else{
                    stairsNum[i][j] = stairsNum[i-1][j-1];
                }
            }
        }
        for(int i=0;i<10;i++){
            sum = (sum + stairsNum[n-1][i]) % 1000000000;
        }
        System.out.println(sum);
    }
}
