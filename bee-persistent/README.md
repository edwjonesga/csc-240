# Assignment Tasks
Here’s a **Markdown assignment guide** that goes along with the code you've prepared in `MainTest.java`. It describes each file and outlines the tasks students need to complete.

---

# 📘 Bee Persistent

This assignment guides you through implementing both **in-memory** and **persistent** B-trees. You’ll define the structure of B-tree nodes, implement insertion and deletion logic, and optionally support disk-based storage using `RandomAccessFile`.

---

## 🗂 File Overview

### `BTree.java`
- A generic wrapper class that manages the root node of the B-tree.
- Supports `insert`, `remove`, `search`, and `traverse`.
- Uses a `Function<Boolean, T>` to dynamically create nodes (either in-memory or persistent).
- ✅ **Provided**.

### `BTreeNode.java` (interface)
- Defines the core methods every B-tree node must support:
  - `insertNonFull`, `splitChild`, `remove`, `search`, `traverse`, `getValueAt`, `getChildren`, etc.
- 💡 You will implement this interface.

### `IntegerBTreeNode.java`
- A concrete implementation of `BTreeNode` that stores values in memory.
- Should use arrays to store values and children.
- ✅ Basic structure stub provided.
- ✏️ **You will implement:** `insertNonFull`, `splitChild`, `remove`, `getPredecessor`, `getSuccessor`, `borrowFromPrev`, `borrowFromNext`, `merge`.

### `PersistentBTreeNode.java` (interface)
- Extends `BTreeNode` and adds methods for:
  - Serialization (`toByteArray`, `fromByteArray`)
  - Disk I/O (`readFromDisk`, `writeToDisk`)
  - File tracking (`setFile`, `setOffset`)
- ✅ **Provided.**
- 💡 Designed for working with `RandomAccessFile`.

### `PersistentIntegerBTreeNode.java`
- A concrete implementation of `PersistentBTreeNode`.
- Stores values and children as byte arrays and offsets in a file.
- ✏️ You will implement:
  - Serialization logic
  - `insertNonFull`, `splitChild`, and disk-based equivalents of in-memory methods

### `MainTest.java`
- A JUnit test suite that verifies:
  - In-memory B-tree inserts and removes
  - Persistent B-tree inserts, reloads, and continued operations after reopening
- ✅ **Fully provided.**
- 🧪 You should pass all tests after implementing the nodes correctly.

### `Main.java`
- A standalone version of the test that can be run as a regular Java app.
- Useful for debugging and experimentation without JUnit.
- ✅ **Provided.**

---

## ✅ Your Tasks

### Part 1: In-Memory B-Tree
1. Implement `IntegerBTreeNode`:
   - Use arrays for values and child nodes.
   - Implement all logic for `insertNonFull`, `splitChild`, and deletion helpers.

2. Verify with:
   - `MainTest.testInMemoryBTree()`
   - `Main.java > testInMemoryBTree()`

---

### Part 2: Persistent B-Tree
1. Implement `PersistentIntegerBTreeNode`:
   - Add serialization logic using `toByteArray()` and `fromByteArray()`
   - Read/write to a `RandomAccessFile` using `offset`
   - Ensure all mutations trigger `markDirty()` and write updates via `writeToDisk()`

2. Verify with:
   - `MainTest.testPersistentBTreePersistence()`
   - `Main.java > testPersistentBTree()`

---

## 💡 Hints

- When splitting or merging nodes, always ensure that children are safely initialized.
- For persistent nodes, use a fixed layout for serialization (e.g., 4096-byte blocks).
- The `BTree` class does not assume any particular node type—plug in yours using a `Function<Boolean, T>`.


---


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
docker build -t bee-persistent .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace bee-persistent
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace bee-persistent
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: bee-persistent
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named bee-persistent.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the bee-persistent directory.


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

