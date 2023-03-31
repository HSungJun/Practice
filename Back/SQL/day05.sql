DESC employee; 
-- describe employee; : employee 테이블에 대해 묘사 설명하라

SELECT
    emp_id,
    emp_name,
    emp_no
FROM
    employee;
-- employe 테이블에서 emp_id ,emp_name ,emp_no 컬럼에 해당하는 데이터를 조회하라

SELECT
    *
FROM
    employee;
-- employee 테이블의 모든 컬럼 데이터를 조회하라

SELECT
    emp_id,
    emp_name
FROM
    employee
WHERE
    emp_id = 207;

--Quiz01
--1 . Employee 테이블에 존재하는 모든 직원의 사번,이름 급여를 출력해보세요

SELECT
    emp_name,
    emp_id,
    salary
FROM
    employee;

--2. 직원 중 D9 부서에 속해 있는 직원들의 사번,이름 ,부서코드를 출력해보세요

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
--1 직원 중 급여를 200만원 이하로 받는 직원의 이름 및 부서코드 직급 코드를 출력해보세요

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
--1.급여가 200~300만 사이인 직원의 사번,이름 ,급여 직급 코드를 출력해보세요

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
--1. employee 테이블의 직원 중에 job_code 가 j3이면서 급여가 350만원의 이상인 직원의 이름과 전화번호를 출력해보세요

SELECT
    emp_name,
    phone
FROM
    employee
WHERE
        job_code = 'J3'
    AND
        salary >= 3500000;
--2. employee 테이블의 직원 중에 부서코드가 d5이거나 d6이거나 d9인 직원의 이름과 부서코드를 출력해보세요

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
    emp_name 사원명,
    salary 월급,
    salary * 12 AS "연 봉",
    '원' 단위
FROM
    employee;
--데이터 영역은 ''  헤더라인쪽은 ""  as랑 ""생략가능 뛰어쓰기있을땐 생략 불가
--crtl shift +d 라인복사
--ctrl shift +d 한줄 삭제
-- select 컬럼명 from 테이블명 where 조건식;
--조건식 =,<,>,<=,>= 사용가능
--and ,or ,between and ,is null,is not null,in

------------------------sysdate&dual    select는 반복문
--dual : 내장 테이블 - SQL 이용자가 특정 기능을 테스트할때 사용할수있도록 미리 만들어둔 허수아비 테이블 허수아비 (연습)
--sysdate = sysdate가 호출되는 시점의 날짜 및 시간을 반환하는 orcle기능 (현재 날짜 및 시간 )
--          date type의 결과를 반환한다 (날짜타입)
--          날짜타입에 대한 수치 연산은 (+,-) 일수 연산이 적용 된다
--          날짜타입과 날짜타입을 연산하면 두 날짜 사이의 일차가 반환 된다

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
--날짜 타입에 대해서는 플러스 마이너스만 가능하다

DESC employee;

--floor() : 실수를 파라미터로 전달받으면 소수점 자리수를 버림하고 정수자리만 반환하는 메서드
-- || 문자열끼리 연결함

SELECT
    emp_id,
    emp_name,
    hire_date AS 입사일,
    floor(SYSDATE - hire_date)
     || '일' AS 근무일수
FROM
    employee;

SELECT
    *
FROM
    employee;

--quiz
--1.employee 테이블에서 근속년수가 20년 이상 된 직원 이름 ,월급,보너스율 을 출력해보세요

SELECT
    emp_name AS 이름,
    salary || '원' AS 월급,
    bonus AS 보너스율
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

-- 2. 모든 직원 이름 ,연봉,실수령액 (연봉 - (연봉 * 3%))을 출력해보세요

SELECT
    emp_name,
    salary * 12 연봉,
    salary * 12 - ( salary * 12 * 0.03 ) " 실 수령액"
FROM
    employee;

SELECT
    *
FROM
    employee
WHERE
    hire_date BETWEEN '90/01/01' AND '01/12/31';
--문자열인데 between을 쓰면 알아서 날짜로 분석함

-------------------------like  % 있을수도 있고 없을수도 있다

SELECT
    *
FROM
    employee
WHERE
    emp_name NOT LIKE '%하%';
                                        --연이 있기만하면 찾는다 %는있어도되고 없어도됨

SELECT
    *
FROM
    employee
WHERE
    emp_name LIKE '전__';
--전이 맨 앞자리에 오고 뒤에 두글자가 반드시 있어야된다

--quiz
--1 모든 직원중에 전화번호의 처음 3자리가 010 아닌 직원의 이름과 전화번호를 출력해보세요

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
--2 모든 직원 중에서 이름에 '이' 자가 들어가는 사람을 모두 찾아 이름을 출력해보세요

SELECT
    emp_name
FROM
    employee
WHERE
    emp_name LIKE '%이%';
--3. 모든 직원 중에서 
    --부서코드가 D9 또는 D6이고
    --월급이 270만원 이상이며
    --email에 알파벳 s가 포함되어있고
    --고용일이 2001년 1월 1일부터 2005년 12월 31일 사이인 직원의
    --이름 ,부서코드 ,급여 ,email,고용일을 출력해보세요

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
    --1. 직속상사 (manager_id)가 없고 부서 (dept_code) 배치도 받지 않은 직원의 사번 및 이름을 출력

SELECT
    emp_name,
    emp_id
FROM
    employee
WHERE
        manager_id IS NULL
    AND
        dept_code IS NULL;
    --2. 부서 배치를 받지 않았지만 보너스는 지급되는 직원의 부서코드 ,이름 및 보너스를 출력

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
-- order by : 쿼리 실행 결과에서 특정 조건을 이용하여 데이터를 정렬하는 문법
--줄세우다 (기본)asc : 올림차순 desc : 내림차순

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

--문제1
--근속년수 5년이상 ,10년 이하인 직원의 이름 주민번호 급여 입사일을 검색하세요

SELECT
    emp_name,
    emp_no,
    salary,
    hire_date
FROM
    employee
WHERE
    floor( (SYSDATE - hire_date) / 365) BETWEEN 5 AND 10;
--문제2
--재직중이 아닌 직원의 이름 ,부서 코드를 검색하세요 (퇴사여부 ENT_YN)

SELECT
    emp_name,
    dept_code
FROM
    employee
WHERE
    ent_yn = 'Y';
--문제3
--근속년수가 10년이상인 직원들을 검색하여
--출력 결과는 이름 ,급여 ,근속년수(소수점 x)를 근속년수가 오름차순으로 정렬하여 출력하세요
--단 급여는 50% 인상된 급여로 출력되도록 하세요

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

--문제4
--입사일이 99/01/01~10/01/01 인 사람중에서 급여가 2000000원 이하인 사람의
--이름 ,주민번호 ,이메일 ,폰번호 ,급여를 검색하세요

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
--문제5
--급여가 2000000~3000000원 인 여직원중에서 4월 생일자를 검색하여
--이름 ,주민번호 ,급여,부서코드를 주민번호 순으로 내림차순으로 출력
--단 부서코드가 null 인 사람은 부서코드가 없음으로 출력하세요  <--x

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
--문제6
--남자 사원 중 보너스가 없는 사원의 오늘까지 근무일을 측정하여
--1000일 마다(소수점제외)
--급여의 10% 보너스를 계산하여 이름,특별보너스 (계산금액) 결과를 출력하세요
--단 이름 순으로 오름 차순 정렬하여 출력하세요

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
--where true면 동작함


-- select 컬럼명 from 테이블명;
-- where 절 - 데이터 조건부
-- between and ,like (% ,_ ) ,is null ,not ,in ,and ,or ,> ,< ,=
-- 문자열 ''
-- order by - 정렬

-----------------------------------------------------
 -- function () == method () 
 -- 자바에서는 메써드 오라클은 펑션
 -- nvl (검사데이터 ,검사데이터가 null일때 치환 될 값 )
 -- nvl(타켓 데이터 ,리턴값 ) :

SELECT
    emp_name,
    nvl(dept_code,'없음')
FROM
    employee;
 
 --length() : 특정 데이터의 길이를 측정하여 반환

SELECT
    length('Hello')
FROM
    dual;

SELECT
    length('한글')
FROM
    dual;
--lengthb() : 특정 데이터의 byte를 측정하여 반환

SELECT
    lengthb('Hello')
FROM
    dual;

SELECT
    lengthb('한 글')
FROM
    dual;
--오라클에서는 한글자가 3바이트임 띄어쓰기는 1바이트

--instr() : 문자열 안에서 특정 문자의 위치 값을 찾는 함수(java의 indexof)

SELECT
    instr(
        'Hello World Hi High',
        'H',
        2,
        2
    )
FROM
    dual;
--'Hello World Hi High' 문자열 안에서 H를 검색하되 1번 글자에서부터 오른쪽으로 검색해가며 1번으로 만나는 H의 위치

-- substr() : 문자열 내에서 지정한 위치의 문자열을 잘라내어 반환하는 함수

SELECT
    substr('Hello World Hi High',7,5)
FROM
    dual;

SELECT
    substr('안녕 세계 안녕 높이',7,5)
FROM
    dual;

--quiz
--1. 직원 명단에서 이름의 성만 추출하여 출력해봅시다

SELECT DISTINCT
    substr(emp_name,1,1)
FROM
    employee
ORDER BY 1;
--distinct 중복 제거

SELECT
    *
FROM
    employee;
--2. 직원 명단에서 사원번호 ,사원명 ,주민번호 ,연봉을 출력하세요
-- 단 주민번호 뒷 6자리는 *기호로 출력하세요
-- 남자직원의 정보만 출력해보세요 (like 사용하지 말것 )

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
--abs() : 값의 절대값을 반환하는 함수

SELECT
    abs(2)
FROM
    dual;

SELECT
    abs(-2)
FROM
    dual;

--mod() : JAVA의 % 연산자 - > 나머지 연산 함수

SELECT
    mod(10,3)
FROM
    dual;

SELECT
    mod(10,4)
FROM
    dual;

-- round() : 반올림 함수 

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

--floor() : 소수점 버림함수 

-- trunc() : 특정 위치에서 버림함수

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

--ceil () : 올림 함수

SELECT
    ceil(126.456)
FROM
    dual;  --소수점 첫쨰 자리에서 올림

SELECT
    ceil(123.456 * 10) / 10
FROM
    dual; --소수점 둘쨰 자리에서 올림

SELECT
    ceil(123.456 * 100) / 100
FROM
    dual; --소수점 셋쨰 자리에서 올림
------------------------------------------------------------
--sysdate : 조회하는 순간의 시간 값을 Date타입으로 반환

SELECT
    SYSDATE
FROM
    dual;
--sysdate = 자바의 timestamp 초 값 계산

--months_between : 두 날짜 사이의 개월 수를 반환 하는 함수

SELECT
    emp_name,
    floor(months_between(SYSDATE,hire_date) ) 근속개월수
FROM
    employee;

--add months : 특정 날짜에 개월수를 더하는 함수

SELECT
    add_months(SYSDATE,1)
FROM
    dual;

--next_day : 지정날짜를 기준으로 가장 가까운 요일 date값을 반환

SELECT
    SYSDATE,
    next_day(SYSDATE,'수요일')
FROM
    dual;

--last_day : 지정날짜가 속한 달의 마지막 날 date값을 반환

SELECT
    last_day(SYSDATE)
FROM
    dual;

--quiz
-- 다음달 마지막 날짜는 며칠일까요?

SELECT
    last_day(add_months(SYSDATE,1) )
FROM
    dual;

SELECT
    last_day(add_months(SYSDATE,-1) )
FROM
    dual;

-- extract : 날짜 값으로부터 연,월,일을 추출하는 함수

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
--1. 사번,사원명,입사년도 (0000년)형식으로 출력해보세요

SELECT
    *
FROM
    employee;

SELECT
    emp_id,
    emp_name,
    EXTRACT(YEAR FROM hire_date)
     || '년' 입사연도
FROM
    employee;

--2. employee 테이블에서 사원의 이름 ,hire_date,년차를 출력해보세요
--년차 출력은 소수점 일경우 올림으로 하여 출력해보세요(28.144-> 29년차)
--(출력시 정렬은 입사일 기준으로 올림차순)

SELECT
    emp_name,
    hire_date,
    ceil( ( (SYSDATE - hire_date) / 365) ) 년차
FROM
    employee
ORDER BY hire_date ASC;

--------------------------------------------------------------

-- to_char() : 날짜값 또는 숫자값을 문자열로 변환하는 함수

-- D : 이번주에 몇번쨰 날 ,DD: 이번달에 몇번쨰 날 ,DDD: 올해의 몇번째 날 

SELECT
    TO_CHAR(SYSDATE,'YYYY"년" MM"월" DD"일" (DY) Day HH24:MI:SS')
FROM
    dual;

SELECT
    TO_CHAR(SYSDATE,'YYYY')
FROM
    dual;
--quiz
--사원명 ,고용일 (1990/02/06(화)) 형태로 출력

SELECT
    emp_name,
    TO_CHAR(hire_date,'YYYY/ MM / DD (DY)')
FROM
    employee;

SELECT
    TO_CHAR(1000000,'L999,999,999')
FROM
    dual;
--숫자 표현은 9로 표시

--to_date() : 문자열을 날짜형으로 변환

SELECT
    TO_DATE('20180208','YYYYMMDD') - 10
FROM
    dual;
--날짜라서 -10 가능 ,문자열이면 계산만 가능 
--출력이 아니고 분석

--quiz
--1945년 8월 15일의 요일은?

SELECT
    TO_CHAR(
        TO_DATE('19450815','YYYYMMDD'),
        'DY'
    ) 광복절요일
FROM
    dual;

SELECT
    TO_DATE('19450815','YYYYMMDD')
FROM
    dual;
--------------------------------------------------------
--decode() : 값에 따른 분기점을 만드는 함수 (자바의 삼항연산자 ,switch)

SELECT
    DECODE(
        'ㅁ',
        'Apple',
        '사과',
        'Orange',
        '오렌지',
        '포도'
    )
FROM
    dual;
--ㅁ칸이 애플이면 애플을 리턴한다 오렌지면 오렌지로 리턴한다
--포도는 else 

SELECT
    *
FROM
    employee;
--quiz
--사원 번호 ,사원명 ,성별 (남 여 ) 형태로 출력해보세요

SELECT
    emp_id,
    emp_name,
    DECODE(
        substr(emp_no,8,1),
        '1',
        '남',
        '2',
        '여'
    ) 성별
FROM
    employee;
----------------------------------------------------------
--case: 조건식에 따른 반환값 분기점 생성 함수

SELECT
    emp_id,
    emp_name,
        CASE
            WHEN substr(emp_no,8,1) = '1' THEN '남'
            WHEN substr(emp_no,8,1) = '2' THEN '여'
            ELSE '?'
        END
    "성별"
FROM
    employee;

--quiz
--1. 60년대 생 직원들 중에서 60~64년 미만의 직원들은 '60년생 초반' 이라고 출력
--               65~69년 까지의 직원들은 '60년생 후반' 이라고 출력
--  사번,이름 ,60년생 초/후반

SELECT
    emp_id,
    emp_name,
        CASE
            WHEN substr(emp_no,1,2) < 65  THEN '60년생 초반'
            WHEN substr(emp_no,1,2) >= 65 THEN '60년생 후반'
        END
    "나이대"
FROM
    employee
WHERE
    substr(emp_no,1,2) BETWEEN 60 AND 69;

SELECT
    length(email)
FROM
    employee;
