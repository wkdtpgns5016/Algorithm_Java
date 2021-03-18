package Math;

import java.io.*;

// BOJ 10872 - 팩토리얼
public class Main_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        bw.write(Long.toString(getFactorial(n)));
        bw.flush();
    }
    public static long getFactorial(long n){
        long sum=1;
        for(int i=2;i<=n;i++){
            sum *= i;
        }
        return sum;
    }
}