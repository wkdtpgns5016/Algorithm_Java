package DataStructure;

import java.io.*;
import java.util.Stack;

// BOJ 9012 - 괄호
public class Main_9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String line = br.readLine();
            if(clacVPS(line)){
                bw.write("YES"+"\n");
            }
            else{
                bw.write("NO"+"\n");
            }
            bw.flush();
        }
    }

    public static boolean clacVPS(String str){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            char ps = str.charAt(i);
            if(stack.empty()){
                stack.push(ps);
            }
            else{
                if(ps==')' && stack.peek().equals('(')){
                    stack.pop();
                }
                else{
                    stack.push(ps);
                }
            }
        }

        if(stack.empty()) return true;
        else return false;
    }
}
