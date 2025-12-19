import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int answer = 0;
    
    static int solution(int n, int[][] computers){
        boolean[] visited = new boolean[computers.length];
        answer = computers.length;
        for(int start=0; start<computers.length; start++){
            if(visited[start]) continue;
            dfs(start, visited, computers);
        }
        return answer;
    }

    static void dfs(int idx, boolean[] visited, int[][] computers){
        visited[idx] = true;

        for(int i=0; i<computers[idx].length; i++){
            if(computers[idx][i] == 1 && !visited[i]){
                answer -= 1;
                dfs(i, visited, computers);
            }
        }
    }
}