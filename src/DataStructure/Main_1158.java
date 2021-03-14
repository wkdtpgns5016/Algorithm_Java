package DataStructure;

import java.io.*;
import java.util.*;
import java.util.Queue;

// BOJ 1158 - 요세푸스 문제
public class Main_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer ts = new StringTokenizer(line," ");
        int n = Integer.parseInt(ts.nextToken());
        int k = Integer.parseInt(ts.nextToken());

        // 큐를 이용한 해결 - 776 ms
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            queue.offer(i);
        }
        bw.write("<");
        while(!queue.isEmpty()){
            for(int i=0;i<k-1;i++){
                int num = queue.poll();
                queue.offer(num);
            }
            if(queue.size() == 1){
                bw.write(queue.poll()+">");
            }
            else{
                bw.write(queue.poll()+", ");
            }
            bw.flush();
        }

        /*
         * 초기 생각 : List 이용하기 - 188 ms
         *
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1;i<=n;i++){
            list.add(i);
        }

        int i=0;
        int r = k-1;
        while(!list.isEmpty()){
            i += r;
            int idx = i%list.size();
            queue.offer(list.get(idx));
            list.remove(idx);
            i = idx;
        }
        bw.write("<");
        while (!queue.isEmpty()){
            if(queue.size() == 1){
                bw.write(queue.poll()+">");
            }
            else{
                bw.write(queue.poll()+", ");
            }
        }
        bw.flush();
         */

    }
}
