CREATE DATABASE IF NOT EXISTS kyobo
  CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE kyobo;

CREATE TABLE IF NOT EXISTS board_post (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(200) NOT NULL,
  writer VARCHAR(50) NOT NULL,
  content TEXT NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO board_post (title, writer, content)
SELECT 'JDBC로 읽는 첫 글', 'admin', 'DAO가 SQL을 실행하고 Service가 흐름을 조정합니다.'
WHERE NOT EXISTS (SELECT 1 FROM board_post);
