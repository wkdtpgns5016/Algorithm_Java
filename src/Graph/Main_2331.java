package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// BOJ 2331 - 반복수열
public class Main_2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        String a = st.nextToken();
        int p = Integer.parseInt(st.nextToken());
        int idx = -1;
        ArrayList<String> list = new ArrayList<>();
        list.add(a);
        do{
            int next = changeNum(list.get(list.size()-1),p);
            list.add(Integer.toString(next));
        }while ((idx = checkNum(list,list.get(list.size()-1))) < 0);

        bw.write(Integer.toString(idx));
        bw.flush();
    }
    public static int changeNum(String str,int p){
        int[] arr = new int[str.length()];
        int result = 0;
        for(int i=0;i<str.length();i++){
            arr[i] = str.charAt(i) - '0';
        }
        for(int i=0;i<arr.length;i++){
            result += getMux(arr[i],p);
        }
        return result;
    }
    public static int checkNum(ArrayList<String> list, String a){
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i).equals(a)) return i;
        }
        return -1;
    }
    public static int getMux(int n, int p){
        int num = 1;
        for(int i=0;i<p;i++){
            num *= n;
        }
        return num;
    }
}
