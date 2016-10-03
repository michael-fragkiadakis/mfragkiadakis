seq = input ('Enter binary sequence: ')
counter = 1
final = 0
a = seq[0]
for x in seq[1:]:
    if x == a:
        counter += 1
        if counter > final:
            final = counter
    else:
        counter = 1
    a = x
print (final)

