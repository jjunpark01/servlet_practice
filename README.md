# Servlet / JDBC 게시판 실습

`custom_project_jdbc`를 참고한 단계별 실습용 뼈대입니다. 완성 코드는 넣지 않았습니다.

## 목표 구조

```text
src/main/java/com/kyobo/web/
├── config/      # DB 연결 설정
├── controller/  # Servlet: HTTP 요청과 응답
├── service/     # 입력 검증과 업무 흐름
├── dao/         # DB 접근 계약 및 JDBC 구현
└── model/       # 게시글 DTO
src/main/webapp/
├── WEB-INF/views/board/  # JSP 화면 (직접 URL 접근 차단)
└── assets/css/           # 정적 CSS
sql/                       # 로컬 DB 생성 스크립트
```

## 권장 실습 순서

1. `sql/schema.sql`을 읽고 MySQL에 데이터베이스와 테이블을 만든다.
2. `BoardPost`에 게시글 필드를 직접 작성한다.
3. `BoardPostDao`에 필요한 메서드 계약을 정의한다.
4. `ConnectionProvider`에서 환경 변수로 DB 연결을 구성한다.
5. `JdbcBoardPostDao`에 목록 조회부터 JDBC 코드를 작성한다.
6. `BoardService`로 검증을 분리하고 `BoardServlet`에서 요청을 연결한다.
7. `list.jsp`부터 화면을 작성하고, 등록·상세 화면을 확장한다.

## 실행 전 준비

- JDK 17 이상, MySQL, Tomcat 10.1 이상을 권장합니다.
- DB 연결값은 환경 변수 `BOARD_DB_URL`, `BOARD_DB_USER`, `BOARD_DB_PASSWORD`로만 설정합니다.
- `build.gradle`의 의존성 버전은 실습 시작 시점에 확인해 업데이트하세요.

## GitHub에 올리지 않을 것

- 비밀번호, API 키, 실제 DB URL이 들어간 `.env`, `db.properties`, IDE 실행 설정
- `.gradle/`, `build/`, `out/`, `logs/`, `work/`, `temp/`, `.smarttomcat/`
- 개인 IDE 설정인 `.idea/workspace.xml` 및 운영 서버 설정 파일

`sql/schema.sql`의 예제 데이터는 학습용 공개 데이터만 유지하세요. 실제 사용자 정보는 커밋하지 마세요.
