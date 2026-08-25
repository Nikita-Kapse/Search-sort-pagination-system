# Search-sort-pagination-system
# Search, Sort & Pagination System

## Overview

This project is a Java-based console application that allows users to search, sort, and paginate records.

The application follows the processing flow:

**Dataset → Search → Sort → Pagination → Display Results**

The project was designed as a clean and modular implementation demonstrating Java OOP concepts, multithreading, error handling, input validation, and unit testing.

---

## Features

* Search records using a keyword
* Case-insensitive searching
* Search by record name and category
* Sort records by name
* Sort records by date
* Sort records by value
* Ascending and descending sorting
* Pagination using page number and page size
* Input validation
* Error handling
* Multithreading using ExecutorService
* Background processing using Callable
* Future-based result retrieval
* Unit tests for core functionality

---

## Technologies Used

* Java
* Java Collections Framework
* Java Comparator
* ExecutorService
* Callable
* Future
* OOP principles

No external libraries are required.

---

## Project Structure

```text
SearchSortProject
│
├── main
│   └── Main.java
│
├── model
│   └── Record.java
│
├── service
│   ├── Searchable.java
│   ├── SearchService.java
│   ├── SortService.java
│   └── PaginationService.java
│
├── thread
│   └── SearchSortTask.java
│
├── util
│   └── DataGenerator.java
│
├── test
│   └── ApplicationTest.java
│
├── README.md
├── prompt.md
└── .gitignore
```

---

## Setup and Running

### Prerequisites

Install Java JDK 8 or later.

Verify Java installation:

```bash
java -version
javac -version
```

### Compile

From the project root directory:

```bash
javac -d out model\Record.java util\DataGenerator.java service\Searchable.java service\SearchService.java service\SortService.java service\PaginationService.java thread\SearchSortTask.java main\Main.java test\ApplicationTest.java
```

### Run the Application

```bash
java -cp out main.Main
```

### Run Unit Tests

```bash
java -cp out test.ApplicationTest
```

---

## Architecture and Design Choices

### Model Layer

`Record.java` represents the application's data model.

It contains:

* ID
* Name
* Category
* Date
* Value

The class demonstrates encapsulation using private fields and public getter/setter methods.

### Service Layer

The service layer separates business logic from user interaction.

* `SearchService` handles searching
* `SortService` handles sorting
* `PaginationService` handles pagination

### Abstraction and Polymorphism

The `Searchable` interface defines the search behavior.

`SearchService` implements the interface.

Example:

```java
Searchable searchService = new SearchService(records);
```

This demonstrates abstraction and polymorphism.

### Multithreading

The application uses:

* ExecutorService
* Callable
* Future

`SearchSortTask` executes search and sorting operations inside a worker thread.

The main thread receives the processed result through a `Future`.

---

## Processing Flow

```text
User Input
    ↓
Main Application
    ↓
ExecutorService
    ↓
SearchSortTask
    ↓
SearchService
    ↓
SortService
    ↓
Future Result
    ↓
PaginationService
    ↓
Final Results
```

---

## Error Handling

The application handles:

* Invalid numeric input
* Invalid page size
* Invalid page number
* Empty search results
* Null data validation
* Empty datasets

---

## Testing

The project includes tests for:

* Search functionality
* Empty keyword search
* Sorting
* Pagination
* Invalid pagination input

---

## Trade-offs

Due to the challenge time limit, the project prioritizes a working and well-structured Java MVP.

The dataset is generated in memory instead of using a database.

The application uses a console interface rather than a graphical or web frontend.

These choices reduce setup complexity and allow more focus on core search, sorting, pagination, testing, multithreading, and code architecture.

---

## Future Improvements

In a production environment, the project could be extended with:

* Database integration
* REST APIs
* Web frontend
* JUnit testing
* Logging framework
* Authentication and authorization
* Advanced filtering
* Configurable datasets
* Performance testing
* Parallel processing for large datasets

---

## Author

Developed as part of an AI Coding Challenge.
