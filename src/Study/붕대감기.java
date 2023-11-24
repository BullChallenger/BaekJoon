package Study;

import java.util.Optional;
import java.util.stream.Stream;

public class 붕대감기 {

    public static void main(String[] args) {
        int[] bandage = { 3, 2, 7 }; // 시전 시간, 초당 회복력, 추가 회복량
        int health = 20;
        int[][] attacks = { {1, 15}, {5, 16}, {8, 6} }; // 공격 시간, 피해량

        System.out.println(solution(bandage, health, attacks));
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        Player player = new Player(health, bandage);
        Monster monster = new Monster(attacks);
        int maxTime = monster.getMaxAttackTime();

        for (int i = 0; i <= maxTime; i++) {
            if (monster.isAttack(i)) {
                monster.attack(player);
                if (player.isDead()) {
                    break;
                }
                continue;
            }

            player.bandage();
            System.out.println(player.getHealth());
        }

        answer = player.getHealth();
        return answer;
    }

}

class Player {

    private int health;
    private int maxHealth;
    private final int bandageSuccessTime;
    private final int bandageHealAmount;
    private final int bandageBonusHealAmount;
    private int bandageCount = 0;

    public Player(int health, int[] bandageSkill) {
        this.health = health;
        this.maxHealth = health;
        this.bandageSuccessTime = bandageSkill[0];
        this.bandageHealAmount = bandageSkill[1];
        this.bandageBonusHealAmount = bandageSkill[2];
    }

    public void bandage() {
        bandageCount++;

        if (bandageCount == bandageSuccessTime) {
            this.health += bandageBonusHealAmount;
            bandageCount = 0;
        }

        this.health += bandageHealAmount;

        if (this.health >= maxHealth) {
            this.health = maxHealth;
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setBandageCount(int bandageCount) {
        this.bandageCount = bandageCount;
    }

    public boolean isDead() {
        if (this.health <= 0) {
            this.health = -1;
            return true;
        }
        return false;
    }
}

class Monster {

    private final int[][] attacks;
    private int attackDamage;

    public Monster(int[][] attacks) {
        this.attacks = attacks;
    }

    public int getMaxAttackTime() {
        return attacks[attacks.length - 1][0];
    }

    public boolean isAttack(int time) {
        Optional<int[]> attackInTime = Stream.of(attacks).filter(attack -> attack[0] == time).findFirst();
        if (attackInTime.isPresent()) {
            this.attackDamage = attackInTime.get()[1];
            return true;
        }
        return false;
    }

    public void attack(Player player) {
        player.setHealth(player.getHealth() - this.attackDamage);
        player.setBandageCount(0);
    }

}
