# Assignment Tasks
# 🧮 Assignment: *Heapin’ It Real* – Build Your Own Generic Binary Heap

## Overview
In this assignment, you will build a **generic binary heap** data structure from scratch. Your task is to "heap it real" by implementing all core heap operations without using built-in Java priority queue utilities.

Your heap will use an array under the hood and support **any type that implements `Comparable<T>`**. You’ll implement methods for adding elements, removing the root, and peeking at the top of the heap — all while maintaining the **heap property**.

---

## Learning Objectives
By the end of this assignment, you will be able to:

- Implement a binary heap using an array structure.
- Apply generic types with `Comparable<T>` for reusable and type-safe code.
- Maintain the heap property using `bubbleUp` and `bubbleDown` operations.
- Evaluate the correctness and efficiency of your data structure through unit testing.

---

## Functional Requirements

Your class must:

- Be named `BinaryHeap<T extends Comparable<T>>`
- Provide a constructor that accepts an initial **capacity**
- Implement the following public methods:
  - `void add(T value)`
  - `T removeRoot()`
  - `T peek()`
  - `boolean isEmpty()`
  - `int size()`
- Internally manage heap order using:
  - `private void bubbleUp(int index)`
  - `private void bubbleDown(int index)`

---

## Constraints

- Do not use `PriorityQueue` or any Java Collections heap utilities.
- The heap must be implemented as an **array**.
- Throw `IllegalStateException` when:
  - Attempting to remove from an empty heap
  - Adding beyond the heap's capacity

---

## Example Usage

```java
BinaryHeap<Integer> heap = new BinaryHeap<>(10);
heap.add(5);
heap.add(3);
heap.add(8);

System.out.println(heap.peek());       // Output: 3
System.out.println(heap.removeRoot()); // Output: 3
System.out.println(heap.peek());       // Output: 5
```

---

## Testing

You are provided with a JUnit test file that verifies:

- Basic insertions
- Proper bubbling
- Root removal
- Exceptions for overflows and underflows

✅ **Your code must pass all tests to receive full credit.**

---

## Submission Guidelines

1. Implement your `BinaryHeap.java` file.
2. Run the provided tests using `BinaryHeapTest.java`.
3. Submit both files as a `.zip` or via your Docker workspace.
4. Make sure all your code is well-commented and formatted.

---

Want to go the extra mile? Try modifying your heap to support **max-heap** behavior using a custom comparator! Be sure to let me know you did.


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
docker build -t heapin-real .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace heapin-real
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace heapin-real
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: heapin-real
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named heapin-real.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the heapin-real directory.


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

