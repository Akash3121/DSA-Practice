//2667. Create Hello World Function

#1
/**
 * @return {Function}
 */
var createHelloWorld = function() {
    return function(...args) {
        return "Hello World";
    }
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */

#2 - Typescript
function createHelloWorld() {
	return function(...args): string {
        return "Hello World";
    };
};

#3 - Javascript
var createHelloWorld = function() {
    return () => "Hello World";
};
