package Math;

import java.io.*;

// BOJ 11653 - 소인수 분해
public class Main_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        getFactorization(n);
    }
    public static void getFactorization(int n){
        int num = n;
        int a = 2;
        while(num > 1 && a<=num){
            if(num % a != 0){
                a++;
                continue;
            }

            System.out.println(a);
            num /= a;
        }
    }
}
