select * from kh.employee_dev;

-- kh �������� �ű��.
grant select on employee_dev to dev;  -- KH > DEV ���� select ������ �ο�

create view employee_view 
as
select emp_id, emp_name, email, phone from employee;
-- >> view �� ��ȯ�Ͽ� ���� > ������ ����

grant create view to kh; -- �����ڰ� ����

select * from employee_view; 
-- view�� �ǽð����� ������ ���� ��ũ�� ���� �����ִ°����� ������׿� ģȭ���̴�.

select * from employee_dev; --table
select * from employee_view; --view

select * from kh.employee_dev; -- ���纻
select * from kh.employee_view; -- �ǽð� ��ũ

grant select on employee_view to dev; 
--kh�������� employee_view select ������ dev���� �־�� ������ ������

-- commit ���� ����(?)
select * from kh.employee_dev; -- ���纻 > ������ ������� ���� x
select * from kh.employee_view; -- �ǽð� ��ũ > ������ ������� ����

