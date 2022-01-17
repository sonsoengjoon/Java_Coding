package test_2;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.*;
/*
원점에 가장 가까운 지점 구하기
두점사이의 거리 구하는 공식을 사용하야함.
원점에서 제일 가까운 좌표를 k개의 갯수만큼 리턴
[1,3] , [-2,2], k=1
 */
public class K_Closest_Points_to_Origin {
    public static void main(String[] args) {
        K_Closest_Points_to_Origin a = new K_Closest_Points_to_Origin();

        int[][] points = {{1,3}, {-2,2}};
        int k = 1;

        int[][] res = a.solve(points, k);
        a.print(res);

    }
    public int[][] solve(int[][] points, int k) {
        //1차원으로 받겠다
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1]));

        int[][] res = new int[k][2]; //k==1

        //2. while

        for(int[] p : points) {
            pq.offer(p);
        }

        int index =0;
        while(index < k) {
            res[index] = pq.poll(); //offer이 있으면 poll는 무조건 나옴
            index++;
       }
        return res;
    }

    public void print(int[][] res) {
        int m = res.length;
        int n = res[0].length;
        for(int i =0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(" [" + i + "][" + j + "] " + res[i][j]);
            }
            System.out.println();
        }
    }

}
