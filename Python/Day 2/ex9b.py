shift = int(input ('Enter shift: '))
phrase = input ('Enter phrase: ')
ords = []
chars = []
i = 0
ceasar = ''
for x in phrase:
    ords.append(ord(x) + shift)
    chars.append(chr(ords[i]))
    ceasar += chars[i]
    i += 1
print (ceasar)
ords = []
chars = []
i = 0
original = ''
for x in ceasar:
    ords.append(ord(x) - shift)
    chars.append(chr(ords[i]))
    original += chars[i]
    i += 1
print (original)
