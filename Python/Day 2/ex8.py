seq = input('Enter number sequence: ')
i, j, summ = 0, 0, 0
pairfirst = []
pairsecond = []
for x in seq:
    if i % 2 == 0:
        pairfirst.append(int(x))
    else:
        pairsecond.append(int(x))
    i += 1
for x in pairsecond:
    summ += x * pairfirst[j]
    j += 1
if len(pairsecond) != len (pairfirst):
    summ += pairfirst[-1]
print (summ)
