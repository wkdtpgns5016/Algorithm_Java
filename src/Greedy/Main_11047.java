package Greedy;
import java.io.*;

// BOJ 11047 - 동전 0
public class Main_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split(" ");

        int n = Integer.parseInt(word[0]);
        int k = Integer.parseInt(word[1]);
        int[] coin = new int[n];
        int count = 0;

        for(int i=0;i<n;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        int i = n-1;
        while(k != 0){
            if(k>=coin[i]){
                count += k / coin[i];
                k = k % coin[i];
            }
            i--;
        }
        System.out.println(count);
    }
}
