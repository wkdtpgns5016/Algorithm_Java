package DataStructure;

import java.io.*;
import java.util.Stack;

//BOJ 10799 - 쇠막대기
public class Main_10799 {
    public static void main(String[] args) throws IOException{
        // 검색한 알고리즘 - 192ms : 훨씬 효율적임
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for(int i=0;i<line.length();i++){
            if(line.charAt(i)=='('){
                stack.push('(');
            }
            else{
                stack.pop();
                if(line.charAt(i-1)=='('){
                    result += stack.size();
                }
                else result++;
            }
        }
        bw.write(Integer.toString(result));
        bw.flush();
        /*
         *
         * 초기방법 - 260ms : 비효율적임
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        int bar = 0;
        int sum = 0;
        for(int i=0;i<line.length();i++){
            char a = line.charAt(i);
            if(stack.empty()){
                stack.push(a);
                count.push(0);
                bar++; sum++;
            }
            else{
                if(a=='('){
                    if(stack.peek().equals('(')){
                        count.pop();
                        count.push(1);

                        stack.push(a);
                        count.push(0);
                        bar++; sum++;
                    }
                }
                else{
                    if(stack.peek().equals('(')){
                        bar--;
                        if(count.peek().equals(0)){
                            sum--;
                            sum += bar;
                        }
                        stack.pop();
                        count.pop();
                    }
                }
            }
        }
        bw.write(Integer.toString(sum));
        bw.flush();*/
    }
}
