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
--1.
--D5�μ� �������� �޿� ���
select avg(salary)from employee where dept_code = 'D5';
--2.
-- ���������� �޿� �հ�
select sum(salary) from employee where substr (emp_no,8,1) =1;

select  * from employee;
----------------------------------------------------------------
--1. ������� �̸��� , �̸��� ���̸� ����ϼ���
--        �̸� �̸��� �̸��ϱ���
--   ex) ȫ�浿 , hong@kh.or.kr 

select emp_name , email, length(email) from employee;


--2. ������ �̸��� �̸��� �ּ��� ���̵� �κи� ����ϼ���
--   ex) ���ö no_hc
--   ex) ������ jung_jh

select emp_name ,substr(email,1,instr(email,'@',1,1)-1) from employee;

--3. 60����� ������� ���, ���ʽ� ���� ����ϼ���   --------------------����
--   �׶� ���ʽ� ���� null�� ��쿡�� 0% �̶�� ��� �ǰ� ���弼��
--       ������ ��� ���ʽ�
--   ex) ������ 62 30%
--   ex) ������ 63 0%

select emp_name as ������, substr(emp_no,1,2) , case when bonus is null then 0 else 
bonus end * 100 || '%' as ���ʽ� from employee where substr(emp_no,1,2) between 60 and 69;


--4. "010" �ڵ��� ��ȣ�� ���� �ʴ� ����� ���� ����ϼ��� (�ڿ� ������ ���� ���̼���)
--      �ο�
--   ex) 3��
select count(phone) || '��'from employee where phone not like '010%';

--5. ������� �Ի����� ����ϼ��� 
--   ��, �Ʒ��� ���� ��µǵ��� ����� ������
--       ������ �Ի���
--   ex) ������ 2012��12��
--   ex) ������ 1997�� 3��

select emp_name as ������ , to_char(hire_date, 'yyyy "��" mm "��" ')�Ի��� from employee;



--6. ������� �ֹι�ȣ�� ��ȸ�ϼ���
--   ��, �ֹι�ȣ 9��° �ڸ����� �������� "*" ���ڷ� ä���� ��� �ϼ���
--   ex) ȫ�浿 771120-1******
select emp_name ,substr(emp_no,1,8) ||'******' from employee;

select * from employee;

--7. ������, �����ڵ�, ����(��)�� ��ȸ�ϼ���. -----------------����

--  ��, ������ \1,000,000 ���� ǥ�õǰ� �� (���� ��ȭ �ܰ� ���� �Ǿ�� ��)
--     ������ ���ʽ�����Ʈ�� ����� 1��ġ �޿���
SELECT
    emp_name,
    job_code,
    TO_CHAR(
        salary * 12 * (1 + nvl(bonus,0)),
        'L999,999,999'
    )
FROM
    employee;


--8. �μ��ڵ尡 D5, D9�� ������ �߿��� 2004�⵵�� �Ի��� ������ �� ��ȸ�ϼ���.
--   [ ��� ����� �μ��ڵ� �Ի��� ]
SELECT COUNT(hire_date) FROM employee WHERE dept_code IN ('D5','D9')
    AND
        hire_date LIKE '04%';

--9. ������, �Ի���, ���ñ����� �ٹ��ϼ� ��ȸ�ϼ���. 
--   * �ָ��� ���� , �Ҽ��� �Ʒ��� ����
select emp_name ������ , hire_date �Ի��� , floor(sysdate-hire_date)�ٹ��ϼ� from employee;

--10. ��� ������ ���� �� ���� ���� ���̿� ���� ���� ���̸� ��� �ϼ���. (���̸� ���)
--��� ������ 1900��� ���̶�� �����Ͽ�
SELECT 
MAX((100 - substr(emp_no,1,2) ) + substr(SYSDATE,1,2) + 1),
MIN((100 - substr(emp_no,1,2) ) + substr(SYSDATE,1,2) + 1)
FROM
employee;