-- 여기까지는 모두 단일행 함수
--------------------------------------------------------
--그룹 함수 ( SUM,AVG,COUNT,MAX ,MIN )


-- 이 회사의 한달 인건비는 얼마인가?
--sum : 합계함수

SELECT
    emp_name,
    SUM(salary)
FROM
    employee;
--그룹 함수가 출력했을떄는 옆에 다른 함수가 올수 없다 

--AVG :(평균함수)

SELECT
    AVG(salary)
FROM
    employee;

--COUNT : 행의 개수 반환하는 함수

SELECT
    COUNT(emp_id)
FROM
    employee;

SELECT
    COUNT(*)
FROM
    employee;
--null값은 카운팅이 안됨                                                   

--MAX : 전체 행에서 가장 큰값을 반환하는 함수

SELECT
    MAX(salary)
FROM
    employee;

--MIN : 전체 행에서 가장 작은 값을 반환하는 함수

SELECT
    MIN(salary),
    MAX(salary)
FROM
    employee;
--그룹끼리는 그룹함수 가능

SELECT
    *
FROM
    employee;
--quiz

--1. D5부서 급여 평균

SELECT
    AVG(salary)
FROM
    employee
WHERE
    ( dept_code ) = 'D5';

--2. 남직원들의 급여 합계

SELECT
    SUM(salary)
FROM
    employee
WHERE
    substr(emp_no,8,1) = 1;

----------------------------------------------------quiz

--1. 직원명과 이메일 ,이메일 길이를 출력하세요
--        이름       이메일      이메일길이
--   ex)    홍길동 ,hong@kh.or.kr        13
--

SELECT
    emp_name 직원명,
    email,
    length(email) 이메일길이
FROM
    employee;

--2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하세요
--   ex) 노옹철   no_hc
--   ex) 정중하   jung_jh
--

SELECT
    emp_name 직원명,
    substr(
        email,
        1,
        instr(email,'@',1) - 1
    )
FROM
    employee;


--3. 60년생의 직원명과 년생,보너스 율을 출력하세요
--   그때 보너스 값이 null인 경우에는 0% 이라고 출력 되게 만드세요
--       직원명    년생     보너스
--   ex) 선동일     62       30%
--   ex) 송은희     63       0%
--

SELECT
    emp_name 직원명,
    substr(emp_no,1,2) 년생,
    bonus * 10 || '0%' AS 보너스
FROM
    employee
WHERE
    substr(emp_no,1,2) BETWEEN 60 AND 69;

--4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하세요 (뒤에 단위는 명을 붙이세요)
--      인원
--   ex) 3명
--

SELECT
    COUNT(phone)
     || '명' AS "010 아닌사람"
FROM
    employee
WHERE
    phone NOT LIKE '010%';

--5. 직원명과 입사년월을 출력하세요 
--   단,아래와 같이 출력되도록 만들어 보세요
--       직원명         입사년월
--   ex) 전형돈      2012년12월
--   ex) 전지연      1997년 3월
--

SELECT
    emp_name "직원명",
    TO_CHAR(hire_date,'YYYY"년" MM"월"') "입사년월"
FROM
    employee;

--6. 직원명과 주민번호를 조회하세요
--   단,주민번호 9번째 자리부터 끝까지는 '*' 문자로 채워서 출력 하세요
--   ex) 홍길동 771120-1******
--

SELECT
    emp_name "직원명",
    substr(emp_no,1,8)
     || '******' "주민번호"
FROM
    employee;

--7. 직원명,직급코드,연봉(원)을 조회하세요.
--  단,연봉은 ￦57,000,000 으로 표시되게 함 (현지 통화 ￦가 적용 되어야 함)
--     연봉은 보너스포인트가 적용된 1년치 급여임
--

SELECT
    emp_name "직원명",
    job_code "직급코드",
    '￦'
     || TO_CHAR(
        ( (salary * 12) + (salary * nvl(bonus,1) ) ),
        '999,999,999'
    )
     || '(원)' AS "연봉(원)"
FROM
    employee;



--8. 부서코드가 D5,D9인 직원들 중에서 2004년도에 입사한 직원의 
--   [ 사번 사원명 부서코드 입사일 ] 을 조회하세요
--

SELECT
    emp_id "사번",
    emp_name "사원명",
    dept_code "부서코드",
    hire_date "입사일"
FROM
    employee
WHERE
        dept_code IN (
            'D5','D9'
        )
    AND
        substr(hire_date,1,2) = '04';

--9. 직원명,입사일,오늘까지의 근무일수 조회하세요. 
--   * 주말도 포함 ,소수점 아래는 버림
--

SELECT
    emp_name "직원명",
    hire_date "입사일",
    floor(SYSDATE - hire_date)
     || '일' AS "근무일수"
FROM
    employee;


--10. 모든 직원의 나이 중 가장 많은 나이와 가장 적은 나이를 출력 하세요. (나이만 출력)
-- 

SELECT
    MAX(100 - substr(emp_no,1,2) + substr(SYSDATE,1,2) + 1) "최고령자",
    MIN(100 - substr(emp_no,1,2) + substr(SYSDATE,1,2) + 1) "막내"
FROM
    employee;

