# Brandon Blackburn
# Euler Project #5
# Find the smallest multiple of integers 1-20.

startNum = 1
endNum = 20

numbers = range(startNum, endNum)
length = len(numbers) - 1
x = length
multiplier = 1
multiple = numbers[x]

while x >= 0:
    if multiple % numbers[x] == 0:
        x -= 1
    else:
        x = length
        multiplier += 1
        multiple = multiplier * numbers[x]
print(multiple)
