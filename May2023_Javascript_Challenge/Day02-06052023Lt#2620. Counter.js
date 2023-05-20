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

#3 - Javascript
var createCounter = function(n) {
    return function() {
        return n++;
    };
};

#4 - Typescript
function createCounter(n: number): () => number {
    return function() {
        return n++;
    }
}

#5 - Typescript
function createCounter(n: number): () => number {
    --n;
    return function() {
        return ++n;
    }
}

#6 - Javascript
var createCounter = function(n) {
    --n;
    return function() {
        return ++n;
    };
};