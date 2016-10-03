num = input('Enter 9 digit number:')
i = 0
for x in num:
    if i % 3 == 0:
        print (x, end='')
    else:
        print (' ', end='')
    i += 1
print ()
for x in num:
    if i % 3 == 1:
        print (x, end='')
    else:
        print (' ', end='')
    i += 1
print ()
for x in num:
    if i % 3 == 2:
        print (x, end='')
    else:
        print (' ', end='')
    i += 1
