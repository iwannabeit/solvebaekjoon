import java.util.Arrays;

class Solution {
    public static int solution(int[] scoville, int K){
        Minheap minheap = new Minheap();

        int[] heap = new int[scoville.length+1];
        int heapsize = 0;
        

        for(int j=0; j<scoville.length; j++){
            heapsize = minheap.insert(scoville[j], heap, heapsize);
        }

        int trial = 0;

        while(heap[1] < K && heapsize >= 2){

            int min1 = heap[1];
            heapsize = minheap.delete(heap, heapsize);
            int min2 = heap[1];
            heapsize = minheap.delete(heap, heapsize);

            int mix = min1+(min2*2);
            heapsize = minheap.insert(mix, heap, heapsize);
            trial++;
        }
        if(heap[1] < K){
            return -1;
        }
        return trial;

        
    }

}

class Minheap{
    public int insert(int value, int[] heap, int heapsize){
        heapsize++;
        int idx = heapsize;

        while(idx != 1 && value < heap[idx/2]){
            heap[idx] = heap[idx/2];
            idx = idx/2;
        }
        heap[idx] = value;
        return heapsize;
    }

    public int delete(int[] heap, int heapsize){
        if(heapsize == 0){
            return 0;
        }

        // 마지막 자식을 루트로(최소값 삭제)
        heap[1] = heap[heapsize];
        heap[heapsize] = -1;
        heapsize--;

        int i=1;

        while(true){
            int left = 2*i;
            int right = 2*i+1;

            // 자식이 없다 : 종료
            if(left > heapsize){
                break;
            }

            //왼/오 중 작은자식
            int smaller = left;
            if(right <= heapsize && heap[right] < heap[left]){
                smaller = right;
            }

            //부모가 더 작으면 종료
            if(heap[i] <= heap[smaller]) break;

            //그 외는 swap
            int tmp = heap[i];
            heap[i] = heap[smaller];
            heap[smaller] = tmp;

            //스왑된 자식 위치로
            i = smaller;
        }
        
        return heapsize;
    }
}