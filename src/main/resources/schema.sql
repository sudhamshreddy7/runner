create table if not exists Run
(
    id int not null,
    distance int not null,
    duration int,
    location varchar(10),
    data_d varchar(20)
    );