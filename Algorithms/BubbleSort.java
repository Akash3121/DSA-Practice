//also known as Siniking sort, Exchange sort
//swapping with the next adjacent element if first elem is greater than second elem
//after first pass greatest elem is at end
//In second pass second largest element is from last to second place 
// It's like sorting from last to first
// As for each iteration last elements are sorted, so it doesn't matter if we compare those last sorted elements in j counter
// so to tackle this, we go till len - i - 1, so that we reduce some un necessary comparisions

//Space - O(1) - no extra space required i.e., no copying to array {In place sorting algorithim}
//Time 
    // best case - O(N) - sorted
    // worst cae - O(n^2) - sorted in reverse order

//Best case: if j never swap a value for i, it means array is sorted, so you can end the program 
            // If j doesn't swap any in i = 0, then it is swapped so for i = 0, iterating n elems -> so O(N)
