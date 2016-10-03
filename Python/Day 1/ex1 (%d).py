for i in range (1,10):
    result = 0
    for j in range (i):
        result += i* 10**j
    print ("%09d" % (result))
