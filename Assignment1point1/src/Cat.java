public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {

        Cat cat1 = new Cat("Whiskers");



        cat1.meow();
        cat1.meow();

        Cat cat2 = new Cat("Rex");
        cat2.meow();
        cat1.meow();

    }
}
