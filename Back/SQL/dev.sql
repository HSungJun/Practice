select * from kh.employee_dev;

-- kh 접속으로 옮긴다.
grant select on employee_dev to dev;  -- KH > DEV 에게 select 권한을 부여

create view employee_view 
as
select emp_id, emp_name, email, phone from employee;
-- >> view 로 전환하여 수행 > 권한이 없음

grant create view to kh; -- 관리자가 실행

select * from employee_view; 
-- view는 실시간으로 원본에 대한 링크를 통해 보고있는것으로 변경사항에 친화적이다.

select * from employee_dev; --table
select * from employee_view; --view

select * from kh.employee_dev; -- 복사본
select * from kh.employee_view; -- 실시간 링크

grant select on employee_view to dev; 
--kh접속으로 employee_view select 권한을 dev에게 주어야 열람이 가능함

-- commit 으로 저장(?)
select * from kh.employee_dev; -- 복사본 > 선동이 변경사항 적용 x
select * from kh.employee_view; -- 실시간 링크 > 선동이 변경사항 적용

