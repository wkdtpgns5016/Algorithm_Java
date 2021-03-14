package Math;

import java.io.*;
import java.util.StringTokenizer;

// BOJ 2609 - 최대공약수와 최소공배수
public class Main_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line," ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(getGCF(a,b) + "\n" + getLCM(a,b));
        bw.flush();
    }
    public static int getGCF(int a, int b){
        int temp;
        if(a < b){
            temp = a;
            a = b;
            b = temp;
        }
        while (a%b != 0){
            temp = a%b;
            a = b;
            b = temp;
        }
        return b;
    }
    public static int getLCM(int a, int b){
        int temp;
        int i = 1;
        if(a < b){
            temp = a;
            a = b;
            b = temp;
        }

        int mul = a;
        while (mul%b != 0){
            i++;
            mul = a * i;
        }
        return mul;
    }
}
