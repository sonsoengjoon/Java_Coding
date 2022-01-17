package test_2;

import java.util.Arrays;

/*
미팅 시간 배열이 주어진다. interval[i] = [start, end]
intervals배열을 이용하여 사람들이 모든 회의에 참석할 수 있는 지 boolean으로 리턴하세요

Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
 */
public class Meeting_Room {
    public static void main(String[] args) {

        Meeting_Room a = new Meeting_Room();

        //int[][] intervals = {{5,10}, {16,20}, {0,30}};
        int[][] intervals = {{7,10}, {2,4}};
        System.out.println(a.solve(intervals));
    }

    public boolean solve(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return true;

        //1. sorting
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]); //오름차순순
        print(intervals);
       //2. for
        int end = intervals[0][1]; //30
        for(int i = 1; i<intervals.length; i++) {
            // 5 ,10
            // 앞회의 에 있는 끝시작과 다음 회의의 시작 회의시간을 비교
            if(intervals[i][0] < end) {
                return false; // 겹친다는 뜻
            }
            end = intervals[i][1]; //이제 다음 회의의 끝시간을 end에 대입
        }
        return true; // 끝까지 문제없으면 겹치는게 없다는 뜻
    }

    private void print(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j =0; j < grid[0].length; j++) {
                System.out.println(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
