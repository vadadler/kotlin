package leetcode

// Easy LeetCode problems.

fun main() {

    // twoSum()
    val input = intArrayOf(2,7,11,15)
    val target = 9
    println("twoSum(${input.contentToString()}, $target)=${twoSum(input, target)?.contentToString()}")
    println("twoSumRecursive(${input.contentToString()}, $target)=${twoSumRecursive(input, 0, target)?.contentToString()}")
}

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

fun twoSum(inputArray: IntArray, target: Int): IntArray? {
    for (i in 0..inputArray.size - 1) {
        for (j in i + 1..inputArray.size - 1) {
            if (inputArray[i] + inputArray[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return null
}

fun twoSumRecursive(inputArray: IntArray, i: Int, target: Int): IntArray? {
    if (i >= inputArray.size) return null

    for (j in i + 1..inputArray.size - 1) {
        if (inputArray[i] + inputArray[j] == target) return intArrayOf(i,j)
    }

    return twoSumRecursive(inputArray, i + 1, target)
}