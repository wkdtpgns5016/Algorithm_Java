package Math;

import java.io.*;

// BOJ 1676 - 팩토리얼 0의 개수
public class Main_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        bw.write(Integer.toString(count));
        bw.flush();
    }
}