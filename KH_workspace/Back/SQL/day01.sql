desc employee; 
-- describe employee; : employee ���̺� ���� ���� �����϶�

select emp_id , emp_name ,emp_no from employee;
-- employe ���̺��� emp_id , emp_name , emp_no �÷��� �ش��ϴ� �����͸� ��ȸ�϶�

select * from employee;
-- employee ���̺��� ��� �÷� �����͸� ��ȸ�϶�

select emp_id , emp_name from employee where emp_id = 207;

--Quiz01
--1 . Employee ���̺� �����ϴ� ��� ������ ���, �̸� �޿��� ����غ�����
select emp_name , emp_id ,salary from employee;

--2. ���� �� D9 �μ��� ���� �ִ� �������� ���, �̸� , �μ��ڵ带 ����غ�����
select emp_id , emp_name , dept_code from employee where dept_code = 'D9';

select * from employee where salary >= 4000000;

select * from job;

--Quiz
--1 ���� �� �޿��� 200���� ���Ϸ� �޴� ������ �̸� �� �μ��ڵ� ���� �ڵ带 ����غ�����

select emp_name , dept_code , job_code salary from employee where  salary <=2000000;

select
emp_name,
dept_code,
job_code,
salary
from
    employee
where
    salary<=2000000;
    
--and , or
select * from employee;
select * from employee where dept_code = 'D6' and salary <=3000000;
    
select * from employee where dept_code = 'D6' or salary <=3000000;

--quiz
--1.�޿��� 200~300�� ������ ������ ���, �̸� ,�޿� ���� �ڵ带 ����غ�����
select salary , emp_name , emp_id , job_code from employee where salary >= 2000000 and salary <= 3000000;
---------------------------
select salary , emp_name , emp_id , job_code from employee where salary between 2000000 and 3000000;

--quiz
select * from employee;
--1. employee ���̺��� ���� �߿� job_code �� j3�̸鼭 �޿��� 350������ �̻��� ������ �̸��� ��ȭ��ȣ�� ����غ�����
select emp_name ,phone from employee where job_code ='J3' and salary >= 3500000;
--2. employee ���̺��� ���� �߿� �μ��ڵ尡 d5�̰ų� d6�̰ų� d9�� ������ �̸��� �μ��ڵ带 ����غ�����
select emp_name , dept_code from employee where dept_code ='D5' or dept_code = 'D6' or dept_code = 'd9';
----------------------------------
select emp_name , dept_code from employee where dept_code in ('D5','D6','D9');

select emp_id, emp_name from employee
    where dept_code is not null;


---------------------alias
select emp_name �����, salary ����, salary * 12 as "�� ��", '��' ���� from employee;
--������ ������ ''  ����������� ""  as�� ""�������� �پ�������� ���� �Ұ�
--crtl shift +d ���κ���
--ctrl shift +d ���� ����
-- select �÷��� from ���̺�� where ���ǽ�;
--���ǽ� =,<,>,<=, >= ��밡��
--and , or , between and , is null, is not null, in

------------------------sysdate&dual    select�� �ݺ���
--dual : ���� ���̺� - SQL �̿��ڰ� Ư�� ����� �׽�Ʈ�Ҷ� ����Ҽ��ֵ��� �̸� ������ ����ƺ� ���̺� ����ƺ� (����)
--sysdate = sysdate�� ȣ��Ǵ� ������ ��¥ �� �ð��� ��ȯ�ϴ� orcle��� (���� ��¥ �� �ð� )
--          date type�� ����� ��ȯ�Ѵ� (��¥Ÿ��)
--          ��¥Ÿ�Կ� ���� ��ġ ������ (+,-) �ϼ� ������ ���� �ȴ�
--          ��¥Ÿ�԰� ��¥Ÿ���� �����ϸ� �� ��¥ ������ ������ ��ȯ �ȴ�
select sysdate from dual;

select 'ABC' - 10 from dual;
select 10 - 5 from dual;

