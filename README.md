# ineuron-Intenship-BookStore
+ A Java Web Developement Project
+ User Login Credentials: (suraj4881@gmail.com/123456)
+ Admin Login Credentials: (admin@gmail.com/admin)
# About
+ A user-friendly Online Bookstore project in which users can log in or register, view the available books, select books along with their quantity, and buy them. Users     can also get payment receipts after successful payment. The project can also be used by the administrator, who can add new books, remove books.to sell both new and       used books. Consider the following scenario: Someone buys a book, and after finishing it, they should be able to sell it again using
  our application

# ScreenShot
+ HomePage
![home](https://user-images.githubusercontent.com/33785415/233817841-304a5284-b08e-4134-9f7f-7820e4e483d9.png)
+ Admin-Module
![admin](https://user-images.githubusercontent.com/33785415/233818304-0fd4821a-0eb1-4204-b6e9-e4905e94e21f.png)
+ User-Module
![user](https://user-images.githubusercontent.com/33785415/233818327-9c46ea7a-3f67-4c47-bcb8-7114f661dd92.png)
+ Cart-Checkout
![cart](https://user-images.githubusercontent.com/33785415/233818406-1abb1ca7-6739-4070-9c79-6313b5165626.png)

# This Website is built for following purpose:-
+ For Selling New Books Online.
+ For Selling Old Books Online.
+ Maintaining books selling history.
+ Adding and managing books.
+ User Friendly.
+ For Implementation of Http Servlets in Java.
+ This is project developed using Java,jsp,jstl,Jdbc,and Servlets and also use Bootstrap.

# Admin Have Following Access for this online store site:-
+ Add New Books.
+ View Books Available.
+ Remove Books.
+ Update Books.
+ Checking Order.

# Users Have Following Access for this online store site:-
+ Create New Account or Register.
+ Login.
+ View Available Books.
+ Select Books to Buy.
+ Select Books Quantity.
+ Buy Books.
+ Get Payment.
+ Old Books Selling.
+ Order Tracing.
+ Edit Profile.
+ Contact us.
+ Search Item.

# Technologies used:-
## Front-End Development:
+ HTML
+ CSS
+ BootStrap
## Back-End Development:
+ Java [JDK 17]
+ JDBC
+ Jsp,jstl
+ Servlet

# Database:
+ MySql

# ======= Software And Tools Required ========
+ Git 
+ Java JDK 17 
+ Eclipse EE (Enterprise Edition)
+ Tomcat v9.0
+ MySQL Server
+ MySQL Workbench 

# ========== Dummy Database ScreenShot ===========
+ Create Database and Table As Shown Below

![db](https://user-images.githubusercontent.com/33785415/233819381-7f0dce13-5751-4dab-90a7-4dcbb43007ac.png)

+ TableName: book_details

![db2](https://user-images.githubusercontent.com/33785415/233819638-647aff7a-5ad7-4b5a-91c9-b04923813d53.png)

+ TableName: book_order

![db3](https://user-images.githubusercontent.com/33785415/233819668-ccea37f4-102e-4af1-9dce-36274ca45608.png)

+ TableName: cart

![db4](https://user-images.githubusercontent.com/33785415/233819695-9ff81e48-48c4-474a-83b9-c169d89057ca.png)

+ TableName: user

![db5](https://user-images.githubusercontent.com/33785415/233819759-2b7a91f3-19f8-48fc-9e71-33973514a086.png)


# ==== Importing and Running The Project Through Eclipse EE ===
+ Step 1: Open Eclipse Enterprise Edition. [Install, if not already installed.]

+ Step 2: Click On File > Import > Git > Projects From Git > Clone Uri > Paste The Repository Url as: https://github.com/shashirajraja/onlinebookstore.git> Select master Branch > Next > Next > Finish.

+ Step 3. a: Go inside src/main/resources > [in.bookstore.db] and update the value of database details as per your usage, like db.driver, db.host, db.username and       db.password according to your installed mysql/postgresql admin user credentials.

+ Step 4: Click on Project > Dynamic Web Project > Set Tomcat Version> Next > Next .

+ Step 5: Right Click On Project > Build Path > Configure Build Path >Set Sql jar> Libraries > Remove and Update Any Libraries if Red Mark Exists > Finish.

+ Step 6: [Only If Tomcat Server is not configured in Eclipse] : Right Click On Project > Run As > Run On Server > Select Tomcat V9.0 > (Select Tomcat V9.0               Installation Location If Asked) Next > Add BookStoreApp > Finish.

+ Step 7: In The Server Tab > Double Click On Tomcat Server > Close And Save.

+ Step 8: Right Click On Project > Run As > Run On Server > Select Tomcat v9.0 > Next > Add All> Done.

+ Step 9: Check Running The Site At http://localhost:9999/BookStoreApp

+ Step 10: Default Username And Password For Admin Is "admin@gmail.com" And "admin"

+ Step 11: The default Username And Password For User Is "suraj4881@gmail.com" And "123456"(And you also set your Own User Depends own you how to configb Database)

# FAQ:

+ Question:1 Unable to Connect to Database?
+ Answer: Please check you have installed the mysql correctly and have updated the correct db details in in.bookstore.db. Also you can try doing refresh and update the   project and restart.

## Note:- Considering this as a Sample Project, we have considered of web security but not much validation I think in this project Not Otp verfication and link given      verfication in future I will Try to Add them.

# Some Screenshots for the project:

+ Add Book -Admin_Module:

![a3](https://user-images.githubusercontent.com/33785415/233820461-5c05c665-93b5-4e66-93cd-8a5102e3582c.png)

+ All Book -Admin_Module:

![a1](https://user-images.githubusercontent.com/33785415/233820487-fa7deb84-0e9d-43b4-b843-c77f82bbc21a.png)

+ All Order Book -Admin_Module:

![a2](https://user-images.githubusercontent.com/33785415/233820513-8990a233-dd53-4f9d-8b31-99c34503589f.png)

+ Sell Old Book -User_Module:

![a4](https://user-images.githubusercontent.com/33785415/233820869-d7c8c6d4-c686-4d19-905c-c3d2e3cbf4ae.png)

+ Edit Old Book -User_Module:

![a5](https://user-images.githubusercontent.com/33785415/233820899-93419756-926f-4116-8149-5022938c4a12.png)

+ Login Edit Profile -User_Module:

![a6](https://user-images.githubusercontent.com/33785415/233820934-ebe6dbaf-8449-4cac-9429-278b095df9da.png)

+ My Order -User_Module:

![a7](https://user-images.githubusercontent.com/33785415/233820949-56fa9add-60e1-4566-82fd-5e741ed14297.png)

+ Help Center -User_Module:

![a8](https://user-images.githubusercontent.com/33785415/233820971-21ac51b8-3d3d-402e-a6a9-5f50ea7aea26.png)

# Suggestions and project improvement ideas are welcomed!
+ Thanks a lot
+ Project Leader
+ Suraj Kumar





