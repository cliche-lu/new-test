ALTER TABLE sys_user
    ADD COLUMN levels VARCHAR(32) NULL COMMENT '等级',
    ADD COLUMN level_score INT NULL COMMENT '等级��';
