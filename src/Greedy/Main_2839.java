package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ 2839 - 설탕 배달
public class Main_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = -1;

        for(int j=n/5;j>=0;j--){
            if((n-(j*5)) % 3 == 0){
                result = j + ((n-(j*5)) / 3);
                break;
            }
        }
        System.out.println(result);
    }
}
