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

---

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
  
  
![image](https://user-images.githubusercontent.com/44644160/155875611-5186afa9-bf4a-426d-8c2a-8faf373d5be1.png)  
The picture above shows the Employee Class implementation where the two Classes Admin and User which are the two major elements of this project extend the Employee Class:  
● User Class: It represents a normal User and it allows him to perform a set of actions that they are allowed to do. For example: the User can Check his salary through the method getSalary() or he can check the actions he can perform through the method showHelp() or he can even resign entirely through the method resign().  
● Admin Class: this class represents an Admin in a company structure, where he can modify various information about the company in addition to the basic actions like checking his salary through the getSalary() method. For example: the Admin can add a new user to the company through the method addUser() or the Admin can change the company name through the method setCompanyName().  
  
  
![image](https://user-images.githubusercontent.com/44644160/155875653-234e3176-a143-4772-a314-8bd5280675d6.png)  
The picture above shows the Company Class, which represents the actual company and showcases how it uses the other classes.  
  
  
# Note about the explanation of the Code and UML Diagrams:
We tried our best to explain the most important parts of the code in this report and at the same time keep it as cohesive and concise as possible to not make this report unreasonably long due to the big amount of features we added.  
So we avoided explaining the trivial methods which a person could understand what and how they do just from their name.  
But we managed to explain all the methods in code through comments. So if there is any vagueness or ambiguity regarding a method or class that was not explained here, please refer to code where each Class, Method, Mechanism, Algorithm is thoroughly explained through comments.  
  
  
# Running the project: 
Steps for execution:  
If you don’t have intelliJ IDE then do the following :  
The `main()` function found in the Main.java is the entrypoint for the application  
To run the application we first need to compile classes:  
- `cd src`  
- `javac *.java`  
and then run the Main class:  
- `java Main`  
Otherwise :  
We can open the project using intelliJ IDE and just run the project.  
  
# Design Patterns: 
1. **Singleton**: This design pattern is used in the DatabaseConnection Class to ensure a single access to the database to avoid any possible problems caused by multiple connections at a time.  
2. **Composite**: This design pattern is used in Team Class. Where the CompanyUnit acts as the component and Team as the composite and Employee as the leaf. We use this pattern because there exists multiple departments in a Company and these departments can also contain multiple other departments or employees, and because of that we can represent the structure of the Company as a tree. And the composite pattern helps us perform actions on a part of this tree easily. For example we showcase the usage of this pattern in the method getSalary in the Team Class which gets us the combined salary of everyone on that team. This Design pattern also helps us in developing the project further because it gives us a concrete structure to follow later on.  
3. **Chain of Responsibility**: This design pattern is used in the CompanyUnitHandler Interface as the handler and CompanyUnit as the BaseHandler and then Employee and Team Classes as the Concrete Handlers. We use this pattern because our structure is represented as a tree because of the composite pattern. And the chain of responsibility patterns helps us pass requests to different parts of the tree. For example we showcase the usage of this pattern in the Class Team in method showHelp() which prints all information about this particular team and then prints all information about all the other teams in that team and so on till we have all the information about the team that handled the request at the start.  
