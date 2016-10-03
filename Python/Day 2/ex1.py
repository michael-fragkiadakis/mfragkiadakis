TIN = input('Enter Tax Identification Number:')
last = int(TIN[-1])
lista = []
summ = 0
j = 1
for i in range (7,-1,-1):
    lista.append(int(TIN[i]))
for x in lista:
    summ += x * 2**j
    j += 1
    a = summ % 11
if a % 10 == last:
    print ('Tax Identification Number valid.')
else:
    print ('Tax Identification Number NOT valid.')
