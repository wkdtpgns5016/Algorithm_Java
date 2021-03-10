package Sorting;

import java.io.*;

// BOJ 10989 - 수 정렬3 (계수정렬)
public class Main_10989 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sort = new int[n];

        int max = 0;
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            if(max<num) max = num;
            arr[i] = num;
        }
        int[] count = new int[max+1];

        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        for(int i=1;i<=max;i++){
            count[i] = count[i] + count[i-1];
        }
        for(int i=n-1;i>=0;i--){
            sort[--count[arr[i]]] = arr[i];
        }
        for(int i=0;i<n;i++){
            bw.write(sort[i]+"\n");
        }
        bw.flush();
    }
}
