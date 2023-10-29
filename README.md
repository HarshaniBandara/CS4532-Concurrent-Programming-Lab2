# Concurrent Programming Lab - Take Home Lab 2

## Table of Contents
- [Description](#description)
- [Learning Outcomes](#learning-outcomes)
- [Challenge](#challenge)
- [Task](#task)
- [Instructions to Run the Program](#instructions-to-run-the-program)

## Description
This is Take Home Lab 2 for the course CS4532 - Concurrent Programming. In this lab, you will learn how to use mutexes and semaphores in an actual program to solve a synchronization problem.

## Learning Outcomes
By the end of this lab, you will be able to:
- Understand how to devise a solution to a problem that requires synchronization.
- Develop a program to solve a synchronization problem using a well-known programming language.

## Challenge
The problem you will tackle in this lab is based on the Senate bus problem at Wellesley College. Riders come to a bus stop and wait for a bus. When the bus arrives, all the waiting riders invoke boardBus, but anyone who arrives while the bus is boarding has to wait for the next bus. The capacity of the bus is 50 people; if there are more than 50 people waiting, some will have to wait for the next bus. When all the waiting riders have boarded, the bus can invoke depart. If the bus arrives when there are no riders, it should depart immediately.

## Task
Your task is to write a Java program with appropriate synchronization code that enforces all of these constraints described in the challenge.

## Instructions to Run the Program
1. Compile the program using :

```shell
   javac Main.java
   ```
2.  Run program using
```shell 
    java main
```