--11. ȸ�翡�� �߱��� �ؾ� �Ǵ� �μ��� ��ǥ�Ͽ��� �մϴ�.
-- �μ��ڵ尡 D5,D6,D9 �߱�, �׿ܴ� �߱پ��� ���� ��µǵ��� �ϼ���
-- ��� ���� �̸�,�μ��ڵ�,�߱����� (�μ��ڵ� ���� �������� ������.)
--   (�μ��ڵ尡 null�� ����� �߱پ��� ��)
SELECT
emp_name,
dept_code,
CASE
WHEN dept_code IN ('D5','D6','D9') THEN '�߱�'
ELSE '�߱پ���'
END
    FROM
employee
ORDER BY dept_code ASC;


--group by : �׷�ȭ �� �����Ϳ� ���� ������ �ٷ�� ����


select emp_name,sum(salary)from employee group by dept_code;
--order by �� �׻� ���� ���� �д�
--dept_code , sum(salary) �̷� ��� �ȵ� �׷��̶� �����־ (�̸� �̷��� �䱸 �ȵ�)
--�̷���� group by ����
--group by ���ĸ�
--�д� ����
-- 1. from ~employee����  
-- 2. where ��
-- 3. group by
-- 4. having
-- 5. select
-- 6. order by
--group by�� sum  ,avg ,max ,min �� �׷��Լ��� �����ϴ�
--group by�� �̸� , �ֹι�ȣ �� �����Լ��� �䱸 �Ҽ� ����
--gropu by �� group by �� ��� �����ʹ� ��� �����ϴ� 
select dept_code from employee group by dept_code;

select * from employee;

select dept_code ,sum(salary) from employee group by dept_code order by 1;

select emp_name "�����" from employee ;

--quiz
-- 1. ���޺� �޿� ����� ����غ����� (���޺� ������������ �����Ͽ� ���)

select nvl(job_code,'����')"����" , to_char(floor(avg(salary)),'L999,999,999') "�޿����" from employee group by nvl(job_code,'����') order by ���� ;


select decode (substr(emp_no,8,1), 1 , '��' ,2,'��') from employee group by decode (substr(emp_no,8,1), 1 , '��' ,2,'��');

--quiz ������ �ο����� ����غ�����

select decode (substr(emp_no,8,1), 1 , '��' ,2,'��')"����" , count(*)"�ο���" from employee group by decode (substr(emp_no,8,1), 1 , '��' ,2,'��');

--������,������,���ö�� ������� ������ ��������� ������� ������ �޿� ����� ����ϼ���

SELECT
    DECODE(SUBSTR(emp_no,8,1),1,'��','��') AS "����",
    TO_CHAR(AVG(salary),'L999,999,9990') AS "��ձ޿�"
FROM
    employee
WHERE
    emp_name NOT IN ('������','������','���ö')
GROUP BY
    SUBSTR(emp_no,8,1);




-------------------------
--���̴뺰 �޿� ���
--�޿������ 100000�� �ڸ����� �ݿø� �Ұ�
--�޿� ��� ����� ���� ��ȭ���(ex L2.542.030) ���·� ���

--order by dept_code, salary

--group by dept_code , job_code
SELECT DECODE(substr(emp_no,1,1),6,'60����',7,'70����',8,'80����') "���̴�",TO_CHAR(floor(round(AVG(salary),-5) ),'L999,999,999') "�޿����"
FROM
    employee
GROUP BY DECODE(substr(emp_no,1,1),6,'60����',7,'70����',8,'80����')
ORDER BY 1;


select
    dept_code,
    job_code,
    count(*)
    from
    employee
    group by dept_code, job_code
    order by 1,2;
--�μ��� ���޺� �ο��� �ľ�

--quiz
--1. �μ��� ������ �ο��� �ľ�
select 
nvl(dept_code,'�μ�����') �μ��ڵ�,
decode(substr(emp_no,8,1),1,'��',2,'��') ����,
count(*) �ο���
from
employee
group by nvl(dept_code,'�μ�����'), decode(substr(emp_no,8,1),1,'��',2,'��')
order by 1,2,3;

--2. �μ��� �޿� ����� 300���� �̻��� �μ��� �μ��ڵ� �� �޿� ����� ����ϼ���
-- group by�� ���� �׷�ȭ�� �����Ϳ� ���� ������ ���Ҷ��� having ���� ���

