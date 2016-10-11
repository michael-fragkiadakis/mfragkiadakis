
select * from students;
INSERT INTO students VALUES (1, 'John', 'Doe', '1981-01-01');
INSERT INTO students VALUES (2, 'Jane', 'Doe', '1982-01-07');
INSERT INTO students VALUES (3, 'Jane', 'Dee', '2003-03-01');
select distinct * from students;
insert into courses values (1, 'SQL', 'AG', 'BN', 2, '2016-10-21');
insert into courses values (2, 'JAVA', 'VS', 'BN', 3, '2016-10-25');
insert into courses values (3, 'R', 'KP', 'TT', 4, '2016-11-09');
insert into courses values (4, 'PYTHON', 'KK', 'DD', 5, '2016-11-09');
select count(StID) from students;
select CourseName from courses where Duration>3;
select FName, LName from students where DateOfBirth<'1999-10-02';
select month(StartingDate) from courses where CourseName='SQL';
select * from courses where Duration>2 and month(StartingDate)=11;
select LecturerName, sum(Duration) as TeachingDays from courses group by LecturerName having sum(Duration)>2;
insert into grades values (1, 1, 7);
insert into grades values (1, 3, 4);
insert into grades values (2, 1, 9);
insert into grades values (2, 4, 1);
insert into grades values (3, 2, 10);
select * from grades;
select distinct students.FName, students.LName from students inner join grades on students.StID=grades.StID;
select students.StID, students.FName, students.LName, courses.CourseName, grades.grade from (students inner join grades on students.StID=grades.StID)
 inner join courses on grades.CourseID=courses.CourseID;
select FName, LName, AVG(grade) from (select students.StID, students.FName, students.LName, courses.CourseName, grades.grade from (students inner join grades on students.StID=grades.StID)
 inner join courses on grades.CourseID=courses.CourseID) as personal group by StID;
select FName, LName from (select students.StID, students.FName, students.LName, courses.CourseName, grades.grade from (students inner join grades on students.StID=grades.StID)
 inner join courses on grades.CourseID=courses.CourseID) as personal group by StID having avg(grade)>5;
select CourseName, avg(grade) from (select students.StID, students.FName, students.LName, courses.CourseName, grades.grade from (students inner join grades on students.StID=grades.StID)
 inner join courses on grades.CourseID=courses.CourseID) as personal group by CourseName;
select FName, LName from (select students.StID, students.FName, students.LName, courses.CourseName, grades.grade from (students inner join grades on students.StID=grades.StID)
 inner join courses on grades.CourseID=courses.CourseID) as personal where CourseName='SQL';
select CourseName, max(grade) from (select students.StID, students.FName, students.LName, courses.CourseName, grades.grade from (students inner join grades on students.StID=grades.StID)
 inner join courses on grades.CourseID=courses.CourseID) as personal group by CourseName;
select FName, LName from (select students.StID, students.FName, students.LName, courses.CourseName, grades.grade from (students inner join grades on students.StID=grades.StID)
 inner join courses on grades.CourseID=courses.CourseID) as personal where CourseName='SQL' and Grade>5;