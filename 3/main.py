# Brandon Blackburn
# Euler Project #3
#
# What is the largest prime factor of the number 600851475143 ?

number = 600851475143
current = 3

while number % 2 == 0:
    number %= 2

while current < number / 2:
    if number % current == 0:
        number = number / current
        current = 1
    current += 2

print(number)
