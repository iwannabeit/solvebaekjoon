import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        
        for(int num: nums){
            set.add(num);
        }
        
        System.out.println(set);
        if(set.size() < nums.length/2){
            answer = set.size();
        }
        else{
            answer = nums.length/2;
        }
        return answer;
    }
}