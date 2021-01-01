# Brandon Blackburn
# Euler Project #7
# Find the difference between the sum of the squares of
# What is the 10 001st prime number?

primeNumbers = [2]
counter = 1
currentNumber = 1

while counter < 10001:
    currentNumber += 2
    divisible = True

    for prime in primeNumbers:
        if (currentNumber % prime) == 0:
            divisible = False
            break
    if divisible:
        primeNumbers.append(currentNumber)
        counter += 1

print(primeNumbers[-1])
