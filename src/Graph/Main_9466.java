package Graph;

import java.io.*;
import java.util.StringTokenizer;

// BOJ 9466 - 텀프로젝트
public class Main_9466 {
    // 블로그 참조 : 깊이우선탐색적용 - https://geehye.github.io/baekjoon-9466/#
    static int[] arr;
    static boolean[] visited, done;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());;
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line," ");

            arr = new int[n+1];
            visited = new boolean[n+1];
            done = new boolean[n+1];
            count = 0;

            for(int j=1;j<=n;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=1;j<=n;j++){
                if(!done[j]) dfs(j);
            }
            bw.write(Integer.toString(n-count)+'\n');
            bw.flush();
        }
    }

    public static void dfs(int v){
        if(visited[v]) {
            done[v] = true;
            count++;
        }else visited[v] = true;

        if(!done[arr[v]]) dfs(arr[v]);
        visited[v] = false;
        done[v] = true;
    }
}
