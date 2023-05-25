//2677. Chunk Array

#1
/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
var chunk = function(arr, size) {
    if (size <= 0) {
        throw new Error("size must be a positive number");
    }

    var chunkedArray = [];

    for (var i = 0; i < arr.length; i += size) {
        var chunk = arr.slice(i, Math.min(arr.length, i + size));
        chunkedArray.push(chunk);
    }

    return chunkedArray;
};