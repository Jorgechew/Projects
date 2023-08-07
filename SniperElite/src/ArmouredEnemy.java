public class ArmouredEnemy extends Enemy{

    private int armour = 100;

    @Override
    public void hit(int bulletDamage) {
        armour = armour - bulletDamage;
        health = health - bulletDamage;
        super.hit(bulletDamage);
    }
    @Override
    public void getMessage() {
        System.out.println("Come to kill me!!!!");
    }


}
