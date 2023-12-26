import java.util.*;

public class NoHearSeePerson1764 {
    public static void main(String[] args){

        int cnt = 0;

        Scanner sc = new Scanner(System.in);
        HashSet<String> no = new HashSet<>();
        TreeSet<String> noHearPerson = new TreeSet<>();

        int sumPerson = sc.nextInt() + sc.nextInt();
        while (cnt < sumPerson) {
            String name = sc.nextLine();
            if(3<=cnt) {
                if (no.contains(name)) {
                    noHearPerson.add(name);
                }
            }
            no.add(name);
            cnt++;
        }
        System.out.println(noHearPerson.size());
        for (String sort : noHearPerson){
            System.out.println(sort);
        }
    }
}
