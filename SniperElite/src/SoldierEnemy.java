public class SoldierEnemy extends Enemy{

    @Override
    public void hit(int bulletDamage) {
        health = health - bulletDamage;
        super.hit(bulletDamage);
    }

    @Override
    public void getMessage() {
        System.out.println("COME TO KILLL!!!!!!");
    }
}
