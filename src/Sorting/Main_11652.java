package Sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

// BOJ 11652 - 카드
public class Main_11652 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long result = 0;
        ArrayList<Long> list = new ArrayList<>();
        long[][] count = new long[n][2];
        
        for(int i=0;i<n;i++){
            long num = Long.parseLong(br.readLine());
            list.add(num);
        }
        Collections.sort(list);

        int j = 0;
        count[j][0]++;
        count[j][1] = list.get(0);
        for(int i=1;i<n;i++){
            if(list.get(i-1).equals(list.get(i))){
                count[j][0]++;
                count[j][1] = list.get(i);
            }
            else{
                j++;
                count[j][0]++;
                count[j][1] = list.get(i);
            }
        }
        long max = 0;
        for(int i=0;i<count.length;i++){
            if(max<count[i][0]) {
                max = count[i][0];
                result = count[i][1];
            }
            else if(max == count[i][0]){
                if(result > count[i][1]){
                    result = count[i][1];
                }
            }
        }
        bw.write(Long.toString(result));
        bw.flush();
    }
}
