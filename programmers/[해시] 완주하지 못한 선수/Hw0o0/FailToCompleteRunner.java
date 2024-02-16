import java.util.HashMap;

public class FailToCompleteRunner {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> person = new HashMap<>();

        for (int a = 0; a < participant.length; a++) {
            if (person.get(participant[a]) == null) {
                person.put(participant[a], 1);
            } else {
                person.put(participant[a], person.get(participant[a]) + 1);
            }
        }

        for (int b = 0; b < completion.length; b++) {
            if (person.get(completion[b]) != null) {
                person.put(completion[b], person.get(completion[b]) - 1);
            }
        }

        for (String s : person.keySet()) {
            if (person.get(s) != 0) {
                answer = s;
            }
        }

        return answer;
    }
}
