import java.util.*;

class Solution {
  static Map<String, Integer> map = new HashMap<>();

  static int solution(String[][] clothes){
      int answer = 1;
      for(String[] clothe: clothes){
          //key 있으면 해당 key 의 value + 1
          if(map.containsKey(clothe[1])){
            map.put(clothe[1], map.get(clothe[1])+1);
          } else{
            map.put(clothe[1], 2);
          }
      }

      for(int value: map.values()){
        answer *= value;
      }

      System.out.println(answer-1);
    return answer-1;
  }
    
    
}