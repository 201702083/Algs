n = int(input())
cnt = 0
require = 666
while True:
    if '666' in str(require):
        cnt += 1
    if cnt == n:
        print(require)
        break
    require += 1