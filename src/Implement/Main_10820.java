package Implement;

import java.io.*;

// BOJ 10820 - 문자열 분석
// 소문자는 97~122 대문자는 65~90 숫자는 48~57 공백은 32
public class Main_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line="";
        while((line=br.readLine())!= null){
            int[] count = new int[4];
            for(int i=0;i<line.length();i++){
                int c = (int)line.charAt(i);

                if(c >= 97 && c<=122) count[0]++;
                else if(c >= 65 && c<=90) count[1]++;
                else if(c >= 46 && c<=57) count[2]++;
                else if(c == 32) count[3]++;
            }
            bw.write(count[0]+" "+count[1]+" "+count[2]+" "+count[3]+"\n");
            bw.flush();
        }
    }
}
