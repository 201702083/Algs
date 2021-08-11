str = input()
find = input()
answer = 0
idx = 0

while idx <= len(str) - len(find):
    if str[idx:idx + len(find)] == find:
        answer += 1
        idx += len(find)
    else:
        idx += 1

print(answer)
