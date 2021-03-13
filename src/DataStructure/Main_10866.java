package DataStructure;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//BOJ 10866 - 덱
public class Main_10866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque deque = new Deque();

        for(int i=0;i<n;i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line," ");
            String commend = st.nextToken();

            if(commend.equals("push_front")){
                int num = Integer.parseInt(st.nextToken());
                deque.push_front(num);
            }
            else if(commend.equals("push_back")){
                int num = Integer.parseInt(st.nextToken());
                deque.push_back(num);
            }
            else if(commend.equals("pop_front")){
                bw.write(deque.pop_front() + "\n");
            }
            else if(commend.equals("pop_back")){
                bw.write(deque.pop_back() + "\n");
            }
            else if(commend.equals("size")){
                bw.write(deque.size() + "\n");
            }
            else if(commend.equals("empty")){
                bw.write(deque.empty() + "\n");
            }
            else if(commend.equals("front")){
                bw.write(deque.front() + "\n");
            }
            else if(commend.equals("back")){
                bw.write(deque.back() + "\n");
            }
            bw.flush();
        }
    }
}

class Deque {
    private ArrayList<Integer> list;
    public Deque(){
        list = new ArrayList<>();
    }
    public int empty(){
        if(list.isEmpty()) return 1;
        else return 0;
    }
    public void push_front(int n){
        list.add(0,n);
    }
    public void push_back(int n){
        list.add(n);
    }
    public int pop_front(){
        if(empty() == 1){
            return -1;
        }
        else{
            int n = front();
            list.remove(0);
            return n;
        }
    }
    public int pop_back(){
        if(empty() == 1){
            return -1;
        }
        else{
            int n = back();
            list.remove(size()-1);
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