package Sorting;

import java.io.*;
import java.util.*;

// BOJ 2751 - 수 정렬2 O(nlogn)
public class Main_2751 {
    // 내가 푼 방법이 계속 시간초과가 나서 검색해서 풀었다..

    /*내가 제출했던 코드 : 시간초과 발생
    * 맨 밑에 제출한 코드와 출처 명시
    * */
    public static int[] arr;
    public static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<Integer>();
        arr = new int[n];
        temp = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSorting(arr,0,n-1);

        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }

    public static void mergeSorting(int[] arr,int start, int end){
        if(start == end) return;
        int mid = (start + end) / 2;
        mergeSorting(arr,start,mid);
        mergeSorting(arr,mid+1,end);
        merge(arr,start,mid,end);
    }
    public static void merge(int[] arr,int start,int mid, int end){
        int i, j, k, l;
        i = start;
        j = mid+1;
        k = start;

        // 분할 정렬된 배열들의 합병
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }

        // 남아 있는 값들을 일괄 복사사
       if(i>mid){
            for(l=j;l<=end;l++){
                temp[k++] = arr[l];
            }
        }
        else{
            for(l=i;l<=mid;l++){
                temp[k++] = arr[l];
            }
        }

        // 배열 temp[](임시 배열)의 리스트를 배열 arr[]로 재복사
        for(l=start;l<=end;l++){
            arr[l] = temp[l];
        }
    }

    public static void quickSorting(int[] arr,int start, int end){
        if(start>=end) return;

        int pivot = arr[(start+end)/2];
        int left = start;
        int right = end;

        while(left <= right){
            while(pivot > arr[left]) left++;
            while(pivot < arr[right]) right--;

            if(left <= right){

                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        quickSorting(arr,start,right);
        quickSorting(arr,left,end);
    }
}
/*
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = in.nextInt();

        // list 계열 중 하나를 쓰면 된다.
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(in.nextInt());
        }
        Collections.sort(list);
        for(int value : list) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}
*/
// 출처: https://st-lab.tistory.com/106 [Stranger's LAB]
