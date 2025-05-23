create table dept (
  deptno int,
  dname  varchar(100),
  loc    varchar(100),
  constraint pk_dept primary key (deptno)
);

create table emp (
  empno    int,
  ename    varchar(100),
  job      varchar(100),
  mgr      int,
  hiredate date,
  sal      float,
  comm     float,
  deptno   int,
  constraint pk_emp primary key (empno),
  constraint fk_mgr foreign key (mgr) references emp (empno),
  constraint fk_deptno foreign key (deptno) references dept (deptno)
);

create table salgrade (
  grade int,
  losal int,
  hisal int,
  constraint pk_salgrade primary key (grade)
);

-- DML - Data Manipulation Language:

insert into dept (deptno,  dname,        loc)
       values    (10,     'ACCOUNTING', 'NEW YORK'),
                 (20,     'RESEARCH',   'DALLAS'),
                 (30,     'SALES',      'CHICAGO'),
                 (40,     'OPERATIONS', 'BOSTON');

insert into salgrade (grade, losal, hisal)
       values        (1,      700,  1200),
                     (2,     1201,  1400),
                     (3,     1401,  2000),
                     (4,     2001,  3000),
                     (5,     3001,  9999);

insert into emp (empno, ename,    job,        mgr,   hiredate,     sal, comm, deptno)
       values   (7369, 'SMITH',  'CLERK',     7902, '1980-12-17',  800, NULL, NULL),
                (7499, 'ALLEN',  'SALESMAN',  7698, '1981-02-20', 1600,  300,   30),
                (7521, 'WARD',   'SALESMAN',  7698, '1981-02-22', 1250,  500,   30),
                (7566, 'JONES',  'MANAGER',   7839, '1981-04-02', 2975, NULL,   20),
                (7654, 'MARTIN', 'SALESMAN',  7698, '1981-09-28', 1250, 1400,   30),
                (7698, 'BLAKE',  'MANAGER',   7839, '1981-05-01', 2850, NULL,   30),
                (7782, 'CLARK',  'MANAGER',   7839, '1981-06-09', 2450, NULL,   10),
                (7788, 'SCOTT',  'ANALYST',   7566, '1982-12-09', 3000, NULL,   20),
                (7839, 'KING',   'PRESIDENT', NULL, '1981-11-17', 5000, NULL,   10),
                (7844, 'TURNER', 'SALESMAN',  7698, '1981-09-08', 1500,    0,   30),
                (7876, 'ADAMS',  'CLERK',     7788, '1983-01-12', 1100, NULL,   20),
                (7900, 'JAMES',  'CLERK',     7698, '1981-12-03',  950, NULL,   30),
                (7902, 'FORD',   'ANALYST',   7566, '1981-12-03', 3000, NULL,   20),
                (7934, 'MILLER', 'CLERK',     7782, '1982-01-23', 1300, NULL,   10);

commit;


1.	Write a query to display all the details of the employees who are working for department 10 or 20.
2.	Write a query to display the names of the employees whose salaries are 5000 or 3000 or 800. Write the query in 2 different ways.
3.	Write a query to display all the details of the employees whose names are:  'SCOTT', 'BLAKE', 'ADAMS'.
4.	Write a query to display the employees whose date of hire is one of the following: 'Dec 17, 1981', '3rd Dec, 1981', '21st Jan, 1981'.
5.	Write a query to display the details of the employees who are getting paid in the range 2000 – 5000. Write the query in two different ways.
6.	Write a query to display the details of all the employees who joined during the period 'Jan 01st, 1981' and '31st Aug, 1981'.
7.	Write a query to display all the details of the employees whose name begins with the letter 'S'.
8.	Write a query to display all the details of the employees whose name is at least 4 characters long.
9.	Write a query to display names of the employees whose name contains the letter 'A'.
10.	Write a query to display names of the employees who have joined in the month where the name of the month starts with the letter 'A'.
11.	Write a query to display names of the employees whose date of joining is within the first 9 days of any calendar month.
12.	Write a query to display the names of the employees who are not receiving any commission.
13.	Write a query to display the names of the employees whose job title is 'MANAGER' and who are working for department 20.
14.	Write a query to display the details of employees, whose name starts with letter 'J' and whose salary is greater than 2500 and who work in the department 20.
15.	Write a query to display the details of employees, whose name starts with letter 'J' or whose salary is greater than 2500 or who work in the department 20.
16.	Write a query to display the details of all the employees whose job title is 'MANAGER' or 'CLERK'.
17.	Write a query to display the employees whose salary is same as that of the employees 'FORD' or 'JAMES'.
18.	Write a query to display the details of the employees who are working in the 'ACCOUNTING' department.
19.	Write a query to display the details of all the salesmen belonging to the sales department who are receiving commission.
20.	Write a query to display details of the all the managers having experience not less than 20 years and working in the location 'NEW YORK' or 'DALLAS' and working under some other manager.
21.	Write a query to display the salary grade of the employee 'FORD'.
22.	Display the details of Managers belonging to grades 4 or 5.
23.	Display the following data for all the employees: Employee number, employee name, salary, grade, work location.
24.	Display the following data for all the employees of the “Accounting” department: Employee number, employee name, salary, work location.
25.	Display all grade 4 and grade 5 MANAGERS of the following departments: ACCOUNTING, SALES.
26.	Write a query to list the details of all the employees who belong to the department where 'ADAMS' is working.
27.	Display the details of all employees those who are senior (in terms of years of experience) to their own manager.
28.	Display the details of all the departments – if the department has any employee then display the employee's number and name as well.
29.	Display the details of employees whose department is located in 'NEW YORK' city.
30.	Display the details of employees whose salary is more than the salary of the employee 'JAMES'.
31.	Display the details of all the employees whose job title is same as that of the employee 'JAMES'.
32.	Display the details of all the employees who are senior to 'JAMES' (in terms of years of experience).
33.	Display the details of all the employees who are working in the same department as that of 'SCOTT'; do not include the details of 'SCOTT'.
34.	Display the details of the employees whose job titles are same as that of the employees of the 'SALES' department.
35.	Display the details of all grade 3 employees whose department is same as that of the employee 'SCOTT'.
36.	Display the details of all the employees working in the city of 'NEW YORK' or 'DALLAS' and whose job title is same as that of any grade 2 employee; however do not include the job title 'SALESMAN'.
37.	Display the details of all the employees whose salary is more than that of employee 'SMITH' but less than that of employee 'BLAKE'; however, it should not be equal to that of 'SCOTT' or that of 'FORD'.
38.	Display the details of all employees to whom other people are reporting.
39.	Display the details of all the employees who are working in the department where the manager of employee 'BLAKE' is working.
40.	Display the following details of all the employees: employee number, name, salary, department name, location. If the employee is not working in any department then display just the employee number, name, salary.
41.	Display the details of employees whose salaries are more than the salary of any employee belonging to department 10.
42.	Display the details of all the employees working in department 10 whose salary is more than the highest salary being given in department 20.
43.	Display the details of the nth highest paid employee.
44.	Display the details of the highest paid employee from each department.
45.	Display the details of the senior-most employee of each department.
46. Get max paid employee details of each department
47. Get nth highest salary paid employees
48. Get max paid employee of given locations
49. Get rank 1, and 2 employee name from all the locations
50. Get employee details, who are getting more than average salary of the dept no 10 and exclude employees from dept no 10