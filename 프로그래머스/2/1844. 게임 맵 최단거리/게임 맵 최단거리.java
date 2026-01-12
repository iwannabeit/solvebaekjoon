import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int answer = bfs(dx, dy, visited, maps);
    
        return answer;
    }
    
    static int bfs(int[] dx, int[] dy, boolean[][] visited, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[maps.length][maps[0].length];
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        dist[0][0] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                // 범위 체크
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length)
                    continue;
                //방문 check , map 조건 check 
                if(!visited[nx][ny] && maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    dist[nx][ny] = dist[x][y] + 1;
                    
                    if(visited[maps.length-1][maps[0].length-1]){
                        return dist[nx][ny];
                    }
                }

            }
        }
        if(!visited[maps.length-1][maps[0].length-1]){
            return -1;
        }
        return -1;
    }
}