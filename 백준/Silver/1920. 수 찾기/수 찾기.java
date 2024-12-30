import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

//        ------------- 여기서부터 코드 작성 -------
        HashMap<Integer, Integer> arr = new HashMap<>();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line1 = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(line1.nextToken());

        StringTokenizer line2 = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            int val = Integer.parseInt(line2.nextToken());
            arr.put(val, val);
        }

        StringTokenizer line3 = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(line3.nextToken());

        StringTokenizer line4 = new StringTokenizer(bf.readLine());
        for(int i=0; i<M; i++){
            int target = Integer.parseInt(line4.nextToken());
            if(!arr.containsKey(target)){
                System.out.println(0);
                continue;
            }
            System.out.println(1);
        }
        
    }
}