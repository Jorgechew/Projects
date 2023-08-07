public abstract class Enemy extends GameObject{

    public int health = 100;

    public boolean isDead = false;

    private String scream;

    public boolean isDead() {
            return isDead;
        }

    public void setDead() {
        isDead = true;
    }

    public void hit (int bulletDamage) {
        health -= bulletDamage;
        if (health <= 0) {
            health = 0;
            isDead = true;
        }
            System.out.println("You shoot me"+ health);

        }



    }


