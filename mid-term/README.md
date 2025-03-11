# Assignment Tasks
# **CSC 242 Introduction to Data Structures - Mid Term Part B**

## **Instructions**
- This midterm consists of **four programming tasks**.
- You are **encouraged** to use code from your **previous assignments** where appropriate.
- **Extra Credit Opportunity** is available (see Question 2 and Question 1).
- You may use Java’s standard libraries, but you **must implement the required functionality yourself**.
- **Submit your completed Java files** by following the submission guidelines below.

---

## **Question 1: Reversing Linked List Every n Inserts (50 Points)**
### **Task:**
- Implement a **Linked List** that **reverses itself every `n` inserts**, where `n` is a specified value.
- You may use your previous **Linked List implementation** and any other **data structures** as needed.
- **Extra Credit:** If you can implement the reversal in **O(1) time complexity**, you will receive additional points.

### **Hints:**
- You will need to **track insertions** and trigger a **reversal** when the count reaches `n`.

---

## **Question 2: Phonebook with First Name, Last Name, and Prefix Search (60 Points)**
### **Task:**
- Implement a **Phonebook** class that allows:
  - **Insertion** of people by **first name**, **last name**, and **phone number**.
  - **Searching** for a person by **first name** or **last name**.

### **Extra Credit (+10 Points):**
- **Prefix-Based Search:** Implement a method that allows searching by **name prefix** (e.g., searching for `"Jo"` should return `"John Doe"` and `"Josh Brown"`).
- **Important Note:**
  *I do not expect you to use a Trie for this—just get creative with data structures.*

### **Hints:**
- The `substring()` method in Java can help:
  ```java
  String name = "Alice";
  System.out.println(name.substring(0, 3)); // Outputs "Ali"
  ```
- If implementing **prefix search**, consider how to **efficiently** store and retrieve matching names.

---

## **Question 3: Histogram Builder (40 Points)**
### **Task:**
- Implement a **HistogramBuilder** class that tracks **how many times a value is inserted**.
- Implement two methods:
  - `insert(T value)`: Inserts a value and updates its count.
  - `getFrequency(T value)`: Returns the number of times `value` has been inserted.

### **Hints:**
- Choose an **appropriate data structure** that allows **efficient insertion and retrieval** of frequency counts.

---

## **Question 4: Dynamic Array with Shrinking Mechanism (50 Points)**
### **Task:**
- Modify your **previous Dynamic Array implementation** so that it **shrinks exponentially** when the **size falls below a threshold**.
- Choose a **threshold carefully** to prevent **unnecessary resizing**.
- Ensure the array **does not oscillate** between growing and shrinking when adding/removing a single element.

### **Hints:**
- When resizing, allocate **only as much memory as necessary** while ensuring **performance remains efficient**.
- Implement a **resize function** that **shrinks the array** when its usage falls below the chosen threshold.

---

## **Debugging and Testing**
A **Main.java** file is provided to help with debugging.
- This will create instances of your classes and **print outputs** for testing.
- **Ensure your code runs correctly** before submitting.

---

## **Submission Guidelines**
- Submit your **completed Java files** (`Phonebook.java`, `ReversingLinkedList.java`, `HistogramBuilder.java`, `DynamicArray.java`, `Main.java`).
- **Zip your files before submitting**:
  - Use the provided utility scripts or your own method to **create a `.zip` file** containing all necessary files.
  - Turn in the zipped archive as your submission.
- **Deadline:** [Insert Deadline Here]  
- **Late submissions** may receive deductions.

---

🚀 **Good luck! Implement efficiently and debug thoroughly!** 🚀

## Downloading, Unzipping, and Running the Assignment
### Step 1: Download the assignment ZIP file from your course portal.
### Step 2: Unzip the file into a directory of your choice.
You can use the following command in the terminal to unzip the file:
```sh
unzip the-assignment.zip
```

### Step 3: Open a terminal (Command Prompt on Windows, Terminal on Mac/Linux) and navigate to the unzipped directory using the `cd` command.

### Step 4: Build the Docker image using the following command:
#### Windows only (Ensure Docker Desktop is running)
```sh
docker build -t mid-term .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace mid-term
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace mid-term
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: mid-term
```sh
refresh-assignment-files.sh
```

## Using the Installed Scripts
After running the Docker container, you will have access to three scripts that are included in the Docker image:

1. **compile.sh:** This script compiles all code including `Main.java` and `MainTest.java` files.
    ```sh
    compile.sh
    ```
    It will compile the source files and ensure that your code is ready for testing.

2. **run-tests.sh:** This script runs the JUnit tests in the `MainTest.java` file.
    ```sh
    run-tests.sh
    ```
    The results will be saved to a file named `test-results.txt`.

3. **prepare_to_submit.sh:** This script prepares your assignment for submission by running all tests and creating a ZIP file containing your work.
    ```sh
    prepare_to_submit.sh
    ```
    If all tests pass, it will create a file named `Assignment.zip` in the `/workspace` directory, ready for submission.

4. **update-docker.sh:** This script downloads a new Dockerfile to your workspace. This is sometimes necessary if updates are required.
    ```sh
    update-docker.sh
    ```
    You will need to exit, rebuild, and restart your Docker container after running this command.

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named mid-term.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the mid-term directory.


# Getting Started with Docker for Your Assignment
This assignment will guide you through creating a Docker-based environment. Follow the instructions below to set up Docker on your system and complete the tasks.

## Setting Up Docker
### Windows
1. Download Docker Desktop from [Docker’s official website](https://www.docker.com/products/docker-desktop/).
2. Run the installer and follow the prompts.
3. After installation, launch Docker Desktop and ensure it is running.

### Mac
1. Open Terminal.
2. Install Homebrew if it is not already installed by running the following command:
    ```sh
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    ```
3. Run the following command to install Docker using Homebrew:
    ```sh
    brew install --cask docker
    ```
4. Start Docker from the command line:
    ```sh
    open /Applications/Docker.app
    ```
5. Verify Docker installation by running:
    ```sh
    docker --version
    ```

### Linux
1. Open a terminal.
2. Run the following commands:
    ```sh
    sudo apt-get update
    sudo apt-get install docker.io
    ```
3. Verify Docker installation with:
    ```sh
    docker --version
    ```

