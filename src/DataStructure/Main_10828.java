package DataStructure;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// BOJ 10828 - 스택
public class Main_10828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack();

        for(int i=0;i<n;i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line," ");
            String commend = st.nextToken();

            if(commend.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }
            else if(commend.equals("pop")){
                bw.write(stack.pop() + "\n");
            }
            else if(commend.equals("size")){
                bw.write(stack.size() + "\n");
            }
            else if(commend.equals("empty")){
                bw.write(stack.empty() + "\n");
            }
            else if(commend.equals("top")){
                bw.write(stack.top() + "\n");
            }
            bw.flush();
        }
    }
}
class Stack{
    ArrayList<Integer> list;
    public Stack(){
        list = new ArrayList<>();
    }

    public void push(int num){
        list.add(num);
    }
    public int pop(){
        int element;
        if(empty() == 0){
            element = list.get(size()-1);
            list.remove(size()-1);
            return element;
        }
        else return -1;
    }
    public int size(){
        return list.size();
    }
    public int empty(){
        if(list.size() == 0) return 1;
        else return 0;
    }
    public int top(){
        if(empty() == 0){
            return list.get(size()-1);
        }
        else return -1;
    }
}
