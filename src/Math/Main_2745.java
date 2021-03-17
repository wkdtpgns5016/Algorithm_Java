package Math;

import java.io.*;
import java.util.StringTokenizer;

// BOJ 2745 : 진법 변환
public class Main_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        String str = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        int num = transNum(str,b);
        if(num <= 1000000000 && num >= 0)
            bw.write(Integer.toString(num));
        bw.flush();
    }
    public static int transNum(String num, int b){
        int n = 1;
        int a = 0;
        for(int i=num.length()-1;i>=0;i--){
            if(num.charAt(i) >= 65 && num.charAt(i) <= 90){
                a += ((int)num.charAt(i) - 55) * n;
            }
            else{
                a += ((int)num.charAt(i) - 48) * n;
            }
            n *= b;
        }
        return a;
    }
}