select
dept_code,
floor(avg(salary))
from employee
group by dept_code
having avg(salary)>=3000000;

--where���� �׷��Լ��� ����Ҽ�����

--quiz
--1.�ο��� 3�� �̸��� �����ڵ��� �ο��� ����Ϸ�����
--�ο��� 3���� �ȵǴ� �����ڵ忡 ���Ͽ� �����ڵ�� �ο����� ����ϼ���

SELECT
    job_code AS "�����ڵ�",
    COUNT(*) AS "�ο���"
FROM
    employee
GROUP BY
    job_code
HAVING
    COUNT(*) < 3;

-----------------------------------------------------------------
--review
--group by + having
--from -> where - > group by - > having - >select - >order by

--JOIN
--�ϳ� �̻��� ���̺�� ���� Ư�� ������ �����ϴ� �����͸� �����Ͽ� ����� �����ϴ� ����

select * from department;

select * from job ;

------------- JOIN ���� (���߹���)


--> ANSI ǥ��
select * from department cross join job;
-- Cross JOin

select * from employee inner join department on dept_code=dept_id;
-- INnter Join


--> Oracle ����
select * from department, job;
--���� : 2���� ���̺�� �ڿ� �޸�
-- JOIN ���� �� - ũ�ν����� (Cross Join - Cartesian Product ī���̼� ���� ������)


select * from employee;
select * from department;

--JOIN ���� �� --inner JOIN : JOIN�� ������ ���� ���̺� �������� Ư�� ������ �����ϴ� ����Ʈ���� �����Ͽ� ��� ���� (NULL ���� ���͸�)
select emp_id , emp_name , dept_code, dept_title from employee, department           --23 * 9 =207
where dept_code = dept_id; --where���� 1���̺��(207) Ȯ���� ��
    
--�̳������� from ���� �ڿ� where��������
--�÷��� �̸��� ������ ������� �տ� � ���̺����� �������
select 
emp_id,emp_name,employee.job_code,job_name 
from employee inner join job on employee.job_code=job.job_code;

select
emp_id,
emp_name,
e.job_code,
job_name 
from 
employee e
inner join job j on e.job_code = j.job_code
where j.job_name = '����';


--------------------------------

--using �ϰ�� on���� ������ ª���� job_code���̺��� �ϰڴ� ������x 
select
emp_id,
emp_name,
job_code,
job_name 
from 
employee
inner join job using (job_code)
where job_name = '����';

--quiz
--1. ��������ο� ���� ������� �̸� , �μ��ڵ� , �޿��� ����ϼ���
select * from EMPLOYEE,department;
select * from employee;
select * from department;
SELECT
    emp_name,
    dept_code,
    salary
FROM
    employee
    INNER JOIN department ON dept_id = dept_code
WHERE
    dept_title = '���������';
    
    
SELECT
    emp_name,
    dept_code,
    salary
FROM
    employee
    INNER JOIN department ON dept_code = dept_id
where dept_title ='���������';

--2. �ؿܿ���n�� �������� ���, �����, �μ���, ������ ����غ�����
select emp_id, emp_name , dept_title , salary* 12
from employee
inner join department on dept_code = dept_id
where dept_title like '�ؿܿ���%'
order by 3,1;

-----------------------------------------
-- outer join : join�� �����ϴ� �� ���̺��� ���� ���̺��� ��� ���� ���� ����ϰ� ����� ����
--inner join ���� inner ���� ����
select
emp_name,
dept_code,
dept_title
from
employee outer left join department on dept_code = dept_id
order by 2;


select
emp_name,
dept_code,
dept_title
from
employee outer left join department on dept_code = dept_id
order by 2;

--full outer���� outer ��������
select
nvl(emp_name,'�����ο�����'),
nvl(dept_code,'�μ�����'),
nvl(dept_title,'�μ������')
from
employee full outer join department on dept_code = dept_id
order by 2;

