# Brandon Blackburn
# Euler Project #9
# There exists exactly one Pythagorean triplet for which a + b + c = 1000.
# Find the product abc.

def function():
    for a in range(1, 998):
        for b in range(1, 999):
            c = (a*a) + (b*b)
            c = c**(1/2)
            if a + b + c == 1000:
                print(a, b, int(c))
                return a*b*c


print(int(function()))
