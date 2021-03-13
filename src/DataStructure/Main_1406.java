package DataStructure;

import java.io.*;
import java.util.*;
import java.util.Stack;

// BOJ 1406 : 에디터
// 일반적인 입출력은 O(n) 이기 때문에, 모든 연산이 O(1)인 스택을 활용!
public class Main_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        String[] arr = br.readLine().split("");
        int n = Integer.parseInt(br.readLine());

        for(String str : arr){
            left.push(str);
        }

        for(int i=0;i<n;i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line," ");

            String commend = st.nextToken();
            if(commend.equals("L")){
                if(!left.empty()) right.push(left.pop());
            }
            else if(commend.equals("D")){
                if(!right.empty()) left.push(right.pop());
            }
            else if(commend.equals("B")){
                if(!left.empty()) left.pop();
            }
            else if(commend.equals("P")){
                String c = st.nextToken();
                left.push(c);
            }
        }
        while(!left.empty()){
            right.push(left.pop());
        }
        while(!right.empty()){
            bw.write(right.pop());
        }
        bw.flush();
    }
}

