package Math;
import java.io.*;
import java.util.StringTokenizer;

// BOJ 1850 - 최대공약수
public class Main_1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int num = (int)(getGCF(a, b) % 10000000);
        for(int i=0;i<num;i++){
            bw.write("1");
        }
        bw.flush();
    }

    public static long getGCF(long a, long b) {
        long temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        while (a % b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}