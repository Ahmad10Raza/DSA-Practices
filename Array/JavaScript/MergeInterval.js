
let Interval = function(start, end) {
    this.start = start;
    this.end = end;
}

let merge = function(intervals) {
    if (intervals.length <= 1) {
        return intervals;
    }

    intervals.sort((a, b) => a.start - b.start);

    let result = [];
    let prev = intervals[0];
    for (let i = 1; i < intervals.length; i++) {
        let current = intervals[i];
        if (current.start <= prev.end) {
            prev.end = Math.max(prev.end, current.end);
        } else {
            result.push(prev);
            prev = current;
        }
    }
    result.push(prev);

    return result;
};

let printIntervals = function(intervals) {
    let str = '';
    for (let i = 0; i < intervals.length; i++) {
        str += `[${intervals[i].start}, ${intervals[i].end}] `;
    }
    console.log(str);
}

let intervals = [new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)];
let merged_intervals = merge(intervals);
printIntervals(merged_intervals);
