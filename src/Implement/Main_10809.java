package Implement;

import java.io.*;

// BOJ 10809 - 알파벳 찾기
public class Main_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        int[] count = new int[26];

        for(int i=0;i<26;i++){
            count[i] = -1;
        }

        for(int i=0;i<line.length();i++){
            int idx = (int)line.charAt(i)-97;
            if(count[idx] == -1) count[idx] = i;
        }

        for(int i=0;i<26;i++){
            bw.write(count[i]+" ");
        }
        bw.flush();
    }
}
