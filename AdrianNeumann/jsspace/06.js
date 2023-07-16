function satisfy(condition, x) {
    return condition(x);
}

function nonCon(x) {
    return true;
}

function multiOfThreeOrFive(x) {
    return x % 3 === 0 || x % 5 === 0;
}

function productOfN(n, condition) {
    product = 1;

    for (let i = 1; i <= n; i++) {
        if (satisfy(condition, i)) {
            product *= i;
        }
    }
    return product;
}

function sumOfN(n, condition) {
    sum = 0;

    for (let i = 0; i <= n; i++) {
        if (satisfy(condition, i)) {
            sum += i;
        }
    }
    return sum;
}


function getPara() {
    let numStr = prompt("Enter a number: ");
    let num = parseInt(numStr);

    while (true) {
        let optionStr = prompt("Enter your option, 0 for sum, 1 for product");
        let option = parseInt(optionStr);

        if (option === 0 || option === 1) {
            return [number, option]
        }
        console.log("You enter an invalid option, please try again!")
    }
}

function delegate(option) {
    if (option === 0) {
        return sumOfN;
    }
    return productOfN;
}

function execute() {
    // let resultArr = getPara();
    // let result = delegate(resultArr[0])(resultArr[1], nonCon);
    // console.log("The result is: " + result);
    let result = sumOfN(3, nonCon)
    console.log(result)
}

execute();