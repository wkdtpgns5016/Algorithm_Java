package Sorting;

import java.io.*;
import java.util.StringTokenizer;


// BOJ 10825 - 국영수
public class Main_10825 {
    public static int[][] grade;
    public static int[][] temp_grade;
    public static String[] name;
    public static String[] temp_name;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        grade = new int[n][3];
        temp_grade = new int[n][3];
        name = new String[n];
        temp_name = new String[n];

        for(int i=0;i<n;i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line," ");

            name[i] = st.nextToken();
            for(int j=0;j<3;j++){
                grade[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        mergeSorting(0,n-1);
        for(int i=0;i<n;i++){
            bw.write(name[i] + "\n");
        }
        bw.flush();
    }
    public static void setValue(int k, int i){
        temp_grade[k][0] = grade[i][0];
        temp_grade[k][1] = grade[i][1];
        temp_grade[k][2] = grade[i][2];

        temp_name[k] = name[i];
    }
    public static void merge(int start, int mid, int end){
        int i,j,k,l;

        i = start;
        j = mid+1;
        k = start;

        while(i<=mid && j<=end){
            if(grade[i][0]>grade[j][0]){
                setValue(k,i);
                k++; i++;
            }
            else if(grade[i][0]<grade[j][0]){
                setValue(k,j);
                k++; j++;
            }
            else{
                if(grade[i][1]>grade[j][1]){
                    setValue(k,j);
                    k++; j++;
                }
                else if(grade[i][1]<grade[j][1]){
                    setValue(k,i);
                    k++; i++;
                }
                else{
                    if(grade[i][2]>grade[j][2]){
                        setValue(k,i);
                        k++; i++;
                    }
                    else if(grade[i][2]<grade[j][2]){
                        setValue(k,j);
                        k++; j++;
                    }
                    else{
                        // 단어 사전 정렬
                        if(name[i].compareTo(name[j]) <= 0){
                            setValue(k,i);
                            k++; i++;
                        }
                        else{
                            setValue(k,j);
                            k++; j++;
                        }
                    }
                }
            }
        }

        if(i>mid){
            for(l = j; l <= end; l++){
                setValue(k,l);
                k++;
            }
        }
        else{
            for(l = i; l <= mid; l++){
                setValue(k,l);
                k++;
            }
        }
        for(l = start; l <= end; l++){
            grade[l][0] = temp_grade[l][0];
            grade[l][1] = temp_grade[l][1];
            grade[l][2] = temp_grade[l][2];
            name[l] = temp_name[l];
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