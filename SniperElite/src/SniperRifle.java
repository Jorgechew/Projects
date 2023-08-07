public class SniperRifle {

    private int bulletDamage = 60;
    private final float HIT_PROB = 0.3f;

    // declare a parameter of type Destroyable
    public void shoot(Enemy target) {

        if(Math.random() < HIT_PROB) {

            // call the method hit on the destroyable object
            target.hit(bulletDamage);

            System.out.println("It's a hit!");

        } else {

            System.out.println("It's a miss!");

        }
    }
}