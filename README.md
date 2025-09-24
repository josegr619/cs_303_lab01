# CS 303 Lab 01 – Linear vs Binary Search
This project implements and benchmarks **Linear Search** and **Binary Search** in Java. It compares their correctness and execution time across arrays of increasing sizes.
## Author
- **Name:** Jose Garcia  
- **BlazerID:** jegarcia  
## Overview
The program:
- Generates random arrays and search keys.
- Runs linear search and binary search.
- Reports whether results are correct.
- Measures execution time in nanoseconds.
## Features
- Linear Search: Iterates through the array until the target is found.  
- Binary Search: Efficiently searches sorted arrays by halving the search range.  
- Benchmarking: Tests array sizes from 2^4 up to 2^18.  
## How to Run
1. Compile the program from the project root:
   ```bash
   javac path/to/YourFile.java
java packageName.YourFile
