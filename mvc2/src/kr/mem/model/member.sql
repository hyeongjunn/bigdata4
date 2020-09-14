select * from EMPLOYEES;
-- 회원 가입에 필요한 테이블 

Drop table tblmem
Drop sequence seq_num;
CREATE table tblMem( --위도와 경도를 넣어주기
	num number primary key, --sequence
	name varchar2(20) not null,
	phone varchar2(20) not null,
	addr varchar2(50),
	lat number(16,12),
	lng number(16,12)
)

CREATE sequence seq_num;

INSERT INTO tblmem values (seq_num.nextval, --가데이터 집어넣기 
'김형준',
'010-8445-9116' ,
'광주광역시 서구 풍암동',
35.1257699845615,
126.852047602507)

select * from tblmem


