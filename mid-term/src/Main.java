



public class Main {
    // Instructions:
    // This Main class is provided to help with debugging.
    // It will create instances of the classes and print out outputs to verify correctness.
    // Instructions:
    // This Main class is provided to help with debugging.
    // It will create instances of the classes and print out outputs to verify correctness.
    
    public static void main(String[] args) {
        // Test Phonebook
        Phonebook phonebook = new Phonebook();
        Phonebook.Person p1 = phonebook.new Person("Alice", "Smith", "123-456-7890");
        Phonebook.Person p2 = phonebook.new Person("Bob", "Jones", "987-654-3210");
        Phonebook.Person p3 = phonebook.new Person("Charlie", "Brown", "555-555-5555");

        phonebook.insert(p1);
        phonebook.insert(p2);
        phonebook.insert(p3);

        System.out.println("Search by first name (Alice): " + phonebook.searchByFirstName("Alice"));
        System.out.println("Search by last name (Jones): " + phonebook.searchByLastName("Jones"));
        System.out.println("Search by prefix (Bo): " + phonebook.searchByPrefix("Bo"));
        // Test ReversingLinkedList
        ReversingLinkedList list = new ReversingLinkedList(3);
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        System.out.println("ReversingLinkedList test completed.");
        
        // Test HistogramBuilder
        HistogramBuilder<String> histogram = new HistogramBuilder<>();
        histogram.insert("apple");
        histogram.insert("banana");
        histogram.insert("apple");
        System.out.println("apple count: " + histogram.getFrequency("apple"));
        
        // Test DynamicArray
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.insert(10);
        dynamicArray.insert(20);
        dynamicArray.remove();
        System.out.println("DynamicArray test completed.");
    }
}