-----------------------------------------
--self join : ���� ���̺��� join�ϴ� ����(���� ���̺��� �˰� �ִ°�찡 �ʿ��Ҷ�)

select 
e1.emp_id,
e1.emp_name,
e1.manager_id,
e2.emp_name
from 
    employee e1
inner join employee e2 on e1.manager_id = e2.emp_id
   order by 1,3;
   
--quiz
--1. ���������� ���� �μ����� ���ϴ� �������� �̸� �μ��ڵ� �����ڵ带 ����غ�����(self join)
              
              
                 
select e2.emp_name , e2.job_code , e2.dept_code from employee e1 inner join employee e2 
on e1.dept_code = e2.dept_code where e1.emp_name= '������';

select * from employee;
-------------------------------------------------------
--���� JOIN  : 3�� �̻��� ���̺��� Join �Ͽ� ���ǹ��� �����͸� �����ϴ� �۾�

-- ������ , �μ��� , ���޸��� ����غ�����
select 
e.emp_name,
d.dept_title,
j.job_name
from employee e
left join department d on e.dept_code = d.dept_id
join job j on e.job_code = j.job_code
order by e.job_code;

------------------------------------------
--quiz
--1. �����, �μ��� ,�ٹ� ����(National code)�� ����غ�����
select
e.emp_name,
d.dept_title,
n.national_name
from 
employee e
join department d 
on e.dept_code = d.dept_id
join location l on d.location_id = l.local_code
join national n on l.national_code =n.national_code;

select * from department;
select * from location;
select * from employee;
select * from job;
select * from national;

-- 1. 2020�� 12�� 25���� ���� �������� ��ȸ�ϼ���.

SELECT

    TO_CHAR(

        TO_DATE('20201225','YYYYMMDD'),

        'DY')

FROM

    dual;

   

-- 2. �ֹι�ȣ�� 1970��� ���̸鼭 ������ �����̰�, ���� ������ �������� �����, �ֹι�ȣ, �μ���, ���޸��� ��ȸ�ϼ���.

   select 

   e.emp_name ��� , e.emp_no �ֹι�ȣ, d.dept_title �μ���, j.job_code ���޸�

   from employee e

   join department d on e.dept_code = d.dept_id

   join job j on j.job_code=e.job_code

   where substr(emp_no,8,1) =2 and substr(emp_no,1,1)=7 and substr(emp_name,1,1)='��';

   

   

   



  

-- 3. �̸��� "��"�ڰ� ���� �������� ���, �����, �μ����� ��ȸ�ϼ���.

SELECT

    emp_id ���,

    emp_name �����,

    dept_title �μ���

FROM

    employee

    join department

    on dept_code=dept_id

WHERE

    emp_name LIKE '%��%';

    

    

-- 4. �μ��� �޿� ����� 300���� ������ �μ��� �μ���� �޿� ����� ����ϼ���

-- > �޿� ����� 10000�� �ڸ� �Ʒ��� ������ ������ּ���. 

-- > ���� �ѱ� ���� ��ȭ ǥ������� ������ּ���. (\3,520,000)

select

d.dept_title �μ���,

to_char(trunc(avg(salary),-4),'L999,999,999')�޿����

from employee e join department d on e.dept_code=d.dept_id

group by d.dept_title 

having avg(salary)<=3000000;







-- 5. �ؿܿ����ο� �ٹ��ϴ� �����, ���޸�, �μ��ڵ�, �μ����� ��ȸ�ϼ���.

select e.emp_name �����, j.job_name ���޸�, e.dept_code �μ��ڵ�,d.dept_title �μ���

from employee e 

join job j on e.job_code = j.job_code

join department d on d.dept_id=e.dept_code

where dept_title like '�ؿ�%';



-- 6. ���ʽ�����Ʈ�� �޴� �������� �����, ���ʽ�����Ʈ, �μ���, �ٹ��������� ��ȸ�ϼ���.

select

e.emp_name �����,

e.bonus ���ʽ�����Ʈ,

d.dept_title �μ���,

n.national_name �ٹ�������

from employee e

join DEPARTMENT d on d.dept_id=e.dept_code

join location l on l.local_code = d.location_id

join national n on n.national_code=l. national_code

where bonus is not null;





-- 7. �μ��ڵ尡 D2�� �������� �����, ���޸�, �μ���, �ٹ��������� ��ȸ�ϼ���.

SELECT

    e.emp_name �����,

    j.job_name ���޸�,

    d.dept_title �μ���,

    l.local_name �ٹ�������

FROM

    employee e

    join job j on j.job_code = e.job_code

    join department d on e.dept_code=d.dept_id

    join location l on l.local_code = d.location_id

   where dept_code = 'D2';

  

-- 8. �ѱ�(KO)�� �Ϻ�(JP)�� �ٹ��ϴ� �������� �����, �μ���, �ٹ�������, �������� ��ȸ�ϼ���.

select 

e.emp_name , d.dept_title , l.local_name, n.national_name

from employee e

join department d 

on e.dept_code = d.dept_id

join location l on l.local_code = d.location_id

join national n on l.national_code = n.national_code

where n.national_name in ('�ѱ�','�Ϻ�');
    
-- 9. ��� ��� �� �������� �Ŵ����� �ΰ� �ִ� ������ �̸�, ������ �μ���, �Ŵ����� �̸��� ����ϼ���.

select e1.emp_name ����, d.dept_title �μ� , e2.emp_name �Ŵ��� 

from EMPLOYEE e1

join DEPARTMENT d on d.dept_id= e1.dept_code

join employee e2 on e2.emp_id = e1.manager_id

where e2.emp_name='������';





-- 10. ���ʽ�����Ʈ�� ���� ������ �߿��� ������ ����� ����� �������� �����, ���޸�, �޿��� ��ȸ�ϼ��� (join�� in ���)

select e.emp_name , j.job_name , e.salary 

from employee e

join job j on j.job_code = e.job_code

where job_name in ('����','���') and bonus is null;





-- 11. �������� ������ ����� ������ ���� ��ȸ�ϼ���.

select decode(ENT_YN,'N' ,'������' ,'Y', '���'),count(*) from employee group by decode(ENT_YN,'N' ,'������' ,'Y', '���');

--------------------------------------------
--SQL
--DDL
--DML
-- insert, update ,select ,delete
-- select(DQL):
-- select ���� -> function()->group by -> having ->join -> [union subquery]
--DCL
--TCL

-------------------------------------------------


--union : �� ���̺��� �ܼ��ϰ� �Ʒ��� �̾� ���̴� ����
--      > 1. union �ϴ� �� ���̺��� �÷����� ���ƾ� �Ѵ�
--      > 2. union �ϴ� �÷����� �ڷ����� ���ƾ� �Ѵ�
-- union , union all , minus, intersect
select DEPT_ID,DEPT_TITLE from department
union 
select * from job;

--���̺� ����(?)

--���̺��� ������� ��ü�� DBL�� ����Ѵ�
--�÷��� data �ڷ����� �ѹ� 

    
    
    
--DML (�����͵� ���� �ִ°�)
select * from A;


create table A(data number);
insert into A values(1);
insert into A values(2);
insert into A values(3);

create table B (data number);

insert into b values(2);
insert into b values(3);
insert into b values(4);


--�����
drop table A;


--union : �� ���̺��� ���� �������̸� �� �� �ߺ��� ���� 1ȸ�� ����Ѵ�

select * from A
union all
select * from B;
-- union all : �� ���̺��� ���� �������̸� �� �� �ߺ��� �൵ ����Ѵ�


select * from A
intersect
select * from B;

-- union intersect : �� ���̺� ���� ������

select * from A
minus
select * from B;

--union minus:�� ���̺� ���� ������ (A ���̺��� B���̺��� ���� ���� ��� �����ϰ� ���� A�� ��)

------------------------------------------------------

--SubQuery : ���� �ȿ� ����  ���� : �Ұ�ȣ�� �ľ� �Ѵ�
--������ ���Ͽ� subquery
--���߿� subquery
--������ ���߿� subquery
-- inline view
--��� ���� ����



select
emp_name
from
employee
where
emp_id=(select manager_id from employee where emp_name = '������');

