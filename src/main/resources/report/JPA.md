## 데이터베이스 dialect(방언)

- JPA는 특정 데이터베이스에 종속 X
- 각각의 데이터베이스가 제공하는 SQL 문법과 함수는 조금씩 다름
  - 기반 문자: MySql은 VARCHAR, Oracle은 VARCHAR2
  - 문자열을 자르는 함수 : SQL 표준은 SUBSTRING(), Oracle은 SUBSTR()
  - 페이징: MySQL은 LIMIT, Oracle은 ROWNUM
- dialect: SQL 표준을 지키지 않는 특정 데이터베이스만의 고유한 기능

JPA는 Dialect를 이용하여 데이터베이스 변경시에도 선택한 Dialect에 맞는 SQL 전문 생성



## JPA 구동 방식

1. Persistence 
2. 설정정보조회(META-INF/persistence.xml) 
3. EntityManagerFactory 
4. EntityManager 생성


