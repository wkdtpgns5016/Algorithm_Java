package Math;

import java.io.*;
import java.util.StringTokenizer;

// BOJ 9613 - GCD 합
public class Main_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line," ");
            int num = Integer.parseInt(st.nextToken());
            long [] arr = new long[num];
            long sum = 0;
            for(int j=0;j<num;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=0;j<num-1;j++){
                for(int k=j+1;k<num;k++){
                    sum += getGCD(arr[j], arr[k]);
                }
            }
            bw.write(sum+"\n");
            bw.flush();
        }
    }
    public static long getGCD(long a, long b){
        long temp;
        if(a < b){
            temp = a;
            a = b;
            b = temp;
        }
        while (a%b != 0){
            temp = a%b;
            a = b;
            b = temp;
        }
        return b;
    }
}
