# Brandon Blackburn
# Euler Problem #2:
# By considering the terms in the Fibonacci sequence whose values do not exceed four million,
# find the sum of the even-valued terms.

num1 = 1
num2 = 1
answer = 2

while num1 < 4000000 and num2 < 4000000:
    temp = num1 + num2
    answer += temp
    num1 = num2
    num2 = temp

print(answer)
