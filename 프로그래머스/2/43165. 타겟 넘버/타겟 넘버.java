class Solution {
    static int numDepth;
    static int targetNum;
    static int cnt = 0;
    static int[] numbers;
    
    public int solution(int[] number, int target) {
        targetNum = target;
        numbers = number;
        numDepth = numbers.length;
        dfs(0,0);
        return cnt;
    }
    
    static void dfs(int depth, int sum){
        if(depth == numDepth){
            if(sum == targetNum){
                cnt++;
            }
            return;
        }

        dfs(depth+1, sum+numbers[depth]);
        dfs(depth+1, sum-numbers[depth]);

    }
}