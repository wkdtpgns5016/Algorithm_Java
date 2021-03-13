package Implement;

import java.io.*;

// BOJ 10808 - 알파벳 개수
public class Main_10808 {
    public static int[] alphabet = new int[26];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        int[] count = new int[26];

        for(int i=0;i<26;i++){
            alphabet[i] = i;
        }

        for(int i=0;i<line.length();i++){
            count[binarySearch(0,alphabet.length-1,(int)line.charAt(i)-97)]++;
            // count[(int)line.charAt(i)-97]++; : 바로 인덱스 계산하는법
        }

        for(int i=0;i<26;i++){
            bw.write(count[i]+" ");
        }
        bw.flush();
    }
    public static int binarySearch(int start, int end, int num){
        int mid = (start+end) / 2;
        int result = 0;
        if(num > mid){
            result = binarySearch(mid+1,end,num);
        }
        else if(num<mid){
            result = binarySearch(start,mid-1,num);
        }
        else{
            result = mid;
        }
        return result;
    }
}
