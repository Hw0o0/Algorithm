package hash;

import java.util.HashMap;

public class PhoneNumberList {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> phoneList = new HashMap<>();

        for (int a = 0; a < phone_book.length; a++) {
            phoneList.put(phone_book[a], a);
        }

        for (int a = 0; a < phone_book.length; a++) {
            for (int b = 0; b < phone_book[a].length(); b++) {
                if (phoneList.containsKey(phone_book[a].substring(0, b))) {
                    return false;
                }
            }
        }
        return answer;
    }
}