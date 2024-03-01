package tasks;

import exceptions.StringNotProperlyFormedException;

public class TaskOne {

    /*
        ალგორითმის აღწერა:
        გადავუაროთ სტრინგის სიმბოლოებს სათითაოდ და თუ შეგვხვდა '+' ან '-' ნიშანი, მაშინ შევინახოთ შესაბამისად 1 ან -1, რომელსაც
        გამოვიყენებთ მაშინ, როდესაც შემდეგ რიცხვს სტრინგში ბოლომდე წავიკითხავთ, ანუ მივალთ შემდეგ ნიშნამდე ან სტრინგის ბოლომდე.

        შედეგს ვინახავთ result ცვლადში, ხოლო nextNum არის შემდეგი რიცხვი, რომელიც უნდა დავუმატოთ ან გამოვაკლოთ result-s
        (აქ ვიყენებთ nextNum-ის ნამრავლს შენახულ 1-ზე ან -1-ზე, იმის მიხედვით, ვუმატებთ თუ ვაკლებთ), თუ ციფრი შეგვხვდა მაშინ
        nextNum ერთი თანრიგით უნდა ამაღლდეს, ანუ გამრავლდეს 10-ზე და დაემატოს ახალი ციფრი, როდესაც ბოლომდე წავიკითხავთ
        რიცხვს, ის დაემატება ან გამოაკლდება result-ს და გავხდით 0-ს, რომ ახალი რიცხვის კითხვა დავიწყოთ.

        პარალელურად ვამოწმებთ სტრინგის ვალიდურობას. სტრინგი ვალიდური იქნება თუ: 1. ყოველი ნიშნის წინ არის ციფრი; 2.სტრინგი
        მთავრდება ციფრით.

        ასიმპტოტიკა:
        space complexity იქნება O(1), რადგან მონაცემების ზომაზე დამოკიდებულს არაფერს ვქმნით.

        time complexity იქნება O(n), სადაც n სტრინგის სიგრძეა, რადგან ერთხელ გადავუყვებით მას.
     */
    public int evaluateExpression(String expression) throws StringNotProperlyFormedException {
        // ცარიელი სტრინგისთვის უბრალოდ 0-ს ვაბრუნებთ
        if (expression == null || expression.isEmpty()) return 0;

        // სტრინგი არ არის ვალიდური, თუ რიცხვით არ მთავრდება
        if (!Character.isDigit(expression.charAt(expression.length() - 1)))
            throw new StringNotProperlyFormedException("the expression must end on a number");

        int result = 0, nextNum = 0;
        // არის true, თუ შემდეგი სიმბოლო, რომელსაც წავიკითხავთ შეიძლება იყოს '+' ან '-', თუ არ შეიძლება, მაგრამ მაინც არის,
        // მაშინ სტრინგი არ არის ვალიდური
        boolean canBeSign = false;
        // ბოლოს ნანახი ნიშნის მიხედვით ვინახავთ 1-ს ან -1-ს
        int nextSignMultiplier = 1;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-') {
                if (!canBeSign)
                    throw new StringNotProperlyFormedException("at index " + i + " there must be a digit before" +
                            "a '" + c + "' sign");
                // რიცხვის წაკითხვა დავასრულეთ და შეგვიძლია დავუმატოთ ან გამოვაკლოთ result-ს დამახსოვრებული
                // nextSignMultiplier-ის მიხედვით
                result += nextSignMultiplier * nextNum;
                nextSignMultiplier = c == '+' ? 1 : -1;
                nextNum = 0;
                // ნიშანი შეგვხვდა, ამიტომ შემდეგი სიმბოლო ვერ იქნება ისევ ნიშანი
                canBeSign = false;
            } else {
                nextNum = nextNum * 10 + c - '0';
                // ციფრის შეხვედრის შემდეგ შეიძლება ნიშანი შგვხვდეს
                canBeSign = true;
            }
        }
        // ბოლოს წაკითხული რიცხვიც უნდა დავუმატოთ result-ს და ისე დავაბრუნოთ
        return result + nextNum * nextSignMultiplier;
    }
}
