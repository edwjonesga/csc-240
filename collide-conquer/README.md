# Assignment Tasks
# Hash It Out: A Collision Course in Data Structures

## Overview
In this assignment, you will implement a hash table from scratch, avoiding Java’s built-in `java.util.Map` interface to focus on the core mechanics of hashing. You will create a `Map<K, V>` interface and two different implementations:

1. **SeparateChainHashMap** – Uses separate chaining to handle collisions.
2. **AddressProbeHashMap** – Uses open addressing with linear probing.

The goal is to gain a deep understanding of how hash tables work, including collision resolution, load factor resizing, and efficient key-value storage.

## Requirements

### The `Map<K, V>` Interface
You will define a `Map<K, V>` interface that includes the following methods:

- `void put(K key, V value)`: Inserts or updates a key-value pair.
- `V get(K key)`: Retrieves the value associated with a key.
- `boolean containsKey(K key)`: Checks if a key exists in the map.
- `V remove(K key)`: Removes a key-value pair and returns the value.
- `int size()`: Returns the number of elements in the map.
- `Set<K> keySet()`: Returns a set of all keys.
- `boolean isEmpty()`: Checks if the map is empty.
- `void clear()`: Removes all key-value pairs.
- `Entry<K, V>[] toArray()`: Returns the underlying array of entries.

### **Implementation Details**
- **You must use an array as the underlying data structure.**
- If generics cause implementation difficulties, feel free to use `Object[]` and cast as needed.
- Implementations must respect the **load factor** and dynamically resize the array when necessary.
- **Avoid probe cycles** when implementing open addressing.

### **Classes to Implement**

#### 1. `SeparateChainHashMap<K, V>`
- Uses **separate chaining** with linked lists to handle collisions.
- Resizes when the number of elements exceeds `loadFactor * capacity`.

#### 2. `AddressProbeHashMap<K, V>`
- Uses **open addressing** with **linear probing** to handle collisions.
- Ensures that probe cycles do not occur.
- Resizes when the number of elements exceeds `loadFactor * capacity`.

## Design Considerations
- Feel free to extract shared logic into a **utility class or a superclass** if it simplifies the code.
- Think about how to efficiently resize and rehash the table.
- Consider edge cases such as:
  - Adding a key that already exists.
  - Removing elements until the map is empty.
  - Handling hash collisions effectively.
  - Ensuring efficient performance as elements grow in number.

## Hints
- Start with the **SeparateChainHashMap** first, as it is conceptually simpler.
- Debugging probe cycles in **AddressProbeHashMap** can be tricky—test thoroughly.
- Ensure that resizing doubles (at least) the array size to maintain performance.

---
By completing this assignment, you'll have built **two working hash tables** from scratch, gaining insight into one of the most fundamental data structures in computer science!


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
docker build -t collide-conquer .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace collide-conquer
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace collide-conquer
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named collide-conquer.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the collide-conquer directory.


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

