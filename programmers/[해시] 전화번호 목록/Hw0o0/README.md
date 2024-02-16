# [해시] 전화번호 목록 오답 노트

## :pushpin: **Algorithm**

알고리즘

- 해시

## :round_pushpin: **Logic**

- 수정 전

 ```java
import java.util.HashMap;

public class PhoneNumberList {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for (int a = 0; a < phone_book.length; a++) {
            for (int b = a + 1; b < phone_book.length; b++) {
                if (phone_book[b].contains(phone_book[a])) {
                    return false;
                }
            }
        }
        return answer;
    }
}


 ```

- 수정 후

 ```java
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

 ```

- 먼저 phone_book을 HashMap인 phoneList로 변환하고 이중 반복문을 통해서 PhoneList에 전화번호에 phone_book[a]를 문자열로 쪼개고, 쪼갠
  문자열 중에 하나라도 있으면 false를 반환하고, 그렇지 않으면 true를 반환한다.
- ## :black_nib: **Review**

- 처음에 쉽게 생각하고 채점을 했는데 시간초과가 생겨서 수정하다가 시간 내에 풀지 못했다.
- 이 문제를 통해서 containsKey()에 대해 알 수 있었다.