nums = input('Enter numbers: ')
lista = nums.split(' ')
i = 0
for x in lista:
    if int(x) < 10:
        print (' '*2+x, end='+')
print ()
for x in lista:
    if 10 <= int(x) < 100:
        print (' '+x, end='+')
print ()
for x in lista:
    if 100 <= int(x):
        print (x, end='+')
