INSERT INTO code_class
	(class_code, class_name)
	VALUES ('A01', 'job');
   
INSERT INTO code_class
	(class_code, class_name)
	VALUES ('A02', 'hobby');
	
INSERT INTO code_detail (class_code, code_value, code_name, sort_seq) VALUES ('A01','00', '---', 1);
INSERT INTO code_detail (class_code, code_value, code_name, sort_seq) VALUES ('A01','01', 'Developer', 2);
INSERT INTO code_detail (class_code, code_value, code_name, sort_seq) VALUES ('A01','02', 'Designer', 3);
INSERT INTO code_detail (class_code, code_value, code_name, sort_seq) VALUES ('A01','03', 'Architect', 4);


INSERT INTO code_detail (class_code, code_value, code_name, sort_seq) VALUES ('A02','00', '---', 1);
INSERT INTO code_detail (class_code, code_value, code_name, sort_seq) VALUES ('A02','01', 'Movie', 2);
INSERT INTO code_detail (class_code, code_value, code_name, sort_seq) VALUES ('A02','02', 'Music', 3);
INSERT INTO code_detail (class_code, code_value, code_name, sort_seq) VALUES ('A02','03', 'Sports', 4);
