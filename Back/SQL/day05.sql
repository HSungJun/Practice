DESC employee; 
-- describe employee; : employee ���̺� ���� ���� �����϶�

SELECT
    emp_id,
    emp_name,
    emp_no
FROM
    employee;
-- employe ���̺��� emp_id ,emp_name ,emp_no �÷��� �ش��ϴ� �����͸� ��ȸ�϶�

SELECT
    *
FROM
    employee;
-- employee ���̺��� ��� �÷� �����͸� ��ȸ�϶�

SELECT
    emp_id,
    emp_name
FROM
    employee
WHERE
    emp_id = 207;

--Quiz01
--1 . Employee ���̺� �����ϴ� ��� ������ ���,�̸� �޿��� ����غ�����

SELECT
    emp_name,
    emp_id,
    salary
FROM
    employee;

--2. ���� �� D9 �μ��� ���� �ִ� �������� ���,�̸� ,�μ��ڵ带 ����غ�����

SELECT
    emp_id,
    emp_name,
    dept_code
FROM
    employee
WHERE
    dept_code = 'D9';

SELECT
    *
FROM
    employee
WHERE
    salary >= 4000000;

SELECT
    *
FROM
    job;

--Quiz
--1 ���� �� �޿��� 200���� ���Ϸ� �޴� ������ �̸� �� �μ��ڵ� ���� �ڵ带 ����غ�����

SELECT
    emp_name,
    dept_code,
    job_code salary
FROM
    employee
WHERE
    salary <= 2000000;

SELECT
    emp_name,
    dept_code,
    job_code,
    salary
FROM
    employee
WHERE
    salary <= 2000000;
    
--and ,or

SELECT
    *
FROM
    employee;

SELECT
    *
FROM
    employee
WHERE
        dept_code = 'D6'
    AND
        salary <= 3000000;

SELECT
    *
FROM
    employee
WHERE
        dept_code = 'D6'
    OR
        salary <= 3000000;

--quiz
--1.�޿��� 200~300�� ������ ������ ���,�̸� ,�޿� ���� �ڵ带 ����غ�����

SELECT
    salary,
    emp_name,
    emp_id,
    job_code
FROM
    employee
WHERE
        salary >= 2000000
    AND
        salary <= 3000000;
---------------------------

SELECT
    salary,
    emp_name,
    emp_id,
    job_code
FROM
    employee
WHERE
    salary BETWEEN 2000000 AND 3000000;

--quiz

SELECT
    *
FROM
    employee;
--1. employee ���̺��� ���� �߿� job_code �� j3�̸鼭 �޿��� 350������ �̻��� ������ �̸��� ��ȭ��ȣ�� ����غ�����

SELECT
    emp_name,
    phone
FROM
    employee
WHERE
        job_code = 'J3'
    AND
        salary >= 3500000;
--2. employee ���̺��� ���� �߿� �μ��ڵ尡 d5�̰ų� d6�̰ų� d9�� ������ �̸��� �μ��ڵ带 ����غ�����

SELECT
    emp_name,
    dept_code
FROM
    employee
WHERE
        dept_code = 'D5'
    OR
        dept_code = 'D6'
    OR
        dept_code = 'd9';
----------------------------------

SELECT
    emp_name,
    dept_code
FROM
    employee
WHERE
    dept_code IN (
        'D5','D6','D9'
    );

SELECT
    emp_id,
    emp_name
FROM
    employee
WHERE
    dept_code IS NOT NULL;


---------------------alias

SELECT
    emp_name �����,
    salary ����,
    salary * 12 AS "�� ��",
    '��' ����
FROM
    employee;
--������ ������ ''  ����������� ""  as�� ""�������� �پ�������� ���� �Ұ�
--crtl shift +d ���κ���
--ctrl shift +d ���� ����
-- select �÷��� from ���̺�� where ���ǽ�;
--���ǽ� =,<,>,<=,>= ��밡��
--and ,or ,between and ,is null,is not null,in

------------------------sysdate&dual    select�� �ݺ���
--dual : ���� ���̺� - SQL �̿��ڰ� Ư�� ����� �׽�Ʈ�Ҷ� ����Ҽ��ֵ��� �̸� ������ ����ƺ� ���̺� ����ƺ� (����)
--sysdate = sysdate�� ȣ��Ǵ� ������ ��¥ �� �ð��� ��ȯ�ϴ� orcle��� (���� ��¥ �� �ð� )
--          date type�� ����� ��ȯ�Ѵ� (��¥Ÿ��)
--          ��¥Ÿ�Կ� ���� ��ġ ������ (+,-) �ϼ� ������ ���� �ȴ�
--          ��¥Ÿ�԰� ��¥Ÿ���� �����ϸ� �� ��¥ ������ ������ ��ȯ �ȴ�

SELECT
    SYSDATE
FROM
    dual;

SELECT
    'ABC' - 10
FROM
    dual;

SELECT
    10 - 5
FROM
    dual;

SELECT
    SYSDATE - 1
FROM
    dual;
--��¥ Ÿ�Կ� ���ؼ��� �÷��� ���̳ʽ��� �����ϴ�

DESC employee;

--floor() : �Ǽ��� �Ķ���ͷ� ���޹����� �Ҽ��� �ڸ����� �����ϰ� �����ڸ��� ��ȯ�ϴ� �޼���
-- || ���ڿ����� ������

SELECT
    emp_id,
    emp_name,
    hire_date AS �Ի���,
    floor(SYSDATE - hire_date)
     || '��' AS �ٹ��ϼ�
FROM
    employee;

SELECT
    *
FROM
    employee;

--quiz
--1.employee ���̺��� �ټӳ���� 20�� �̻� �� ���� �̸� ,����,���ʽ��� �� ����غ�����

SELECT
    emp_name AS �̸�,
    salary || '��' AS ����,
    bonus AS ���ʽ���
FROM
    employee
WHERE
    floor(SYSDATE - hire_date) >= 7300;

SELECT
    emp_name,
    salary,
    bonus
FROM
    employee
WHERE
    floor( (SYSDATE - hire_date) / 365) >= 20;

-- 2. ��� ���� �̸� ,����,�Ǽ��ɾ� (���� - (���� * 3%))�� ����غ�����

SELECT
    emp_name,
    salary * 12 ����,
    salary * 12 - ( salary * 12 * 0.03 ) " �� ���ɾ�"
FROM
    employee;

SELECT
    *
FROM
    employee
WHERE
    hire_date BETWEEN '90/01/01' AND '01/12/31';
--���ڿ��ε� between�� ���� �˾Ƽ� ��¥�� �м���

-------------------------like  % �������� �ְ� �������� �ִ�

SELECT
    *
FROM
    employee
WHERE
    emp_name NOT LIKE '%��%';
                                        --���� �ֱ⸸�ϸ� ã�´� %���־�ǰ� �����

SELECT
    *
FROM
    employee
WHERE
    emp_name LIKE '��__';
--���� �� ���ڸ��� ���� �ڿ� �α��ڰ� �ݵ�� �־�ߵȴ�

--quiz
--1 ��� �����߿� ��ȭ��ȣ�� ó�� 3�ڸ��� 010 �ƴ� ������ �̸��� ��ȭ��ȣ�� ����غ�����

SELECT
    emp_name,
    phone
FROM
    employee
WHERE
    phone NOT LIKE '010%';

SELECT
    *
FROM
    employee;
--2 ��� ���� �߿��� �̸��� '��' �ڰ� ���� ����� ��� ã�� �̸��� ����غ�����

SELECT
    emp_name
FROM
    employee
WHERE
    emp_name LIKE '%��%';
--3. ��� ���� �߿��� 
    --�μ��ڵ尡 D9 �Ǵ� D6�̰�
    --������ 270���� �̻��̸�
    --email�� ���ĺ� s�� ���ԵǾ��ְ�
    --������� 2001�� 1�� 1�Ϻ��� 2005�� 12�� 31�� ������ ������
    --�̸� ,�μ��ڵ� ,�޿� ,email,������� ����غ�����

SELECT
    emp_name,
    dept_code,
    salary,
    email,
    hire_date
FROM
    employee
WHERE
        dept_code IN (
            'D9','D6'
        )
    AND
        salary >= 2700000
    AND
        email LIKE '%s%'
    AND
        hire_date BETWEEN '01/01/01' AND '05/12/31';

SELECT
    *
FROM
    employee;

    --quiz
    --1. ���ӻ�� (manager_id)�� ���� �μ� (dept_code) ��ġ�� ���� ���� ������ ��� �� �̸��� ���

SELECT
    emp_name,
    emp_id
FROM
    employee
WHERE
        manager_id IS NULL
    AND
        dept_code IS NULL;
    --2. �μ� ��ġ�� ���� �ʾ����� ���ʽ��� ���޵Ǵ� ������ �μ��ڵ� ,�̸� �� ���ʽ��� ���

SELECT
    emp_name,
    bonus,
    dept_code
FROM
    employee
WHERE
        dept_code IS NULL
    AND
        bonus IS NOT NULL;


-------------------------------order by
-- order by : ���� ���� ������� Ư�� ������ �̿��Ͽ� �����͸� �����ϴ� ����
--�ټ���� (�⺻)asc : �ø����� desc : ��������

SELECT
    emp_id,
    emp_name,
    dept_code,
    salary
FROM
    employee
ORDER BY
    dept_code DESC NULLS FIRST,
    salary DESC;

SELECT
    emp_id,
    emp_name,
    dept_code,
    salary
FROM
    employee
ORDER BY
    dept_code DESC NULLS LAST,
    salary ASC;

SELECT
    emp_id,
    emp_name,
    dept_code,
    salary
FROM
    employee
ORDER BY 3 DESC;


-- desc employee;
-- desc -> describe

-- order by desc;
-- desc - > descending

--����1
--�ټӳ�� 5���̻� ,10�� ������ ������ �̸� �ֹι�ȣ �޿� �Ի����� �˻��ϼ���

SELECT
    emp_name,
    emp_no,
    salary,
    hire_date
FROM
    employee
WHERE
    floor( (SYSDATE - hire_date) / 365) BETWEEN 5 AND 10;
--����2
--�������� �ƴ� ������ �̸� ,�μ� �ڵ带 �˻��ϼ��� (��翩�� ENT_YN)

SELECT
    emp_name,
    dept_code
FROM
    employee
WHERE
    ent_yn = 'Y';
--����3
--�ټӳ���� 10���̻��� �������� �˻��Ͽ�
--��� ����� �̸� ,�޿� ,�ټӳ��(�Ҽ��� x)�� �ټӳ���� ������������ �����Ͽ� ����ϼ���
--�� �޿��� 50% �λ�� �޿��� ��µǵ��� �ϼ���

SELECT
    emp_name,
    salary * 1.5,
    floor( ( (SYSDATE - hire_date) / 365) )
FROM
    employee
WHERE
    floor( ( (SYSDATE - hire_date) / 365) ) >= 10
ORDER BY floor( ( (SYSDATE - hire_date) / 365) ) ASC;

SELECT
    *
FROM
    employee;

--����4
--�Ի����� 99/01/01~10/01/01 �� ����߿��� �޿��� 2000000�� ������ �����
--�̸� ,�ֹι�ȣ ,�̸��� ,����ȣ ,�޿��� �˻��ϼ���

SELECT
    emp_name,
    emp_no,
    email,
    phone,
    salary
FROM
    employee
WHERE
        hire_date BETWEEN '99/01/01' AND '10/01/01'
    AND
        salary <= 2000000;
--����5
--�޿��� 2000000~3000000�� �� �������߿��� 4�� �����ڸ� �˻��Ͽ�
--�̸� ,�ֹι�ȣ ,�޿�,�μ��ڵ带 �ֹι�ȣ ������ ������������ ���
--�� �μ��ڵ尡 null �� ����� �μ��ڵ尡 �������� ����ϼ���  <--x

SELECT
    emp_name,
    emp_no,
    salary,
    dept_code
FROM
    employee
WHERE
        salary >= 2000000
    AND
        salary <= 3000000
    AND
        emp_no LIKE '%-2%'
    AND
        emp_no LIKE '%04%'
ORDER BY emp_no DESC;
--����6
--���� ��� �� ���ʽ��� ���� ����� ���ñ��� �ٹ����� �����Ͽ�
--1000�� ����(�Ҽ�������)
--�޿��� 10% ���ʽ��� ����Ͽ� �̸�,Ư�����ʽ� (���ݾ�) ����� ����ϼ���
--�� �̸� ������ ���� ���� �����Ͽ� ����ϼ���

SELECT
    *
FROM
    employee;

SELECT
    emp_name,
    ( salary * 0.1 ) * floor( (SYSDATE - hire_date) / 1000)
FROM
    employee
WHERE
        emp_no LIKE '%-1%'
    AND
        bonus IS NULL
ORDER BY emp_name ASC;

SELECT
    *
FROM
    employee
WHERE
    1 = 1;
--where true�� ������


-- select �÷��� from ���̺��;
-- where �� - ������ ���Ǻ�
-- between and ,like (% ,_ ) ,is null ,not ,in ,and ,or ,> ,< ,=
-- ���ڿ� ''
-- order by - ����

-----------------------------------------------------
 -- function () == method () 
 -- �ڹٿ����� �޽�� ����Ŭ�� ���
 -- nvl (�˻絥���� ,�˻絥���Ͱ� null�϶� ġȯ �� �� )
 -- nvl(Ÿ�� ������ ,���ϰ� ) :

SELECT
    emp_name,
    nvl(dept_code,'����')
FROM
    employee;
 
 --length() : Ư�� �������� ���̸� �����Ͽ� ��ȯ

SELECT
    length('Hello')
FROM
    dual;

SELECT
    length('�ѱ�')
FROM
    dual;
--lengthb() : Ư�� �������� byte�� �����Ͽ� ��ȯ

SELECT
    lengthb('Hello')
FROM
    dual;

SELECT
    lengthb('�� ��')
FROM
    dual;
--����Ŭ������ �ѱ��ڰ� 3����Ʈ�� ����� 1����Ʈ

--instr() : ���ڿ� �ȿ��� Ư�� ������ ��ġ ���� ã�� �Լ�(java�� indexof)

SELECT
    instr(
        'Hello World Hi High',
        'H',
        2,
        2
    )
FROM
    dual;
--'Hello World Hi High' ���ڿ� �ȿ��� H�� �˻��ϵ� 1�� ���ڿ������� ���������� �˻��ذ��� 1������ ������ H�� ��ġ

-- substr() : ���ڿ� ������ ������ ��ġ�� ���ڿ��� �߶󳻾� ��ȯ�ϴ� �Լ�

SELECT
    substr('Hello World Hi High',7,5)
FROM
    dual;

SELECT
    substr('�ȳ� ���� �ȳ� ����',7,5)
FROM
    dual;

--quiz
--1. ���� ��ܿ��� �̸��� ���� �����Ͽ� ����غ��ô�

SELECT DISTINCT
    substr(emp_name,1,1)
FROM
    employee
ORDER BY 1;
--distinct �ߺ� ����

SELECT
    *
FROM
    employee;
--2. ���� ��ܿ��� �����ȣ ,����� ,�ֹι�ȣ ,������ ����ϼ���
-- �� �ֹι�ȣ �� 6�ڸ��� *��ȣ�� ����ϼ���
-- ���������� ������ ����غ����� (like ������� ���� )

SELECT
    emp_id,
    emp_name,
    substr(emp_no,1,8)
     || '******',
    salary * 12
FROM
    employee
WHERE
    substr(emp_no,8,1) = '1';

----------------------------------------------------
--abs() : ���� ���밪�� ��ȯ�ϴ� �Լ�

SELECT
    abs(2)
FROM
    dual;

SELECT
    abs(-2)
FROM
    dual;

--mod() : JAVA�� % ������ - > ������ ���� �Լ�

SELECT
    mod(10,3)
FROM
    dual;

SELECT
    mod(10,4)
FROM
    dual;

-- round() : �ݿø� �Լ� 

SELECT
    round(126.456,0)
FROM
    dual;

SELECT
    round(126.456,1)
FROM
    dual;

SELECT
    round(126.456,2)
FROM
    dual;

SELECT
    round(126.456,3)
FROM
    dual;

SELECT
    round(126.456,-1)
FROM
    dual;

SELECT
    round(126.456,-2)
FROM
    dual;

--floor() : �Ҽ��� �����Լ� 

-- trunc() : Ư�� ��ġ���� �����Լ�

SELECT
    trunc(126.456,1)
FROM
    dual;

SELECT
    trunc(126.456,2)
FROM
    dual;

SELECT
    trunc(126.456,-1)
FROM
    dual;

--ceil () : �ø� �Լ�

SELECT
    ceil(126.456)
FROM
    dual;  --�Ҽ��� ù�� �ڸ����� �ø�

SELECT
    ceil(123.456 * 10) / 10
FROM
    dual; --�Ҽ��� �Ѥ� �ڸ����� �ø�

SELECT
    ceil(123.456 * 100) / 100
FROM
    dual; --�Ҽ��� �¤� �ڸ����� �ø�
------------------------------------------------------------
--sysdate : ��ȸ�ϴ� ������ �ð� ���� DateŸ������ ��ȯ

SELECT
    SYSDATE
FROM
    dual;
--sysdate = �ڹ��� timestamp �� �� ���

--months_between : �� ��¥ ������ ���� ���� ��ȯ �ϴ� �Լ�

SELECT
    emp_name,
    floor(months_between(SYSDATE,hire_date) ) �ټӰ�����
FROM
    employee;

--add months : Ư�� ��¥�� �������� ���ϴ� �Լ�

SELECT
    add_months(SYSDATE,1)
FROM
    dual;

--next_day : ������¥�� �������� ���� ����� ���� date���� ��ȯ

SELECT
    SYSDATE,
    next_day(SYSDATE,'������')
FROM
    dual;

--last_day : ������¥�� ���� ���� ������ �� date���� ��ȯ

SELECT
    last_day(SYSDATE)
FROM
    dual;

--quiz
-- ������ ������ ��¥�� ��ĥ�ϱ��?

SELECT
    last_day(add_months(SYSDATE,1) )
FROM
    dual;

SELECT
    last_day(add_months(SYSDATE,-1) )
FROM
    dual;

-- extract : ��¥ �����κ��� ��,��,���� �����ϴ� �Լ�

SELECT
    EXTRACT(YEAR FROM SYSDATE)
FROM
    dual;

SELECT
    EXTRACT(MONTH FROM SYSDATE)
FROM
    dual;

SELECT
    EXTRACT(DAY FROM SYSDATE)
FROM
    dual;

--quiz
--1. ���,�����,�Ի�⵵ (0000��)�������� ����غ�����

SELECT
    *
FROM
    employee;

SELECT
    emp_id,
    emp_name,
    EXTRACT(YEAR FROM hire_date)
     || '��' �Ի翬��
FROM
    employee;

--2. employee ���̺��� ����� �̸� ,hire_date,������ ����غ�����
--���� ����� �Ҽ��� �ϰ�� �ø����� �Ͽ� ����غ�����(28.144-> 29����)
--(��½� ������ �Ի��� �������� �ø�����)

SELECT
    emp_name,
    hire_date,
    ceil( ( (SYSDATE - hire_date) / 365) ) ����
FROM
    employee
ORDER BY hire_date ASC;

--------------------------------------------------------------

-- to_char() : ��¥�� �Ǵ� ���ڰ��� ���ڿ��� ��ȯ�ϴ� �Լ�

-- D : �̹��ֿ� ����� �� ,DD: �̹��޿� ����� �� ,DDD: ������ ���° �� 

SELECT
    TO_CHAR(SYSDATE,'YYYY"��" MM"��" DD"��" (DY) Day HH24:MI:SS')
FROM
    dual;

SELECT
    TO_CHAR(SYSDATE,'YYYY')
FROM
    dual;
--quiz
--����� ,����� (1990/02/06(ȭ)) ���·� ���

SELECT
    emp_name,
    TO_CHAR(hire_date,'YYYY/ MM / DD (DY)')
FROM
    employee;

SELECT
    TO_CHAR(1000000,'L999,999,999')
FROM
    dual;
--���� ǥ���� 9�� ǥ��

--to_date() : ���ڿ��� ��¥������ ��ȯ

SELECT
    TO_DATE('20180208','YYYYMMDD') - 10
FROM
    dual;
--��¥�� -10 ���� ,���ڿ��̸� ��길 ���� 
--����� �ƴϰ� �м�

--quiz
--1945�� 8�� 15���� ������?

SELECT
    TO_CHAR(
        TO_DATE('19450815','YYYYMMDD'),
        'DY'
    ) ����������
FROM
    dual;

SELECT
    TO_DATE('19450815','YYYYMMDD')
FROM
    dual;
--------------------------------------------------------
--decode() : ���� ���� �б����� ����� �Լ� (�ڹ��� ���׿����� ,switch)

SELECT
    DECODE(
        '��',
        'Apple',
        '���',
        'Orange',
        '������',
        '����'
    )
FROM
    dual;
--��ĭ�� �����̸� ������ �����Ѵ� �������� �������� �����Ѵ�
--������ else 

SELECT
    *
FROM
    employee;
--quiz
--��� ��ȣ ,����� ,���� (�� �� ) ���·� ����غ�����

SELECT
    emp_id,
    emp_name,
    DECODE(
        substr(emp_no,8,1),
        '1',
        '��',
        '2',
        '��'
    ) ����
FROM
    employee;
----------------------------------------------------------
--case: ���ǽĿ� ���� ��ȯ�� �б��� ���� �Լ�

SELECT
    emp_id,
    emp_name,
        CASE
            WHEN substr(emp_no,8,1) = '1' THEN '��'
            WHEN substr(emp_no,8,1) = '2' THEN '��'
            ELSE '?'
        END
    "����"
FROM
    employee;

--quiz
--1. 60��� �� ������ �߿��� 60~64�� �̸��� �������� '60��� �ʹ�' �̶�� ���
--               65~69�� ������ �������� '60��� �Ĺ�' �̶�� ���
--  ���,�̸� ,60��� ��/�Ĺ�

SELECT
    emp_id,
    emp_name,
        CASE
            WHEN substr(emp_no,1,2) < 65  THEN '60��� �ʹ�'
            WHEN substr(emp_no,1,2) >= 65 THEN '60��� �Ĺ�'
        END
    "���̴�"
FROM
    employee
WHERE
    substr(emp_no,1,2) BETWEEN 60 AND 69;

SELECT
    length(email)
FROM
    employee;
-- ��������� ��� ������ �Լ�
--------------------------------------------------------
--�׷� �Լ� ( SUM,AVG,COUNT,MAX ,MIN )


-- �� ȸ���� �Ѵ� �ΰǺ�� ���ΰ�?
--sum : �հ��Լ�

SELECT
    emp_name,
    SUM(salary)
FROM
    employee;
--�׷� �Լ��� ����������� ���� �ٸ� �Լ��� �ü� ���� 

--AVG :(����Լ�)

SELECT
    AVG(salary)
FROM
    employee;

--COUNT : ���� ���� ��ȯ�ϴ� �Լ�

SELECT
    COUNT(emp_id)
FROM
    employee;

SELECT
    COUNT(*)
FROM
    employee;
--null���� ī������ �ȵ�                                                   

--MAX : ��ü �࿡�� ���� ū���� ��ȯ�ϴ� �Լ�

SELECT
    MAX(salary)
FROM
    employee;

--MIN : ��ü �࿡�� ���� ���� ���� ��ȯ�ϴ� �Լ�

SELECT
    MIN(salary),
    MAX(salary)
FROM
    employee;
--�׷쳢���� �׷��Լ� ����

SELECT
    *
FROM
    employee;
--quiz

--1. D5�μ� �޿� ���

SELECT
    AVG(salary)
FROM
    employee
WHERE
    ( dept_code ) = 'D5';

--2. ���������� �޿� �հ�

SELECT
    SUM(salary)
FROM
    employee
WHERE
    substr(emp_no,8,1) = 1;

----------------------------------------------------quiz

--1. ������� �̸��� ,�̸��� ���̸� ����ϼ���
--        �̸�       �̸���      �̸��ϱ���
--   ex)    ȫ�浿 ,hong@kh.or.kr        13
--

SELECT
    emp_name ������,
    email,
    length(email) �̸��ϱ���
FROM
    employee;

--2. ������ �̸��� �̸��� �ּ��� ���̵� �κи� ����ϼ���
--   ex) ���ö   no_hc
--   ex) ������   jung_jh
--

SELECT
    emp_name ������,
    substr(
        email,
        1,
        instr(email,'@',1) - 1
    )
FROM
    employee;


--3. 60����� ������� ���,���ʽ� ���� ����ϼ���
--   �׶� ���ʽ� ���� null�� ��쿡�� 0% �̶�� ��� �ǰ� ���弼��
--       ������    ���     ���ʽ�
--   ex) ������     62       30%
--   ex) ������     63       0%
--

SELECT
    emp_name ������,
    substr(emp_no,1,2) ���,
    bonus * 10 || '0%' AS ���ʽ�
FROM
    employee
WHERE
    substr(emp_no,1,2) BETWEEN 60 AND 69;

--4. '010' �ڵ��� ��ȣ�� ���� �ʴ� ����� ���� ����ϼ��� (�ڿ� ������ ���� ���̼���)
--      �ο�
--   ex) 3��
--

SELECT
    COUNT(phone)
     || '��' AS "010 �ƴѻ��"
FROM
    employee
WHERE
    phone NOT LIKE '010%';

--5. ������� �Ի����� ����ϼ��� 
--   ��,�Ʒ��� ���� ��µǵ��� ����� ������
--       ������         �Ի���
--   ex) ������      2012��12��
--   ex) ������      1997�� 3��
--

SELECT
    emp_name "������",
    TO_CHAR(hire_date,'YYYY"��" MM"��"') "�Ի���"
FROM
    employee;

--6. ������� �ֹι�ȣ�� ��ȸ�ϼ���
--   ��,�ֹι�ȣ 9��° �ڸ����� �������� '*' ���ڷ� ä���� ��� �ϼ���
--   ex) ȫ�浿 771120-1******
--

SELECT
    emp_name "������",
    substr(emp_no,1,8)
     || '******' "�ֹι�ȣ"
FROM
    employee;

--7. ������,�����ڵ�,����(��)�� ��ȸ�ϼ���.
--  ��,������ ��57,000,000 ���� ǥ�õǰ� �� (���� ��ȭ �ܰ� ���� �Ǿ�� ��)
--     ������ ���ʽ�����Ʈ�� ����� 1��ġ �޿���
--

SELECT
    emp_name "������",
    job_code "�����ڵ�",
    '��'
     || TO_CHAR(
        ( (salary * 12) + (salary * nvl(bonus,1) ) ),
        '999,999,999'
    )
     || '(��)' AS "����(��)"
FROM
    employee;



--8. �μ��ڵ尡 D5,D9�� ������ �߿��� 2004�⵵�� �Ի��� ������ 
--   [ ��� ����� �μ��ڵ� �Ի��� ] �� ��ȸ�ϼ���
--

SELECT
    emp_id "���",
    emp_name "�����",
    dept_code "�μ��ڵ�",
    hire_date "�Ի���"
FROM
    employee
WHERE
        dept_code IN (
            'D5','D9'
        )
    AND
        substr(hire_date,1,2) = '04';

--9. ������,�Ի���,���ñ����� �ٹ��ϼ� ��ȸ�ϼ���. 
--   * �ָ��� ���� ,�Ҽ��� �Ʒ��� ����
--

SELECT
    emp_name "������",
    hire_date "�Ի���",
    floor(SYSDATE - hire_date)
     || '��' AS "�ٹ��ϼ�"
FROM
    employee;


--10. ��� ������ ���� �� ���� ���� ���̿� ���� ���� ���̸� ��� �ϼ���. (���̸� ���)
-- 

SELECT
    MAX(100 - substr(emp_no,1,2) + substr(SYSDATE,1,2) + 1) "�ְ����",
    MIN(100 - substr(emp_no,1,2) + substr(SYSDATE,1,2) + 1) "����"
FROM
    employee;

--11.  ȸ�翡�� �߱��� �ؾ� �Ǵ� �μ��� ��ǥ�Ͽ��� �մϴ�.
-- �μ��ڵ尡 D5,D6,D9  �߱�,�׿ܴ� �߱پ��� ���� ��µǵ��� �ϼ���
-- ��� ���� �̸�,�μ��ڵ�,�߱����� (�μ��ڵ� ���� �������� ������.)
--   (�μ��ڵ尡 null�� ����� �߱پ��� ��)

SELECT
    emp_name "������",
    nvl(dept_code,'�μ� ����') "�μ��ڵ�",
        CASE
            WHEN dept_code IN (
                'D5','D6','D9'
            ) THEN '�߱�'
            ELSE '�߱پ���'
        END
    "�߱� ����"
FROM
    employee;



------------------------------------------------------day3

-- group by : �׷�ȭ�� �����Ϳ� ���� ������ �ٷ�� ����
-- order by �� ������ ���� ������
-- group by - ��ü �����͵� �� Ư�� �����ͺ��� ������ �з�,�׷�ȭ�� ������ �� �з�������
-- ��°��������� �׿� �����ʹ� ��� �Ұ���  

SELECT
    SUM(salary)
FROM
    employee
WHERE
    dept_code = 'D9';

SELECT
    dept_code,
    SUM(salary)
FROM
    employee
GROUP BY
    dept_code;
    
    -- �μ��ڵ庰�� ����

SELECT
    dept_code,
    SUM(salary)
FROM
    employee
GROUP BY
    dept_code
ORDER BY dept_code;
    
    -- from --> where > groub by > having > select > order by ������ ����
    
---------------------------------- quiz

SELECT
    *
FROM
    employee;
--1. ���޺� �޿� ����� ������ּ���. null���� intertn,���޺� ������������ ����

SELECT
    nvl(job_code,'intern') "����",
    TO_CHAR(
        floor(AVG(salary) ),
        'L999,999,999'
    )
     || '��' AS "�޿� ���"
FROM
    employee
GROUP BY
    job_code
ORDER BY ����;
    
    
-- group by �� �׷��ų ���ظ� ������ ����

SELECT
    DECODE(
        substr(emp_no,8,1),
        1,
        '��',
        2,
        '��'
    )
FROM
    employee
GROUP BY
    DECODE(
        substr(emp_no,8,1),
        1,
        '��',
        2,
        '��'
    ); 


------------------------------ quiz
--������ �ο��� ���

SELECT
    DECODE(
        substr(emp_no,8,1),
        1,
        '��',
        2,
        '��'
    ),
    COUNT(*) "�ο���"
FROM
    employee
GROUP BY
    DECODE(
        substr(emp_no,8,1),
        1,
        '��',
        2,
        '��'
    ); 
    
    
    ----------------------- 
    --������,������,���ö ������� ������ ��� ������ ������� ������ �޿� ����� ����ϼ���.

SELECT
    *
FROM
    employee;

SELECT
        CASE
            WHEN substr(emp_no,8,1) = 1 THEN '��'
            WHEN substr(emp_no,8,1) = 2 THEN '��'
        END
    "����",
    TO_CHAR(
        floor(AVG(salary) ),
        'L999,999,999'
    ) "�޿� ���"
FROM
    employee
WHERE
    emp_id BETWEEN '203' AND '222'
GROUP BY
    substr(emp_no,8,1);
    
    
    -- ���̴뺰 �޿� ���

SELECT
        CASE
            WHEN substr(emp_no,1,1) = 6 THEN '60����'
            WHEN substr(emp_no,1,1) = 7 THEN '70����'
            WHEN substr(emp_no,1,1) = 8 THEN '80����'
        END
    "���̴�",
    TO_CHAR(
        round(
            floor(AVG(salary) ),
            -5
        ),
        'L999,999,999'
    ) "�޿� ���"
FROM
    employee
GROUP BY
    substr(emp_no,1,1);
                            ------------
SELECT
    substr(emp_no,1,1)
     || '0����' "���̴�",
    TO_CHAR(
        round(
            floor(AVG(salary) ),
            -5
        ),
        'L999,999,999'
    ) "�޿� ���"
FROM
    employee
GROUP BY
    substr(emp_no,1,1);
    
    
    
    
----------------------- 
-- group by ���� ���� �ߺ�����

SELECT
    *
FROM
    employee;
    
    
select
    dept_code,
    job_code,
    count(*)
from
    employee
group by dept_code, job_code
order by 1,2;
    -- ���޺� �ο��� �ľ�
    
---------------------------------------------- quiz

select
    nvl (dept_code,'intern' )"�μ�",
    DECODE(substr(emp_no,8,1),1,'��', 2,'��') "���� ",
    count(*)||'��' "�ο���"
from
    employee
group by dept_code, DECODE(substr(emp_no,8,1),1,'��', 2,'��')
order by 1,2;
    -- �μ� �� ������ �ο��� �ľ�
    
    
--�μ��� �޿� ����� 300���� �̻��� �μ��� �μ��ڵ� �� �޿� ����� ����ϼ���

-- group by �� �׷�ȭ �� �������� ������ ���� ������ having �� ���

select
    dept_code "�μ��ڵ�",
    TO_CHAR(floor(AVG(salary)),'L999,999,999') "�޿� ���"
from
    employee
group by dept_code
having avg(salary) > 3000000; -- group by �� �׷�ȭ �� ������ �޿������ �ǹ�.

    

-------------------------------quiz

--1. �ο��� 3�� �̸��� �����ڵ��� �ο��� ����Ϸ��� ��.
-- �ο��� 3�� �̸��� �����ڵ忡 ���Ͽ� �����ڵ�� �ο��� ���
select
    job_code "����",
    count(*) "�ο� ��"
from
    employee
group by job_code
having count(*) <3;
    -- ���޺� �ο��� �ľ�
    








-------------------------------------------------
-------------------------------------------------
--day 04
-- join :�ϳ� �̻��� ���̺�κ��� Ư�� ������ �����ϴ� �����͸� ��ġ���Ͽ� ����� �����ϴ� ����
-- ��������� from�� �ش��Ѵ�.

select * from departmnt;
select * from job;

-- ANSI ǥ�ع�     : ��������.
select * from department cross join job;
select * from department inner join departmenr on dept_code= dept_id ;

-- Oracle ���빮   :   
select * from department, job; 
--join ���� �� = ũ�ν� ����(cross join : cartessian product�� �����)


-- Join ; Inner Join�� ������ ���� ���̺� �������� Ư�� ������ �����ϴ� ���ڵ常�� ���
select emp_id, emp_name, dept_title from employee, department
where dept_code= dept_id;



select emp_id, emp_name, e.job_code, job_name 
from employee e
inner join job on e.job_code = job.job_code
where job.job_name = '����';



select emp_id, emp_name, job_code, job_name 
from employee
inner join job using (job_code)
where job_name = '����';
--using ���� ��Ī ��� �Ұ���




-----------------------------------------------------------
--quiz
--1. ��������ο� ���� ������� �̸�, �μ��ڵ�, �޿��� ����ϼ���
select emp_name, dept_code, salary, dept_title
from employee
inner join department on dept_title = '���������';

select * from department;

--2. �ؿܿ���n�� �������� ���, �����, �μ���, ������ ����غ�����.
select emp_id, emp_name, dept_title, (salary*12)
from employee
inner join department on dept_title like '�ؿ�%';



-----------------------------
--outer join : join�� �����ϴ� �� ���̺��� ���� ���̺��� ��� �������� ����ϰ�
--����� ���� / inner join���� inner ��������

select
nvl(emp_name,'�����ο� ����'), nvl(dept_code, '�μ��ڵ����'), nvl(dept_title,'�μ������')
from
employee full outer join department on dept_code = dept_id
order by 2;
-- null���� ���� ����� ���� ����ϱ����ؼ� full ���
-- left, right, full �� outer join ������ ���⶧���� full,right,left joinó�� outer ��������

-------------------------------
--self join : ���� ���̺��� join �ϴ� ����

SELECT * FROM job j1 cross join job j2;

select emp_id, emp_name, manager_id from employee;
-- ���ӻ���� ��ȣ�� ǥ��Ǳ� ������ ������ Ȯ���ؾ���.

select e1.emp_id, e1.emp_name, e1.manager_id, e2.emp_name
from employee e1
join employee e2 on e1.manager_id = e2.emp_id
    order by 1;


--------------------------------
--1. �������� ���� �μ����� ���ϴ� �������� �̸� �μ��ڵ� �����ڵ� ���

select * from employee;

select e2.emp_name, e2.dept_code, e2.job_code
from employee e1 
     join employee e2 on e1.dept_code = e2.dept_code
where e1.emp_name = '������'     ;


--------------------------
--���� join : 3�� �̻��� ���̺��� join �Ͽ� ���ǹ��� �����͸� �����ϴ� �۾�

-- ������, �μ���, ���޸��� ������ּ���
select e.emp_name, d.dept_title, j.job_name
from employee e
left join department d on e.dept_code = d.dept_id
join job j on e.job_code = j.job_code
order by e.job_code;
-- ����join 

---------------------------------------- quiz




-- 1. �����, �μ���, �ٹ�����(National_Code) �� ����ϼ���
SELECT * FROM employee;
select * from department;

select e.emp_name, d.dept_title, n.national_name
from employee e
left join department d on e.dept_code = d.dept_id
join location l on d.location_id = l.local_code
join national n on l.national_code =n.NATIONAL_CODE 
order by e.dept_code;


-- 1. 2020�� 12�� 25���� ���� �������� ��ȸ�ϼ���.

SELECT
    TO_CHAR(
        TO_DATE('20201225','YYYYMMDD'),
        'day'
    ) ��¥
FROM
    dual;

-- 2. �ֹι�ȣ�� 1970��� ���̸鼭 ������ �����̰�,
--  ���� ������ �������� �����,�ֹι�ȣ,�μ���,���޸��� ��ȸ�ϼ���.

SELECT
    emp_name �����,
    emp_no �ֹι�ȣ,
    dept_title �μ���,
    job_name ���޸�
FROM
    employee e
    JOIN department d ON e.dept_code = d.dept_id
    JOIN job j USING ( job_code )
WHERE
        substr(emp_no,1,1) = 7
    AND
        substr(emp_no,8,1) = 2
    AND
        substr(emp_name,1,1) = '��';
   
 
-- 3. �̸��� "��"�ڰ� ���� �������� ���,�����,�μ����� ��ȸ�ϼ���.

SELECT
    emp_id ���,
    emp_name �����,
    dept_title �μ���
FROM
    employee
    JOIN department ON dept_code = dept_id
WHERE
    substr(emp_name,1,3) LIKE '%��%';


-- 4. �μ��� �޿� ����� 300���� ������ �μ��� �μ���� �޿� ����� ����ϼ���
-- > �޿� ����� 10000�� �ڸ� �Ʒ��� ������ ������ּ���. 
-- > ���� �ѱ� ���� ��ȭ ǥ������� ������ּ���. (��3,520,000)

SELECT
    d.dept_title "�μ���",
    TO_CHAR(
        trunc(
            floor(AVG(e.salary) ),
            -4
        ),
        'L999,999,999'
    ) "�޿� ���"
FROM
    employee e
    JOIN department d ON e.dept_code = d.dept_id
GROUP BY
    e.dept_code,
    d.dept_title
HAVING
    AVG(salary) <= 3000000;

-- 5. �ؿܿ����ο� �ٹ��ϴ� �����,���޸�,�μ��ڵ�,�μ����� ��ȸ�ϼ���.

SELECT
    e.emp_name �����,
    j.job_name ���޸�,
    e.dept_code �μ��ڵ�,
    d.dept_title �μ���
FROM
    employee e
    JOIN job j ON e.job_code = j.job_code
    INNER JOIN department d ON d.dept_title LIKE '�ؿ�%';

-- 6. ���ʽ�����Ʈ�� �޴� �������� �����,���ʽ�����Ʈ,�μ���,�ٹ��������� ��ȸ�ϼ���.

SELECT
    e.emp_name �����,
    e.bonus ���ʽ�����Ʈ,
    d.dept_title �μ���,
    n.national_name �ٹ�������
FROM
    employee e
    FULL JOIN department d ON e.dept_code = d.dept_id
    JOIN location l ON d.location_id = l.local_code
    JOIN national n ON l.national_code = n.national_code
WHERE
    e.bonus IS NOT NULL;

-- 7. �μ��ڵ尡 D2�� �������� �����,���޸�,�μ���,�ٹ��������� ��ȸ�ϼ���.

SELECT
    e.emp_name �����,
    j.job_name ���޸�,
    d.dept_title �μ���,
    n.national_name �ٹ�������
FROM
    employee e
    JOIN job j ON e.job_code = j.job_code
    FULL JOIN department d ON e.dept_code = d.dept_id
    JOIN location l ON d.location_id = l.local_code
    JOIN national n ON l.national_code = n.national_code
WHERE
    e.dept_code = 'D2';
   
-- 8. �ѱ�(KO)�� �Ϻ�(JP)�� �ٹ��ϴ� �������� �����,�μ���,�ٹ�������,�������� ��ȸ�ϼ���.

SELECT
    e.emp_name �����,
    d.dept_title �μ���,
    l.local_name �ٹ�������,
    n.national_name ������
FROM
    employee e
    JOIN job j ON e.job_code = j.job_code
    FULL JOIN department d ON e.dept_code = d.dept_id
    JOIN location l ON d.location_id = l.local_code
    JOIN national n ON l.national_code = n.national_code
WHERE
    l.national_code IN (
        'KO','JP'
    );

-- 9. ��� ��� �� �������� �Ŵ����� �ΰ� �ִ� ������ �̸�,������ �μ���,�Ŵ����� �̸��� ����ϼ���.

SELECT
    e1.emp_name �����,
    d.dept_title �μ���,
    e2.emp_name �Ŵ�����
FROM
    employee e1
    INNER JOIN department d ON e1.dept_code = d.dept_id
    INNER JOIN employee e2 ON e1.manager_id = e2.emp_id
WHERE
    e2.emp_name = '������'; 

-- 10. ���ʽ�����Ʈ�� ���� ������ �߿��� ������ ����� ����� �������� �����,���޸�,�޿��� ��ȸ�ϼ��� (join�� in ���)

SELECT
    e.emp_name �����,
    j.job_name ���޸�,
    e.salary �޿�
FROM
    employee e
    JOIN job j ON e.job_code = j.job_code
    INNER JOIN department d ON e.dept_code = d.dept_id
WHERE
        job_name IN (
            '����','���'
        )
    AND
        bonus IS NULL;

-- 11. �������� ������ ����� ������ ���� ��ȸ�ϼ���.

SELECT
    DECODE(
        ent_yn,
        'Y',
        '���',
        '������'
    ) AS "�������",
    COUNT(*) "���� ��"
FROM
    employee
GROUP BY
    ent_yn;
    
    
    
    
    ---------------------------------------------------------------------
    ------------------------------------------------------------------day5
    
    
    --union
    
    
--    union : �� ���̺��� �������̸� ���� �ߺ��� ���� 1ȸ�� ����Ѵ�. 
    
--    union all : �� ���̺��� �ߺ��� ����ϴ� ������.
    
    
--    interscept : �� ���̺��� ������

--  minus : �� ���̺��� ������.
    
    
    
    -------------------------------------------
    ---------------------------------------------
    --subQuerry : ���� �ȿ� ���� 
-- ������ ���Ͽ�    
-- ������
-- ���߿�
-- ������ ���߿�
-- inline view
--
select emp_name from employee where emp_id = 
(select manager_id from employee where emp_name='������');

--���� ���ο� ������ �����ϴ� ���. 


--------------------------------qiuz
--������������ �޿��� �����ѱ޿��� �޴� ������ �̸� �� �޿� ���
select salary from employee where emp_name = '������';
select emp_name, salary from employee where salary = 
(select salary from employee where emp_name = '������')
and emp_name != '������';


--2. ������ �޿� ��պ��� �޿��� ���� �޴� ������ �̸� �����ڵ� �ݿ��� ���

select avg(salary) from employee;
select emp_name, job_code, salary from employee 
where (select avg(salary) from employee) < salary ;

