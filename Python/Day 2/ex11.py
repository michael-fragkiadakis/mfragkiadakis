limit = int(input ('Enter limit: '))
ten = []
counter = 0
for i in range(3, limit+1):
    a = 0
    for j in range(limit//2+1):
        if i == 2**j:
            a = 1
            break
    if a == 0:
        if counter < 10:
            counter += 1
        else:
            counter = 1
            print ()
        print (i, end=' ')
