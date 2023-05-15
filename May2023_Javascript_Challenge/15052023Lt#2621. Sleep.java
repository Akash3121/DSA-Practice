//2621. Sleep

#1
async function sleep(millis) {
    function callback(resolve, reject){
        setTimeout(resolve, millis);
    }

    return new Promise(callback);
}

#2
async function sleep(millis) {

    return new Promise(response => setTimeout(response, millis));
}

#3
async function sleep(millis) {
    await new Promise((resolve, reject) => setTimeout(resolve, millis));
}