ALTER TABLE `ptit_score_management`.`account`
DROP FOREIGN KEY `fk_account_person`;
ALTER TABLE `ptit_score_management`.`account`
DROP INDEX `fk_account_person` ;
;
ALTER TABLE `ptit_score_management`.`person`
ADD INDEX `FK_person_account_idx` (`account_id` ASC) VISIBLE;
;
ALTER TABLE `ptit_score_management`.`person`
ADD CONSTRAINT `FK_person_account`
  FOREIGN KEY (`account_id`)
  REFERENCES `ptit_score_management`.`account` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
