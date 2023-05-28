insert into user_details(id,name,bday)
values(1001,'Surya',current_date());

insert into user_details(id,name,bday)
values(1002,'Maddy',current_date());

insert into user_details(id,name,bday)
values(1003,'Anirudh',current_date());

insert into post(id,description,user_id)
values(1001,'Learning Springboot',1001);

insert into post(id,description,user_id)
values(1002,'Completed Java',1001);

insert into post(id,description,user_id)
values(1003,'Took an Interview',1002);

insert into post(id,description,user_id)
values(1004,'Completed a concert',1003);