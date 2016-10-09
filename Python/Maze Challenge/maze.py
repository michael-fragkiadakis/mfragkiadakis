''' To begin with, the user needs to provide a maze in the form of [string lines (representing maze
rows) with the following symbols: X (walls), _ (empty spaces), S (starting point), G (Goal point)] saved
in maze.py's directory. First thing the program does, is ask the user for that .txt name. If none is
provided, or given text doesn't exist, it will use the default maze.txt'''
import os
# 1. Asking user for input. Checking if input path exists. If not, it is set to default (maze.txt).
txt = input('Enter text name (without ".txt" suffix): ') + '.txt'
if not os.path.exists(txt):
    txt = 'maze.txt'
    print ('\n*** WARNING!: Text not found. Running for maze.txt instead. ***')
    # Source: http://stackabuse.com/python-check-if-a-file-or-directory-exists/


'''Reads given txt (or default maze.txt if user's input is NULL) and stores it as a list of lists.'''
# 2. Input .txt  => to list of lists format.
with open(txt) as text:
    maze = []
    for line in text:
        maze.append(list(line.rstrip())) # rstrip method gets rid of the "\n" at the end of each line.
    # Source: http://stackoverflow.com/a/18448898

print ('\n* Maze challenge accepted * ')


''' When called, the following function gives as a graphic representation of our maze.
It essentially turns our list of lists into a grid graph'''
xmax, ymax = len(maze), len(maze[0]) # Setting number of rows as xmax & number of columns as ymax.
# 3. Printing list of lists in grid format.
def printmaze (maze):
    print ('\nMaze Graph') 
    print ('='*(2*ymax-1)) # upper boarder
    
    for lists in maze:
        for i in lists:
            print(i,end=' ')
        print()
        
    print ('='*(2*ymax-1)) # lower boarder

printmaze (maze) # Calling function for initial maze representation.


''' Now that we have our maze set, we will try to solve our problem using recursion. In order to reach
our goal, we need to create a path from S to G. While searching for it whenever we bump into a wall
(or other invalid spot), we need to change direction. Thus, the procedure can be like so:

From starting spot, try going north. If that is a valid move, repeat, otherwise try going east, if
invalid, south, if invalid, west and repeat. Following this clockwise moving procedure, backtracking
where there is a dead-end, we will eventually find our goal, given that such a path exists.

It actually is harder than it sounds. There is something extra we need to do to avoid running in circles
(infinite loop). We need a way to remember where we have been. That can be achieved by dropping bread
crumbs along the way, or in our terms, marking spots we pass through as visited, so as not to visit them
again, unless we reach a dead-end, in which case we will back-track, unmarking them as we go. So while
navigating the maze, we will be marking visited spots with '+'.

Character representations;
'S' = starting spot
'G' = goal / exit spot
'X' = obstacle/wall
'_' = unvisited (or leading to dead-end)spot
'+' = visited spot / part of solution path

So there are 4 possible results, when trying to move to a new spot;
1. Find exit (G) -> Goal reached, problem (almost) solved.
2. Bump into a wall (X) -> change direction.
3. Run into an already visited spot (+) -> move if back-tracking, otherwise change direction.
4. Run into an empty spot -> Move into it and repeat.

REMINDER: x, y coordinates start at 0, meaning that a 5x5 maze will have a x,y range of (0,4) [instead
of the usual (1,5)], where x represents rows and y represents columns, like so:
 y - - >
x
|
|
v
'''
# 4. Find starting position (S) index & print it along with maze graph.
for i, j in enumerate(maze):
    if 'S' in j:
        x1 = i
        y1 = j.index('S')
print (maze[x1][y1], 'point found at: [%d, %d]' % (x1, y1))


print ('Number of rows (xmax): %d \nNumber of columns (ymax): %d \n' % (len(maze), ymax))
    # printing rows and columns number as set earlier.
    
path = [] # Initializing path list, where the solution will be stored as path coordinates.


''' We have represented our maze, starting point, as well as the maze's dimensions. We are now ready to
start looking for a way out of the maze (or G)'''
# 5. Recursive search for the exit (G).
def search(x, y):
    if maze[x][y] == 'G':
        path.append([x,y]) # Adding final value to solution path list.
        print ('Goal reached! %d,%d' % (x, y))
        return True
    elif maze[x][y] == 'X':
        print ('Wall at: %d,%d' % (x, y))
        return False
    elif maze[x][y] == '+':
        print ('Already visited: %d,%d' % (x, y))
        return False

    # else: spot is available to move into
    print ('Moving into: %d,%d' % (x, y))
    maze[x][y] = '+'    # marking as visited.
    path.append([x,y])  # adding position's coordinates to our solution path list.

    # explore neighbors clockwise (starting north), only after checking said neighbor is within bounds.
    if ((x > 0 and search(x-1, y))         # check north 
        or (y < ymax-1 and search(x, y+1)) # check east
        or (x < xmax-1 and search(x+1, y)) # check south
        or (y > 0 and search(x, y-1))):    # check west
        return True
    
    maze[x][y] = ' '    # not part of solution path => unmarking.
    path.pop()          # removing unmarked spot's coordinates from solution path list.
    return False
    # Source: http://www.laurentluce.com/posts/solving-mazes-using-python-simple-recursivity-and-a-search/

print ('Initializing search... \n')
search(x1, y1)


'''After calling our main (search) function and reaching our goal, we have a series of '+' we need to
present as our solution. There is one thing to do however, before that. Our funvtion started searching
at our starting spot, and being a valid spot as it is, it was marked as visited '+'. so before
representing our solution, we have to set it back to 'S'.'''
maze[x1][y1] = 'S' # Resetting starting position, currently being '+', back to 'S'.


''' Finally, everything is set. We are ready to present our solution. We will do that in two ways:
a) As a series of solution path spot's coordinates (# 6)
b) As a graph, calling the printmaze function again (# 7).'''
# 6. Solution presentation as coordinates.
print ('\n* Maze challenge complete * \n')
print ('Solution path;')
for lists in path:
    print (maze[lists[0]][lists[1]], lists)
    # printing series of solution path's coordiinates, lead by the respective (final) maze value. 
    
# 7. Solution graphic representation as '+' path.
printmaze (maze) # Calling function for final maze representation.


'''Future improvements:
1) Find optimal path.
2) Use colored output for path.
3) Check that input is valid (only valid symbols used, all rows of same length, etc.)
4) Instead of +, use <,^,>,v symbols depending on movement direction'''
