package problem.programmers;

import java.util.*;

public class P_72412 {
        static class Solution {
            static Map<String, List<Integer>> map;
            public int[] solution(String[] info, String[] query) {
                List<Integer> answer = new ArrayList<>();
                map = new HashMap<>();
                for (String s : info) {
                    String[] s1 = s.split(" ");
                    setMap(s1, 0, new StringBuilder());
                }
                for (String s : map.keySet()) map.get(s).sort((o1, o2) -> o1 - o2);
                for (String s : query) {
                    String[] s1 = s.replaceAll(" and ", "")
                            .replaceAll("-", "").split(" ");
                    String key = s1[0];
                    int score = Integer.parseInt(s1[1]);
                    answer.add(binarySearch(key, score));
                }
                return answer.stream().mapToInt(Integer::intValue).toArray();
            }

            private int binarySearch(String key, int score) {
                if(!map.containsKey(key)) return 0;
                List<Integer> list = map.get(key);
//                if(list.get(0) > score) return list.size(); //점수가 너무 높음
//                else if(list.get(list.size()-1) < score) return 0; // 점수가 너무 낮음

                int ans = -1;

                int low = 0;
                int hi = list.size() - 1;
                while (low <= hi) {
                    int mid = (low + hi) / 2;
                    int t = list.get(mid);
                    if(t == score){
                        ans = mid;
                        hi = mid - 1;
                    }
                    else if(t > score){ // 중간 값보다 작을 떄
                        hi = mid - 1; // 탐색범위를 작은 범위로 당김
                    }else{
                        low = mid + 1;
                    }
                }
                ans = ans != -1 ? ans : low;
                return list.size() - ans;

            }
            private void setMap(String[] s1,int idx,StringBuilder sb){
                if(idx == 4){
                    if(!map.containsKey(sb.toString())) map.put(sb.toString(), new ArrayList<>());
                    map.get(sb.toString()).add(Integer.parseInt(s1[4]));
                    return;
                }
                setMap(s1, idx + 1, sb);
                String tmp = s1[idx];
                sb.append(tmp);
                setMap(s1, idx + 1, sb);
                sb.delete(sb.length() - tmp.length(), sb.length());
            }
        }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(new String[]{
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        }, new String[]{
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        });
        System.out.println(Arrays.toString(solution));
    }


}
