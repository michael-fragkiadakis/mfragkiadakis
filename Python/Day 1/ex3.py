import math
a = int(input("First triangle side's length in centimeters:"))
b = int(input("Second triangle side's length in centimeters:"))
c = int(input("Third triangle side's length in centimeters:"))
A = math.sqrt((a + b + c) * (- a + b + c) * (a - b + c) * (a + b - c)) / 4
# Some length combinations are not feasible and therefore produce unrealistic results.
print ("The area of your triangle is", A, "square centimeters.")
