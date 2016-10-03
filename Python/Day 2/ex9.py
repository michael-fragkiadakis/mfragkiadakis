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
