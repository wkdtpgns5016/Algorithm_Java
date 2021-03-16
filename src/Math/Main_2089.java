package Math;

import java.io.*;

// BOJ 1212 - -2진수
public class Main_2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String num = br.readLine();

        for(int i=0;i<num.length();i++) {

        }
        bw.flush();
    }

    public static String calcBinary(char n){
        String binary="";
        int num = n - '0';
        int sub = maxNum(num);
        int[] arr = new int[sub+1];
        while(num >0){
            sub = maxNum(num);
            arr[sub]++;
            num -= getDouble(sub);
        }

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i] == 1){
                binary += "1";
            }
            else binary += "0";
        }

        return binary;
    }
    public static int maxNum(int n){
        int i = 0;
        while(n != 1 || n != -1){
            n = n/(-2);
            i++;
        }
        return i;
    }
    public static int getDouble(int n){
        int num = 1;
        for(int i=0;i<n;i++){
            num *=2;
        }
        return num;
    }

}