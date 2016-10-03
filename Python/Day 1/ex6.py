num = int(input("Enter number of triangle numbers:"))
for n in range (num+1):
    result = n * (n+1) / 2
    print (int(result), end=" ")
