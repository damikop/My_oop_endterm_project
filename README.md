# My_oop_endterm_project
SE-2012, Damilya and Nurzhamal



Library Management System is a software application implemented in Java platform using MySQL database design. It is useful for libraries in any university, college, or similar educational institution to manage and maintain data in database through computerized system. Using this system, users need not search the entire library to find a book;



Books-> The book’s table consists of the columns {ISBN, title, author, category}




Function of each class:
Book.java class: Book is kind of object that has isbn, title, author and category(genre of book). There are getting, setting and tostring.

MyApp.java: providing with interface and three methods which are used to get all books, get book by isbn and add book to the database.

PostgresDB.java: connecting Java to our database (PostgreSQL).

Only inside of repository we can write sql code.

BookController.java: getting already filtered/sorted data and passing it to the view.

BookRepository.java: getting data(isbn,title,author,category of books) from the database.

Main.java: parses command line arguments, does some checking, and then initializes objects that continue the work of the program. 



Class Diagram


![image](https://user-images.githubusercontent.com/74738634/110336182-cf615900-804e-11eb-9eb7-8e5753a5422f.png)

Interface

![image](https://user-images.githubusercontent.com/74738634/110337676-5f53d280-8050-11eb-941c-40e705941762.png)
