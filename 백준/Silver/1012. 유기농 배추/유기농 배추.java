
import java.io.*;
import java.util.*;

class Main {
    static boolean[][] visited;
    static int[][] map; 
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException{

        // InputStream is = _1012.class.getResourceAsStream("/org/input.txt");
        // BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line1 = new StringTokenizer(bf.readLine());
        
        int T = Integer.parseInt(line1.nextToken());

        for(int i=0; i<T; i++){
            int cnt = 0;

            StringTokenizer mnk = new StringTokenizer(bf.readLine());
            int M = Integer.parseInt(mnk.nextToken());
            int N = Integer.parseInt(mnk.nextToken());
            int K = Integer.parseInt(mnk.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int j=0; j<K; j++){
                StringTokenizer cabXY = new StringTokenizer(bf.readLine());
                int cabX = Integer.parseInt(cabXY.nextToken());
                int cabY = Integer.parseInt(cabXY.nextToken());
                map[cabY][cabX] = 1;
            }

            // System.out.println(Arrays.deepToString(map)); 

            for(int y=0; y<N; y++){
                for(int x=0; x<M; x++){
                    if(visited[y][x]){continue;}
                    // System.out.print(y+" "+x+" ");

                    if(!visited[y][x] && map[y][x] == 1){
                        dfs(x, y, N, M);
                        cnt++;
                    }
                    // visited[y][x] = true;
                }
            }
            System.out.println(cnt);
        }
        
    }

    static void dfs(int x, int y, int N, int M){
        visited[y][x] = true;
        for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0 || ny < 0 || nx >= M || ny >= N){continue;}

                if(!visited[ny][nx] && map[ny][nx] == 1){
                    // System.out.println(nx+" "+ny+" ");
                    dfs(nx, ny, N, M);
                }
            }
        
    }
}
