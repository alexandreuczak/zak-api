insert into gretting(id, message)values(gretting_seq.nextval, 'olá');
insert into gretting(id, message)values(gretting_seq.nextval, 'oi');
insert into gretting(id, message)values(gretting_seq.nextval, 'tudo bem');

insert into user_app(id, name, password, admin)values(user_seq.nextval, 'zak', '$2a$10$uW1eMRVCr6J1mOZmLybcUOee8bjtoOyIMqQdPemEz6FIPvvVwny4W', false);
insert into user_app(id, name, password, admin)values(user_seq.nextval, 'admin', '$2a$10$0rGFmJpaYG6NPq1BX6IpWOYjBQ1pgGU.uITiJnb/XAwtXCcXIDwVW', true);