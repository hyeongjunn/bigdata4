select * from EMPLOYEES;
-- ȸ�� ���Կ� �ʿ��� ���̺� 

Drop table tblmem
Drop sequence seq_num;
CREATE table tblMem( --������ �浵�� �־��ֱ�
	num number primary key, --sequence
	name varchar2(20) not null,
	phone varchar2(20) not null,
	addr varchar2(50),
	lat number(16,12),
	lng number(16,12)
)

CREATE sequence seq_num;

INSERT INTO tblmem values (seq_num.nextval, --�������� ����ֱ� 
'������',
'010-8445-9116' ,
'���ֱ����� ���� ǳ�ϵ�',
35.1257699845615,
126.852047602507)

select * from tblmem


