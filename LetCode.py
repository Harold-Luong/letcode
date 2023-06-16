import random


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
    for char in reversed(s):
        curent = my_dict[char]
        if (curent >= prevValue):
            total += curent
        else:
            total -= curent
        prevValue = curent
    return total


def number_of_steps(num):
    count = 0
    while (num > 0):
        if (num % 2 == 0):
            num = num/2
            count += 1
        else:
            num -= 1
            count += 1
    return count


def random_num(s, e):
    return random.randrange(s, e, 2)


def is_primes(y):
    if (y < 2):
        return False
    else:
        for i in range(2, int((y**0.5)+1)):
            if y % i == 0:
                return False
        return True


def total_number_of_primes(n):
    total = 0
    for i in range(n+1):
        if is_primes(i):
            total += i
    return total
 
