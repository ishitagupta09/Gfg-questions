from typing import List


class Solution:
    def minimumInteger(self, N : int, A : List[int]) -> int:
        # code here
        A.sort()
        arr_sum = sum(A)
        for i in A:
            mini = N*i
            if arr_sum <= mini:
                return i
                break
            
Solution().minimumInteger(3, [1, 3, 2])
    
