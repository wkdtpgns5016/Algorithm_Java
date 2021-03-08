package Sorting;
import java.io.*;
import java.util.StringTokenizer;

// BOJ 11650 - 좌표 정렬하기
public class Main_11650 {
    public static int[][] arr;
    public static int[][] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][2];
        temp = new int[n][2];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        mergeSorting(0,arr.length-1);
        for(int i=0; i<n; i++){
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }
        bw.flush();
    }

    public static void mergeSorting(int start, int end){
        if(start == end) return;
        int mid = (start + end) / 2;
        mergeSorting(start,mid);
        mergeSorting(mid+1,end);
        merge(start,mid,end);
    }
    public static void merge(int start,int mid, int end){
        int i, j, k, l;
        i = start;
        j = mid+1;
        k = start;

        // 분할 정렬된 배열들의 합병
        while(i<=mid && j<=end){
            if(arr[i][0]<arr[j][0]){
                temp[k][0] = arr[i][0];
                temp[k][1] = arr[i][1];
                k++; i++;
            }
            else if(arr[i][0]>arr[j][0]){
                temp[k][0] = arr[j][0];
                temp[k][1] = arr[j][1];
                k++; j++;
            }
            else{
                if(arr[i][1]<=arr[j][1]){
                    temp[k][0] = arr[i][0];
                    temp[k][1] = arr[i][1];
                    k++; i++;
                }
                else{
                    temp[k][0] = arr[j][0];
                    temp[k][1] = arr[j][1];
                    k++; j++;
                }
            }
        }

        // 남아 있는 값들을 일괄 복사
        if(i>mid){
            for(l=j;l<=end;l++){
                temp[k][0] = arr[l][0];
                temp[k][1] = arr[l][1];
                k++;
            }
        }
        else{
            for(l=i;l<=mid;l++){
                temp[k][0] = arr[l][0];
                temp[k][1] = arr[l][1];
                k++;
            }
        }

        // 배열 temp[](임시 배열)의 리스트를 배열 arr[]로 재복사
        for(l=start;l<=end;l++){
            arr[l][0] = temp[l][0];
            arr[l][1] = temp[l][1];
        }
    }
}