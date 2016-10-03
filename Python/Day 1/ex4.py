import math
print ("Quadratic equation (ax^2+bx+c) root finder")
a = int(input("Enter a value:"))
b = int(input("Enter b value:"))
c = int(input("Enter c value:"))
if b**2 - 4*a*c < 0:
    print ("No real-valued solutions exist.")
else:
    print ("The roots of this equation are:")
    x1 = (-b + math.sqrt(b**2 - 4*a*c)) / 2*a
    print ("x1 =", x1)
    x2 = (-b - math.sqrt(b**2 - 4*a*c)) / 2*a
    print ("x2 =", x2)

