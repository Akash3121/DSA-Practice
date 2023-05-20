//2620. Counter

#1 - Javascript
var createCounter = function(n) {
    let currentCounter = n - 1;
    return function() {
        currentCounter += 1;
        return currentCounter;
    };
};

#2 - Typescript
function createCounter(n: number): () => number {
    let currentCounter = n - 1;
    return function() {
        currentCounter += 1;
        return currentCounter;
    }
}
