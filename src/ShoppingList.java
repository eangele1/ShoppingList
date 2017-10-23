import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class ShoppingList {
	
	public static void shoppingList(){

		Scanner stdin = new Scanner(System.in);
		
		while (true){
			int size = list.size();
			System.out.println("Current amount of items in shopping list: " + size);
			System.out.println("Add more? (\"y\" for yes, \"n\" for no)");
			if (stdin.nextLine().startsWith("y")) {
				System.out.println("");
				System.out.println("Enter an item: ");
				list.add(stdin.nextLine());
				System.out.println("");
			}
			else
				break;
		}
		
	}
	
	static List<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		System.out.println("This program will help you make a shopping list.");
		System.out.println("");
		
		shoppingList();

		System.out.println("\nWould you like to export this list into a text file?"
				+ "\n(1 for yes, 0 for no)");
		int choice = input.nextInt();

		while(choice > 1 || choice < 0){
			System.out.println("Invalid. Type in 1 or 0.");
			System.out.println("\nWould you like to export this list into a text file?"
					+ "\n(1 for yes, 0 for no)");
			choice = input.nextInt();
		}

		if (choice == 1){
			try {
				PrintStream o = new PrintStream(new File("Shopping List.txt"));
				PrintStream console = System.out;
				System.setOut(o);
				System.out.println("Shopping List: ");
				System.out.println("");
				String[] stringArray = list.toArray(new String[0]);

				for (int i = 0; i < stringArray.length; i++){
					System.out.println("-" + stringArray[i]);
				}
				System.setOut(console);
				System.out.println("");
				System.out.println("Done!");
				System.out.println("");
				System.out.println("Shopping List: ");
				System.out.println("");
				for (int i = 0; i < stringArray.length; i++){
					System.out.println("-" + stringArray[i]);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("ERROR. FILE NOT FOUND. STOPPING PROGRAM NOW.");
				System.exit(0);
			}
		}
		else{
			System.out.println("Shopping List: ");
			System.out.println("");
			String[] stringArray = list.toArray(new String[0]);

			for (int i = 0; i < stringArray.length; i++){
				System.out.println("-" + stringArray[i]);
			}
		}
	}
}