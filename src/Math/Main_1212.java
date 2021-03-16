package Math;

import java.io.*;

// BOJ 1212 - 8진수 2진수
public class Main_1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String num = br.readLine();

        for(int i=0;i<num.length();i++) {
            bw.write(calc(num.charAt(i),i));
        }
        bw.flush();
    }
    public static String calc(char n, int i){
        switch (n){
            case 48: {
                if(i==0) return "0";
                else return"000";
            }
            case 49: {
                if(i==0) return "1";
                else return"001";
            }
            case 50: {
                if(i==0) return "10";
                else return"010";
            }
            case 51: {
                if(i==0) return "11";
                else return"011";
            }
            case 52: return "100";
            case 53: return "101";
            case 54: return "110";
            case 55: return "111";
        }
        return "";
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
        while(n > 1){
            n = n/2;
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
