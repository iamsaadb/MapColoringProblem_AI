# MapColoringProblem_AI
**********************MINI PROJECT*************************
****************CSP PROBLEM - MAP COLORING****************

1/ What's the project about?
The program aims to solve NP problem using simple data structures and backtracking 
algorithm from the less constraining node to the most constraining one, it starts by 
affecting colors to the nodes with minimum adjacency degree and looping until all 
nodes have affected colors. Many ways to implement that can use linked list or trees, 
but I prefer to use the adjacency matrix in a file because it is easy to work with.

2/ How to run the program?
On your command line: 
>> javac Main.java
>> java Main inputfile outputfile   (example: java Main map.txt out.txt)

the input file should contain the total number of your nodes in the first line and then 
in each line the adjacency tuples, if 1 is adjacent to 5 then enter 1 5

the output file will reprint the tuple, the adjacency matrix, and then MINIMAL 
number of colors needed to color the map.
Last, it prints the adjacency matrix with the color IDs in the diagonal 

3/ How to improve this program?
However this program is effective, I wish I had more time to focus on the UI, and make 
it more graphic than just a script in an output file.
In order to read the adjacencies from an actual JPEG map, I need to have good understanding
of C++ and Image Processing to be able to build a totally autonomous program that gets
a monochromatic map and outputs a colored map after running the MColoring program!

Thank you!

******Saad Bouayad*********12/12/2018*******
**********CSC510.02***********