select sysdate -1 from dual;
--��¥ Ÿ�Կ� ���ؼ��� �÷��� ���̳ʽ��� �����ϴ�

desc employee;

--floor() : �Ǽ��� �Ķ���ͷ� ���޹����� �Ҽ��� �ڸ����� �����ϰ� �����ڸ��� ��ȯ�ϴ� �޼���
-- || ���ڿ����� ������
select emp_id, emp_name , hire_date as �Ի���, floor (sysdate - hire_date) || '��'
as �ٹ��ϼ� from employee;
select * from employee;

--quiz
--1.employee ���̺��� �ټӳ���� 20�� �̻� �� ���� �̸� ,����,���ʽ��� �� ����غ�����


select emp_name as �̸�, salary || '��' as ���� , bonus as ���ʽ��� from employee where floor(sysdate-hire_date)>=7300;

select emp_name ,salary ,bonus from employee where floor ((sysdate-hire_date)/365) >=20;

-- 2. ��� ���� �̸� ,����, �Ǽ��ɾ� (���� - (���� * 3%))�� ����غ�����
select emp_name,
salary*12 ����, 
salary*12 - (salary *12 *0.03) " �� ���ɾ�"
from
employee;

select * from employee where hire_date between '90/01/01' and '01/12/31';
--���ڿ��ε� between�� ���� �˾Ƽ� ��¥�� �м���

-------------------------like  % �������� �ְ� �������� �ִ�
select * from employee where emp_name not like '%��%';
                                        --���� �ֱ⸸�ϸ� ã�´� %���־�ǰ� �����
select * from employee where emp_name like '��__';
--���� �� ���ڸ��� ���� �ڿ� �α��ڰ� �ݵ�� �־�ߵȴ�

--quiz
--1 ��� �����߿� ��ȭ��ȣ�� ó�� 3�ڸ��� 010 �ƴ� ������ �̸��� ��ȭ��ȣ�� ����غ�����
select emp_name, phone from employee where phone not like '010%';

select * from employee;
--2 ��� ���� �߿��� �̸��� '��' �ڰ� ���� ����� ��� ã�� �̸��� ����غ�����
select emp_name from employee where emp_name like '%��%';
--3. ��� ���� �߿��� 
    --�μ��ڵ尡 D9 �Ǵ� D6�̰�
    --������ 270���� �̻��̸�
    --email�� ���ĺ� s�� ���ԵǾ��ְ�
    --������� 2001�� 1�� 1�Ϻ��� 2005�� 12�� 31�� ������ ������
    --�̸� ,�μ��ڵ� ,�޿� , email, ������� ����غ�����
    select emp_name , dept_code , salary , email, hire_date from employee 
    where dept_code in ('D9' , 'D6')and salary >= 2700000 and email like '%s%'
    and hire_date between '01/01/01' and '05/12/31';
    select * from employee;

    --quiz
    --1. ���ӻ�� (manager_id)�� ���� �μ� (dept_code) ��ġ�� ���� ���� ������ ��� �� �̸��� ���
    select emp_name , emp_id from employee where manager_id is null and dept_code is null;
    --2. �μ� ��ġ�� ���� �ʾ����� ���ʽ��� ���޵Ǵ� ������ �μ��ڵ� , �̸� �� ���ʽ��� ���
    select emp_name ,bonus , dept_code from employee where dept_code is null and bonus is not null;


-------------------------------order by
-- order by : ���� ���� ������� Ư�� ������ �̿��Ͽ� �����͸� �����ϴ� ����
--�ټ���� (�⺻)asc : �ø����� desc : ��������
select emp_id , emp_name ,dept_code ,salary from employee order by dept_code desc nulls first ,salary desc; 
select emp_id , emp_name ,dept_code ,salary from employee order by dept_code desc nulls last  ,salary asc; 

select emp_id , emp_name ,dept_code ,salary from employee order by 3 desc;


-- desc employee;
-- desc -> describe

-- order by desc;
-- desc - > descending

