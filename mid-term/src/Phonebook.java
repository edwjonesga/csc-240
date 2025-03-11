public class Phonebook {
    
    // Points: 60
    // Instructions:
    // Implement a Phonebook class that allows inserting people by first name and last name.
    // You should be able to search for a person by first name or last name.
    // For extra credit, implement a prefix-based search. If you complete the prefix search,
    // the first name/last name search will be handled automatically, but you still get extra credit! :-)
    // Note: I don't expect you to use a Trie for this—just get creative with hash maps.

    // Hint: The substring method in Java allows you to extract a part of a string.
    // Example:
    // String name = "Alice";
    // System.out.println(name.substring(0, 3)); // Outputs "Ali"

  
    class Person {
        private String firstName;
        private String lastName;
        private String phoneNumber;
        
        public Person(String firstName, String lastName, String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
        }
        
        public String getFirstName() {
            return firstName;
        }
        
        public String getLastName() {
            return lastName;
        }
        
        public String getFullName() {
            return firstName + " " + lastName;
        }
    }

    public void insert(Person p) {
        // TODO: Implement insertion logic.
        // Store people by first name and last name.
    }

    public List<Person> searchByFirstName(String firstName) {
        // TODO: Implement search by first name.
        return new ArrayList<>();
    }

    public List<Person> searchByLastName(String lastName) {
        // TODO: Implement search by last name.
        return new ArrayList<>();
    }

    public List<Person> searchByPrefix(String prefix) {
        // TODO: Implement prefix-based search (Extra Credit)
        return new ArrayList<>();
    }
}
