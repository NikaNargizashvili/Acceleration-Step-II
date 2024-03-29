package tasks;

import java.util.List;

public class TaskTwo {

    /*
        ალგორითმის აღწერა:
        გადავუყვეთ გადმოცემულ სიას და თითოეული სტრინგისთვის, თუ ის არ არის null (ამას არ ვთვლი ბედნიერ სტრინგად),
        დავიწყოთ ინდექსი 1-იდან და თითო ბიჯზე შევადაროთ ამ ინდექსზე მნიშვნელობა წინა ინდექსზე მნიშვნელობას, თუ ისინი
        დაემთხვა, მაშინ წინა ინდექსის შემდეგ იგივე სიმბოლო მოდის და ამიტომ ეს სტრინგი არ არის ბედნიერი, ამიტომ ვწყვეტთ
        ამ სტრინგის განხილვას და გადავდივართ შემდეგ სტრინგზე, ხოლო თუ სტრინგის ბოლო ინდექსისთვისაც შესრულდა წინა სიმბოლოსგან
        განსხვავებულობის პირობა, ესე იგი ეს სტრინგი ბედნიერია და happyStringNum-ს გავზრდით ერთით.

        თუ სტრინგის ზომა ნაკლებია 2-ზე, მაშინ ის აუცილებლად ბედნიერია, ამ შემთხვევაში გამოტოვებს სტრინგის განხილვის ციკლს
        და პირდაპირ პასუხის 1-ით გაზრდაზე გადავა.

        ასიმპტოტიკა:
        space complexity იქნება O(1), რადგან მონაცემების ზომაზე დამოკიდებულ ახალს არაფერს ვქმნით.

        time complexity იქნება O(n*m) სადაც n არის სიის ზომა, ხოლო m სტრინგების მაქსიმალური სიგრძე.
     */
    public int numberOfHappyStrings(List<String> strings) {
        // null-ზე შემოწმება
        if (strings == null) return 0;

        int happyStringNum = 0;

        for (String str: strings) {
            // ვთვლი, რომ null არ არის ბედნიერი სტრინგი
            if (str == null) continue;

            // თუ null არ არის და არსად დაირღვა განსხვავებულობის პირობა, მაშინ default-ად ბედნიერია ეს რიცხვი
            boolean isHappy = true;

            // ამ ციკლს 2-ზე ნაკლები სიგრძის სტრინგები არ გაივლიან i-ს საწყისი მნიშვნელობისა და i < str.length() შეზღუდვიდან
            // გამომდინარე და პირადაპირ ბედნიერად ჩაითვლებიან
            for (int i = 1; i < str.length(); i++) {
                // თუ სიმბოლო მის წინა სიმბოლოს დაემთხვა, სტრინგი არ არის ბედნიერი და ვწყვეტთ ციკლს
                if (str.charAt(i - 1) == str.charAt(i)) {
                    isHappy = false;
                    break;
                }
            }

            if (isHappy) happyStringNum++;
        }

        return happyStringNum;
    }
}