--����1
--�ټӳ�� 5���̻� , 10�� ������ ������ �̸� �ֹι�ȣ �޿� �Ի����� �˻��ϼ���
select emp_name , emp_no, salary , hire_date from employee where floor ((sysdate-hire_date)/365) between 5 and 10;
--����2
--�������� �ƴ� ������ �̸� ,�μ� �ڵ带 �˻��ϼ��� (��翩�� ENT_YN)
select emp_name , dept_code from employee where ent_yn = 'Y';
--����3
--�ټӳ���� 10���̻��� �������� �˻��Ͽ�
--��� ����� �̸� ,�޿� , �ټӳ��(�Ҽ��� x)�� �ټӳ���� ������������ �����Ͽ� ����ϼ���
--�� �޿��� 50% �λ�� �޿��� ��µǵ��� �ϼ���
select emp_name , salary *1.5 , floor(((sysdate - hire_date)/365)) from employee where floor(((sysdate - hire_date)/365))>=10 order by floor(((sysdate - hire_date)/365)) asc;
    select * from employee;

--����4
--�Ի����� 99/01/01~10/01/01 �� ����߿��� �޿��� 2000000�� ������ �����
--�̸� ,�ֹι�ȣ ,�̸��� , ����ȣ , �޿��� �˻��ϼ���
select emp_name , emp_no , email, phone , salary from employee where hire_date between '99/01/01' and '10/01/01' and salary <=2000000;
--����5
--�޿��� 2000000~3000000�� �� �������߿��� 4�� �����ڸ� �˻��Ͽ�
--�̸� ,�ֹι�ȣ ,�޿�,�μ��ڵ带 �ֹι�ȣ ������ ������������ ���
--�� �μ��ڵ尡 null �� ����� �μ��ڵ尡 �������� ����ϼ���  <--x
select emp_name , emp_no , salary , dept_code from employee where salary >=2000000 and salary <= 3000000 and emp_no like '%-2%' and emp_no like '%04%' order by emp_no desc;
--����6
--���� ��� �� ���ʽ��� ���� ����� ���ñ��� �ٹ����� �����Ͽ�
--1000�� ����(�Ҽ�������)
--�޿��� 10% ���ʽ��� ����Ͽ� �̸�,Ư�����ʽ� (���ݾ�) ����� ����ϼ���
--�� �̸� ������ ���� ���� �����Ͽ� ����ϼ���
select * from employee;
SELECT
    emp_name,
    ( salary * 0.1 ) * floor((SYSDATE - hire_date) / 1000)
FROM
    employee
WHERE
        emp_no LIKE '%-1%'
    AND
        bonus IS NULL
ORDER BY emp_name ASC;

select * from employee where 1=1;
--where true�� ������


-- select �÷��� from ���̺��;
-- where �� - ������ ���Ǻ�
-- between and , like (% , _ ) , is null ,not ,in ,and ,or , > , < , =
-- ���ڿ� ''
-- order by - ����

-----------------------------------------------------
 -- function () == method () 
 -- �ڹٿ����� �޽�� ����Ŭ�� ���
 -- nvl (�˻絥���� , �˻絥���Ͱ� null�϶� ġȯ �� �� )
 -- nvl(Ÿ�� ������ ,���ϰ� ) :
 select emp_name , nvl(dept_code,'����' )from employee;
 
 --length() : Ư�� �������� ���̸� �����Ͽ� ��ȯ

select length ('Hello') from dual;
select length('�ѱ�') from dual;
--lengthb() : Ư�� �������� byte�� �����Ͽ� ��ȯ
select lengthb('Hello') from dual;
select lengthb('�� ��') from dual;
--����Ŭ������ �ѱ��ڰ� 3����Ʈ�� ����� 1����Ʈ

--instr() : ���ڿ� �ȿ��� Ư�� ������ ��ġ ���� ã�� �Լ�(java�� indexof)
select instr('Hello World Hi High','H',2,2)from dual;
--'Hello World Hi High' ���ڿ� �ȿ��� H�� �˻��ϵ� 1�� ���ڿ������� ���������� �˻��ذ��� 1������ ������ H�� ��ġ

