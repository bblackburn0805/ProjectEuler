# Brandon Blackburn
# Euler Project #4
#
# Find the largest palindrome made from the product of two 3-digit numbers.
#
# Will find the largest palindrome from two numbers with any amount of digits... but anything above 4 will take a
# long long time. It will check EVERY number from the lowest to highest numbers with specified digits.

digits = int(input("Enter amount of digits: "))

# num1 is assigned to the lowest number with specified digits
num1 = 10 ** (digits - 1)
ans1 = 0
ans2 = 0

# logic
while num1 < (10 ** digits):
    num2 = num1
    while num2 < (10 ** digits):
        forward = num1 * num2
        test = forward
        backward = 0

        # build backwards by taking each digit of forward
        while test > 0:
            backward = (backward * 10) + (test % 10)
            test = test//10

        if forward == backward and num1 * num2 > ans1 * ans2:
            ans1 = num1
            ans2 = num2
        num2 += 1
    num1 += 1

print("Number 1: " + str(ans1))
print("Number 2: " + str(ans2))
print("Highest palindrome multiple of two numbers with  " + str(digits) + "  digits is:  " + str(ans1*ans2))
