import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        Toy toy1 = new Toy("1", "Car", 1);
        Toy toy2 = new Toy("2", "LEGO ", 1);
        Toy toy3 = new Toy("3", "Barby", 10);

        toyStore.addToy(toy1);
        toyStore.addToy(toy2);
        toyStore.addToy(toy3);
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько игрушек необходимо добавить? ");
        count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            toyStore.addToyFromConsole();
        }
        toyStore.generateResults();
    }
}