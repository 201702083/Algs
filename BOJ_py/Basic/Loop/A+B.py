N = int(input())
c = [0 for i in range(0,N)]
for i in range(0,N):
    a,b = input().split()
    a = int(a)
    b = int(b)
    c[i] = a+b
for i in range(0,N):
    print('Case #' ,end='')
    print(i+1,end=': ')
    print(c[i])