# String Calculator TDD

This project is a String Calculator developed using Test-Driven Development (TDD) principles. The calculator processes a string of numbers separated by delimiters and returns their sum, with specific features implemented step-by-step.

## Project Structure

- **Language**: Java 21
- **Build Tool**: Gradle
- **Testing Libraries**: JUnit 5, Mockito

## Features

- Returns the sum of numbers in a comma-separated string.
- Supports various delimiters and handles special cases (e.g., new lines, custom delimiters).
- Throws exceptions for invalid inputs (e.g., negative numbers).
- Each feature is implemented using TDD with comprehensive tests.

## Installation and Setup

### Prerequisites

1. **Java 21**: Ensure you have Java 21 installed on your system.
   - [Download Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
2. **Gradle**: Install Gradle for project build and dependency management.
   - [Download Gradle](https://gradle.org/install/)

### Step-by-Step Setup

1. **Clone the Repository**:
``` bash 
git clone https://github.com/sdeengine/String_calculator_TDD.git
```
2. **Navigate to the Project Directory**: 
``` bash
cd String_calculator_TDD
```
3. **Build the Project**: 
``` bash 
./gradlew build
```
4. **Run Tests**: 
``` bash  
./gradlew test
```

## Usage and TDD Implementation
The String Calculator is developed incrementally, with each feature accompanied by a corresponding test.

## TDD Implementation Steps
1. **Add Method for Empty String**
   - **Description**: Returns 0 for an empty string.
   - **Test Method**: testAddEmptyString.
   - **Implementation**:
```JAVA
public int add(String numbers){ 
  if (numbers.isEmpty()){ 
   return 0; 
  } 
  return -1; 
}
```

2. **Add Method for Single Number**
   - **Description**: Returns the number itself when a single number is passed (e.g., "1" returns 1).
   - **Test Method**: testAddSingleNumber 
   - **Implementation**:
```JAVA
public int addSingleNumber(String numbers) {
   if (numbers.isEmpty()) {
       return 0;
     }
   return Integer.parseInt(numbers);
}
```

3. **Add Method for Two Numbers**
   - **Description**: Returns the sum of two numbers separated by a comma (e.g., "1,2" returns 3).
   - **Test Method**: testAddTwoNumbers
   - **Implementation**:
```JAVA
public int addTwoNumbers(String numbers) {
     if (numbers.isEmpty()) {
        return 0;
      }
    String[] parts = numbers.split(",");
     if (parts.length == 1) {
        return Integer.parseInt(parts[0]);
      }
    return Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
}
```

4. **Handle Multiple Numbers**
   - **Description**: Sums multiple comma-separated numbers.
   - **Test Method**: testAddMultipleNumbers
   - **Implementation**:
```JAVA
public int addMultipleNumbers(String numbers) {
    if (numbers.isEmpty()) {
        return 0;
     }
    String[] parts = numbers.split(",");
    int sum = 0;
    for (String part : parts) {
        sum += Integer.parseInt(part);
     }
    return sum;
}
```

5. **Support New Line as Delimiter**
   - **Description**: Supports both commas and new lines as delimiters (e.g., "1\n2,3" returns 6).
   - **Test Method**: testAddWithNewLineDelimiter
   - **Implementation**:
```JAVA
public int addWithNewLineDelimiter(String numbers) {
    if (numbers.isEmpty()) {
        return 0;
     }
    String[] parts = numbers.split("[,\n]");
    int sum = 0;
    for (String part : parts) {
        sum += Integer.parseInt(part);
     }
    return sum;
}
```

6. **Support Custom Delimiters**
   - **Description**:Allows custom single-character delimiters specified as "//[delimiter]\n".
   - **Test Method**: testAddWithCustomDelimiter
   - **Implementation**:
```JAVA
public int addWithCustomDelimiter(String numbers) {
    if (numbers.isEmpty()) {
        return 0;
     }
    String delimiter = ",|\n";
    if (numbers.startsWith("//")) {
        int delimiterIndex = numbers.indexOf("\n");
        delimiter = numbers.substring(2, delimiterIndex);
        numbers = numbers.substring(delimiterIndex + 1);
     }
    String[] parts = numbers.split(delimiter);
    int sum = 0;
    for (String part : parts) {
        sum += Integer.parseInt(part);
     }
    return sum;
}
```

7.  **Handle Negative Numbers Exception**
    - **Description**: Throws an exception if negative numbers are passed.
    - **Test Method**: testAddWithNegativeNumbers
    - **Implementation**: 
```JAVA
public int addWithNegativeNumbers(String numbers) {
    if (numbers.isEmpty()) {
        return 0;
     }
    String delimiter = ",|\n";
    if (numbers.startsWith("//")) {
        int delimiterIndex = numbers.indexOf("\n");
        delimiter = numbers.substring(2, delimiterIndex);
        numbers = numbers.substring(delimiterIndex + 1);
     }
    String[] parts = numbers.split(delimiter);
    int sum = 0;
    List<String> negatives = new ArrayList<>();
    for (String part : parts) {
        int number = Integer.parseInt(part);
        if (number < 0) {
            negatives.add(part);
        }
        sum += number;
     }
    if (!negatives.isEmpty()) {
        throw new IllegalArgumentException("Negatives not allowed: " + String.join(", ", negatives));
     }
    return sum;
}
```

## Running Tests

To run all tests, use the following command:
``` bash 
 ./gradlew test
```

Each test case validates a specific feature of the String Calculator, ensuring that the functionality works as expected.