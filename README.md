# Advanced-Employee-Management-System  
# Overview:  
This an implementation of a company management system that keeps track of all information relevant to a company and it’s employees The system has 2 major elements:  
-Admins: Can store and edit info about company, employees, payrolls as well as manage employee leave status.  
-User: Can check their personal info including leave status, salary, holidays in addition to voicing grievances or resigning.  
The system also has the element (Team) which can be composed of Admins and Users and other Teams  
For example : a company contains a Developing team which in itself contains 2 other teams : FrontEnd and BackEnd. And then these 2 teams contain Employees.  
  
# Functionality:  
An ‘Employee’ logs into an existing account previously created by an ‘Admin’ and stored in the database.  
The ‘Employee’ then gains access to different actions and data based on his role in the company.  
The ‘Employee’ then can perform these actions.  
  
# Explaination of the Code/UML  
![image](https://user-images.githubusercontent.com/44644160/155875290-63414213-7456-4a12-a629-f026c8c96704.png)  
The picture above describes the two classes:  
-Database: which contains all the information about all the aspects in out project in Maps or attributes to simulate an actual Database  
-DatabaseConnection: which is the only way to interact with the Database through its methods. This Class also showcases the Singleton Design Pattern in which you can only have one connection to the database to avoid  
any possible problems caused by multiple connections at a time.  
  
These Classes contain the methods necessary to interact with the database and get/add any information needed.  
  
For example: We have the method addUser(Employee) which has an Employee as a parameter and we want to add him into the database, so we get the Users Map and add him in it.  

