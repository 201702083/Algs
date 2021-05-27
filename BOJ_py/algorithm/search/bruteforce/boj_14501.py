def recursive_solution(date, sum):
    global answer
    if date == N + 1:
        answer = max(sum, answer)
        return
    if date > N + 1:
        return

    # 상담 진행과 패스 두 가지 모두 탐색
    recursive_solution(date + T[date], sum + P[date])
    recursive_solution(date + 1, sum)

N = int(input())
answer = 0

T = [0] * (N+1)
P = [0] * (N+1)
for i in range (1,N+1):
    T[i], P[i] = map(int, input().split())
recursive_solution(1,0)
print(answer)