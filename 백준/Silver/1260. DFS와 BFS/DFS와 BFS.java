import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
        public static ArrayList<ArrayList<Integer>> map;

        public static boolean[] visitedDfs;
        public static boolean[] visitedBfs;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        visitedDfs = new boolean[N+1];
        visitedBfs = new boolean[N+1];

        map = new ArrayList<>();
        for(int i=0; i<=N; i++){
            map.add(new ArrayList<>());
        }
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++) {
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            int cnnct1 = Integer.parseInt(st1.nextToken());
            int cnnct2 = Integer.parseInt(st1.nextToken());

            map.get(cnnct1).add(cnnct2);
            if(!map.get(cnnct2).contains(cnnct1)){
                map.get(cnnct2).add(cnnct1);
            }
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(map.get(i)); // 오름차순 정렬
        }

        dfs(V);
        System.out.println();
        bfs(V);

    }

    public static void dfs(int node){
        visitedDfs[node] = true;
        System.out.print(node+ " ");

        for(int nod : map.get(node)){
            if(!visitedDfs[nod]){
                dfs(nod);
            }
        }
    }

    public static void bfs(int node){
        Queue<Integer> q = new LinkedList<>();

        q.offer(node);
        visitedBfs[node] = true;

        while(!q.isEmpty()){
            int target = q.poll();
            System.out.print(target+" ");

            for(int nod: map.get(target)){
                if(!visitedBfs[nod]){
                    q.offer(nod);
                    visitedBfs[nod] = true;
                }
            }
        }
        
    }
}

