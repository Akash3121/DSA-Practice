//2618. Check if Object Instance of Class

#1
/**
 * @param {any} obj
 * @param {any} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if (obj === null | obj === undefined || typeof classFunction !== 'function') {
        return false;
    }

    let curPrototype = Object.getPrototypeOf(obj);
    while (curPrototype !== null) {
        if (curPrototype === classFunction.prototype) {
            return true;
        }
        curPrototype = Object.getPrototypeOf(curPrototype);
    }
    return false;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */