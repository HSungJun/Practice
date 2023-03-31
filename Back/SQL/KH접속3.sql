desc employee; 
-- describe employee; : employee 테이블에 대해 묘사 설명하라

select emp_id , emp_name ,emp_no from employee;
-- employe 테이블에서 emp_id , emp_name , emp_no 컬럼에 해당하는 데이터를 조회하라

select * from employee;
-- employee 테이블의 모든 컬럼 데이터를 조회하라

select emp_id , emp_name from employee where emp_id = 207;

--Quiz01
--1 . Employee 테이블에 존재하는 모든 직원의 사번, 이름 급여를 출력해보세요
select emp_name , emp_id ,salary from employee;

--2. 직원 중 D9 부서에 속해 있는 직원들의 사번, 이름 , 부서코드를 출력해보세요
select emp_id , emp_name , dept_code from employee where dept_code = 'D9';

select * from employee where salary >= 4000000;

select * from job;

--Quiz
--1 직원 중 급여를 200만원 이하로 받는 직원의 이름 및 부서코드 직급 코드를 출력해보세요

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
--1.급여가 200~300만 사이인 직원의 사번, 이름 ,급여 직급 코드를 출력해보세요
select salary , emp_name , emp_id , job_code from employee where salary >= 2000000 and salary <= 3000000;
---------------------------
select salary , emp_name , emp_id , job_code from employee where salary between 2000000 and 3000000;

--quiz
select * from employee;
--1. employee 테이블의 직원 중에 job_code 가 j3이면서 급여가 350만원의 이상인 직원의 이름과 전화번호를 출력해보세요
select emp_name ,phone from employee where job_code ='J3' and salary >= 3500000;
--2. employee 테이블의 직원 중에 부서코드가 d5이거나 d6이거나 d9인 직원의 이름과 부서코드를 출력해보세요
select emp_name , dept_code from employee where dept_code ='D5' or dept_code = 'D6' or dept_code = 'd9';
----------------------------------
select emp_name , dept_code from employee where dept_code in ('D5','D6','D9');

select emp_id, emp_name from employee
    where dept_code is not null;


---------------------alias
select emp_name 사원명, salary 월급, salary * 12 as "연 봉", '원' 단위 from employee;
--데이터 영역은 ''  헤더라인쪽은 ""  as랑 ""생략가능 뛰어쓰기있을땐 생략 불가
--crtl shift +d 라인복사
--ctrl shift +d 한줄 삭제
-- select 컬럼명 from 테이블명 where 조건식;
--조건식 =,<,>,<=, >= 사용가능
--and , or , between and , is null, is not null, in

------------------------sysdate&dual    select는 반복문
--dual : 내장 테이블 - SQL 이용자가 특정 기능을 테스트할때 사용할수있도록 미리 만들어둔 허수아비 테이블 허수아비 (연습)
--sysdate = sysdate가 호출되는 시점의 날짜 및 시간을 반환하는 orcle기능 (현재 날짜 및 시간 )
--          date type의 결과를 반환한다 (날짜타입)
--          날짜타입에 대한 수치 연산은 (+,-) 일수 연산이 적용 된다
--          날짜타입과 날짜타입을 연산하면 두 날짜 사이의 일차가 반환 된다
select sysdate from dual;

select 'ABC' - 10 from dual;
select 10 - 5 from dual;

select sysdate -1 from dual;
--날짜 타입에 대해서는 플러스 마이너스만 가능하다

desc employee;

--floor() : 실수를 파라미터로 전달받으면 소수점 자리수를 버림하고 정수자리만 반환하는 메서드
-- || 문자열끼리 연결함
select emp_id, emp_name , hire_date as 입사일, floor (sysdate - hire_date) || '일'
as 근무일수 from employee;
select * from employee;

--quiz
--1.employee 테이블에서 근속년수가 20년 이상 된 직원 이름 ,월급,보너스율 을 출력해보세요


select emp_name as 이름, salary || '원' as 월급 , bonus as 보너스율 from employee where floor(sysdate-hire_date)>=7300;

select emp_name ,salary ,bonus from employee where floor ((sysdate-hire_date)/365) >=20;

-- 2. 모든 직원 이름 ,연봉, 실수령액 (연봉 - (연봉 * 3%))을 출력해보세요
select emp_name,
salary*12 연봉, 
salary*12 - (salary *12 *0.03) " 실 수령액"
from
employee;

select * from employee where hire_date between '90/01/01' and '01/12/31';
--문자열인데 between을 쓰면 알아서 날짜로 분석함

-------------------------like  % 있을수도 있고 없을수도 있다
select * from employee where emp_name not like '%하%';
                                        --연이 있기만하면 찾는다 %는있어도되고 없어도됨
select * from employee where emp_name like '전__';
--전이 맨 앞자리에 오고 뒤에 두글자가 반드시 있어야된다

--quiz
--1 모든 직원중에 전화번호의 처음 3자리가 010 아닌 직원의 이름과 전화번호를 출력해보세요
select emp_name, phone from employee where phone not like '010%';

select * from employee;
--2 모든 직원 중에서 이름에 '이' 자가 들어가는 사람을 모두 찾아 이름을 출력해보세요
select emp_name from employee where emp_name like '%이%';
--3. 모든 직원 중에서 
    --부서코드가 D9 또는 D6이고
    --월급이 270만원 이상이며
    --email에 알파벳 s가 포함되어있고
    --고용일이 2001년 1월 1일부터 2005년 12월 31일 사이인 직원의
    --이름 ,부서코드 ,급여 , email, 고용일을 출력해보세요
    select emp_name , dept_code , salary , email, hire_date from employee 
    where dept_code in ('D9' , 'D6')and salary >= 2700000 and email like '%s%'
    and hire_date between '01/01/01' and '05/12/31';
    select * from employee;

    --quiz
    --1. 직속상사 (manager_id)가 없고 부서 (dept_code) 배치도 받지 않은 직원의 사번 및 이름을 출력
    select emp_name , emp_id from employee where manager_id is null and dept_code is null;
    --2. 부서 배치를 받지 않았지만 보너스는 지급되는 직원의 부서코드 , 이름 및 보너스를 출력
    select emp_name ,bonus , dept_code from employee where dept_code is null and bonus is not null;


-------------------------------order by
-- order by : 쿼리 실행 결과에서 특정 조건을 이용하여 데이터를 정렬하는 문법
--줄세우다 (기본)asc : 올림차순 desc : 내림차순
select emp_id , emp_name ,dept_code ,salary from employee order by dept_code desc nulls first ,salary desc; 
select emp_id , emp_name ,dept_code ,salary from employee order by dept_code desc nulls last  ,salary asc; 

select emp_id , emp_name ,dept_code ,salary from employee order by 3 desc;


-- desc employee;
-- desc -> describe

-- order by desc;
-- desc - > descending

--문제1
--근속년수 5년이상 , 10년 이하인 직원의 이름 주민번호 급여 입사일을 검색하세요
select emp_name , emp_no, salary , hire_date from employee where floor ((sysdate-hire_date)/365) between 5 and 10;
--문제2
--재직중이 아닌 직원의 이름 ,부서 코드를 검색하세요 (퇴사여부 ENT_YN)
select emp_name , dept_code from employee where ent_yn = 'Y';
--문제3
--근속년수가 10년이상인 직원들을 검색하여
--출력 결과는 이름 ,급여 , 근속년수(소수점 x)를 근속년수가 오름차순으로 정렬하여 출력하세요
--단 급여는 50% 인상된 급여로 출력되도록 하세요
select emp_name , salary *1.5 , floor(((sysdate - hire_date)/365)) from employee where floor(((sysdate - hire_date)/365))>=10 order by floor(((sysdate - hire_date)/365)) asc;
    select * from employee;

--문제4
--입사일이 99/01/01~10/01/01 인 사람중에서 급여가 2000000원 이하인 사람의
--이름 ,주민번호 ,이메일 , 폰번호 , 급여를 검색하세요
select emp_name , emp_no , email, phone , salary from employee where hire_date between '99/01/01' and '10/01/01' and salary <=2000000;
--문제5
--급여가 2000000~3000000원 인 여직원중에서 4월 생일자를 검색하여
--이름 ,주민번호 ,급여,부서코드를 주민번호 순으로 내림차순으로 출력
--단 부서코드가 null 인 사람은 부서코드가 없음으로 출력하세요  <--x
select emp_name , emp_no , salary , dept_code from employee where salary >=2000000 and salary <= 3000000 and emp_no like '%-2%' and emp_no like '%04%' order by emp_no desc;
--문제6
--남자 사원 중 보너스가 없는 사원의 오늘까지 근무일을 측정하여
--1000일 마다(소수점제외)
--급여의 10% 보너스를 계산하여 이름,특별보너스 (계산금액) 결과를 출력하세요
--단 이름 순으로 오름 차순 정렬하여 출력하세요
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
--where true면 동작함


-- select 컬럼명 from 테이블명;
-- where 절 - 데이터 조건부
-- between and , like (% , _ ) , is null ,not ,in ,and ,or , > , < , =
-- 문자열 ''
-- order by - 정렬

-----------------------------------------------------
 -- function () == method () 
 -- 자바에서는 메써드 오라클은 펑션
 -- nvl (검사데이터 , 검사데이터가 null일때 치환 될 값 )
 -- nvl(타켓 데이터 ,리턴값 ) :
 select emp_name , nvl(dept_code,'없음' )from employee;
 
 --length() : 특정 데이터의 길이를 측정하여 반환

select length ('Hello') from dual;
select length('한글') from dual;
--lengthb() : 특정 데이터의 byte를 측정하여 반환
select lengthb('Hello') from dual;
select lengthb('한 글') from dual;
--오라클에서는 한글자가 3바이트임 띄어쓰기는 1바이트

--instr() : 문자열 안에서 특정 문자의 위치 값을 찾는 함수(java의 indexof)
select instr('Hello World Hi High','H',2,2)from dual;
--'Hello World Hi High' 문자열 안에서 H를 검색하되 1번 글자에서부터 오른쪽으로 검색해가며 1번으로 만나는 H의 위치

-- substr() : 문자열 내에서 지정한 위치의 문자열을 잘라내어 반환하는 함수
select substr('Hello World Hi High' ,7,5 )from dual;
select substr('안녕 세계 안녕 높이' ,7,5 )from dual;

--quiz
--1. 직원 명단에서 이름의 성만 추출하여 출력해봅시다
select distinct substr(emp_name,1,1)  from employee order by 1;
--distinct 중복 제거

select * from employee;
--2. 직원 명단에서 사원번호 , 사원명 , 주민번호 , 연봉을 출력하세요
-- 단 주민번호 뒷 6자리는 *기호로 출력하세요
-- 남자직원의 정보만 출력해보세요 (like 사용하지 말것 )
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
--abs() : 값의 절대값을 반환하는 함수
select abs(2) from dual;
select abs(-2) from dual;

--mod() : JAVA의 % 연산자 - > 나머지 연산 함수
select mod (10,3) from dual;
select mod (10,4) from dual;

-- round() : 반올림 함수 
select round(126.456, 0) from dual;
select round(126.456, 1) from dual;
select round(126.456, 2) from dual;
select round(126.456, 3) from dual;
select round(126.456, -1) from dual;
select round(126.456, -2) from dual;

--floor() : 소수점 버림함수 

-- trunc() : 특정 위치에서 버림함수
select trunc(126.456 ,1 ) from dual;
select trunc(126.456 ,2 ) from dual;
select trunc(126.456 ,-1 ) from dual;

--ceil () : 올림 함수
select ceil(126.456) from dual;  --소수점 첫쨰 자리에서 올림
select ceil(123.456 * 10) /10 from dual; --소수점 둘쨰 자리에서 올림
select ceil(123.456 * 100) /100 from dual; --소수점 셋쨰 자리에서 올림
------------------------------------------------------------
--sysdate : 조회하는 순간의 시간 값을 Date타입으로 반환
select sysdate from dual;
--sysdate = 자바의 timestamp 초 값 계산

--months_between : 두 날짜 사이의 개월 수를 반환 하는 함수
select emp_name, floor(months_between(sysdate, hire_date)) 근속개월수 from employee;

--add months : 특정 날짜에 개월수를 더하는 함수
select add_months(sysdate,1) from dual;

--next_day : 지정날짜를 기준으로 가장 가까운 요일 date값을 반환
select sysdate , next_day(sysdate, '수요일') from dual;

--last_day : 지정날짜가 속한 달의 마지막 날 date값을 반환

select last_day(sysdate) from dual;

--quiz
-- 다음달 마지막 날짜는 며칠일까요?
select last_day(add_months(sysdate,1))from dual ;
select last_day(add_months(sysdate,-1))from dual ;

-- extract : 날짜 값으로부터 연,월,일을 추출하는 함수

select extract(year from sysdate ) from dual;
select extract(month from sysdate ) from dual;
select extract(day from sysdate ) from dual;

--quiz
--1. 사번,사원명, 입사년도 (0000년)형식으로 출력해보세요
select * from employee;
select emp_id , emp_name , extract(year from hire_date)||'년' 입사연도 from employee;

--2. employee 테이블에서 사원의 이름 ,hire_date, 년차를 출력해보세요
--년차 출력은 소수점 일경우 올림으로 하여 출력해보세요(28.144-> 29년차)
--(출력시 정렬은 입사일 기준으로 올림차순)

select emp_name ,hire_date, ceil(((sysdate - hire_date)/365))년차 from employee order by hire_date asc;

--------------------------------------------------------------

-- to_char() : 날짜값 또는 숫자값을 문자열로 변환하는 함수

-- D : 이번주에 몇번쨰 날 , DD: 이번달에 몇번쨰 날 , DDD: 올해의 몇번째 날 

select to_char(sysdate,'YYYY"년" MM"월" DD"일" (DY) Day HH24:MI:SS') from dual;
select to_char(sysdate ,'YYYY'  ) from dual;
--quiz
--사원명 ,고용일 (1990/02/06(화)) 형태로 출력
select emp_name , to_char(hire_date , 'YYYY/ MM / DD (DY)' ) from employee;
select to_char(1000000, 'L999,999,999') from dual;
--숫자 표현은 9로 표시

--to_date() : 문자열을 날짜형으로 변환
select to_date('20180208','YYYYMMDD') - 10 from dual;
--날짜라서 -10 가능 ,문자열이면 계산만 가능 
--출력이 아니고 분석

--quiz
--1945년 8월 15일의 요일은?

select to_char(to_date('19450815','YYYYMMDD'),'DY')광복절요일 from dual;
select to_date('19450815','YYYYMMDD')from dual;
--------------------------------------------------------
--decode() : 값에 따른 분기점을 만드는 함수 (자바의 삼항연산자 ,switch)

select decode('ㅁ' , 'Apple' , '사과' , 'Orange' , '오렌지', '포도') from dual;
--ㅁ칸이 애플이면 애플을 리턴한다 오렌지면 오렌지로 리턴한다
--포도는 else 
select * from employee;
--quiz
--사원 번호 , 사원명 , 성별 (남 여 ) 형태로 출력해보세요
select emp_id , emp_name , decode(substr(emp_no,8,1),'1','남','2','여') 성별 from employee;
----------------------------------------------------------
--case: 조건식에 따른 반환값 분기점 생성 함수
select emp_id , emp_name , case when substr(emp_no,8,1)='1' then '남' when substr(emp_no,8,1) = '2' then '여' else '?' end "성별" from employee;

--quiz
--1. 60년대 생 직원들 중에서 60~64년 미만의 직원들은 '60년생 초반' 이라고 출력
--               65~69년 까지의 직원들은 '60년생 후반' 이라고 출력
--  사번, 이름 , 60년생 초/후반
select emp_id , emp_name , 
case when 
substr(emp_no,1,2) <65  then '60년생 초반' 
when substr(emp_no,1,2)>= 65 then '60년생 후반'
end "나이대" from employee 
where substr(emp_no,1,2) between 60 and 69;

select length(email) from employee;
-- 여기까지는 모두 단일행 함수
--------------------------------------------------------
--그룹 함수 ( SUM, AVG, COUNT, MAX , MIN )


-- 이 회사의 한달 인건비는 얼마인가?
--sum : 합계함수
select emp_name ,sum(salary) from employee;
--그룹 함수가 출력했을떄는 옆에 다른 함수가 올수 없다 

--AVG :(평균함수)
select avg(salary) from employee;

--COUNT : 행의 개수 반환하는 함수

select count(emp_id) from employee;
select count(*) from employee;
--null값은 카운팅이 안됨                                                   

--MAX : 전체 행에서 가장 큰값을 반환하는 함수
select max(salary) from employee;

--MIN : 전체 행에서 가장 작은 값을 반환하는 함수
select min(salary),max(salary) from employee;
--그룹끼리는 그룹함수 가능
select * from employee;
--quiz
--1.
--D5부서 직원들의 급여 평균
select avg(salary)from employee where dept_code = 'D5';
--2.
-- 남직원들의 급여 합계
select sum(salary) from employee where substr (emp_no,8,1) =1;

select  * from employee;
----------------------------------------------------------------
--1. 직원명과 이메일 , 이메일 길이를 출력하세요
--        이름 이메일 이메일길이
--   ex) 홍길동 , hong@kh.or.kr 

select emp_name , email, length(email) from employee;


--2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하세요
--   ex) 노옹철 no_hc
--   ex) 정중하 jung_jh

select emp_name ,substr(email,1,instr(email,'@',1,1)-1) from employee;

--3. 60년생의 직원명과 년생, 보너스 율을 출력하세요   --------------------공부
--   그때 보너스 값이 null인 경우에는 0% 이라고 출력 되게 만드세요
--       직원명 년생 보너스
--   ex) 선동일 62 30%
--   ex) 송은희 63 0%

select emp_name as 직원명, substr(emp_no,1,2) , case when bonus is null then 0 else 
bonus end * 100 || '%' as 보너스 from employee where substr(emp_no,1,2) between 60 and 69;


--4. "010" 핸드폰 번호를 쓰지 않는 사람의 수를 출력하세요 (뒤에 단위는 명을 붙이세요)
--      인원
--   ex) 3명
select count(phone) || '명'from employee where phone not like '010%';

--5. 직원명과 입사년월을 출력하세요 
--   단, 아래와 같이 출력되도록 만들어 보세요
--       직원명 입사년월
--   ex) 전형돈 2012년12월
--   ex) 전지연 1997년 3월

select emp_name as 직원명 , to_char(hire_date, 'yyyy "년" mm "월" ')입사년월 from employee;



--6. 직원명과 주민번호를 조회하세요
--   단, 주민번호 9번째 자리부터 끝까지는 "*" 문자로 채워서 출력 하세요
--   ex) 홍길동 771120-1******
select emp_name ,substr(emp_no,1,8) ||'******' from employee;

select * from employee;

--7. 직원명, 직급코드, 연봉(원)을 조회하세요. -----------------공부

--  단, 연봉은 \1,000,000 으로 표시되게 함 (현지 통화 ￦가 적용 되어야 함)
--     연봉은 보너스포인트가 적용된 1년치 급여임
SELECT
    emp_name,
    job_code,
    TO_CHAR(
        salary * 12 * (1 + nvl(bonus,0)),
        'L999,999,999'
    )
FROM
    employee;


--8. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원의 수 조회하세요.
--   [ 사번 사원명 부서코드 입사일 ]
SELECT COUNT(hire_date) FROM employee WHERE dept_code IN ('D5','D9')
    AND
        hire_date LIKE '04%';

--9. 직원명, 입사일, 오늘까지의 근무일수 조회하세요. 
--   * 주말도 포함 , 소수점 아래는 버림
select emp_name 직원명 , hire_date 입사일 , floor(sysdate-hire_date)근무일수 from employee;

--10. 모든 직원의 나이 중 가장 많은 나이와 가장 적은 나이를 출력 하세요. (나이만 출력)
--모든 직원이 1900년대 생이라는 전제하에
SELECT 
MAX((100 - substr(emp_no,1,2) ) + substr(SYSDATE,1,2) + 1),
MIN((100 - substr(emp_no,1,2) ) + substr(SYSDATE,1,2) + 1)
FROM
employee;

--11. 회사에서 야근을 해야 되는 부서를 발표하여야 합니다.
-- 부서코드가 D5,D6,D9 야근, 그외는 야근없음 으로 출력되도록 하세요
-- 출력 값은 이름,부서코드,야근유무 (부서코드 기준 오름차순 정렬함.)
--   (부서코드가 null인 사람도 야근없음 임)
SELECT
emp_name,
dept_code,
CASE
WHEN dept_code IN ('D5','D6','D9') THEN '야근'
ELSE '야근없음'
END
    FROM
employee
ORDER BY dept_code ASC;


--group by : 그룹화 된 데이터에 대한 정보를 다루는 문법


select emp_name,sum(salary)from employee group by dept_code;
--order by 는 항상 가장 끝에 둔다
--dept_code , sum(salary) 이런 경우 안됨 그룹이랑 묶여있어서 (이름 이런게 요구 안됨)
--이런경우 group by 쓴다
--group by 해쳐모여
--읽는 순서
-- 1. from ~employee에서  
-- 2. where 절
-- 3. group by
-- 4. having
-- 5. select
-- 6. order by
--group by는 sum  ,avg ,max ,min 등 그룹함수는 가능하다
--group by는 이름 , 주민번호 등 개인함수는 요구 할수 없다
--gropu by 는 group by 에 썼던 데이터는 사용 가능하다 
select dept_code from employee group by dept_code;

select * from employee;

select dept_code ,sum(salary) from employee group by dept_code order by 1;

select emp_name "사원명" from employee ;

--quiz
-- 1. 직급별 급여 평균을 출력해보세요 (직급별 오름차순으로 정렬하여 출력)

select nvl(job_code,'인턴')"직급" , to_char(floor(avg(salary)),'L999,999,999') "급여평균" from employee group by nvl(job_code,'인턴') order by 직급 ;


select decode (substr(emp_no,8,1), 1 , '남' ,2,'여') from employee group by decode (substr(emp_no,8,1), 1 , '남' ,2,'여');

--quiz 성별별 인원수를 출력해보세요

select decode (substr(emp_no,8,1), 1 , '남' ,2,'여')"성별" , count(*)"인원수" from employee group by decode (substr(emp_no,8,1), 1 , '남' ,2,'여');

--선동일,송종기,노옹철을 세사람을 제외한 모든직원을 대상으로 성별별 급여 평균을 출력하세요

SELECT
    DECODE(SUBSTR(emp_no,8,1),1,'남','여') AS "성별",
    TO_CHAR(AVG(salary),'L999,999,9990') AS "평균급여"
FROM
    employee
WHERE
    emp_name NOT IN ('선동일','송종기','노옹철')
GROUP BY
    SUBSTR(emp_no,8,1);




-------------------------
--나이대별 급여 평균
--급여평균은 100000의 자리까지 반올림 할것
--급여 평균 출력은 로컬 통화모양(ex L2.542.030) 형태로 출력

--order by dept_code, salary

--group by dept_code , job_code
SELECT DECODE(substr(emp_no,1,1),6,'60년대생',7,'70년대생',8,'80년대생') "나이대",TO_CHAR(floor(round(AVG(salary),-5) ),'L999,999,999') "급여평균"
FROM
    employee
GROUP BY DECODE(substr(emp_no,1,1),6,'60년대생',7,'70년대생',8,'80년대생')
ORDER BY 1;


select
    dept_code,
    job_code,
    count(*)
    from
    employee
    group by dept_code, job_code
    order by 1,2;
--부서내 직급별 인원수 파악

--quiz
--1. 부서내 성별별 인원수 파악
select 
nvl(dept_code,'부서없음') 부서코드,
decode(substr(emp_no,8,1),1,'남',2,'여') 성별,
count(*) 인원수
from
employee
group by nvl(dept_code,'부서없음'), decode(substr(emp_no,8,1),1,'남',2,'여')
order by 1,2,3;

--2. 부서별 급여 평균이 300만원 이상인 부서의 부서코드 및 급여 평균을 출력하세요
-- group by로 인해 그룹화된 데이터에 대해 조건을 비교할때는 having 절을 사용

select
dept_code,
floor(avg(salary))
from employee
group by dept_code
having avg(salary)>=3000000;

--where절은 그룹함수를 사용할수없음

--quiz
--1.인원이 3명 미만인 직급코드의 인원을 충원하려고함
--인원이 3명이 안되는 직급코드에 대하여 직급코드와 인원수를 출력하세요

SELECT
    job_code AS "직급코드",
    COUNT(*) AS "인원수"
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
--하나 이상의 테이블로 부터 특정 조건을 충족하는 데이터를 취합하여 결과를 생성하는 문법

select * from department;

select * from job ;

------------- JOIN 문법 (이중문법)


--> ANSI 표준
select * from department cross join job;
-- Cross JOin

select * from employee inner join department on dept_code=dept_id;
-- INnter Join


--> Oracle 전용
select * from department, job;
--사용법 : 2개면 테이블명 뒤에 콤마
-- JOIN 종류 중 - 크로스조인 (Cross Join - Cartesian Product 카테이션 곱을 만들어낸다)


select * from employee;
select * from department;

--JOIN 종류 중 --inner JOIN : JOIN에 참여한 여러 테이블 정보에서 특정 조건을 만족하는 레코트만을 선별하여 결과 생성 (NULL 값은 필터링)
select emp_id , emp_name , dept_code, dept_title from employee, department           --23 * 9 =207
where dept_code = dept_id; --where절은 1테이블당(207) 확인을 함
    
--이너조인은 from 절임 뒤에 where쓸수있음
--컬럼에 이름이 같은게 있을경우 앞에 어떤 테이블인지 써줘야함
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
where j.job_name = '과장';


--------------------------------

--using 일경우 on보다 문장이 짧아짐 job_code테이블끼리 하겠다 별명사용x 
select
emp_id,
emp_name,
job_code,
job_name 
from 
employee
inner join job using (job_code)
where job_name = '과장';

--quiz
--1. 기술지원부에 속한 사람들의 이름 , 부서코드 , 급여를 출력하세요
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
    dept_title = '기술지원부';
    
    
SELECT
    emp_name,
    dept_code,
    salary
FROM
    employee
    INNER JOIN department ON dept_code = dept_id
where dept_title ='기술지원부';

--2. 해외영업n부 직원들의 사번, 사원명, 부서명, 연봉을 출력해보세요
select emp_id, emp_name , dept_title , salary* 12
from employee
inner join department on dept_code = dept_id
where dept_title like '해외영업%'
order by 3,1;

-----------------------------------------
-- outer join : join에 참여하는 두 테이블에서 한쪽 테이블의 모든 행을 강제 출력하게 만드는 문법
--inner join 에서 inner 생략 가능
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

--full outer에서 outer 생략가능
select
nvl(emp_name,'배정인원없음'),
nvl(dept_code,'부서없음'),
nvl(dept_title,'부서명없음')
from
employee full outer join department on dept_code = dept_id
order by 2;

-----------------------------------------
--self join : 같은 테이블을 join하는 문법(같은 테이블을 알고 있는경우가 필요할때)

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
--1. 하이유씨와 같은 부서에서 일하는 직원들의 이름 부서코드 직급코드를 출력해보세요(self join)
              
              
                 
select e2.emp_name , e2.job_code , e2.dept_code from employee e1 inner join employee e2 
on e1.dept_code = e2.dept_code where e1.emp_name= '하이유';

select * from employee;
-------------------------------------------------------
--다중 JOIN  : 3개 이상의 테이블을 Join 하여 유의미한 데이터를 생성하는 작업

-- 직원명 , 부서명 , 직급명을 출력해보세요
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
--1. 사원명, 부서명 ,근무 지역(National code)를 출력해보세요
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

-- 1. 2020년 12월 25일이 무슨 요일인지 조회하세요.

SELECT

    TO_CHAR(

        TO_DATE('20201225','YYYYMMDD'),

        'DY')

FROM

    dual;

   

-- 2. 주민번호가 1970년대 생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하세요.

   select 

   e.emp_name 사원 , e.emp_no 주민번호, d.dept_title 부서명, j.job_code 직급명

   from employee e

   join department d on e.dept_code = d.dept_id

   join job j on j.job_code=e.job_code

   where substr(emp_no,8,1) =2 and substr(emp_no,1,1)=7 and substr(emp_name,1,1)='전';

   

   

   



  

-- 3. 이름에 "형"자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하세요.

SELECT

    emp_id 사번,

    emp_name 사원명,

    dept_title 부서명

FROM

    employee

    join department

    on dept_code=dept_id

WHERE

    emp_name LIKE '%형%';

    

    

-- 4. 부서별 급여 평균이 300만원 이하인 부서의 부서명과 급여 평균을 출력하세요

-- > 급여 평균은 10000의 자리 아래로 버리고 출력해주세요. 

-- > 또한 한국 로컬 통화 표기법으로 출력해주세요. (\3,520,000)

select

d.dept_title 부서명,

to_char(trunc(avg(salary),-4),'L999,999,999')급여평균

from employee e join department d on e.dept_code=d.dept_id

group by d.dept_title 

having avg(salary)<=3000000;







-- 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하세요.

select e.emp_name 사원명, j.job_name 직급명, e.dept_code 부서코드,d.dept_title 부서명

from employee e 

join job j on e.job_code = j.job_code

join department d on d.dept_id=e.dept_code

where dept_title like '해외%';



-- 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하세요.

select

e.emp_name 사원명,

e.bonus 보너스포인트,

d.dept_title 부서명,

n.national_name 근무지역명

from employee e

join DEPARTMENT d on d.dept_id=e.dept_code

join location l on l.local_code = d.location_id

join national n on n.national_code=l. national_code

where bonus is not null;





-- 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하세요.

SELECT

    e.emp_name 사원명,

    j.job_name 직급명,

    d.dept_title 부서명,

    l.local_name 근무지역명

FROM

    employee e

    join job j on j.job_code = e.job_code

    join department d on e.dept_code=d.dept_id

    join location l on l.local_code = d.location_id

   where dept_code = 'D2';

  

-- 8. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 근무지역명, 국가명을 조회하세요.

select 

e.emp_name , d.dept_title , l.local_name, n.national_name

from employee e

join department d 

on e.dept_code = d.dept_id

join location l on l.local_code = d.location_id

join national n on l.national_code = n.national_code

where n.national_name in ('한국','일본');
    
-- 9. 모든 사원 중 선동일을 매니저로 두고 있는 직원의 이름, 직원의 부서명, 매니저의 이름을 출력하세요.

select e1.emp_name 직원, d.dept_title 부서 , e2.emp_name 매니저 

from EMPLOYEE e1

join DEPARTMENT d on d.dept_id= e1.dept_code

join employee e2 on e2.emp_id = e1.manager_id

where e2.emp_name='선동일';





-- 10. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하세요 (join과 in 사용)

select e.emp_name , j.job_name , e.salary 

from employee e

join job j on j.job_code = e.job_code

where job_name in ('차장','사원') and bonus is null;





-- 11. 재직중인 직원과 퇴사한 직원의 수를 조회하세요.

select decode(ENT_YN,'N' ,'재직중' ,'Y', '퇴사'),count(*) from employee group by decode(ENT_YN,'N' ,'재직중' ,'Y', '퇴사');

--------------------------------------------
--SQL
--DDL
--DML
-- insert, update ,select ,delete
-- select(DQL):
-- select 기초 -> function()->group by -> having ->join -> [union subquery]
--DCL
--TCL

-------------------------------------------------


--union : 두 테이블을 단순하게 아래로 이어 붙이는 문법
--      > 1. union 하는 두 테이블의 컬럼수가 같아야 한다
--      > 2. union 하는 컬럼들의 자료형이 같아야 한다
-- union , union all , minus, intersect
select DEPT_ID,DEPT_TITLE from department
union 
select * from job;

--테이블 생성(?)

--테이블을 만드려면 객체라서 DBL을 써야한다
--컬럼은 data 자료형은 넘버 

    
    
    
--DML (데이터도 집어 넣는거)
select * from A;


create table A(data number);
insert into A values(1);
insert into A values(2);
insert into A values(3);

create table B (data number);

insert into b values(2);
insert into b values(3);
insert into b values(4);


--지우기
drop table A;


--union : 두 테이블의 간의 합집합이며 그 중 중복된 행은 1회만 출력한다

select * from A
union all
select * from B;
-- union all : 두 테이블의 간의 합집합이며 그 중 중복된 행도 출력한다


select * from A
intersect
select * from B;

-- union intersect : 두 테이블 간의 교집합

select * from A
minus
select * from B;

--union minus:두 테이블 간의 차집합 (A 테이블에서 B테이블이 가진 값을 모두 제거하고 남은 A의 값)

------------------------------------------------------

--SubQuery : 쿼리 안에 쿼리  사용법 : 소괄호를 쳐야 한다
--단일행 단일열 subquery
--다중열 subquery
--다중행 다중열 subquery
-- inline view
--상관 서브 쿼리



select
emp_name
from
employee
where
emp_id=(select manager_id from employee where emp_name = '전지연');

--quiz
--윤은해 직원의 급여와 동일한 급여를 받는 직원의 이름 및 급여 출력

select * from employee;


select salary from employee where emp_name='윤은해';
select emp_name, salary from employee where salary= 2000000;


--쿼리는 값이다
select emp_name, salary from employee where salary= (select salary from employee where emp_name='윤은해')
and emp_name != '윤은해';

--2.전 직원 급여 평균보다 급여를 많이 받는 직원의 이름,직급코드,급여를 출력하세요

select avg(salary) from employee;
select emp_name  ,job_code ,salary from employee
where (select avg(salary) from employee) < salary;
--where절은 그룹함수 x
--위에서는 where 절이 아니고 select절에 사용했음

--3. D1 , D2부서의 직원중에서 급여가 D5부서의 급여 평균 보다
--많이 받는 직원들의 부서번호 사번 사원명 급여를 출력하세요
select avg(salary) from employee where dept_code ='D5';

select dept_code , emp_id , emp_name , salary from employee where dept_code in  ('D1','D2')
and salary>(select avg(salary) from employee where dept_code ='D5'); 


--4.급여가 제일 많은 사람과 제일 적은 사람의 , 사번 사원명 급여를 출력해보세요

select max(salary) from employee;
select min(salary) from employee;
select emp_id , emp_name , salary from employee where salary = (select max(salary) from employee) or
salary = (select min(salary) from employee);

-------------------------------------------------------------
--다중행 단일열 서브쿼리

select * from employee;
--박나라, 송중기 직원의 부서코드와 동일한 부서에 속한 직원들의 정보

select dept_code from employee where emp_name in ('송종기','박나라');
select * from employee 
where dept_code in ('D9','D5');



select * from employee
where dept_code in (select dept_code from employee where emp_name in ('송종기','박나라'));



--다중으로 할떄는 =으로 비교할수 업음 (여러개니까) 단일일땐 가능
--다중으로할떄는 =아니고 in을 사용해야댐


--quiz
--1. 차태연 또는 전지연 직원의 급여등급(sal_level) 과 같은 급여 등급인
--직원의 직급명과 사원명을 출력




select emp_name , job_name , sal_level from employee e
join job j on e.job_code=j.job_code
where sal_level in (select sal_level from employee where emp_name in ('차태연','전지연'));


select sal_level from employee where emp_name in ('차태연','전지연');

--2. 직급이 대표, 부사장이 아닌 모든 직원의 사원명, 직급코드를 출력
select emp_name , job_code from employee 
where 
job_code not in (select job_code from job where job_name in ('대표','부사장'));

