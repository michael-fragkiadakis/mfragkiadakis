byte = input('Enter binary number:')
last = int(byte[-1])
byt = byte[:7]
count = 0
for x in byt:
    if int(x) == 1:
        count += 1
if count % 2 == last:
    print ('Parity check OK.')
else:
    print ('Parity check NOT OK.')
