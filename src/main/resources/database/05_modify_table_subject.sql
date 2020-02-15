USE ptit_score_management;
ALTER TABLE `ptit_score_management`.`score_detail`
DROP FOREIGN KEY `fk_scoredetail_subject`;
ALTER TABLE `ptit_score_management`.`score_detail`
DROP INDEX `fk_scoredetail_subject` ;

ALTER TABLE `ptit_score_management`.`subject`
CHANGE COLUMN `id` `subject_id` VARCHAR(11) NOT NULL ;

ALTER TABLE `ptit_score_management`.`subject`
ADD COLUMN `id` INT NULL AFTER `subject_detail_id`;

ALTER TABLE `ptit_score_management`.`subject`
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ,
ADD PRIMARY KEY (`id`);
;
ALTER TABLE `ptit_score_management`.`score_detail`
CHANGE COLUMN `subject_id` `subject_id` INT NOT NULL ;

ALTER TABLE `ptit_score_management`.`score_detail`
ADD INDEX `fk_scoredetail_subject_idx` (`subject_id` ASC) VISIBLE;
;
ALTER TABLE `ptit_score_management`.`score_detail`
ADD CONSTRAINT `fk_scoredetail_subject`
  FOREIGN KEY (`subject_id`)
  REFERENCES `ptit_score_management`.`subject` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `ptit_score_management`.`subject`
ADD COLUMN `credit` INT NULL AFTER `name`;
