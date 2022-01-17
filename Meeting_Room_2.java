package test_2;
import java.util.Comparator;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// 미팅 시간 배열이 주어진다. interval[i] = [start, end]
// intervals 배열을 이용하여 사람들이 회의에 참석하려면 몇 개의 회의실이 필요한지 리턴
/*
1. 아이디어
: 우선순위 큐를 이용해서, 회의끝시간이 제일 긴것을 관리한다.
앞.end 뒷.start 시간을 비교해서 회의실 추가가 필요 없는 것은 하나로 합치고,
추가가 필요한것은 큐에 넣는다
 */
public class Meeting_Room_2 {
    public static void main(String[] args) {

        Meeting_Room_2 a = new Meeting_Room_2();
        int[][] intervals = {{5,10}, {16,20}, {0,30}};
        //int[][] intervals = {{6,10}, {1,7}, {6,20}};
        //int[][] intervals = {{6,10}, {1,3}};

        System.out.println(a.solve_1(intervals));
        System.out.println(a.solve_heap(intervals));
    }

    public int solve_1(int[][] intervals) {
        // 앞 오른차순 -> 0 , 5, 30
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        int end = intervals[0][1]; //(0,30) (5,10) (16,20)
        int room = 1;
        for(int i =1; i<intervals.length; i++) {

            if(intervals[i][0] < end) {
                room++;
            }
            end = intervals[i][1];
        }
        return room;
    }

    public int solve_heap(int[][] intervals) {
        // 앞 오른차순 -> 0 , 5, 30
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        // 뒷(end time) 오름차순 정리
        Queue<int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        //2. for pq
        for(int[] arr: intervals) {
            if(q.isEmpty()) q.add(arr); //(0,30) (5,10)
            else {
                if(q.peek()[1] <= arr[0]) {
                    //10 <= 16을 비교
                    q.poll();
                }
                q.offer(arr); // 16,20
            }
        }
        return q.size();
    }
}