--11.  회사에서 야근을 해야 되는 부서를 발표하여야 합니다.
-- 부서코드가 D5,D6,D9  야근,그외는 야근없음 으로 출력되도록 하세요
-- 출력 값은 이름,부서코드,야근유무 (부서코드 기준 오름차순 정렬함.)
--   (부서코드가 null인 사람도 야근없음 임)

SELECT
    emp_name "직원명",
    nvl(dept_code,'부서 없음') "부서코드",
        CASE
            WHEN dept_code IN (
                'D5','D6','D9'
            ) THEN '야근'
            ELSE '야근없음'
        END
    "야근 유무"
FROM
    employee;



------------------------------------------------------day3

-- group by : 그룹화된 데이터에 대한 정보를 다루는 문법
-- order by 는 무조건 제일 마지막
-- group by - 전체 데이터들 중 특정 데이터별로 데이터 분류,그룹화된 데이터 및 분류기준은
-- 출력가능하지만 그외 데이터는 출력 불가능  

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
    
    -- 부서코드별로 정렬

SELECT
    dept_code,
    SUM(salary)
FROM
    employee
GROUP BY
    dept_code
ORDER BY dept_code;
    
    -- from --> where > groub by > having > select > order by 순으로 실행
    
---------------------------------- quiz

SELECT
    *
FROM
    employee;
--1. 직급별 급여 평균을 출력해주세요. null값은 intertn,직급별 오름차순으로 정렬

SELECT
    nvl(job_code,'intern') "직급",
    TO_CHAR(
        floor(AVG(salary) ),
        'L999,999,999'
    )
     || '원' AS "급여 평균"
FROM
    employee
GROUP BY
    job_code
ORDER BY 직급;
    
    
-- group by 는 그룹시킬 기준만 있으면 가능

SELECT
    DECODE(
        substr(emp_no,8,1),
        1,
        '남',
        2,
        '여'
    )
FROM
    employee
GROUP BY
    DECODE(
        substr(emp_no,8,1),
        1,
        '남',
        2,
        '여'
    ); 


------------------------------ quiz
--성별별 인원수 출력

SELECT
    DECODE(
        substr(emp_no,8,1),
        1,
        '남',
        2,
        '여'
    ),
    COUNT(*) "인원수"
FROM
    employee
GROUP BY
    DECODE(
        substr(emp_no,8,1),
        1,
        '남',
        2,
        '여'
    ); 
    
    
    ----------------------- 
    --선동일,송종기,노옹철 세사람을 제외한 모든 직원을 대상으로 성별별 급여 평균을 출력하세요.

SELECT
    *
FROM
    employee;

SELECT
        CASE
            WHEN substr(emp_no,8,1) = 1 THEN '남'
            WHEN substr(emp_no,8,1) = 2 THEN '여'
        END
    "성별",
    TO_CHAR(
        floor(AVG(salary) ),
        'L999,999,999'
    ) "급여 평균"
FROM
    employee
WHERE
    emp_id BETWEEN '203' AND '222'
GROUP BY
    substr(emp_no,8,1);
    
    
    -- 나이대별 급여 평균

SELECT
        CASE
            WHEN substr(emp_no,1,1) = 6 THEN '60년대생'
            WHEN substr(emp_no,1,1) = 7 THEN '70년대생'
            WHEN substr(emp_no,1,1) = 8 THEN '80년대생'
        END
    "나이대",
    TO_CHAR(
        round(
            floor(AVG(salary) ),
            -5
        ),
        'L999,999,999'
    ) "급여 평균"
FROM
    employee
GROUP BY
    substr(emp_no,1,1);
                            ------------
SELECT
    substr(emp_no,1,1)
     || '0년대생' "나이대",
    TO_CHAR(
        round(
            floor(AVG(salary) ),
            -5
        ),
        'L999,999,999'
    ) "급여 평균"
FROM
    employee
GROUP BY
    substr(emp_no,1,1);
    
    
    
    
----------------------- 
-- group by 정렬 조건 중복가능

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
    -- 직급별 인원수 파악
    
---------------------------------------------- quiz

select
    nvl (dept_code,'intern' )"부서",
    DECODE(substr(emp_no,8,1),1,'남', 2,'여') "성별 ",
    count(*)||'명' "인원수"
from
    employee
group by dept_code, DECODE(substr(emp_no,8,1),1,'남', 2,'여')
order by 1,2;
    -- 부서 내 성별별 인원수 파악
    
    
--부서별 급여 평균이 300만원 이상인 부서의 부서코드 및 급여 평균을 출력하세요

-- group by 로 그룹화 된 데이터의 조건을 비교할 떄에는 having 절 사용

select
    dept_code "부서코드",
    TO_CHAR(floor(AVG(salary)),'L999,999,999') "급여 평균"
from
    employee
group by dept_code
having avg(salary) > 3000000; -- group by 로 그룹화 된 이후의 급여평균을 의미.

    

-------------------------------quiz

--1. 인원이 3명 미만인 직급코드의 인원을 충원하려고 함.
-- 인원이 3명 미만인 직급코드에 대하여 직급코드와 인원수 출력
select
    job_code "직급",
    count(*) "인원 수"
from
    employee
group by job_code
having count(*) <3;
    -- 직급별 인원수 파악
    








