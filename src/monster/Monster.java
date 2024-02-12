package monster;
import organisms.Organism;

public class Monster extends Organism {
    Float vitiosity;
    public Monster(String name, float vito) {
        // super() to initialize parent class
        super(name);
        this.vitiosity = vito;
    }

    public void move() {
        System.out.printf("%s can move, and fast.\n", this.get_name());
    }
    public float calc_damage() {
        // java much more strict with type conversion, even between float and int
        // explicit conversion needed, and casting with float() is invalid
        // return type of overriden methods of child class must match the return type of the parent to the dot
        return attributes.get("phys_atk").floatValue() * vitiosity;
    }

    public void attack() {
        System.out.printf("%s did %.2f damage in an attack!\n", this.get_name(), this.calc_damage());
    }
}
