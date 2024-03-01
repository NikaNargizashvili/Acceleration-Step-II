package tasks;

public class TaskFive {

    /*
        ალგორითმის აღწერა:
        რეკურსიით ვცადოთ ვარიანტების განხილვა, ვაბრუნებთ -1-ს იმ შემთხვევაში, თუ ვერ მივიღეთ ჯამი k.

        რეკურსიაში index ინახავს მასივის იმ რიცხვის ინდექსს, რომლის განხილვასაც ვაპირებთ.

        currLength ინახავს აქამდე ჯამის დათვლაში გამოყენებული ელემენტების რაოდენობას.

        ასიმპტოტიკა:
        space complexity იქნება O(n) რეკურსიის მაქსიმალური სიღრმიდან გამომდინარე.

        time complexity იქნება O(2 ^ n), რადგან ყველა რიცხვის არჩევა-არ არჩევის შემთხვევას განვიხილავთ.
     */
    public int lenOfLongSubarr(int[] array, int k) {
        // ცარილი მასივისა და k == 0-ისთვის ვთვლი, რომ 0-ის მიღება 0 ელემენტით შეიძლება,
        // მაგრამ თუ არ არის k 0-ის ტოლი, მაშინ ცარიელი მასივით მას ვერ მივიღებთ
        if (array == null || array.length == 0) {
            if (k == 0) return 0;
            return -1;
        }
        return recursion(array, k, 0, 0);
    }

    private int recursion(int[] array, int k, int index, int currLength) {
        if (index >= array.length) {
            if (k != 0)
                return -1;
            return currLength;
        }

        // შემთხვევა, როდესაც arr[index]-ს ვიყენებთ
        int included = recursion(array, k - array[index], index + 1, currLength + 1);

        // შემთხვევა, როდესაც arr[index]-ს არ ვიყენებთ
        int excluded = recursion(array, k, index + 1, currLength);

        // ვაბრუნებთ მაქსიმალურ მნიშვნელობას ჩათვლით, არ ჩათვლით და აქამდე მიღებულ შედეგს შორის
        return Math.max(Math.max(included, excluded), k == 0 ? currLength : -1);
    }
}
