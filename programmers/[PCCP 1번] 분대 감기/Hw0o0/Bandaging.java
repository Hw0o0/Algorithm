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
