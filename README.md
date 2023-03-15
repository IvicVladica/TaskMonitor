# TaskMonitor
Application monitors number of tasks done by employees

Installation and settings:
Technologies (Java Oracle 17, PostgreSQL Server, SpringBoot 2.7.4., Open API)
1. Open project with Java IDE
2. Open pgAdmin4
3. Create Database named TaskMonitor in PostgreSQL Server using PgAdmin4
4. Username and Password used for Database creation set in
src/main/resources/application.properties
5. After this steps application is ready to run
Folder structure overview
Application contains Model package with entity classes, Repository package which contains classes with methods for read/write from database, Service package with classes for application business logic and Controller package with Controller class for processing incoming API requests.
Application folder structure is shown below
● Controller
○ Controller
● Model
○ Client
○ Employee
○ Task ● Repository
○ ClientRepository
○ EmployeeRepository ○ TaskRepository
● Service
○ ClientService
○ EmployeeService ○ TaskService
Flyway migrations are used for table creation and modification.
Dto classes and Exception handlers will be added in the next version.
Description of additional functionalities
Since the primary concept of application was monitoring of tasks done by employees, my idea was to specify which client is the user of delegated tasks. New table “Clients” can store information of Company clients - name, address, phone and priority.
Everytime a task is created beside the assignment of an employee who is working on that task, the client also needs to be assigned. In that way, we can monitor the number of tasks for each client and to make statistics according to the frequency of tasks for certain clients. Two statistics implemented in application are:
- Top 3 Clients in last 3 months - which can show us which clients are company key accounts, and to pay more attention on that clients
- Worst 3 Clients in last 3 months - statistic which show clients with minimum tasks in last 3 months, and according to that information company may consider ways to improve cooperation with that client
Level of priority, as one of information stored for client, in every moment can show status of client and it depends of total number of tasks done for one client. At moment of creation of each task, Task Monitor checks the total number of task for entered client, and changes priority according to schema:
1-4: Low
5-9: Middle
10 and above: High
Statistics for employees and statistics for clients used in the proper way can be useful for better coordination between employees, tasks and clients.
