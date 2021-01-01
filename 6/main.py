# Brandon Blackburn
# Euler Project #6
# Find the difference between the sum of the squares of
# the first one hundred natural numbers and the square of the sum.

start = 1
end = 100
sum1 = 0
sum2 = 0

# Sum1 is the sum of squares, sum2 is the square of sums.
for num in range(start, end + 1):
    sum1 += (num * num)
    sum2 += num

print(sum2 - sum1)
