package Math;

import java.io.*;
import java.util.StringTokenizer;

// BOJ 1934 - 최소공배수
public class Main_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(getLCM(a,b) + "\n");
            bw.flush();
        }
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
