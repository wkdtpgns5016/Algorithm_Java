package Math;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// BOJ 1212 - -2진수
public class Main_2089 {
    public static void main(String[] args) throws IOException {
        // 풀다가 막혀서 검색함 : https://dundung.tistory.com/27 참고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        if(n==0) //n이 0 일때
            bw.write(Integer.toString(n));

        while(n!=0) {
            list.add(Math.abs(n%-2));
            n=(int)Math.ceil((double)n/-2);
        }

        for(int i=list.size()-1; i>=0; i--){
            bw.write(Integer.toString(list.get(i)));
        }
        bw.flush();
    }
}