--d1 d2 �μ� ������� d5�޿� ��պ��� ���̹޴� �������� �μ���ȣ ��� ����� ���
select avg(salary) from employee where(dept_code = 'D5');
select dept_code, dept_code, emp_name from employee
where (select avg(salary) from employee where(dept_code = 'D5')) < salary
and dept_code in('D1','D2');

--�޿��� ���� ��������� ���� ��������� ��� ��� �޿�
select max(salary) , min(salary) from employee;
select emp_id, salary from employee 
where (select max(salary) , min (salary) from employee);

--�ڳ��� ���߱� ������ �μ��ڵ�� ������ �μ������� ����
select * from employee
where dept_code in (select dept_code from employee where emp_name in ('������','�ڳ���'));


--
--1. ���¿� �Ǵ� ������ ������ �޿���ް� ���� ����� ���� ���޸� ����� ���
select sal_level from employee where emp_name in ('���¿�','������');

select e.emp_name, j.job_name
from employee e
join job j on j.job_code = e.job_code
where sal_level in 
(select sal_level from employee where emp_name in ('���¿�','������'));


--2. ������ ��ǥ, �λ����̾ƴ� ��� ������ �����, �����ڵ� 
select job_code from job
where JOB_name in ('��ǥ','�λ���');

select emp_name, job_code
from employee 
where job_code not in (select job_code from job where JOB_name in ('��ǥ','�λ���'));



-- D5�μ��� �ٹ��ϴ� �������� �޿����� ���̹޴� ������ ���� ���
select emp_name, salary from employee
 where salary > any(select salary from employee where dept_code ='D5'); 
 --any() = ()�� �ƹ��ų� ���� ũ�⸸ �ϴٸ�
 select emp_name, salary from employee
 where salary > (select min(salary) from employee where dept_code ='D5'); 
 --any �� ����� �� ()�������� min �� ���ΰͰ� ����
 
 select emp_name, salary from employee
 where salary > all(select salary from employee where dept_code ='D5'); 
 --all �� ����� �� ()���� �������� ��� ����麸�� ū��. 
  select emp_name, salary from employee
 where salary > (select max(salary) from employee where dept_code ='D5'); 
 --all �� �ִ񰪺��� ū ��.
 
 
 
 -------------------------------------------
 ---------------------------------------------
 
--���߿� �������� 
select dept_code, job_code from employee where ent_yn ='Y';

select emp_name, dept_code, job_code from employee
where (dept_code, job_code) = (select dept_code, job_code from employee where ent_yn ='Y');

--������ ���߿��� ��� ���߿��� ������ �����ϴ�. 
--�Ұ�ȣ �� ����Ͽ� �񱳱��� ������ ��쿡 ���߿� �������� �񱳰� �����ϴ�.


--���߿� �������������� <,> any �Ǵ� all ��� �Ұ���.
--��, = ��ȣ�� ���ؼ��� any �� ��� �� �� �ִ�.(all �� �Ұ���)



-----------------------------------
-- ������ 0808�� ������ ���� �μ��ڵ�, ���� �����ڵ��� �������� ������ ������ ���
-- ������ 0808�� ������ �������
select dept_code, job_code from employee where substr(emp_no,3,4)='0808';

select emp_name, substr(emp_no,3,4) "����" from employee
where (dept_code,job_code)in(select dept_code, job_code from employee 
where substr(emp_no,3,4)='0808')
and substr(emp_no,3,4)!='0808';

-- �μ��� �޿��� ���� ���� �޴� ������ �μ��ڵ�, �����̸� �� �޿� ���. �μ��ڵ�� ����.

select dept_code, emp_name, salary from employee
where(dept_code, salary) in (select dept_code, max(salary) from employee
group by dept_code )order by 1;


--------------------------------------
--SubQuery�� ����ϴ� �Ǵٸ� ���� / select ��

select dept_title from department;
select emp_name, (select dept_title from department where dept_code = dept_id) 
from employee;

--������� ���޸��� ����ϼ���, �� subquery��
select job_name from job;
select emp_name, (select job_name from job j where e.job_code = j.job_code) from employee e;

-----------------------------------------------
--rank ���� �Լ�
--���� ����� ������ ���ڷ� ��Ÿ��
select emp_name, salary, rank() over(order by salary desc) from employee;
--������ ��ü������ ��Ÿ��
select emp_name, salary, dense_rank() over(order by salary desc) from employee;

select emp_name, salary, row_number() over(order by salary desc) from employee;

-------------------------quiz

--1.�޿� ������������ 10������ 15�� ������ 

select emp_name, salary, rank() over(order by salary desc) "�޿� ��ŷ" 
from employee
where "�޿� ��ŷ" > 9 and "�޿� ��ŷ" < 16;

select * from (select emp_name, salary, rank() over(order by salary desc) "�޿� ��ŷ" 
from employee) where "�޿� ��ŷ" > 9 and "�޿� ��ŷ" < 16;
 

-------------------------------------------------------------------------
-------------------------------------------------------------------------

--1. ��������ο� ���� ������� ����� �̸�,�μ��ڵ�,�޿��� ����Ͻÿ�
--
select e.emp_name, e.dept_code, e.salary 
from employee e
join department d on e.dept_code = d.dept_id
where d.dept_title = '���������';

--2. ��������ο� ���� ����� �� ���� ������ ���� ����� �̸�,�μ��ڵ�,�޿��� ����Ͻÿ�
--

--3. �Ŵ����� �ִ� ����߿� ������ ��ü��� ����� �Ѱ� ���,�̸�,�Ŵ��� �̸�,����(������������)�� ���Ͻÿ�.
--��, JOIN�� �̿��Ͻÿ�
--
--4. �� ���޸��� �޿� ����� ���� ���� ������ �̸�, �����ڵ�, �޿�, �޿���� ��ȸ
--
--5. ���� ���ʽ��� ���� �޴� ������ ������� �̾����� 4~8���� ����, �����, �޿�, ���ʽ����� ���
--
--6. �μ��� ��� �޿��� 2200000 �̻��� �μ���, ��� �޿� ��ȸ ��, ��� �޿��� �Ҽ��� ����
--
--7. ������ ���� ��պ��� ���� �޴� ���ڻ���� �����,�����ڵ�,�μ��ڵ�,������ �̸� ������������ ��ȸ�Ͻÿ� ���� ��� => (�޿�+(�޿�*���ʽ�))*12






--------------------------------------------------------------------
--------------------------------------------------------------------

