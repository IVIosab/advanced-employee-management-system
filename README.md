# Advanced-Employee-Management-System  
# Overview:  
This an implementation of a company management system that keeps track of all information relevant to a company and it’s employees The system has 2 major elements:  
- Admins: Can store and edit info about company, employees, payrolls as well as manage employee leave status.  
- User: Can check their personal info including leave status, salary, holidays in addition to voicing grievances or resigning.  
The system also has the element (Team) which can be composed of Admins and Users and other Teams  
For example : a company contains a Developing team which in itself contains 2 other teams : FrontEnd and BackEnd. And then these 2 teams contain Employees.  
  
# Functionality:  
An ‘Employee’ logs into an existing account previously created by an ‘Admin’ and stored in the database.  
The ‘Employee’ then gains access to different actions and data based on his role in the company.  
The ‘Employee’ then can perform these actions.  
  
# Explaination of the Code/UML  
![image](https://user-images.githubusercontent.com/44644160/155875290-63414213-7456-4a12-a629-f026c8c96704.png)  
The picture above describes the two classes:  
- Database: which contains all the information about all the aspects in out project in Maps or attributes to simulate an actual Database  
- DatabaseConnection: which is the only way to interact with the Database through its methods. This Class also showcases the **Singleton Design Pattern** in which you can only have one connection to the database to avoid  
any possible problems caused by multiple connections at a time.  
  
These Classes contain the methods necessary to interact with the database and get/add any information needed.  
  
For example: We have the method addUser(Employee) which has an Employee as a parameter and we want to add him into the database, so we get the Users Map and add him in it.  

![image](https://user-images.githubusercontent.com/44644160/155875440-9806b06f-d927-47af-b610-8f1b82e1784a.png)  
The picture above describes the Implementation of the **Composite Design Pattern** through an interface and 2 classes:  
- <<Interface>> CompanyUnit: which we consider as the Component, and in it we specify the operations that are common to both Teams and Employees  
- Team Class: Which is the Composite(container) in our case where it has a list of other CompanyUnits which may be other containers or employees  
- Employee Class: which is the leaf node and it is split into two types Admin and User. (This part will be explained later on)  
  
Team and Employee classes Implement the Interface CompanyUnit. And because of that we get a tree-like structure where we have methods that are applicable to both Teams and Employees.  
  
We showcase the usage of this Design Pattern through the two methods getSalary() and getName().  
  
For Example: the getSalary() method is used to get the salary of an employee or to get the combined salary of every employee on a team.  
  
![image](https://user-images.githubusercontent.com/44644160/155875512-815e9868-fee7-4c33-9af1-2ddcd0a17961.png)  
The picture above describes the implementation of the **Chain Of Responsibility Design Pattern** through the 2 interfaces and 2 classes:  
- <<Interface>> CompanyUnitHandler: which is the handler and it has what is common for all concrete handlers. We showcase it with the showHelp() method.  
- <<Interface>> CompanyUnit: which should be the base handler where all the boilerplate code that is common for all handler classes is written. But because this interface is related to the Composite pattern we leave it as an interface and consider it as only a gateway to the Concrete Handlers.  
- Employee and Team Classes : These classes are the Concrete Handlers, they contain the actual code for processing requests. And whether to pass it along the chain.  
  
We showcase the functionality of this Pattern through the showHelp() method.  
  
Where in the Team class if showHelp() is called, it shows the information about the team then passes the request to the teams within this team and it also shows the information about the sub-teams and so on till we reach the leaf nodes.  
