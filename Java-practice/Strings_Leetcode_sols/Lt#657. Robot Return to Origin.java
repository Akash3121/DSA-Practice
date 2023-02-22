//657. Robot Return to Origin

#python
class Solution(object):
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """
        return moves.count("U") == moves.count("D") and moves.count("L") == moves.count("R")

#python3
class Solution:
    def judgeCircle(self, moves: str) -> bool:
        up = 0
        left = 0
        for i in range(len(moves)):
            if moves[i] == "U" :
                up += 1
            elif moves[i] == "L":
                left += 1
            elif moves[i] == "D" :
                up -= 1
            elif moves[i] == "R":
                left -= 1
        return up == 0 and left == 0