-- substr() : ���ڿ� ������ ������ ��ġ�� ���ڿ��� �߶󳻾� ��ȯ�ϴ� �Լ�
select substr('Hello World Hi High' ,7,5 )from dual;
select substr('�ȳ� ���� �ȳ� ����' ,7,5 )from dual;

--quiz
--1. ���� ��ܿ��� �̸��� ���� �����Ͽ� ����غ��ô�
select distinct substr(emp_name,1,1)  from employee order by 1;
--distinct �ߺ� ����

select * from employee;
--2. ���� ��ܿ��� �����ȣ , ����� , �ֹι�ȣ , ������ ����ϼ���
-- �� �ֹι�ȣ �� 6�ڸ��� *��ȣ�� ����ϼ���
-- ���������� ������ ����غ����� (like ������� ���� )
SELECT
    emp_id,
    emp_name,
    substr(emp_no,1,8)||'******',
    salary * 12
FROM
    employee
where
    substr(emp_no,8,1)='1';

----------------------------------------------------
--abs() : ���� ���밪�� ��ȯ�ϴ� �Լ�
select abs(2) from dual;
select abs(-2) from dual;

--mod() : JAVA�� % ������ - > ������ ���� �Լ�
select mod (10,3) from dual;
select mod (10,4) from dual;

-- round() : �ݿø� �Լ� 
select round(126.456, 0) from dual;
select round(126.456, 1) from dual;
select round(126.456, 2) from dual;
select round(126.456, 3) from dual;
select round(126.456, -1) from dual;
select round(126.456, -2) from dual;

--floor() : �Ҽ��� �����Լ� 

-- trunc() : Ư�� ��ġ���� �����Լ�
select trunc(126.456 ,1 ) from dual;
select trunc(126.456 ,2 ) from dual;
select trunc(126.456 ,-1 ) from dual;

--ceil () : �ø� �Լ�
select ceil(126.456) from dual;  --�Ҽ��� ù�� �ڸ����� �ø�
select ceil(123.456 * 10) /10 from dual; --�Ҽ��� �Ѥ� �ڸ����� �ø�
select ceil(123.456 * 100) /100 from dual; --�Ҽ��� �¤� �ڸ����� �ø�
------------------------------------------------------------
--sysdate : ��ȸ�ϴ� ������ �ð� ���� DateŸ������ ��ȯ
select sysdate from dual;
--sysdate = �ڹ��� timestamp �� �� ���

--months_between : �� ��¥ ������ ���� ���� ��ȯ �ϴ� �Լ�
select emp_name, floor(months_between(sysdate, hire_date)) �ټӰ����� from employee;

--add months : Ư�� ��¥�� �������� ���ϴ� �Լ�
select add_months(sysdate,1) from dual;

--next_day : ������¥�� �������� ���� ����� ���� date���� ��ȯ
select sysdate , next_day(sysdate, '������') from dual;

--last_day : ������¥�� ���� ���� ������ �� date���� ��ȯ

select last_day(sysdate) from dual;

--quiz
-- ������ ������ ��¥�� ��ĥ�ϱ��?
select last_day(add_months(sysdate,1))from dual ;
select last_day(add_months(sysdate,-1))from dual ;

-- extract : ��¥ �����κ��� ��,��,���� �����ϴ� �Լ�

select extract(year from sysdate ) from dual;
select extract(month from sysdate ) from dual;
select extract(day from sysdate ) from dual;

--quiz
--1. ���,�����, �Ի�⵵ (0000��)�������� ����غ�����
select * from employee;
select emp_id , emp_name , extract(year from hire_date)||'��' �Ի翬�� from employee;

--2. employee ���̺��� ����� �̸� ,hire_date, ������ ����غ�����
--���� ����� �Ҽ��� �ϰ�� �ø����� �Ͽ� ����غ�����(28.144-> 29����)
--(��½� ������ �Ի��� �������� �ø�����)

