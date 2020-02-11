USE ptit_score_management;
CREATE TABLE person(
	id int primary key not null auto_increment,
    first_name varchar(100) null,
    last_name varchar(50) null
);

CREATE TABLE student(
	id int primary key not null,
	student_id varchar(11) not null unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

CREATE TABLE account(
	id int not null primary key auto_increment,
    username varchar(50) not null unique,
    password varchar(100) not null,
    avatar varchar(100) null,
    email varchar(60) null,
    enable tinyint(2) default 1,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    person_id int not null
);

CREATE TABLE role(
	id int primary key not null auto_increment,
    name varchar(50) not null
);

CREATE TABLE subject(
	id varchar(11) primary key not null,
    name varchar(150) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

CREATE TABLE subject_detail(
	id int primary key not null auto_increment,
    attendance_weight tinyint(4),
    mid_term_exam_weight tinyint(4),
    practice_weight tinyint(4),
    assignment_weight tinyint(4),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    subject_id varchar(11) not null
);

CREATE TABLE account_role(
	id int primary key auto_increment,
    account_id int not null,
    role_id int not null
);

CREATE TABLE score_detail(
	id int primary key auto_increment,
    student_id int not null,
    subject_id varchar(11) not null,
    attendance_score float(4,2) null,
    mid_term_exam_score float(4,2) null,
    practice_score float(4,2) null,
    assignment_score float(4,2) null,
    final_exam_score float(4,2) null,
    description varchar(50) null,
    term int(6) null
);
