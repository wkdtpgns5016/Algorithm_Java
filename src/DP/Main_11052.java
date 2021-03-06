package DP;
import java.io.*;
import java.util.*;

// BOJ 11052 - 카드 구매하기
public class Main_11052{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n+1];
        int[] d = new int[n+1];

        String line =br.readLine();
        StringTokenizer st = new StringTokenizer(line," ");

        for(int i=1;i<=n;i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        /*
         * 초기 정답 실행시간 = 164ms
        d[1] = cards[1];
        for(int i=2;i<=n;i++){
            int max=0;
            for(int j=i;j>(i/2)+(i%2);j--){
                int num = d[j-1] + d[i-(j-1)];
                if(max<num) max = num;
            }
            d[i] = Math.max(max,cards[i]);
        }
        */

        // 검색한 알고리즘 실행시간 = 156ms
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                d[i] = Math.max(d[i-j] + cards[j],d[i]);
            }
        }
        System.out.print(d[n]);
    }
}