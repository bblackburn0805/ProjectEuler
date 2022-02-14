# Brandon Blackburn
# Project Euler # 15

#   Algorithm to find the amount of ways to transverse
# through a grid of boxes, using only down and right.

# User: specify the dimensions of the grid we are using
grid_x = 20
grid_y = 20

# To avoid confusion, we add one so that the matrix makes full boxes. 0,0 is the destination.
grid_x += 1
grid_y += 1

# Create 2d Array for the boxes
previous_moves = [[1] * grid_x for i in range(grid_y)]

# Enter values for boxes that have 1 length and 1 width
for num in range(1, grid_x):
    previous_moves[num][1] = num + 1
for num in range(1, grid_y):
    previous_moves[1][num] = num + 1

# Start from box at 2,2. Move to the next box up, and once that column
# is filled, move to the next row (3,2).
for x in range(2, grid_x):
    for y in range(2, grid_y):
        right_move = previous_moves[x - 1][y]
        down_move = previous_moves[x][y - 1]
        current_total_moves = right_move + down_move
        previous_moves[x][y] = current_total_moves

# Answer is the final value entered in the 2D array.
print(previous_moves[grid_x - 1][grid_y - 1])
