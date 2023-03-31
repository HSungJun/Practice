select * from cafe;

insert into cafe values (cafe_seq.nextval, 'Cafe Mocha', 4000, 'Y');
rollback;

delete from cafe where id = 1030;