-------------------------------------------------
-------------------------------------------------
--day 04
-- join :하나 이상의 테이블로부터 특정 조건을 충족하는 데이터를 ㅜ치합하여 결과를 생성하는 문법
-- 실행순서는 from에 해당한다.

select * from departmnt;
select * from job;

-- ANSI 표준문     : 범용적임.
select * from department cross join job;
select * from department inner join departmenr on dept_code= dept_id ;

-- Oracle 전용문   :   
select * from department, job; 
--join 종류 중 = 크로스 조인(cross join : cartessian product를 만든다)


-- Join ; Inner Join에 참가한 여러 테이블 정보에서 특정 조건을 만족하는 레코드만을 출력
select emp_id, emp_name, dept_title from employee, department
where dept_code= dept_id;



select emp_id, emp_name, e.job_code, job_name 
from employee e
inner join job on e.job_code = job.job_code
where job.job_name = '과장';



select emp_id, emp_name, job_code, job_name 
from employee
inner join job using (job_code)
where job_name = '과장';
--using 사용시 별칭 사용 불가능




-----------------------------------------------------------
--quiz
--1. 기술지원부에 속한 사람들의 이름, 부서코드, 급여를 출력하세요
select emp_name, dept_code, salary, dept_title
from employee
inner join department on dept_title = '기술지원부';

select * from department;

--2. 해외영업n부 직원들의 사번, 사원명, 부서명, 연봉을 출력해보세요.
select emp_id, emp_name, dept_title, (salary*12)
from employee
inner join department on dept_title like '해외%';



-----------------------------
--outer join : join에 참여하는 두 테이블에서 한쪽 테이블의 모든 행을강제 출력하게
--만드는 문법 / inner join에서 inner 생략가능

select
nvl(emp_name,'배정인원 없음'), nvl(dept_code, '부서코드없음'), nvl(dept_title,'부서명없음')
from
employee full outer join department on dept_code = dept_id
order by 2;
-- null값을 가진 사람들 또한 출력하기위해서 full 사용
-- left, right, full 은 outer join 에서만 쓰기때문에 full,right,left join처럼 outer 생략가능

-------------------------------
--self join : 같은 테이블은 join 하는 문법

SELECT * FROM job j1 cross join job j2;

select emp_id, emp_name, manager_id from employee;
-- 직속상관이 번호로 표기되기 때문에 일일히 확인해야함.

select e1.emp_id, e1.emp_name, e1.manager_id, e2.emp_name
from employee e1
join employee e2 on e1.manager_id = e2.emp_id
    order by 1;


--------------------------------
--1. 하이유와 같은 부서에서 일하는 직원들의 이름 부서코드 직급코드 출력

select * from employee;

select e2.emp_name, e2.dept_code, e2.job_code
from employee e1 
     join employee e2 on e1.dept_code = e2.dept_code
where e1.emp_name = '하이유'     ;


--------------------------
--다중 join : 3개 이상의 테이블을 join 하여 유의미한 데이터를 생성하는 작업

-- 직원명, 부서명, 직급명을 출력해주세요
select e.emp_name, d.dept_title, j.job_name
from employee e
left join department d on e.dept_code = d.dept_id
join job j on e.job_code = j.job_code
order by e.job_code;
-- 다중join 

---------------------------------------- quiz




-- 1. 사원명, 부서명, 근무지역(National_Code) 를 출력하세요
SELECT * FROM employee;
select * from department;

select e.emp_name, d.dept_title, n.national_name
from employee e
left join department d on e.dept_code = d.dept_id
join location l on d.location_id = l.local_code
join national n on l.national_code =n.NATIONAL_CODE 
order by e.dept_code;


-- 1. 2020년 12월 25일이 무슨 요일인지 조회하세요.

SELECT
    TO_CHAR(
        TO_DATE('20201225','YYYYMMDD'),
        'day'
    ) 날짜
FROM
    dual;

-- 2. 주민번호가 1970년대 생이면서 성별이 여자이고,
--  성이 전씨인 직원들의 사원명,주민번호,부서명,직급명을 조회하세요.

SELECT
    emp_name 사원명,
    emp_no 주민번호,
    dept_title 부서명,
    job_name 직급명
FROM
    employee e
    JOIN department d ON e.dept_code = d.dept_id
    JOIN job j USING ( job_code )
WHERE
        substr(emp_no,1,1) = 7
    AND
        substr(emp_no,8,1) = 2
    AND
        substr(emp_name,1,1) = '전';
   
 
-- 3. 이름에 "형"자가 들어가는 직원들의 사번,사원명,부서명을 조회하세요.

SELECT
    emp_id 사번,
    emp_name 사원명,
    dept_title 부서명
FROM
    employee
    JOIN department ON dept_code = dept_id
WHERE
    substr(emp_name,1,3) LIKE '%형%';


-- 4. 부서별 급여 평균이 300만원 이하인 부서의 부서명과 급여 평균을 출력하세요
-- > 급여 평균은 10000의 자리 아래로 버리고 출력해주세요. 
-- > 또한 한국 로컬 통화 표기법으로 출력해주세요. (￦3,520,000)

SELECT
    d.dept_title "부서명",
    TO_CHAR(
        trunc(
            floor(AVG(e.salary) ),
            -4
        ),
        'L999,999,999'
    ) "급여 평균"
