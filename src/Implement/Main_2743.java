package Implement;

import java.io.*;

// BOJ 2743 - 단어 길이 재기
public class Main_2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        bw.write(Integer.toString(line.length()));
        bw.flush();
    }
}
