class Solution {
      public static long solution(int n, int[] times) {
      long start = 0;
      long maxtime = 0;
      long answer = 0;
      
      for(int i: times){
        maxtime = Math.max(maxtime, i);
      }
      long end = maxtime*n;


      while(start<=end){
        long possible = 0;
        long mid = (start+end)/2;

        for(int i: times){
          possible += mid/i;
        }

        if(possible >= n){
          answer = mid;
          end = mid-1;
        }else{
          start = mid+1;
        }

      }
      return answer;
  }
}