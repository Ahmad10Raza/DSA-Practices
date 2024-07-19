
function intersection(arr1, arr2) {
    let i = 0;
    let j = 0;
    let res = [];

    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] < arr2[j]) {
            i++;
        } else if (arr1[i] > arr2[j]) {
            j++;
        } else {
            res.push(arr1[i]);
            i++;
            j++;
        }
    }

    return res;
}

let arr1 = [1, 2, 3, 4, 5];
let arr2 = [2, 3, 4, 5, 6];
console.log(intersection(arr1, arr2)); // [2, 3, 4, 5]