import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(String mem: participant){
            map.put(mem, map.getOrDefault(mem, 0) + 1); //기존 key 값이 있다면 +1을 해서 개수를 증가
        }
        
        for(String completeMem: completion){
            if(map.containsKey(completeMem))
                map.put(completeMem, map.get(completeMem) - 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                answer = key;
            }
        }   
        
        return answer;
    }
}