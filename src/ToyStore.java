import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Scanner;

public class ToyStore {
    private PriorityQueue<Toy> toyQueue;

    public ToyStore() {
        toyQueue = new PriorityQueue<>(10, (t1, t2) -> t2.getFrequency() - t1.getFrequency());
    }

    public void addToy(Toy toy) {
        toyQueue.add(toy);
    }

    public void generateResults() {
        try {
            FileWriter fileWriter = new FileWriter("results.txt", true);
            List<Toy> extractedToys = new ArrayList<>();
            fileWriter.write("\n");
            for (int i = 0; i < 10 && !toyQueue.isEmpty(); i++) {
                Toy toy = toyQueue.poll();
                extractedToys.add(toy);
                fileWriter.write("Toy ID: " + toy.getId() + ", Name: " + toy.getName() + "\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addToyFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ID игрушки: ");
        String id = scanner.nextLine();

        System.out.print("Введите название игрушки: ");
        String name = scanner.nextLine();

        System.out.print("Введите частоту выпадения игрушки: ");
        int frequency = scanner.nextInt();

        Toy toy = new Toy(id, name, frequency);
        addToy(toy);

        System.out.println("Игрушка добавлена в розыгрыш.");

    }

}