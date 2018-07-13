drop database if exists select_test;
create database select_test;
use select_test;
# 为了保证从表参照的主表存在，通常应该先建主表。
create table teacher_table
(
	# auto_increment:实际上代表所有数据库的自动编号策略，通常用作数据表的逻辑主键。
	teacher_id int auto_increment,
	teacher_name varchar(255),
	primary key(teacher_id)
);
create table student_table
(
	# 为本表建立主键约束
	student_id int auto_increment primary key,
	student_name varchar(255),
	# 指定java_teacher参照到teacher_table的teacher_id列
	java_teacher int,
	foreign key(java_teacher) references teacher_table(teacher_id)
);
insert into teacher_table
values
(null , 'Yeeku');
insert into teacher_table
values
(null , 'Leegang');
insert into teacher_table
values
(null , 'Martine');
insert into student_table
values
(null , '张三' , 1);
insert into student_table
values
(null , '张三' , 1);
insert into student_table
values
(null , '李四' , 1);
insert into student_table
values
(null , '王五' , 2);
insert into student_table
values
(null , '_王五' , 2);

insert into student_table
values
(null , null , 2);
insert into student_table
values
(null , '赵六' , null);


