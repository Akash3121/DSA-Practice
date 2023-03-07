//1813. Sentence Similarity III

#python3
class Solution:
    def areSentencesSimilar(self, sentence1: str, sentence2: str) -> bool:
        s1 = sentence1.split()
        s2 = sentence2.split()

        # let s1 lenght be smaller
        if (len(s1) > len(s2)):
            s1, s2 = s2, s1 #swap

        while (s1):
            # we are checking first and last elems because we can only insert from one side, cn't add from both sides 
            if s1[0] == s2[0]:
                s1.pop(0) #0 is needed as pop removes the last elem by default
                s2.pop(0)
            elif s1[-1] == s2[-1]:
                s1.pop()
                s2.pop()
            else:
                return False

        return True

#python3 - using deque
class Solution:
    def areSentencesSimilar(self, sentence1: str, sentence2: str) -> bool:
        # using dequeue so that the pop(0) time will be reduced
        # pop(0) takes O(n) times in List and popleft() in dequeue takes constant time
        s1 = deque(sentence1.split())
        s2 = deque(sentence2.split())

        # let s1 lenght be smaller
        if (len(s1) > len(s2)):
            s1, s2 = s2, s1 #swap

        while (s1):
            # we are checking first and last elems because we can only insert from one side, cn't add from both sides 
            if s1[0] == s2[0]:
                s1.popleft() 
                s2.popleft()
            elif s1[-1] == s2[-1]:
                s1.pop()
                s2.pop()
            else:
                return False

        return True

