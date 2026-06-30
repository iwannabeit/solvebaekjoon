import java.util.*;

class Solution {
    static boolean solution(String s) {
      boolean answer = true;

      Stack<Character> st = new Stack<>();
      if(s.charAt(0) == ')'){
        return false;
      }
      st.push(s.charAt(0));

      for(int i=1; i<s.length(); i++){
        if(s.charAt(i) == ')'){
          if(st.empty()){
            return false;
          }
          st.pop();
        } else{
          st.push(s.charAt(i));
        }

      }

      if(!st.empty()){
        return false;
      }

      return answer;
    }
}