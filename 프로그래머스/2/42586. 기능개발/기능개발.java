import java.util.Arrays;

class Solution {
    public int[] solution(int[] progress, int[] time){
        int idx = 0;
        int releaseIdx = 0;
        int[] released = new int[progress.length];

        while(idx < progress.length){
            // 1. 하루 진행
            for(int i=0; i<progress.length; i++){
                progress[i] += time[i];
                if(progress[i] >= 100){
                    progress[i] = 100;
                }
            }
            // 2. 배포 가능하면 한 번에 쭉 배포
            if(progress[idx] == 100){
                // 해당 idx부터 연속 100이면 같은 날 배포. released 인덱스 증가x
                while(idx < progress.length && progress[idx] == 100){
                    released[releaseIdx] += 1;
                    idx++;
                }
                // 다음 진행 index가 100이 아니면 다른 배포 묶음. released 인덱스 증가
                releaseIdx++;
            }
        }
        return Arrays.copyOf(released, releaseIdx);
    }
}