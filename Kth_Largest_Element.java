package test_2;
// k번 째 제일 큰 원소
// 정수 배열 nums와 정수 k가 주어지면 배열에서 k번째로 큰 요소를 반환합니다.
// k번째로 큰 요소는 정렬 후 값에 대한 가장 큰 요소가 아닌 유일한 순서 요소입니다.

/*
내 생각: 비교를 해야 될 거 같다. 단순한 크기 순이 아니라 순서로
보기 때문에 for문을 돌면서 첫번째 숫자랑 그 뒤를 다 비교(빼기를 해서 가장 큰 값을 마지막 배열에 넣기)
단 양수이면
 */
/*
MIN HEAP으로 푼다.
 */


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kth_Largest_Element {
    public static void main(String[] args) {
        Kth_Largest_Element a = new Kth_Largest_Element();

        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k =4;
        System.out.println(a.solve(nums, k));
        System.out.println(a.solve_pq(nums, k));
    }

    public int solve(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n-k]; //1,2,2,3,3,4,5,5,6


    }

    public int solve_pq(int[] nums, int k) {
        //1
        Queue<Integer> pq = new PriorityQueue<>(); //asc minHeap

        //2
        for(int i : nums) {
            pq.offer(i);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
