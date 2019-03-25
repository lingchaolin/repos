create table students
(
	student_id int AUTO_INCREMENT primary key,
	student_name varchar(20) not null,
	student_sex char(1),
	student_birthday date
);

select * from students;

insert into students(student_name,student_sex,student_birthday) values ('张三','1','1998-10-19');