select emp_name ,hire_date, ceil(((sysdate - hire_date)/365))���� from employee order by hire_date asc;

--------------------------------------------------------------

-- to_char() : ��¥�� �Ǵ� ���ڰ��� ���ڿ��� ��ȯ�ϴ� �Լ�

-- D : �̹��ֿ� ����� �� , DD: �̹��޿� ����� �� , DDD: ������ ���° �� 

select to_char(sysdate,'YYYY"��" MM"��" DD"��" (DY) Day HH24:MI:SS') from dual;
select to_char(sysdate ,'YYYY'  ) from dual;
--quiz
--����� ,����� (1990/02/06(ȭ)) ���·� ���
select emp_name , to_char(hire_date , 'YYYY/ MM / DD (DY)' ) from employee;
select to_char(1000000, 'L999,999,999') from dual;
--���� ǥ���� 9�� ǥ��

--to_date() : ���ڿ��� ��¥������ ��ȯ
select to_date('20180208','YYYYMMDD') - 10 from dual;
--��¥�� -10 ���� ,���ڿ��̸� ��길 ���� 
--����� �ƴϰ� �м�

--quiz
--1945�� 8�� 15���� ������?

select to_char(to_date('19450815','YYYYMMDD'),'DY')���������� from dual;
select to_date('19450815','YYYYMMDD')from dual;
--------------------------------------------------------
--decode() : ���� ���� �б����� ����� �Լ� (�ڹ��� ���׿����� ,switch)

select decode('��' , 'Apple' , '���' , 'Orange' , '������', '����') from dual;
--��ĭ�� �����̸� ������ �����Ѵ� �������� �������� �����Ѵ�
--������ else 
select * from employee;
--quiz
--��� ��ȣ , ����� , ���� (�� �� ) ���·� ����غ�����
select emp_id , emp_name , decode(substr(emp_no,8,1),'1','��','2','��') ���� from employee;
----------------------------------------------------------
--case: ���ǽĿ� ���� ��ȯ�� �б��� ���� �Լ�
select emp_id , emp_name , case when substr(emp_no,8,1)='1' then '��' when substr(emp_no,8,1) = '2' then '��' else '?' end "����" from employee;

--quiz
--1. 60��� �� ������ �߿��� 60~64�� �̸��� �������� '60��� �ʹ�' �̶�� ���
--               65~69�� ������ �������� '60��� �Ĺ�' �̶�� ���
--  ���, �̸� , 60��� ��/�Ĺ�
select emp_id , emp_name , 
case when 
substr(emp_no,1,2) <65  then '60��� �ʹ�' 
when substr(emp_no,1,2)>= 65 then '60��� �Ĺ�'
end "���̴�" from employee 
where substr(emp_no,1,2) between 60 and 69;

select length(email) from employee;
-- ��������� ��� ������ �Լ�
--------------------------------------------------------
--�׷� �Լ� ( SUM, AVG, COUNT, MAX , MIN )


-- �� ȸ���� �Ѵ� �ΰǺ�� ���ΰ�?
--sum : �հ��Լ�
select emp_name ,sum(salary) from employee;
--�׷� �Լ��� ����������� ���� �ٸ� �Լ��� �ü� ���� 

--AVG :(����Լ�)
select avg(salary) from employee;

--COUNT : ���� ���� ��ȯ�ϴ� �Լ�

select count(emp_id) from employee;
select count(*) from employee;
--null���� ī������ �ȵ�                                                   

--MAX : ��ü �࿡�� ���� ū���� ��ȯ�ϴ� �Լ�
select max(salary) from employee;

--MIN : ��ü �࿡�� ���� ���� ���� ��ȯ�ϴ� �Լ�
select min(salary),max(salary) from employee;
--�׷쳢���� �׷��Լ� ����
select * from employee;
--quiz

--1. D5�μ� �޿� ���
select avg(salary) from employee
    where (dept_code)= 'D5';

--2. ���������� �޿� �հ�
select sum(salary) from employee
    where substr(emp_no,8,1)= 1;







