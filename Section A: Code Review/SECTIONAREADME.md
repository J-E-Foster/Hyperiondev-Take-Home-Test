<h1>Section A: Code Review</h1> 

## Option 1: Python

This is a simulation code review that evaluates the work of a fictional student by commenting on:

* Correctness
* Efficiency
* Style
* Documentation

### The code review can be found [**here**](REVIEW.md).<br /><br />

### Task Description:

**Compulsory Task 1 Follow these steps**:

* In a file called anagram.py, create:
* Given an array of strings strs, group the anagrams together.
* An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
  typically using all the original letters exactly once.
  * You can return the answer in any order.
  * Strings consists of lowercase English letters.
* Example input:
* Input: strs = ["eat","tea","tan","ate","nat","bat"]
* Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

### Student Solution:

```
class Solution
       def groupAnagrams(self, strs):
      result = {}
      for i in strs:
         x = "".join(sorted()
         if x in result:
            result[x].append(i)
         else:
            result[x] = [i]
      return list(result.values())
ob1 = Solution()
print(ob1.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
```
