package Math;

import java.io.*;

// BOJ 1373 - 2진수 8진수
public class Main_1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str =  br.readLine();
        int i = str.length()-1;
        int size = 0;
        if(str.length()%3 == 0){
            size = str.length()/3;
        }
        else{
            size = str.length()/3 + 1;
        }

        char[] arr = new char[size];
        int idx = arr.length-1;

        while (i  >= 0 ){
            int n=1;
            int num=0;
            for(int j=0;j<3;j++){
                if(i < 0) break;
                num += ((int)str.charAt(i--) - 48) * n;
                n *= 2;
            }
            arr[idx--] = (char)(num +'0');
        }
        String s = new String(arr);
        bw.write(s);
        bw.flush();
    }
}