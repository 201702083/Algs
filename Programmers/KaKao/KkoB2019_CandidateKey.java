import java.util.*;
import java.util.stream.Collectors;


public class KkoB2019_CandidateKey {
    public static void main(String[] args) {
        String[][] testCase = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        Solution sol = new Solution();
        System.out.println(sol.solution(testCase));
    }
    static class Solution {

        private String[][] table;
        private int colCount;
        private Set<Key> candidates = new HashSet<>();

        public int solution(String[][] relation) {
            table = relation;
            colCount = relation[0].length;
            findCandidateKeys();
            return candidates.size();
        }
        private void findCandidateKeys() {
            for (int i = 1; i <= colCount; i++)
                dfs(new int[i], new boolean[colCount], 0, 0, i);
        }

        private void dfs(int[] result, boolean[] visited, int start, int depth, int targetLength) { // 가능한 키 조합 모두 탐색
            if (depth == targetLength) { // 탐색 개수 채우면
                Key newKey = new Key(Arrays.stream(result).boxed().collect(Collectors.toList()));
                if (isCandidate(newKey)) candidates.add(newKey); // 후보키 조건 충족 시 추가
                return;
            }

            for (int i = start; i < colCount; i++) {
                if (!visited[i]) { // 방문안했으면 체크 후 재귀호출
                    visited[i] = true;
                    result[depth] = i;
                    dfs(result, visited, i + 1, depth + 1, targetLength);
                    visited[i] = false;
                    result[depth] = 0;
                }
            }
        }

        private boolean isCandidate(Key key) { // 후보키 체크
            return isUnique(key) && isMinimum(key);
        }

        private boolean isUnique(Key key) { // 유일성 체크
            Set<String> rows = new HashSet<>();
            for (int i = 0; i < table.length; i++) {
                String current = "";
                for (int attribute : key.attributes) current += table[i][attribute];
                if (rows.contains(current)) return false;
                rows.add(current);
            }
            return true;
        }

        private boolean isMinimum(Key key) { // 최소성 체크
            for (Key candidate : candidates)
                if (key.contains(candidate)) return false;
            return true;
        }
    }


    static class Key { // Key 객체
        List<Integer> attributes;

        public Key(List<Integer> attributes) {
            this.attributes = attributes;
        }

        public boolean contains(Key target) {
            for (int attribute : target.attributes)
                if (!this.attributes.contains(attribute)) return false;
            return true;
        }
    }
}

