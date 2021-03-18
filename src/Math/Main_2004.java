package Math;

import java.io.*;
import java.util.StringTokenizer;

// BOJ 2004 - 조합 0의 개수
public class Main_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line," ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int resultF = calcFive(n) - (calcFive(n-r) + calcFive(r));
        int resultT = calcTwo(n) - (calcTwo(n-r) + calcTwo(r));
        bw.write(Integer.toString(Math.min(resultF,resultT)));
        bw.flush();
    }

    public static int calcFive(int n){
        int count = 0;
        int num = n;
        while (num >= 5){
            count += num / 5;
            num /= 5;
        }
        return count;
    }
    public static int calcTwo(int n){
        int count = 0;
        int num = n;
        while (num >= 2) {
            count += num / 2;
            num /= 2;
        }
        return count;
    }
}