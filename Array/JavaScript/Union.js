
function union(arr1, arr2) {
  let i = 0;
    let j = 0;
    let res = [];

    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] < arr2[j]) {
            res.push(arr1[i]);
            i++;
        } else if (arr1[i] > arr2[j]) {
            res.push(arr2[j]);
            j++;
        } else {
            res.push(arr1[i]);
            i++;
            j++;
        }
    }

    while (i < arr1.length) {
        res.push(arr1[i]);
        i++;
    }

    while (j < arr2.length) {
        res.push(arr2[j]);
        j++;
    }

    return res;
}


let arr1 = [1, 2, 3, 4, 5];
let arr2 = [2, 3, 4, 5, 6];
console.log(union(arr1, arr2)); // [1, 2, 3, 4, 5, 6]