select job_code from job where job_name not in ('대표','부사장');



-- D5 부서의 직원들의 급여보다 많이 받는 직원의 정보를 출력

select emp_name, salary from employee
where salary >any(select salary from employee where dept_code = 'D5');
--d5에서 뽑은 급여목록중에서 아무거나 크기만 하다면 그 대상을 출력
select emp_name, salary from employee
where salary >(select min(salary) from employee where dept_code = 'D5');




select emp_name, salary from employee
where salary >all(select salary from employee where dept_code = 'D5');


select emp_name, salary from employee
where salary > (select max(salary) from employee where dept_code = 'D5');
--모든 어떠한 결과보다 더 커야 한다 
-------------------------------------------------------
--다중 열 서브 쿼리 = 다중행 다중열 서브쿼리 문법과 동일 

select dept_code, job_code from employee where ent_yn='Y';

select emp_name , dept_code, job_code from employee
    where (dept_code,job_code) = (select dept_code, job_code from employee where ent_yn='Y');
--오른쪽인 서브 쿼리에 2개 면 왼쪽도 2개로하고 소괄호를 묶어야한다 개수가 다르면 in으로

select emp_name,bonus,salary from employee
where (bonus,salary)=any(select bonus, salary from employee where emp_name='유재식');
--다중열 서브쿼리에서는 >,< any또는 all을 사용할수없음
--단,=기호에 대해서는 any는 사용할수 있다.



--quiz
--1.생일이 8월 8일인 사원들과 같은 부서코드 , 같은 직급코드인 직원들의 사원명과 생일을 출력
-->생일이 8월 8일인 직원은 출력에서 제외
select emp_name,dept_code ,job_code from employee where substr(emp_no,3,4)='0808';

SELECT
    dept_code , job_code,emp_name,
   substr(emp_no,3,4)
FROM
    employee
WHERE ( dept_code,job_code ) 
IN (SELECT dept_code,job_code FROM employee WHERE substr(emp_no,3,4) = '0808') AND substr(emp_no,3,4) != '0808';

--2. 부서별 급여를 가장 많이 받는 직원의 부서코드, 직원이름 및 급여를 출력해주세요
--부서 코드로 정렬

select dept_code , max(salary) from employee group by dept_code;

select dept_code,emp_name,salary from employee 
where (dept_code,salary) in (select dept_code , max(salary) from employee group by dept_code) order by 1;
-------------------------------------------------
--subquery를 사용하는 또 다른 유형 - select편 (조인 대신에)

select emp_name , (select dept_title from department where dept_code=dept_id)dept_title from employee;
--서브쿼리가 메인쿼리에 컬럼하나를 끌어다가 자기부품처럼 사용하고 있다

--직원명과 직급명을 출력하세요 (단 subquery 로)
select emp_name , (select job_name from job j where e.job_code= j.job_code) from employee e;

--inline view : from 절에서 사용되는 subquery
select emp_id,emp_no from (select emp_id,emp_name,emp_no from employee);

-----------------------------------------------------------------
--rank 관련 함수(순위)
--over 안에 기준 rank over 같이써야댐
select emp_name,salary, rank() over(order by salary desc)"급여 랭킹" from employee;

select emp_name,salary, dense_rank() over(order by salary desc)"급여 랭킹" from employee;
--dense_rank() over 순위 다 나오게 함

select emp_name , salary , row_number() over(order by salary desc) "급여 랭킹" from employee;
--행 번호를 얻어 낼떄 사용하는 함수

--quiz
--1. 급여 내림차순으로 행마다 번호를 붙였을때 , 10~15까지의 데이터만 출력해보세요

select emp_name ,salary ,row_number() over(order by salary desc) "급여 랭킹" from employee;


--1. 기술지원부에 속한 사람들의 사람의 이름,부서코드,급여를 출력하시오

select emp_name , (select dept_title from department where dept_code=dept_id )dept_title , salary from employee where dept_title ='기술지원부';

--2. 기술지원부에 속한 사람들 중 가장 연봉이 높은 사람의 이름,부서코드,급여를 출력하시오
select emp_name ,dept_code, salary from employee ;

select max(salary*12) ,(select dept_title from department where dept_code=dept_id )dept_title from employee;

--3. 매니저가 있는 사원중에 월급이 전체사원 평균을 넘고 사번,이름,매니저 이름,월급(만원단위부터)을 구하시오.
--단, JOIN을 이용하시오
select emp_id 사번 , emp_name 이름 , emp_name 매니저 , salary from employee;
select avg(salary) from employee;



--4. 각 직급마다 급여 등급이 가장 높은 직원의 이름, 직급코드, 급여, 급여등급 조회

--5. 가장 보너스를 많이 받는 순으로 사원들을 뽑았을때 4~8위의 순위, 사원명, 급여, 보너스율을 출력



--6. 부서별 평균 급여가 2200000 이상인 부서명, 평균 급여 조회 단, 평균 급여는 소수점 버림


--7.직급의 연봉 평균보다 적게 받는 여자사원의 사원명,직급코드,부서코드,연봉을 이름 오름차순으로 조회하시오 연봉 계산 => (급여+(급여*보너스))*12






