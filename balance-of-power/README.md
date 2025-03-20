# Assignment Tasks
# **Assignment: "BALANCE OF POWER - AVL Trees in Action"** 🌳⚖️

## **Objective**

The goal of this assignment is to transform your **Binary Search Tree (BST)** from the previous assignment into a **self-balancing AVL Tree**. You'll implement **rotations, balance checking, and ensure the tree remains sorted and balanced after every insertion and deletion**.

## **Instructions**

### **1. Update Balance Factor Calculation**

- Implement `updateBalanceFactor(TreeNode node)` to track the **balance factor** for every node.
- The **balance factor** is defined as:

### **2. Implement AVL Rotations**

Implement the following **rotations** to maintain AVL balance:

- **LL (Left-Left Rotation)**: When the left child is left-heavy.
- **LR (Left-Right Rotation)**: When the left child is right-heavy.
- **RR (Right-Right Rotation)**: When the right child is right-heavy.
- **RL (Right-Left Rotation)**: When the right child is left-heavy.

### **3. Implement the Balance Method**

- Create a method `balance(TreeNode node)` that **checks the balance factor** of a node and applies the appropriate rotation when needed.
- Call `balance(node)` after every **insertion and deletion**.

### **4. Modify Insert and Delete Methods**

- Update `insert(int value)` and `delete(int value)` to:
  - **Maintain AVL balance** by calling `balance()` after modifying the tree.
  - **Ensure in-order traversal remains sorted** after balancing.

### **5. Verify AVL Properties**

- Use the **level-order traversal** (`levelOrderTraversal()`) to confirm the tree is correctly balanced after operations.
- Use **in-order traversal** (`inOrderTraversal()`) to verify the tree remains sorted after insertions and rotations.

## **Submission Instructions**

- Submit your **assignment.zip** file containing all required Java files.
- Ensure your code is **well-documented** and formatted correctly.





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
docker build -t balance-of-power .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace balance-of-power
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace balance-of-power
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: balance-of-power
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named balance-of-power.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the balance-of-power directory.


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