--quiz
--������ ������ �޿��� ������ �޿��� �޴� ������ �̸� �� �޿� ���

select * from employee;


select salary from employee where emp_name='������';
select emp_name, salary from employee where salary= 2000000;


--������ ���̴�
select emp_name, salary from employee where salary= (select salary from employee where emp_name='������')
and emp_name != '������';

--2.�� ���� �޿� ��պ��� �޿��� ���� �޴� ������ �̸�,�����ڵ�,�޿��� ����ϼ���

select avg(salary) from employee;
select emp_name  ,job_code ,salary from employee
where (select avg(salary) from employee) < salary;
--where���� �׷��Լ� x
--�������� where ���� �ƴϰ� select���� �������

--3. D1 , D2�μ��� �����߿��� �޿��� D5�μ��� �޿� ��� ����
--���� �޴� �������� �μ���ȣ ��� ����� �޿��� ����ϼ���
select avg(salary) from employee where dept_code ='D5';

select dept_code , emp_id , emp_name , salary from employee where dept_code in  ('D1','D2')
and salary>(select avg(salary) from employee where dept_code ='D5'); 


--4.�޿��� ���� ���� ����� ���� ���� ����� , ��� ����� �޿��� ����غ�����

select max(salary) from employee;
select min(salary) from employee;
select emp_id , emp_name , salary from employee where salary = (select max(salary) from employee) or
salary = (select min(salary) from employee);

-------------------------------------------------------------
--������ ���Ͽ� ��������

select * from employee;
--�ڳ���, ���߱� ������ �μ��ڵ�� ������ �μ��� ���� �������� ����

select dept_code from employee where emp_name in ('������','�ڳ���');
select * from employee 
where dept_code in ('D9','D5');



select * from employee
where dept_code in (select dept_code from employee where emp_name in ('������','�ڳ���'));



--�������� �ҋ��� =���� ���Ҽ� ���� (�������ϱ�) �����϶� ����
--���������ҋ��� =�ƴϰ� in�� ����ؾߴ�


--quiz
--1. ���¿� �Ǵ� ������ ������ �޿����(sal_level) �� ���� �޿� �����
--������ ���޸�� ������� ���




select emp_name , job_name , sal_level from employee e
join job j on e.job_code=j.job_code
where sal_level in (select sal_level from employee where emp_name in ('���¿�','������'));


select sal_level from employee where emp_name in ('���¿�','������');

--2. ������ ��ǥ, �λ����� �ƴ� ��� ������ �����, �����ڵ带 ���
select emp_name , job_code from employee 
where 
job_code not in (select job_code from job where job_name in ('��ǥ','�λ���'));

select job_code from job where job_name not in ('��ǥ','�λ���');



-- D5 �μ��� �������� �޿����� ���� �޴� ������ ������ ���

select emp_name, salary from employee
where salary >any(select salary from employee where dept_code = 'D5');
--d5���� ���� �޿�����߿��� �ƹ��ų� ũ�⸸ �ϴٸ� �� ����� ���
select emp_name, salary from employee
where salary >(select min(salary) from employee where dept_code = 'D5');




select emp_name, salary from employee
where salary >all(select salary from employee where dept_code = 'D5');


select emp_name, salary from employee
where salary > (select max(salary) from employee where dept_code = 'D5');
--��� ��� ������� �� Ŀ�� �Ѵ� 
-------------------------------------------------------
--���� �� ���� ���� = ������ ���߿� �������� ������ ���� 

select dept_code, job_code from employee where ent_yn='Y';

select emp_name , dept_code, job_code from employee
    where (dept_code,job_code) = (select dept_code, job_code from employee where ent_yn='Y');
--�������� ���� ������ 2�� �� ���ʵ� 2�����ϰ� �Ұ�ȣ�� ������Ѵ� ������ �ٸ��� in����

select emp_name,bonus,salary from employee
where (bonus,salary)=any(select bonus, salary from employee where emp_name='�����');
--���߿� �������������� >,< any�Ǵ� all�� ����Ҽ�����
--��,=��ȣ�� ���ؼ��� any�� ����Ҽ� �ִ�.



