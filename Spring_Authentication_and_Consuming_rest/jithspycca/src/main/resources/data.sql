INSERT INTO `roles` (`role_name`)
  VALUES ('CUSTOMER');

INSERT INTO `roles` (`role_name`)
    VALUES ('ADMIN');

 INSERT INTO `person` (`name`,`password`,`email`,`role_id`)
     VALUES ('jithin','$2a$12$2WNNBMZ2R84YdDcw6nRkH.tldydy8HkoziwM/q7dEB5BWyABrd2xO','jithin@gmail.com',2);