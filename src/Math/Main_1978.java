package Math;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// BOJ 1978 - 소수 찾기
public class Main_1978 {
    // 에라토스테네스의 체 알고리즘 적용 - 132ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result=0;
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num == 1) result--;
            if(isPrimeNumber(num)) result++;
        }

        bw.write(Integer.toString(result));
        bw.flush();
    }

    /*
     *
     * 초기 생각 - 140ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        int result = 0;

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }
        List<Integer> list = getDecimal(max);
        for(int i=0;i<arr.length;i++){
            boolean b = false;
            for(int j=0;j<list.size();j++){
                if(arr[i]<list.get(j)) break;
                else{
                    if(arr[i] % list.get(j) == 0){
                        if(arr[i] == list.get(j)) {
                            b=true;
                        }
                        else{
                            b=false;
                            break;
                        }
                    }
                    else b=true;
                }
            }
            if(b) result++;
        }

        bw.write(Integer.toString(result));
        bw.flush();
    }*/

    // 에라토스테네스의 체 알고리즘 **
    public static boolean isPrimeNumber(int x) {
        int end = (int) Math.sqrt(x);
        for(int i = 2; i <= end; i++) {
            if(x % i == 0) return false;
        }
        return true;
    }

    public static List<Integer> getDecimal(int end){
        int num = 2;
        List<Integer> list = new ArrayList<>();
        while(num <= end){
            if(list.isEmpty()) {
                list.add(num);
                num++;
            }
            else{
                boolean b = false;
                for(int i=0;i<list.size();i++){
                    if(num % list.get(i) == 0){
                        b = false;
                        break;
                    }
                    else b=true;
                }
                if(b){
                    list.add(num);
                }
                num++;
            }
        }
        return list;
    }
}