FROM
    employee e
    JOIN department d ON e.dept_code = d.dept_id
GROUP BY
    e.dept_code,
    d.dept_title
HAVING
    AVG(salary) <= 3000000;

-- 5. 해외영업부에 근무하는 사원명,직급명,부서코드,부서명을 조회하세요.

SELECT
    e.emp_name 사원명,
    j.job_name 직급명,
    e.dept_code 부서코드,
    d.dept_title 부서명
FROM
    employee e
    JOIN job j ON e.job_code = j.job_code
    INNER JOIN department d ON d.dept_title LIKE '해외%';

-- 6. 보너스포인트를 받는 직원들의 사원명,보너스포인트,부서명,근무지역명을 조회하세요.

SELECT
    e.emp_name 사원명,
    e.bonus 보너스포인트,
    d.dept_title 부서명,
    n.national_name 근무지역명
FROM
    employee e
    FULL JOIN department d ON e.dept_code = d.dept_id
    JOIN location l ON d.location_id = l.local_code
    JOIN national n ON l.national_code = n.national_code
WHERE
    e.bonus IS NOT NULL;

-- 7. 부서코드가 D2인 직원들의 사원명,직급명,부서명,근무지역명을 조회하세요.

SELECT
    e.emp_name 사원명,
    j.job_name 직급명,
    d.dept_title 부서명,
    n.national_name 근무지역명
FROM
    employee e
    JOIN job j ON e.job_code = j.job_code
    FULL JOIN department d ON e.dept_code = d.dept_id
    JOIN location l ON d.location_id = l.local_code
    JOIN national n ON l.national_code = n.national_code
WHERE
    e.dept_code = 'D2';
   
-- 8. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명,부서명,근무지역명,국가명을 조회하세요.

SELECT
    e.emp_name 사원명,
    d.dept_title 부서명,
    l.local_name 근무지역명,
    n.national_name 국가명
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

-- 9. 모든 사원 중 선동일을 매니저로 두고 있는 직원의 이름,직원의 부서명,매니저의 이름을 출력하세요.

SELECT
    e1.emp_name 사원명,
    d.dept_title 부서명,
    e2.emp_name 매니저명
FROM
    employee e1
    INNER JOIN department d ON e1.dept_code = d.dept_id
    INNER JOIN employee e2 ON e1.manager_id = e2.emp_id
WHERE
    e2.emp_name = '선동일'; 

-- 10. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명,직급명,급여를 조회하세요 (join과 in 사용)

SELECT
    e.emp_name 사원명,
    j.job_name 직급명,
    e.salary 급여
FROM
    employee e
    JOIN job j ON e.job_code = j.job_code
    INNER JOIN department d ON e.dept_code = d.dept_id
WHERE
        job_name IN (
            '차장','사원'
        )
    AND
        bonus IS NULL;

-- 11. 재직중인 직원과 퇴사한 직원의 수를 조회하세요.

SELECT
    DECODE(
        ent_yn,
        'Y',
        '퇴사',
        '재직중'
    ) AS "퇴사유무",
    COUNT(*) "직원 수"
FROM
    employee
GROUP BY
    ent_yn;
    
    
    
    
    ---------------------------------------------------------------------
    ------------------------------------------------------------------day5
    
    
    --union
    
    
--    union : 두 테이블간에 합집하이며 그중 중복된 행은 1회만 출력한다. 
    
--    union all : 두 테이블간의 중복을 허용하는 합집합.
    
    
--    interscept : 두 테이블간의 교집합

--  minus : 두 테이블간의 차집합.
    
    
    
    -------------------------------------------
    ---------------------------------------------
    --subQuerry : 쿼리 안에 쿼리 
-- 단일행 단일열    
-- 다중행
-- 다중열
-- 다중행 다중열
-- inline view
--
select emp_name from employee where emp_id = 
(select manager_id from employee where emp_name='전지연');

--쿼리 내부에 쿼리가 존재하는 경우. 


--------------------------------qiuz
--윤은해직원의 급여와 동일한급여를 받는 직원의 이름 및 급여 출력
select salary from employee where emp_name = '윤은해';
select emp_name, salary from employee where salary = 
(select salary from employee where emp_name = '윤은해')
and emp_name != '윤은해';


--2. 전직원 급여 편균보다 급여를 많이 받는 직원의 이름 직급코드 금여를 출력

select avg(salary) from employee;
select emp_name, job_code, salary from employee 
where (select avg(salary) from employee) < salary ;

--d1 d2 부서 직우너중 d5급여 평균보다 많이받는 직원들의 부서번호 사번 사원명 출력
select avg(salary) from employee where(dept_code = 'D5');
select dept_code, dept_code, emp_name from employee
where (select avg(salary) from employee where(dept_code = 'D5')) < salary
and dept_code in('D1','D2');

--급여가 제일 많은사람과 제일 적은사람의 사번 사원 급여
select max(salary) , min(salary) from employee;
select emp_id, salary from employee 
where (select max(salary) , min (salary) from employee);

--박나라 송중기 직원의 부서코드와 동일한 부서에속한 직원
select * from employee
where dept_code in (select dept_code from employee where emp_name in ('송종기','박나라'));


--
--1. 차태연 또는 전지연 직원의 급여등급과 같은 등급의 직원 직급명 사원명 출력
select sal_level from employee where emp_name in ('차태연','전지연');

