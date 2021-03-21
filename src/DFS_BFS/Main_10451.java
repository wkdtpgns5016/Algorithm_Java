package DFS_BFS;

import java.io.*;
import java.util.StringTokenizer;

// BOJ 10451 - 순열 사이클
public class Main_10451 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            boolean[] visited = new boolean[n+1];

            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line," ") ;
            for(int k=1;k<=n;k++){
                arr[k] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for(int k=1;k<=n;k++){
                if(visited[k]) continue;
                else{
                    int idx = k;
                    while(k != arr[idx]){
                        visited[idx] = true;
                        idx = arr[idx];
                    }
                    visited[idx] = true;
                    count++;
                }
            }
            bw.write(Integer.toString(count)+'\n');
            bw.flush();
        }
    }
}
