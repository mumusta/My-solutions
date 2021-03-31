T = int(input())
fact = [ 1 ] * 25


for i in range(1,25):
    fact[i] = fact[i - 1] * i


for t in range(T):

    odd = 0
    den = 1
    n = int(input())
    str = input()
    cw = [ 0 ] * 30

    for c in str:
        cw[ord(c) - 97] += 1

    for i in range(30):
        if (cw[i] % 2 != 0):
            odd += 1

    if odd > 1:
        print('0')
        continue

    for i in range(30):
        den *= fact[cw[i] // 2]

    print(int(fact[n // 2] / den))
