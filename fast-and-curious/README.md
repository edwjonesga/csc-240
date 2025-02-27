# Assignment Tasks
# Fast and Curious: The Need for Hashing Speed

## Overview
In this assignment, you will implement and explore **real-world applications of hash tables and maps**, reinforcing their efficiency in fast lookups, caching, and managing scoped variables.

## Objectives
- Implement a **Phonebook** that allows for efficient contact lookup.
- Create a **Least Recently Used (LRU) Cache** to manage frequently accessed data.
- Develop a **Symbol Table** that supports scoped variable resolution.

## Tasks

### 1. Phonebook
Implement a **Phonebook** that:
- Allows adding contacts with a name and phone number.
- Enables quick retrieval of a contact’s number.
- Supports checking if a contact exists.

You should focus on efficiency—your implementation should allow quick lookups.

### 2. Least Recently Used (LRU) Cache
Implement an **LRU Cache** that:
- Caches a specified capacity of key-value pairs.
- Tracks the last time a key was accessed.
- Removes the **least recently accessed** item when capacity is exceeded.
- Allows adding and retrieving items efficiently.

Think carefully about how to track the order of accesses efficiently.

### 3. Symbol Table with Scoping
Implement a **Symbol Table** that:
- Maps keys (variable names) to values.
- Allows creating **new scopes** that hide variables from previous scopes.
- Supports popping scopes to remove local variables and restore visibility to previous ones.
- Enables accessing hidden variables by referring to their **specific scope name**.

You will need to carefully manage scope stacking and variable resolution.

## Guidelines
- **Efficiency is key**—design your solutions to be performant.
- Use the appropriate data structures for each problem.
- Ensure correctness by writing your own **unit tests**.
- Think about **edge cases**, such as handling duplicate keys, popping empty scopes, or accessing missing entries.

By completing this assignment, you will gain hands-on experience with **high-performance lookup structures** and **data management strategies** used in real-world applications!


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
docker build -t fast-and-curious .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace fast-and-curious
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace fast-and-curious
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: fast-and-curious
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named fast-and-curious.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the fast-and-curious directory.


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

