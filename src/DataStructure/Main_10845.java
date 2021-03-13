package DataStructure;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//BOJ 10845 - 큐
public class Main_10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue queue = new Queue();

        for(int i=0;i<n;i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line," ");
            String commend = st.nextToken();

            if(commend.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                queue.push(num);
            }
            else if(commend.equals("pop")){
                bw.write(queue.pop() + "\n");
            }
            else if(commend.equals("size")){
                bw.write(queue.size() + "\n");
            }
            else if(commend.equals("empty")){
                bw.write(queue.empty() + "\n");
            }
            else if(commend.equals("front")){
                bw.write(queue.front() + "\n");
            }
            else if(commend.equals("back")){
                bw.write(queue.back() + "\n");
            }
            bw.flush();
        }
    }
}
class Queue {
    private ArrayList<Integer> list;
    public Queue(){
        list = new ArrayList<>();
    }
    public int empty(){
        if(list.isEmpty()) return 1;
        else return 0;
    }
    public void push(int n){
        list.add(n);
    }
    public int pop(){
        if(empty() == 1){
            return -1;
        }
        else{
            int n = front();
            list.remove(0);
            return n;
        }
    }
    public int size(){
        return list.size();
    }
    public int front(){
        if(empty() == 1){
            return -1;
        }
        else{
            return list.get(0);
        }
    }
    public int back(){
        if(empty() == 1){
            return -1;
        }
        else{
            return list.get(size()-1);
        }
    }
}