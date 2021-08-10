from collections import deque
import sys
input = sys.stdin.readline
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
def bfs(i, j):
    q = deque()
    q.append([i, j])
    max_len = 0
    while q:
        a, b = q.popleft()
        for k in range(4):
            x = a + dx[k]
            y = b + dy[k]
            if 0 <= x < n and 0 <= y < m and visit[x][y] == 0 and map[x][y] != "W":
                visit[x][y] = 1
                map[x][y] = map[a][b] + 1
                max_len = max(max_len, map[x][y])
                q.append([x, y])
    return max_len
n, m = map(int, input().split())
map = []
result = 0
for i in range(n):
    map.append(list(input().strip()))
for i in range(n):
    for j in range(m):
        if map[i][j] != "W":
            visit = [[0] * m for _ in range(n)]
            map[i][j] = 0
            visit[i][j] = 1
            result = max(result, bfs(i, j))
print(result)