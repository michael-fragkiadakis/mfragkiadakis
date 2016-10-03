num = input('Enter binary number:')
for x in num:
    if int(x) % 2 == 1:
        print (x, end=' ')
print()
for x in num:
    if int(x) % 2 == 0:
        print (x, end=' ')

