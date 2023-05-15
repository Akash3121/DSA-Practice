//2621. Sleep

async function sleep(millis) {
    function callback(resolve, reject){
        setTimeout(resolve, millis);
    }

    return new Promise(callback);
}