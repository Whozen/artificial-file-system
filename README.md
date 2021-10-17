# Design Patterns

## Programming Language used
Java

## Description
The project aims to create a simluation of a file system similar to Unix, displayed by a graphical/text editor. Commands available to be used: <br/>
1. mkdir <dirname> <br/>
2. create <filename> <size> <br/>
3. cd <dirname> | .. <br/>
4. del <dirname> | <filename> <br/>
5. size <dirname> | <filename> <br/>
6. ls <dirname> | <filename> <br/>
7. resize <filename> <size> <br/>
  
The project shows the implementation of different design patterns such as Creational design patterns, Structural design patterns, and Behavioral design patterns. Different design patterns are used for different purposes, all within a single project. Here, Part 1, and Part 2 and 3 are two different projects, where Part 2 and 3 is an extension to Part 1.

The program entry point is Enter.java for both Part 1, and Part 2 and 3. An initial file system is created on load by reading the script from "script1.txt" for Part 1, and "script2.txt" for Part 2 and 3. Then, users can give their own commands and use the file system.
