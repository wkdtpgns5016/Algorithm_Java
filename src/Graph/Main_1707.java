package Graph;

import java.io.*;
import java.util.*;

// BOJ 1707 - 이분 그래프
public class Main_1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line," ");
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            LinkedList<Integer>[] abjList = new LinkedList[v+1];
            boolean[] visited = new boolean[v+1];
            int[] color = new int[v+1];

            for(int j=0;j<=v;j++){
                abjList[j] = new LinkedList<>();
            }

            for(int j=0;j<e;j++){
                line = br.readLine();
                st = new StringTokenizer(line," ");
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());

                abjList[node1].add(node2);
                abjList[node2].add(node1);
            }
            for(int j=0;j<=v;j++){
                Collections.sort(abjList[j]);
            }

            if(checkBFS(abjList,color)) bw.write("YES\n");
            else bw.write("NO\n");
            bw.flush();
        }
    }

    // 너비 우선 탐색(BFS) 활용 - 컬러로 같은색을 탐색하면 false
    public static boolean checkBFS(LinkedList<Integer>[] list, int[] color){
        for(int i=1;i<list.length;i++){
            if(color[i] == 0){
                int v = i;
                Queue<Integer> queue = new LinkedList<>();
                color[i] = 1;
                queue.add(v);

                while(!queue.isEmpty()){
                    v = queue.poll();
                    Iterator<Integer> iter = list[v].listIterator();
                    while(iter.hasNext()){
                        int w = iter.next();
                        if(color[w] == 0) {
                            color[w] = color[v] * -1;
                            queue.add(w);
                        }
                        else if(color[w] == color[v]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
