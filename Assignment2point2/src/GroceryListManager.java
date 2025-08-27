import java.util.ArrayList;
import java.util.HashMap;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();
    private HashMap<String, ArrayList<String>> groceryHashMap = new HashMap<>();




    public void addItem(String item) {
        groceryList.add(item);
    }


    public void removeItem(String item) {
        groceryList.remove(item);
    }


    public void displayList() {
        System.out.println("Grocery List:");
        int i = 1;
        for (String item : groceryList) {
            System.out.println(i + ". " + item);
            i++;
        }
        if (groceryList.isEmpty()) {
            System.out.println("List is empty.");
        }
    }


    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }


    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();


        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.addItem("Bread");


        manager.displayList();


        System.out.println("\nIs \"Milk\" in the grocery list? " + manager.checkItem("Milk"));


        System.out.println("\nRemoving \"Milk\" from the list...");
        manager.removeItem("Milk");


        System.out.println("\nUpdated Grocery List:");
        manager.displayList();
    }
}


