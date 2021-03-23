package Graph;

import java.io.*;
import java.util.*;

// BOJ 1260 - DFS와 BFS
public class Main_1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] abjList = new LinkedList[n+1];
        for(int i=0;i<=n;i++){
            abjList[i] = new LinkedList<Integer>();
        }
        boolean[] visited = new boolean[n+1];

        for(int i=0;i<m;i++){
            line = br.readLine();
            st = new StringTokenizer(line, " ");

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            abjList[node1].add(node2);
            abjList[node2].add(node1);
        }
        for(int i=1;i<=n;i++){
            Collections.sort(abjList[i]);
        }
        DFS_list(v,abjList,visited);
        System.out.println();
        visited = new boolean[n+1];
        BFS_list(v,abjList,visited);
    }
    // DFS 인접리스트 : 재귀 구현
    public static void DFS_list(int v, LinkedList<Integer>[] list, boolean[] visited){
        visited[v] = true;
        System.out.print(v+" ");

        Iterator<Integer> iter = list[v].listIterator();
        while(iter.hasNext()){
            int w = iter.next();
            if(!visited[w]){
                DFS_list(w,list,visited);
            }
        }
    }

    // BFS 인접리스트 : 큐 구현
    public static void BFS_list(int v, LinkedList<Integer>[] list, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);

        while(!queue.isEmpty()){
            v = queue.poll();
            System.out.print(v+" ");

            Iterator<Integer> iter = list[v].listIterator();
            while(iter.hasNext()){
                int w = iter.next();
                if(!visited[w]){
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }
}