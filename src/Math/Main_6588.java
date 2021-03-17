package Math;

import java.io.*;

// BOJ 6588 - 골드바흐의 추측
public class Main_6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num;
        int i=3;
        while((num = Integer.parseInt(br.readLine())) != 0){
            i=3;
            boolean count = false;
            while(i<num){
                if(isPrimeNumber(i) && isPrimeNumber(num-i)){
                    bw.write(num+" = "+i+" + "+(num-i)+"\n");
                    count = true;
                    break;
                }
                i+=2;
            }
            if(!count) bw.write("Goldbach's conjecture is wrong.\n");
            bw.flush();
        }
    }
    public static boolean isPrimeNumber(int x){
        int end = (int)Math.sqrt(x);
        for(int i=2;i<=end;i++){
            if(x%i==0) return false;
        }
        return true;
    }
}
