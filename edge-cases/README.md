# Assignment Tasks

---

# Edge Cases Welcome

## Objective

Implement a generic graph interface and two corresponding data structure implementations: one using an adjacency matrix, and one using an adjacency list.

Your graph should support:
- Directed and undirected graphs
- Weighted and unweighted graphs
- Generic node types (e.g., String, Integer)
- Automatic conversion between generic nodes and internal integer indices
- Dynamically growing internal storage (especially for the matrix implementation)

---

## Requirements

### 1. Interface: Graph<T>
You must define a generic interface with the following methods:

```
void addEdge(T from, T to);
void addEdge(T from, T to, int weight);
boolean hasEdge(T from, T to);
void removeEdge(T from, T to);
void printGraph();
```

- `addEdge(T from, T to)` should add an edge with a default weight (e.g., 1) when the graph is unweighted.
- `addEdge(T from, T to, int weight)` should add an edge with the given weight (only relevant for weighted graphs).
- If the graph is undirected, `addEdge` and `removeEdge` must update both directions.
- `printGraph()` must print all edges in a readable ASCII format. Examples:
  - Directed weighted: `A ----10----> B`
  - Directed unweighted: `A ---------> B`
  - Undirected weighted: `A ----10---- B`
  - Undirected unweighted: `A ------- B`

---

### 2. Implementations

You must implement the `Graph<T>` interface in two separate classes:

#### a. AdjacencyMatrixGraph<T>
- Internally uses a 2D array of integers.
- Zero represents no edge; positive integers represent weights.
- Dynamically resize the matrix as new nodes are added.
- Make use of known data structures for label-index conversions.

#### b. AdjacencyListGraph<T>
- Add nodes and grow the list structure as needed.
- Make use of known data structures for label-index conversions.

---

### 3. Constructors

Each implementation must provide a constructor of the following form:

```
public AdjacencyMatrixGraph(boolean directed, boolean weighted)
public AdjacencyListGraph(boolean directed, boolean weighted)
```

These flags determine the graph’s behavior:
- If `directed` is `false`, all edges should be bidirectional.
- If `weighted` is `false`, ignore the weight parameter and store a default constant (e.g., 1).

---

### 4. Notes

- Do not use object-heavy node and edge classes. Stick to arrays, lists, maps, and integers for performance and clarity.
- Make sure your internal data structures grow dynamically as new nodes are added.

---

## Deliverables

Submit the following files:
- `AdjacencyMatrixGraph.java`
- `AdjacencyListGraph.java`

You are provided with:
- `Graph.java`
- `Main.java` – a basic demo to run locally (you may modify this as needed)
- `MainTest.java` – a JUnit test suite to validate correctness

Make sure your code passes the tests and prints graph edges using the required format.

```

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
docker build -t edge-cases .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace edge-cases
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace edge-cases
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: edge-cases
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named edge-cases.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the edge-cases directory.


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

