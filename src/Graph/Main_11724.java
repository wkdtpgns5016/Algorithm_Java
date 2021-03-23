package Graph;

import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

// BOJ 11724 - 연결 요소의 개수
public class Main_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] abjList = new LinkedList[n+1];
        for(int i=0;i<=n;i++){
            abjList[i] = new LinkedList<Integer>();
        }
        boolean[] visited = new boolean[n+1];

        for(int i=0;i<m;i++){
            line = br.readLine();
            st = new StringTokenizer(line," ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            abjList[u].add(v);
            abjList[v].add(u);
        }
        for(int i=1;i<=n;i++){
            Collections.sort(abjList[i]);
        }
        int result = getConnectedComponent(abjList,visited);
        bw.write(Integer.toString(result));
        bw.flush();
    }

    public static int getConnectedComponent(LinkedList<Integer>[] list, boolean[] visited){
        int count = 0;

        // 방문하지 않은 노드를 DFS 탐색
        for(int i=1;i<visited.length;i++){
            if(!visited[i]) {
                DFS_list(i,list,visited);
                count++;
            }
        }

        return count;
    }

    public static void DFS_list(int v,LinkedList<Integer>[] list, boolean[] visited){
        visited[v] = true;

        Iterator<Integer> iter = list[v].listIterator();
        while(iter.hasNext()){
            int w = iter.next();
            if(!visited[w]){
                DFS_list(w,list,visited);
            }
        }
    }
}
