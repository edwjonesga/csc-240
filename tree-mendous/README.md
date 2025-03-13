# Assignment Tasks
# Binary Search Tree (BST) Assignment

## Objective
The goal of this assignment is to implement a **Binary Search Tree (BST)** and perform fundamental operations on it. Students will implement insert, delete, find, and various tree traversal methods. Additionally, they will compute the height, depth of a node, and perform a level-order traversal. Lastly, students will create an ASCII representation of the tree.

## Instructions
### **1. Implement a Binary Search Tree (BST)**
- Define a `BinarySearchTree` class that implements the `BinaryTree` interface.
- Implement a `TreeNode` class to represent the nodes of the tree.

### **2. Implement Core Operations**
- `insert(int value)`: Inserts a value into the BST.
- `find(int value)`: Returns `true` if the value exists in the tree, `false` otherwise.
- `delete(int value)`: Removes a value from the tree, adjusting the structure if necessary.

### **3. Implement Tree Traversals**
- `inOrderTraversal()`: Returns a list of values in in-order sequence.
- `preOrderTraversal()`: Returns a list of values in pre-order sequence.
- `postOrderTraversal()`: Returns a list of values in post-order sequence.

### **4. Compute Tree Height**
- `getHeight()`: Returns the height of the tree.

### **5. Compute Node Depth**
- `getDepth(int value)`: Returns the depth of a given node.

### **6. Implement Level Order Traversal**
- `levelOrderTraversal()`: Returns a **multi-dimensional list** containing nodes grouped by levels.

### **7. Print an ASCII Representation of the Tree**
- `printAsciiTree()`: Prints the tree with the root centered at the top and left and right subtrees clearly separated.

## **Expected Output Example**
```
Enter numbers to insert into the BST (type 'end' to finish):
10 5 15 2 7 12 20 end
BST Created. Performing Traversals:
In-order Traversal: [2, 5, 7, 10, 12, 15, 20]
Pre-order Traversal: [10, 5, 2, 7, 15, 12, 20]
Post-order Traversal: [2, 7, 5, 12, 20, 15, 10]
Tree Height: 2
Enter a node value to find its depth: 7
Depth of 7 is: 2
Level Order Traversal: [[10], [5, 15], [2, 7, 12, 20]]
ASCII Representation:
   10
  5   15
 2 7 12 20
```

## **Submission Instructions**
- Submit your **Java source code files** (`.java` files).
- Include a `README.md` explaining how to compile and run your program.
- Ensure your code is well-documented and formatted correctly.

Good luck and happy coding! 🚀



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
docker build -t tree-mendous .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace tree-mendous
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace tree-mendous
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: tree-mendous
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named tree-mendous.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the tree-mendous directory.


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

