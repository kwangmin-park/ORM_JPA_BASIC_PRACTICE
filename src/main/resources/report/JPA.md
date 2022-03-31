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

## 주의
- Entity Manager Factory 는 어플리케이션에서 하나만 생성하여 전체에 공유
- Entity Manager는 쓰레드간의 공유X(사용하고 버려야한다)
- JPA의 모든 데이터 변경은 트랜잭션 안에서 실행

## JPQL
- JPA를 사용하면 엔티티 객체를 중심으로 개발
- 문제는 검색 쿼리
- 검색을 할 때도 테이블이 아닌 엔티티 객체를 대상으로 검색
- 모든 DB 데이터를 객체로 변환해서 검색하는 것은 불가능
- 어플리케이션이 필요한 데이터만 DB에서 불러오려면 결국 검색 조건이 포함된 SQL이 필요



