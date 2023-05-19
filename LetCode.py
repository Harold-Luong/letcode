def roman_to_interger(s):
    my_dict = {"I": 1, 
               "V": 5, 
               "X": 10, 
               "L": 50, 
               "C": 100, 
               "D": 500, 
               "M": 1000}
    i = len(s)-1
    total = 0 
    prevValue = 0
    for char in reversed(s) :
        curent = my_dict[char]
        if(curent >= prevValue):
            total += curent
        else:
            total -= curent
        prevValue = curent
    return total


def number_of_steps(num):
    count = 0
    while (num > 0):
        if(num % 2 ==0):
            num = num/2
            count += 1
        else:
            num -=1
            count +=1
    return count







print( number_of_steps(123))


 