--quiz
--1.������ 8�� 8���� ������ ���� �μ��ڵ� , ���� �����ڵ��� �������� ������ ������ ���
-->������ 8�� 8���� ������ ��¿��� ����
select emp_name,dept_code ,job_code from employee where substr(emp_no,3,4)='0808';

SELECT
    dept_code , job_code,emp_name,
   substr(emp_no,3,4)
FROM
    employee
WHERE ( dept_code,job_code ) 
IN (SELECT dept_code,job_code FROM employee WHERE substr(emp_no,3,4) = '0808') AND substr(emp_no,3,4) != '0808';

--2. �μ��� �޿��� ���� ���� �޴� ������ �μ��ڵ�, �����̸� �� �޿��� ������ּ���
--�μ� �ڵ�� ����

select dept_code , max(salary) from employee group by dept_code;

select dept_code,emp_name,salary from employee 
where (dept_code,salary) in (select dept_code , max(salary) from employee group by dept_code) order by 1;
-------------------------------------------------
--subquery�� ����ϴ� �� �ٸ� ���� - select�� (���� ��ſ�)

select emp_name , (select dept_title from department where dept_code=dept_id)dept_title from employee;
--���������� ���������� �÷��ϳ��� ����ٰ� �ڱ��ǰó�� ����ϰ� �ִ�

--������� ���޸��� ����ϼ��� (�� subquery ��)
select emp_name , (select job_name from job j where e.job_code= j.job_code) from employee e;

--inline view : from ������ ���Ǵ� subquery
select emp_id,emp_no from (select emp_id,emp_name,emp_no from employee);

-----------------------------------------------------------------
--rank ���� �Լ�(����)
--over �ȿ� ���� rank over ���̽�ߴ�
select emp_name,salary, rank() over(order by salary desc)"�޿� ��ŷ" from employee;

select emp_name,salary, dense_rank() over(order by salary desc)"�޿� ��ŷ" from employee;
--dense_rank() over ���� �� ������ ��

select emp_name , salary , row_number() over(order by salary desc) "�޿� ��ŷ" from employee;
--�� ��ȣ�� ��� ���� ����ϴ� �Լ�

--quiz
--1. �޿� ������������ �ึ�� ��ȣ�� �ٿ����� , 10~15������ �����͸� ����غ�����

select emp_name ,salary ,row_number() over(order by salary desc) "�޿� ��ŷ" from employee;


--1. ��������ο� ���� ������� ����� �̸�,�μ��ڵ�,�޿��� ����Ͻÿ�

select emp_name , (select dept_title from department where dept_code=dept_id )dept_title , salary from employee where dept_title ='���������';

--2. ��������ο� ���� ����� �� ���� ������ ���� ����� �̸�,�μ��ڵ�,�޿��� ����Ͻÿ�
select emp_name ,dept_code, salary from employee ;

select max(salary*12) ,(select dept_title from department where dept_code=dept_id )dept_title from employee;

--3. �Ŵ����� �ִ� ����߿� ������ ��ü��� ����� �Ѱ� ���,�̸�,�Ŵ��� �̸�,����(������������)�� ���Ͻÿ�.
--��, JOIN�� �̿��Ͻÿ�
select emp_id ��� , emp_name �̸� , emp_name �Ŵ��� , salary from employee;
select avg(salary) from employee;



--4. �� ���޸��� �޿� ����� ���� ���� ������ �̸�, �����ڵ�, �޿�, �޿���� ��ȸ

--5. ���� ���ʽ��� ���� �޴� ������ ������� �̾����� 4~8���� ����, �����, �޿�, ���ʽ����� ���



--6. �μ��� ��� �޿��� 2200000 �̻��� �μ���, ��� �޿� ��ȸ ��, ��� �޿��� �Ҽ��� ����


--7.������ ���� ��պ��� ���� �޴� ���ڻ���� �����,�����ڵ�,�μ��ڵ�,������ �̸� ������������ ��ȸ�Ͻÿ� ���� ��� => (�޿�+(�޿�*���ʽ�))*12






