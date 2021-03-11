package Sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// BOJ 11004 - K번째 수
public class Main_11004 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line," ");
        int n = Integer.parseInt(st.nextToken());
        int idx = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();

        line = br.readLine();
        st = new StringTokenizer(line," ");
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        bw.write(Integer.toString(list.get(idx-1)));
        bw.flush();
    }
}
