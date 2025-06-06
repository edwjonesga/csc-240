# Use the official OpenJDK image as the base image
FROM openjdk:11

# Set the maintainer label
LABEL maintainer="edwjones@ccu.edu"

# Create necessary directories
RUN mkdir -p /workspace /bin /opt/junit

# Install required utilities: zip, unzip, wget, curl, and Git
RUN apt-get update && apt-get install -y zip unzip wget curl git jq

# Set the working directory inside the container
WORKDIR /workspace

# Install necessary packages and download JUnit
RUN apt-get update && apt-get install -y wget unzip && \
    wget -O /opt/junit/junit-platform-console-standalone.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.8.2/junit-platform-console-standalone-1.8.2.jar && \
    apt-get clean

# Set CLASSPATH to include JUnit and current directory
ENV CLASSPATH="/opt/junit/junit-platform-console-standalone.jar:."

# Generate the compile.sh script to compile everything
RUN echo '#!/bin/bash' > /bin/compile.sh && \
    echo 'echo "Compiling all Java files under src/ and its subdirectories..."' >> /bin/compile.sh && \
    echo 'find . -name "*.java" > sources.txt' >> /bin/compile.sh && \
    echo 'javac -d . @sources.txt' >> /bin/compile.sh && \
    echo 'if [ $? -eq 0 ]; then' >> /bin/compile.sh && \
    echo '  echo "Compilation complete."' >> /bin/compile.sh && \
    echo 'else' >> /bin/compile.sh && \
    echo '  echo "Compilation failed. Please check for errors."' >> /bin/compile.sh && \
    echo '  exit 1' >> /bin/compile.sh && \
    echo 'fi' >> /bin/compile.sh && \
    chmod +x /bin/compile.sh

# Generate the run-tests.sh script
RUN echo '#!/bin/bash' > /bin/run-tests.sh && \
    echo 'echo "Running JUnit tests..."' >> /bin/run-tests.sh && \
    echo 'java -jar /opt/junit/junit-platform-console-standalone.jar --class-path . --scan-class-path > test-results.txt' >> /bin/run-tests.sh && \
    echo 'echo "Tests completed. Results saved to test-results.txt."' >> /bin/run-tests.sh && \
    chmod +x /bin/run-tests.sh

# Generate the prepare_to_submit.sh script
RUN echo '#!/bin/bash' > /bin/prepare_to_submit.sh && \
    echo 'echo "Preparing submission..."' >> /bin/prepare_to_submit.sh && \
    echo 'run-tests.sh' >> /bin/prepare_to_submit.sh && \
    echo 'if grep -q "FAILURE" test-results.txt; then' >> /bin/prepare_to_submit.sh && \
    echo '  echo "Tests failed. Fix your code before submission!"' >> /bin/prepare_to_submit.sh && \
    echo '  exit 1' >> /bin/prepare_to_submit.sh && \
    echo 'fi' >> /bin/prepare_to_submit.sh && \
    echo 'zip -r /workspace/Assignment.zip . Dockerfile' >> /bin/prepare_to_submit.sh && \
    echo 'echo "Submission package created: Assignment.zip"' >> /bin/prepare_to_submit.sh && \
    chmod +x /bin/prepare_to_submit.sh

# Generate the update-docker.sh script
RUN echo '#!/bin/bash' > /bin/update-docker.sh && \
    echo 'echo "Downloading new Dockerfile..."' >> /bin/update-docker.sh && \
    echo 'curl -L -o /workspace/Dockerfile "https://drive.google.com/uc?export=download&id=1ue-IvpaByECuq3GwAzEZdAbYyotYqJjA"' >> /bin/update-docker.sh && \
    echo 'if [ $? -eq 0 ]; then' >> /bin/update-docker.sh && \
    echo '  echo "Dockerfile updated successfully."' >> /bin/update-docker.sh && \
    echo '  echo "Please exit the container, rebuild it with commands from the assignment page."' >> /bin/update-docker.sh && \
    echo 'else' >> /bin/update-docker.sh && \
    echo '  echo "Failed to download the new Dockerfile. Please check the link or your connection."' >> /bin/update-docker.sh && \
    echo 'fi' >> /bin/update-docker.sh && \
    chmod +x /bin/update-docker.sh

