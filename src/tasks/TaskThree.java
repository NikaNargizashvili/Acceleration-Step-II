package tasks;

public class TaskThree {

    // ListNode-ის კლასი
    public static class ListNode {
        private final int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public ListNode getNext() {
            return next;
        }
    }

    /*
        ალგორითმის აღწერა:
        შემოვიღოთ ერთი ListNode, რომლის next-იც იქნება შებუნებული სიის დასაწყისი. ალგორითმის მიზანია გადაუყვეს გადმოცემულ
        სიას და ყოველი ელემენტი მარცხნიდან მიაბას აქამდე აწყობილ შებრუნებულ სიას (თუ წარმოვიდგენთ, რომ ნახაზზე მარცხნიდან
        მარჯვნივ არის დალაგებული თავდაპირველი სიის ელემენტები).

        დასაწყისში newHeadPointer.next არის null, ამის შემდეგ გადმოცემული სიის თითოეული ელემენტი სათითაოდ ჩაემატება
        newHeadPointer-სა და newHeadPointer.next-ს შორის და გახდება შებრუნებული სიის ახალი საწყისი ელემენტი. რადგან
        სიას გადავუყვებით მარცხნიდან მარჯვნივ, ხოლო შებრუნებულ სიას ვაწყობთ მარჯვნიდან მარცხნივ, ამიტომ საბოლოო პასუხი
        თავდაპირველის შებრუნებული სია გამოვა.

        ასიმპტოტიკა:
        space complexity იქნება O(1), რადგან მხოლოდ ერთ დამატებით ListNode-ს ვქმნით ყოველთვის, მონაცემების ზომის მიუხედავად

        time complexity იქნება O(n), რადგან მხოლოდ ერთხელ გვიწევს გადმოცემულ სიაზე გადაყოლა (n სიის სიგრძეა).
     */
    public ListNode reverseList(ListNode head) {
        // ამ ListNode-ის next მიუთითებს შებრუნებული სიის პირველ ელემენტზე
        ListNode newHeadPointer = new ListNode(0);
        // საიტერაციო ListNode, რომლითაც აღვნიშნავთ კოკნრეტულ მომენტში გადმოცემული სიის რომელ ელემენტზე ვდგავართ
        ListNode curr = head;

        while (curr != null) {
            // ყოველ ნაბიჯზე temp-ში შევინახავთ დროებით ამ ბიჯზე მისაბმელ ელემენტს, შემდეგ შეგვეძლება curr გადავიყვანოთ
            // შემდეგ ელემენტზე, ამის შემდეგ temp-ს მარცხნიდან მივაბამთ აქამდე აწყობილ შებრუნებულ სიას და ამ ელემენტს დავნიშნავთ
            // შებრუნებული სიის საწყისად
            ListNode temp = curr;
            curr = curr.next;
            temp.next = newHeadPointer.next;
            newHeadPointer.next = temp;
        }

        return newHeadPointer.next;
    }
}
