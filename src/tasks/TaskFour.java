package tasks;

import java.util.*;

public class TaskFour {

    /*
        ალგორითმის აღწერა:
        შევინახოთ nums1-სა და nums2-ს შორის უმცირესი ზომის მქონე მასივის რიცხვები HashSet-ში (უმცირესი იმისთვის,
        რომ space complexity-ს გავუკეთოთ ოპტიმიზება), რადგან ეს ამ მასივში რიცხვის არსებობის სწრაფად შემოწმების
        საშუალებას მოგვცემს. ამასთან, თითო რიცხვი თითოჯერ იქნება შენახული, რაც დაგვეხმარება duplicate-ების თავიდან აცილებაში.

        შემდეგ გადავუყვეთ ამ ორს შორის უდიდესი ზომის მქონე მასივს (ანუ იმას, რომელიც არ შეგვინახავს HashSet-ში) და ვნახოთ
        რომელი რიცხვები გვხვდება HashSet-ში. თუ რომელიმე ასეთი რიცხვი მოიძებნა, მაშინ საერთო რიცხვების სიაში ჩავამტებთ და
        HashSet-იდან ამოვიღებთ, რომ ერთი და იგივე რიცხვი ორჯერ არ მოვძებნოთ HashSet-ში და ორჯერ არ ჩავამატოთ პასუხების სიაში.

        ბოლოს პასუხების სიას ჩავწერთ ახალ int[] ტიპის მასივში და დავაბრუნებთ.

        ასიმპტოტიკა:
        თუ n არის nums1-ის ზომა და m არის nums2-ის ზომა, მაშინ:

        space complexity იქნება O(min(m, n)) (HashSet-ისთვის) + O(min(m, n)) (საერთო რიცხვების სიისთვის)
        + O(min(m, n)) (პასუხად დასაბრუნებელი ახალი მასივისთვის), ანუ O(min(m, n))

        time complexity იქნება O(m) + O(n) + O(min(m, n)) (აქ O(m) + O(n) HashSet-ის შექმნისთვის და მეორე მასივზე
        გადაყოლისთვის, O(min(m, n)) საბოლოო პასუხის მასივში ჩაწერისთვის), ანუ O(m + n)
     */
    public int[] findIntersection(int[] nums1, int[] nums2) {
        // null-ებს, როგორც ცარიელ სიმრავლეებს, არ ექნებათ საერთო ელემენტები
        if (nums1 == null || nums2 == null) return new int[0];

        // ამ სიაში ჩავწერთ საერთო რიცხვებს და ბოლოს გადავწერთ ახალ მასივში
        List<Integer> commonValues = new ArrayList<>();

        // longer-ით გვექნება ამ ორ მასივს შორის უდიდესი აღნიშნული, ხოლო shorter-ით უმცირესი ზომის
        int[] longer = nums1.length > nums2.length ? nums1 : nums2;
        int[] shorter = longer == nums1 ? nums2 : nums1;

        // shorter-ის ელემენტების HashSet-ში ჩაწერა
        Set<Integer> potentialCommons = new HashSet<>();
        for (int num : shorter) {
            potentialCommons.add(num);
        }

        // longer-ზე გადაყოლა potentialCommons-თან შესადარებლად
        for (int num : longer) {
            if (potentialCommons.contains(num)) {
                commonValues.add(num);
                potentialCommons.remove(num);
            }
        }

        // მიღებული საერთო რიცხვების int[]-ტიპის მასივში გადაწერა, რათა პასუხად დავაბრუნოთ
        int[] res = new int[commonValues.size()];
        for (int i = 0; i < commonValues.size(); i++) {
            res[i] = commonValues.get(i);
        }

        return res;
    }
}
