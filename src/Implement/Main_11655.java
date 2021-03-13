package Implement;

import java.io.*;

// BOJ 11655 - ROT13
public class Main_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        for(int i=0;i<line.length();i++){
            bw.write(ROT13(line.charAt(i)));
            bw.flush();
        }
    }
    public static char ROT13(char a){
        int n = (int)a;
        if(n >= 97 && n <= 122){
            n += 13;
            if(n>122) n = (n%122)+96;
        }
        else if(n >= 65 && n <= 90){
            n += 13;
            if(n>90) n = (n%90)+64;
        }
        return (char)n;
    }
}
