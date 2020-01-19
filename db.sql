CREATE TABLE master.dbo.app_user (
	id varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	id_card_no varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	login_name varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	login_password varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	first_name varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	last_name varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	create_by varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	create_date datetime NULL,
	change_by varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	change_date datetime NULL
) GO