# [PCCP 1번] 분대 감기

## :pushpin: **Algorithm**

알고리즘

- 구현

## :round_pushpin: **Logic**

 ```java
public class Bandaging {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int continuity = 1;
        int currentHealth = health;
        for (int a = 0, b = 0; a <= attacks[attacks.length - 1][0]; a++) {
            if (a == attacks[b][0]) {
                currentHealth -= attacks[b][1];
                if (currentHealth <= 0) {
                    return -1;
                }
                b++;
            } else {
                for (int c = 0; c < bandage[0]; c++) {
                    if (a == attacks[b][0]) {
                        currentHealth -= attacks[b][1];
                        if (currentHealth <= 0) {
                            return -1;
                        }
                        b++;
                        break;
                    }
                    if (health < currentHealth + bandage[1]) {
                        currentHealth = health;
                        break;
                    }
                    currentHealth += bandage[1];
                    continuity++;
                    if (continuity == bandage[0]) {
                        break;
                    }
                    a++;
                }
                if (continuity == bandage[0]) {
                    currentHealth += bandage[2];
                    if (health < currentHealth) {
                        currentHealth = health;
                    }
                }
                continuity = 0;
            }
        }
        return currentHealth;
    }
}

 ```

- 공격 받을 떄와 받지 않을 떄를 if/else로 나누고 공격 받을떄와 회복하는 경우, 회복중 공격당한 경우, 연속 회복 성공시 추가 회복량을 받는 떄를 코드로 구현한다.

- ## :black_nib: **Review**

- 천천히 생각한걸 코드로 바꾸니 쉽게 구현가능했다.