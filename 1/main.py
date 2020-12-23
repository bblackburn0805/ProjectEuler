# Numbers is all integers from 1 to 999
# set contains all numbers that are multiples of 3 or 5

numbers = range(999)
sets = []
sums = 0

for x in numbers:
    if (x % 3 == 0) or (x % 5 == 0):
        sets.append(x)

for y in sets:
    sums += y

print(sums)
