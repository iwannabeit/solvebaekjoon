class Solution {
    public int solution(int[][] sizes) {
        if(sizes.length == 0)
            return 0;
        int maxX = 0;
        int maxY = 0;
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int tmp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = tmp;
            }
            
            if(sizes[i][0] > maxX)
                maxX = sizes[i][0];
            if(sizes[i][1] > maxY)
                maxY = sizes[i][1];
            System.out.println(sizes[i][0] + " " + sizes[i][1]);
        }
        
        return maxX * maxY;
    }

}