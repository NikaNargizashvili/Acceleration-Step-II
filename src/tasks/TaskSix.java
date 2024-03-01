package tasks;

public class TaskSix {

    /*
        ალგორითმის აღწერა:
        გადავუყვეთ array-ის და გვქონდეს sequence-ის ინდექსის აღმნიშვნელი რიცხვი, ეს ინდექსი დაიწყება 0-იდან და თუ ამ ინდექსზე
        არსებულ რიცხვს ვნახავთ array-ში, მაშინ გადავალთ შემდეგ sequence-ის შემდეგ ინდექსზე და გავაგრძელებთ ასე, სანამ ან
        array-ის ბოლოში გავალთ, ან sequence-ის. თუ sequence-ის ინდექსი ამ მასივს გაცდა, ესე იგი ყველა ელემენტი მოიძებნა,
        თუ array-ის ყველა ელემენტი შევამოწმეთ და sequence-ის არა, მაშინ პასუხი იქნება false.

        null-ებს ვთვლი ცარიელ სიმრავლეებად და ცარიელ სიმრავლეს ვთვლი ნებისმიერი სიმრავლის ქვესიმრავლედ.

        თუ sequence-ის ზომა მეტია array-ის ზომაზე, მაშინ ცხადია მისი ქვესიმრავლე ვერ იქნება და ამ შემთხვევაში
        შეგვიძლია პირდაპირ false დავაბრუნოთ.

        ასიმპტოტიკა:
        space complexity იქნება O(1), რადგან მონაცემების ზომაზე დამოკიდებულს ახალს არაფერს ვქმნით.

        time complexity იქნება O(n), სადაც n array-ის ზომაა, რადგან ერთი ციკლი გვაქვს მხოლოდ, რომლითაც გადავუყვებით ამ მასივს.
     */
    public boolean isValidSequence(int[] array, int[] sequence) {
        // ცარიელი სიმრავლისთვის ავტომატურად ვაბრუნებთ true-ს
        if (sequence == null || sequence.length == 0) return true;

        // როდესაც array-ის ზომა ნაკლებია sequence-ის ზომაზე, ავტომატურად ვაბრუნებთ false-ს
        if (array == null || sequence.length > array.length) return false;

        // sequence-ის ინდექსი, რომელზე არსებულ რიცხვსაც ვეძებთ
        int sequenceIndex = 0;

        for (int val : array) {
            // თუ შეგვხვდა საძებნი რიცხვი, მაშინ შეგვიძლია შემდეგ რიცხვზე გადავიდეთ, ან თუ sequence-ის ბოლო ელემენტი
            // შეგვხვდა, მაშინ ალგორითმი დასრულდება, რადგან ყველა ელემენტი ვიპოვეთ და დავაბრუნებთ true-ს
            if (val == sequence[sequenceIndex]) {
                if (sequenceIndex == sequence.length - 1)
                    return true;

                sequenceIndex++;
            }
        }

        return false;
    }
}
