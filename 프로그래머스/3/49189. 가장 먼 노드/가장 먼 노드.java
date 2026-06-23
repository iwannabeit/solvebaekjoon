import java.util.*;

class Solution {
    static int solution(int n, int[][] edges){
    int[] dist = new int[n+1];
    int maxDist = 0;
    int cnt = 0;
    boolean[] visit = new boolean[n+1];
    ArrayList<Integer>[] list = new ArrayList[n+1];

    for(int i=0; i<=n; i++){
      list[i] = new ArrayList<>();
    }

    for(int[] edge: edges){
      list[edge[0]].add(edge[1]);
      list[edge[1]].add(edge[0]);
    }


    maxDist = bfs(list, dist, visit, n);
    
    for(int i=1; i<dist.length; i++){
      if(dist[i] == maxDist)
        cnt++;
    }
    return cnt;
  }

  public static int bfs(ArrayList<Integer>[] list, int[] dist, boolean[] visit, int n){
    Queue<int[]> q = new LinkedList<>();
    int maxDist = 0;
    
    q.offer(new int[]{1, 0});
    visit[1] = true;
    dist[1] = 0;

    while(!q.isEmpty()){
      int[] poll = q.poll();
      
      for(int i=0; i<list[poll[0]].size(); i++){
        int curNode = list[poll[0]].get(i);

        if(!visit[curNode] ){
          visit[curNode] = true;
          dist[curNode] = dist[poll[0]]+1;
          maxDist = Math.max(maxDist, dist[curNode]);
          q.offer(new int[]{curNode, dist[curNode]});
        }
      }
    }
    
    return maxDist;
  }
}