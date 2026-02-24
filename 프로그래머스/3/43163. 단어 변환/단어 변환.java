import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<String>();
        boolean[] visited = new boolean[words.length];
        Queue<Integer> depthQ = new LinkedList<Integer>();

        int diffCnt = 0;      
        String nxtWord = "";
        
        q.offer(begin);
        depthQ.offer(0);
        
        while(!q.isEmpty()){
          nxtWord = q.poll();
          int depth = depthQ.poll();
          if(nxtWord.equals(target)){
            return depth;
          }
          for(int i=0; i<words.length; i++){
            if(visited[i]){ continue;}
            for(int j=0; j<begin.length(); j++){
              if(words[i].charAt(j) != nxtWord.charAt(j)){
                diffCnt++;
              }
            }

            if(diffCnt == 1){
              q.offer(words[i]);
              visited[i] = true;
              depthQ.offer(depth+1);
            }
            diffCnt=0;
          }
        }
        return 0;
    }
}