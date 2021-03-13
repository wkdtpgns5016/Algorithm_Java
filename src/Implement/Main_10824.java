package Implement;

import java.io.*;
import java.util.StringTokenizer;

// BOJ 10824 - 네 수
public class Main_10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        long a = Long.parseLong(st.nextToken() + st.nextToken());
        long b = Long.parseLong(st.nextToken() + st.nextToken());

        bw.write(Long.toString(a+b));
        bw.flush();
    }
}
