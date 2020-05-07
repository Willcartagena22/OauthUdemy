INSERT INTO `usuarios` (username,password,enabled,name,email) VALUES('cwill','$2a$10$kD/syoJ5Rcmx.akXVFZvFOHd5TYj6B2wBqHWR4WMxRQiDca0Lpis6',1,'Will Cartagena', 'calvarado@gmail.com');
INSERT INTO `usuarios` (username,password,enabled,name,email) VALUES('cwill2','$2a$10$0m7NCtg/ergbQRXWdwDguu6FeJiOHgVakrcxR2Yt0vw5iVP4m9zFK',1,'Will Cartagena2', 'calvarado2@gmail.com');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id,role_id) VALUES(1,1);
INSERT INTO `usuarios_roles` (usuario_id,role_id) VALUES(2,2);
INSERT INTO `usuarios_roles` (usuario_id,role_id) VALUES(2,1);