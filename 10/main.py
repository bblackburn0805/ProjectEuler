# Brandon Blackburn
# Euler Project #10
# Find the sum of all the primes below two million.


def function():
    primes = [2]
    for num in range(3, 2000000, 2):
        divisible = False
        for prime in primes:
            if (num ** .5) + 1 < prime:
                break
            if num % prime == 0:
                divisible = True
                break

        if not divisible:
            primes.append(num)
    return sum(primes)


print(int(function()))
