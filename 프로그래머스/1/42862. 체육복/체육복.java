import java.util.*;


class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌이 있는 학생이 도난당한 경우 먼저 제외
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        
        for (int l : lost) {
            if (Arrays.stream(reserve).anyMatch(r -> r == l)) {
                reserveList.add(l);  // 자기 체육복을 입음
            } else {
                lostList.add(l);
            }
        }

        int answer = n - lostList.size(); // 기본적으로 체육복을 가진 학생 수

        // 체육복 빌려주기
        for (int r : reserve) {
            if (reserveList.contains(r)) continue; // 자기 체육복을 입은 경우 제외

            for (int i = 0; i < lostList.size(); i++) {
                int l = lostList.get(i);
                if (r == l - 1 || r == l + 1) {  // 앞뒤 학생에게 빌려줄 수 있는지 확인
                    answer++;
                    lostList.remove(i);
                    break;
                }
            }
        }

        return answer;
    }
    
}

