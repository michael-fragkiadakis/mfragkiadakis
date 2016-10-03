y = int(input('Enter year (between 1900 and 2099):'))
a = y % 4
b = y % 7
c = y % 19
d = (19*c + 15) % 30
e = (2*a + 4*b - d +34) % 7
month = ((d + e + 114) // 31)
day = ((d + e + 114) % 31) + 1
if day <= 17 or (day == 18 and month != 4):
    day += 13
elif month == 4:
    day -= 17
    month += 1
else:
    day -= 18
    month += 1
print ('Day:', day, '\nMonth:', month)
print ('Date:', day, '/', month, '/', y)
