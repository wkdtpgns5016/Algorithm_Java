package Math;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// BOJ 1212 - Base Conversion
public class Main_11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        line = br.readLine();
        st = new StringTokenizer(line, " ");

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int dnum = clacDecimal(arr,a);
        List<Integer> list = new ArrayList<>();

        while(dnum != 0){
            list.add(dnum%b);
            dnum/=b;
        }

        for(int i=list.size()-1; i>=0; i--){
            bw.write(list.get(i)+" ");
        }
        bw.flush();
    }
    public static int clacDecimal(int[] arr,int a){
        int d = 1;
        int sum = 0;
        for(int i=arr.length-1;i>=0;i--){
            sum += arr[i] * d;
            d*=a;
        }
        return sum;
    }
}