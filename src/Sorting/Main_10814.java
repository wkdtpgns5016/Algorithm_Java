package Sorting;

import java.io.*;
import java.util.StringTokenizer;

// BOJ 10814 - 나이순 정렬
public class Main_10814 {
    public static int[] ages;
    public static int[] temp_ages;
    public static String[] names;
    public static String[] temp_names;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        ages = new int[n];
        temp_ages = new int[n];
        names = new String[n];
        temp_names = new String[n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            ages[i] = Integer.parseInt(st.nextToken());
            names[i] = st.nextToken();
        }

        mergeSorting(0,n-1);

        for(int i=0;i<n;i++){
            bw.write(ages[i]+" "+names[i]+"\n");
        }
        bw.flush();
    }
    public static void merge(int start, int mid, int end){
        int i,j,k,l;
        i = start;
        j = mid+1;
        k = start;

        while(i<=mid && j<=end){
            if(ages[i] <= ages[j]){
                temp_ages[k] = ages[i];
                temp_names[k] = names[i];
                k++; i++;
            }
            else {
                temp_ages[k] = ages[j];
                temp_names[k] = names[j];
                k++; j++;
            }
        }

        if(i>mid){
            for(l=j;l<=end;l++){
                temp_ages[k] = ages[l];
                temp_names[k] = names[l];
                k++;
            }
        }
        else{
            for(l=i;l<=mid;l++){
                temp_ages[k] = ages[l];
                temp_names[k] = names[l];
                k++;
            }
        }
        for(l=start;l<=end;l++){
            ages[l] = temp_ages[l];
            names[l] = temp_names[l];
        }
    }
    public static void mergeSorting(int start, int end){
        if(start == end) return;
        int mid = (start + end) / 2;

        mergeSorting(start,mid);
        mergeSorting(mid+1,end);
        merge(start,mid,end);
    }
}
