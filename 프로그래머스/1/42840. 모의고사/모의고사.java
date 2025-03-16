import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {0, 0, 0};
        List<Integer> result = new ArrayList<>();
        
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i=0; i<answers.length; i++){
            if(first[i%5] == answers[i])
                answer[0] += 1; 
            
            if(second[i%8] == answers[i])
                answer[1] += 1;
            
            if(third[i%10] == answers[i])
                answer[2] += 1;
        }
        
        System.out.println(answer);
        
        // 최대값 찾기
        int maxValue = Arrays.stream(answer).max().getAsInt();

        // 최대값의 인덱스를 찾아 +1 후 리스트에 저장
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == maxValue) {
                result.add(i + 1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}