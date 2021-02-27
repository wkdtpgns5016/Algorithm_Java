package DP;
import java.io.*;

// BOJ 9465 - 스티커
public class Main_9465{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int idx = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][idx];
            int[][] score = new int[2][idx];

            for (int j = 0; j < 2; j++) {
                String[] line = br.readLine().split(" ");
                for (int k = 0; k < idx; k++) {
                    sticker[j][k] = Integer.parseInt(line[k]);
                }
            }
            score[0][0] = sticker[0][0];
            score[1][0] = sticker[1][0];
            score[0][1] = sticker[1][0] + sticker[0][1];
            score[1][1] = sticker[0][0] + sticker[1][1];

            for (int j = 2; j < idx; j++) {
                score[0][j] = Math.max(score[1][j-1],score[1][j-2]) + sticker[0][j];
                score[1][j] = Math.max(score[0][j-1],score[0][j-2]) + sticker[1][j];
            }
            System.out.println(Math.max(score[0][idx-1], score[1][idx-1]));
        }
    }
}