select e.emp_name, j.job_name
from employee e
join job j on j.job_code = e.job_code
where sal_level in 
(select sal_level from employee where emp_name in ('차태연','전지연'));


--2. 직급이 대표, 부사장이아닌 모든 직원의 사원명, 직급코드 
select job_code from job
where JOB_name in ('대표','부사장');

select emp_name, job_code
from employee 
where job_code not in (select job_code from job where JOB_name in ('대표','부사장'));



-- D5부서에 근무하는 직원들의 급여보다 많이받는 직원의 정보 출력
select emp_name, salary from employee
 where salary > any(select salary from employee where dept_code ='D5'); 
 --any() = ()중 아무거나 보다 크기만 하다면
 select emp_name, salary from employee
 where salary > (select min(salary) from employee where dept_code ='D5'); 
 --any 를 사용할 시 ()내부절에 min 을 붙인것과 동일
 
 select emp_name, salary from employee
 where salary > all(select salary from employee where dept_code ='D5'); 
 --all 을 사용할 시 ()내부 데이터의 모든 결과들보다 큰것. 
  select emp_name, salary from employee
 where salary > (select max(salary) from employee where dept_code ='D5'); 
 --all 은 최댓값보다 큰 것.
 
 
 
 -------------------------------------------
 ---------------------------------------------
 
--다중열 서브쿼리 
select dept_code, job_code from employee where ent_yn ='Y';

select emp_name, dept_code, job_code from employee
where (dept_code, job_code) = (select dept_code, job_code from employee where ent_yn ='Y');

--다중행 다중열의 경우 다중열과 문법이 동일하다. 
--소괄호 를 사용하여 비교군을 묶어준 경우에 다중열 서브쿼리 비교가 가능하다.


--다중열 서브쿼리에서는 <,> any 또는 all 사용 불가능.
--단, = 기호에 대해서는 any 는 사용 할 수 있다.(all 은 불가능)



-----------------------------------
-- 생일이 0808인 사원들과 같은 부서코드, 같은 직급코드인 직원들의 사원명과 생일을 출력
-- 생일이 0808인 직원은 출력제외
select dept_code, job_code from employee where substr(emp_no,3,4)='0808';

select emp_name, substr(emp_no,3,4) "생일" from employee
where (dept_code,job_code)in(select dept_code, job_code from employee 
where substr(emp_no,3,4)='0808')
and substr(emp_no,3,4)!='0808';

-- 부서별 급여를 가장 많이 받는 직원의 부서코드, 직원이름 및 급여 출력. 부서코드로 정렬.

select dept_code, emp_name, salary from employee
where(dept_code, salary) in (select dept_code, max(salary) from employee
group by dept_code )order by 1;


--------------------------------------
--SubQuery를 사용하는 또다른 유형 / select 편

select dept_title from department;
select emp_name, (select dept_title from department where dept_code = dept_id) 
from employee;

--직원명과 직급명을 출력하세요, 단 subquery로
select job_name from job;
select emp_name, (select job_name from job j where e.job_code = j.job_code) from employee e;

-----------------------------------------------
--rank 관련 함수
--동일 등수가 동일한 숫자로 나타남
select emp_name, salary, rank() over(order by salary desc) from employee;
--순위가 전체적으로 나타남
select emp_name, salary, dense_rank() over(order by salary desc) from employee;

select emp_name, salary, row_number() over(order by salary desc) from employee;

-------------------------quiz

--1.급여 내림차순으로 10위부터 15위 까지만 

select emp_name, salary, rank() over(order by salary desc) "급여 랭킹" 
from employee
where "급여 랭킹" > 9 and "급여 랭킹" < 16;

select * from (select emp_name, salary, rank() over(order by salary desc) "급여 랭킹" 
from employee) where "급여 랭킹" > 9 and "급여 랭킹" < 16;
 

-------------------------------------------------------------------------
-------------------------------------------------------------------------

--1. 기술지원부에 속한 사람들의 사람의 이름,부서코드,급여를 출력하시오
--
select e.emp_name, e.dept_code, e.salary 
from employee e
join department d on e.dept_code = d.dept_id
where d.dept_title = '기술지원부';

--2. 기술지원부에 속한 사람들 중 가장 연봉이 높은 사람의 이름,부서코드,급여를 출력하시오
--

--3. 매니저가 있는 사원중에 월급이 전체사원 평균을 넘고 사번,이름,매니저 이름,월급(만원단위부터)을 구하시오.
--단, JOIN을 이용하시오
--
--4. 각 직급마다 급여 등급이 가장 높은 직원의 이름, 직급코드, 급여, 급여등급 조회
--
--5. 가장 보너스를 많이 받는 순으로 사원들을 뽑았을때 4~8위의 순위, 사원명, 급여, 보너스율을 출력
--
--6. 부서별 평균 급여가 2200000 이상인 부서명, 평균 급여 조회 단, 평균 급여는 소수점 버림
--
--7. 직급의 연봉 평균보다 적게 받는 여자사원의 사원명,직급코드,부서코드,연봉을 이름 오름차순으로 조회하시오 연봉 계산 => (급여+(급여*보너스))*12






--------------------------------------------------------------------
--------------------------------------------------------------------

