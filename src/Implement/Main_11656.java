package Implement;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

// BOJ 11656 - 접미사 배열
public class Main_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<line.length();i++){
            list.add(line.substring(i));
        }
        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            bw.write(list.get(i) + "\n");
            bw.flush();
        }
    }
}
