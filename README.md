# Number of Ways to Reorder Array to Get Same BST
This repository contains a Java solution for the problem of finding the number of different ways to reorder an array in order to construct a Binary Search Tree (BST) that is identical to the original BST formed from the array.

## Problem Description
Given an array `nums` that represents a permutation of integers from 1 to n, the task is to find the number of different ways to reorder `nums` so that the constructed BST is identical to the original BST formed from `nums`. The solution needs to be returned modulo 10^9 + 7.

For example, given `nums = [2, 1, 3]`, the BST formed will have 2 as the root, 1 as the left child, and 3 as the right child. The array `[2, 3, 1]` also yields the same BST, but `[3, 2, 1]` yields a different BST.

## Solution
The solution to this problem involves using dynamic programming and Pascal's triangle.

The main steps of the solution are as follows:

Initialize a dynamic programming array, `dp`, to store the number of ways to reorder the elements of `nums` such that the constructed BST remains the same as the original BST.

Calculate the values of the Pascal's triangle table to be used for coefficient calculations. This table is stored in the `table` 2D array.

Define a recursive function, `dfs`, to perform a depth-first search on the array and calculate the number of ways to reorder the elements.

In the `dfs` function, if the size of the list is less than 3, there is only one way to reorder it, so it returns 1.

If the list has more than 2 elements, separate the list into `leftNodes` and `rightNodes` based on the values relative to the first element (root).

Recursively call `dfs` on `leftNodes` and `rightNodes` to calculate the number of ways to reorder them.

Multiply the number of ways for `leftNodes` and `rightNodes` by the appropriate coefficient from the Pascal's triangle table. The coefficient is determined by `table[m - 1][leftNodes.size()]`, where `m` is the total number of nodes in the current subtree, and `leftNodes.size()` is the number of nodes in the left subtree.

Return the result modulo 10^9 + 7.

## Running the Code
To run the code, you need a Java compiler and runtime environment. The `Solution` class provides a `numOfWays` method that takes an array of integers as input and returns the number of ways to reorder the array.

You can modify the `main` method in the `Solution` class to test the solution with different inputs. It currently demonstrates an example input `nums = [2, 1, 3]` and prints the result to the console.
