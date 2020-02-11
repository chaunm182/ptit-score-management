USE ptit_score_management;

ALTER TABLE account_role ADD CONSTRAINT fk_account_role_1 FOREIGN KEY(account_id) REFERENCES account(id);
ALTER TABLE account_role ADD CONSTRAINT fk_account_role_2 FOREIGN KEY(role_id) REFERENCES role(id);

ALTER TABLE student ADD CONSTRAINT fk_student_person FOREIGN KEY(id) REFERENCES person(id);

ALTER TABLE account ADD CONSTRAINT fk_account_person FOREIGN KEY(person_id) REFERENCES person(id);


ALTER TABLE subject_detail ADD CONSTRAINT fk_subjectdetail_subject FOREIGN KEY(subject_id) REFERENCES subject(id);

ALTER TABLE score_detail ADD CONSTRAINT fk_scoredetail_subject FOREIGN KEY(subject_id) REFERENCES subject(id);
ALTER TABLE score_detail ADD CONSTRAINT fk_scoredetail_student FOREIGN KEY(student_id) REFERENCES student(id);


