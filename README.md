# Number of ways to Reorder Array to Get Same BST

This repository contains a Java solution to a problem of reordering an array to construct a Binary Search Tree (BST) that is identical to the original BST formed from the array. The solution uses a recursive approach and dynamic programming to compute the number of ways to reorder the array.

## Problem

Given an array `nums` that represents a permutation of integers from 1 to n, the goal is to construct a Binary Search Tree (BST) by inserting the elements of `nums` in order into an initially empty BST. The problem is to find the number of different ways to reorder `nums` such that the constructed BST is identical to the original BST formed from the original array.

For example, given `nums = [2,1,3]`, we can construct a BST where 2 is the root, 1 is the left child, and 3 is the right child. The array `[2,3,1]` also yields the same BST, but `[3,2,1]` yields a different BST.

The task is to implement a function `numOfWays(nums: int[])` that returns the number of ways to reorder `nums` modulo 10^9 + 7.

## Solution

The provided solution uses a recursive approach and dynamic programming to solve the problem efficiently. Here's a brief overview of the solution algorithm:

1. The algorithm initializes a table to store Pascal's triangle coefficients, which will be used to calculate the number of ways to reorder the left and right subtrees.
2. The `numOfWays` function converts the input array `nums` to an `ArrayList` and calls the recursive `dfs` function with the `ArrayList` as a parameter.
3. The `dfs` function handles the recursive logic:
   - If the size of the `nums` list is less than 3, indicating there are 0, 1, or 2 elements, it returns 1, representing the only possible way to reorder the array.
   - If the size is 3 or more, the function separates the elements into two lists: `leftNodes` (elements less than the first element of `nums`) and `rightNodes` (elements greater than or equal to the first element).
   - The function recursively calls itself on `leftNodes` and `rightNodes` and calculates the number of ways to reorder them.
   - The final number of ways to reorder `nums` is calculated by multiplying the number of ways for the left and right subtrees and then multiplying it by the corresponding binomial coefficient from the Pascal's triangle table.
4. The solution returns the final result modulo 10^9 + 7.

## Usage

You can follow these steps to use the solution:

1. Clone this GitHub repository or download the source code.
2. Open the project in your Java development environment.
3. Run the program and provide the required inputs, such as the length of the array and the elements of the array.
4. The program will output the number of ways to reorder the array such that the constructed BST is identical to the original BST.

```java
public static void main(String[] args) {
    int[] nums = {2, 1, 3};
    Solution solution = new Solution();
    int result = solution.numOfWays(nums);
    System.out.println("Number of ways to reorder nums: " + result);
}
```

## Complexity Analysis
The time complexity of the solution is O(N^2), where N is the length of the input array nums. This is because we iterate over the elements of nums and perform calculations using the Pascal's triangle table.

The space complexity is O(N) since we use additional space for the Pascal's triangle table and the recursive call stack.

## Contributing

Contributions to this repository are always welcome. If you find any issues or have suggestions for improvements, please feel free to create a pull request or submit an issue.
