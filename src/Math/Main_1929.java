package Math;

import java.io.*;
import java.util.StringTokenizer;

// BOJ 1929 - 소수 구하기
public class Main_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line," ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for(int i=m;i<=n;i++){
            if(isPrimeNumber(i) && i!=1) bw.write(i+"\n");
        }
        bw.flush();
    }

    public static boolean isPrimeNumber(int x){
        int end = (int)Math.sqrt(x);
        for(int i=2;i<=end;i++){
            if(x%i==0) return false;
        }
        return true;
    }
}