# Generate refresh-assignment-files.sh to fetch assignments from GitHub
RUN echo '#!/bin/bash' > /bin/refresh-assignment-files.sh && \
    echo 'echo "Fetching available classes (repositories) from GitHub..."' >> /bin/refresh-assignment-files.sh && \
    echo 'repos=$(curl -s https://api.github.com/users/edwjonesga/repos | jq -r ".[].name")' >> /bin/refresh-assignment-files.sh && \
    echo 'if [ -z "$repos" ]; then' >> /bin/refresh-assignment-files.sh && \
    echo '  echo "No repositories found. Check network connection or GitHub username."' >> /bin/refresh-assignment-files.sh && \
    echo '  exit 1' >> /bin/refresh-assignment-files.sh && \
    echo 'fi' >> /bin/refresh-assignment-files.sh && \
    echo '' >> /bin/refresh-assignment-files.sh && \
    echo 'echo "Select your class (repository):"' >> /bin/refresh-assignment-files.sh && \
    echo 'select repo in $repos; do' >> /bin/refresh-assignment-files.sh && \
    echo '  if [ -n "$repo" ]; then' >> /bin/refresh-assignment-files.sh && \
    echo '    echo "You selected: $repo"' >> /bin/refresh-assignment-files.sh && \
    echo '    break' >> /bin/refresh-assignment-files.sh && \
    echo '  else' >> /bin/refresh-assignment-files.sh && \
    echo '    echo "Invalid selection. Please try again."' >> /bin/refresh-assignment-files.sh && \
    echo '  fi' >> /bin/refresh-assignment-files.sh && \
    echo 'done' >> /bin/refresh-assignment-files.sh && \
    echo '' >> /bin/refresh-assignment-files.sh && \
    echo 'echo "Fetching assignments (directories) for $repo..."' >> /bin/refresh-assignment-files.sh && \
    echo 'temp_dir=$(mktemp -d)' >> /bin/refresh-assignment-files.sh && \
    echo 'git clone --depth=1 https://github.com/edwjonesga/$repo.git $temp_dir > /dev/null 2>&1' >> /bin/refresh-assignment-files.sh && \
    echo 'assignments=$(find $temp_dir -maxdepth 1 -type d -not -name ".*" -exec basename {} \;)' >> /bin/refresh-assignment-files.sh && \
    echo '' >> /bin/refresh-assignment-files.sh && \
    echo 'if [ -z "$assignments" ]; then' >> /bin/refresh-assignment-files.sh && \
    echo '  echo "No assignments found."' >> /bin/refresh-assignment-files.sh && \
    echo '  rm -rf $temp_dir' >> /bin/refresh-assignment-files.sh && \
    echo '  exit 1' >> /bin/refresh-assignment-files.sh && \
    echo 'fi' >> /bin/refresh-assignment-files.sh && \
    echo '' >> /bin/refresh-assignment-files.sh && \
    echo 'echo "Select your assignment:"' >> /bin/refresh-assignment-files.sh && \
    echo 'select assignment in $assignments; do' >> /bin/refresh-assignment-files.sh && \
    echo '  if [ -n "$assignment" ]; then' >> /bin/refresh-assignment-files.sh && \
    echo '    echo "You selected: $assignment"' >> /bin/refresh-assignment-files.sh && \
    echo '    break' >> /bin/refresh-assignment-files.sh && \
    echo '  else' >> /bin/refresh-assignment-files.sh && \
    echo '    echo "Invalid selection. Please try again."' >> /bin/refresh-assignment-files.sh && \
    echo '  fi' >> /bin/refresh-assignment-files.sh && \
    echo 'done' >> /bin/refresh-assignment-files.sh && \
    echo '' >> /bin/refresh-assignment-files.sh && \
    echo 'echo "Would you like to (R)eplace existing files or (K)eep them in a separate directory? (Default: Keep)"' >> /bin/refresh-assignment-files.sh && \
    echo 'read -r user_choice' >> /bin/refresh-assignment-files.sh && \
    echo 'user_choice=${user_choice,,}' >> /bin/refresh-assignment-files.sh && \
    echo '' >> /bin/refresh-assignment-files.sh && \
    echo 'if [[ "$user_choice" == "r" ]]; then' >> /bin/refresh-assignment-files.sh && \
    echo '  echo "Replacing existing files... with $temp_dir"' >> /bin/refresh-assignment-files.sh && \
    echo '  cp -r $temp_dir/$assignment/* /workspace/' >> /bin/refresh-assignment-files.sh && \
    echo '  echo "Files copied to /workspace/."' >> /bin/refresh-assignment-files.sh && \
    echo 'else' >> /bin/refresh-assignment-files.sh && \
    echo '  echo "Keeping files in a separate directory."' >> /bin/refresh-assignment-files.sh && \
    echo '  mv $temp_dir /workspace/$assignment' >> /bin/refresh-assignment-files.sh && \
    echo '  echo "Files saved to /workspace/$assignment."' >> /bin/refresh-assignment-files.sh && \
    echo 'fi' >> /bin/refresh-assignment-files.sh && \
    echo '' >> /bin/refresh-assignment-files.sh && \
    echo 'rm -rf $temp_dir' >> /bin/refresh-assignment-files.sh && \
    echo 'echo "Operation completed!"' >> /bin/refresh-assignment-files.sh && \
    chmod +x /bin/refresh-assignment-files.sh

# Add bin directory to PATH
ENV PATH="/bin:$PATH"

# Default command to start a bash shell in the container
CMD ["bash"]
