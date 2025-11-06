import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
                Set<String> set = new HashSet<>(Arrays.asList(phone_book));
        for (String num : phone_book) { 
            // num의 모든 접두사 검사 (자기 자신은 제외하려고 len-1까지) 
            for (int k = 1; k < num.length(); k++) { 
                if (set.contains(num.substring(0, k))) { 
                    return false; 
                } 
            } 
        } return true;
    }
}