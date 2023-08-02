# SpringBlog

이 프로젝트는 Spring Framework 기반의 프로젝트로 기본 게시판 기능을 구현하고있는 프로젝트 입니다.

## 디렉토리 구조
```bash
├── src                         # 소스 코드가 위치하는 디렉토리
│   ├── main                    # 메인 소스 코드가 위치하는 디렉토리
│   │   ├── java                # 자바 소스 코드가 위치하는 디렉토리
│   │   │   ├── comm.thesun4sky.springblog  # 기본 패키지 이름
│   │   │   │   ├── aop         # AOP 관련 클래스들이 위치하는 디렉토리
│   │   │   │   ├── config      # 스프링 설정 클래스들이 위치하는 디렉토리
│   │   │   │   ├── controller  # 컨트롤러 클래스들이 위치하는 디렉토리
│   │   │   │   ├── dto         # DTO(Data Transfer Object) 클래스들이 위치하는 디렉토리
│   │   │   │   ├── entity      # 엔티티 클래스들이 위치하는 디렉토리
│   │   │   │   ├── jwt         # JWT(Json Web Token) 관련 클래스들이 위치하는 디렉토리
│   │   │   │   ├── repository  # 레포지토리 클래스들이 위치하는 디렉토리
│   │   │   │   ├── security    # 보안 관련 클래스들이 위치하는 디렉토리
│   │   │   │   ├── service     # 서비스 클래스들이 위치하는 디렉토리
│   │   │   │   └── SpringBlogApplication.java  # 스프링 애플리케이션의 진입점인 메인 클래스
│   │   └── resources           # 리소스 파일들이 위치하는 디렉토리
│   └── test                    # 테스트 소스 코드가 위치하는 디렉토리
├── build.gradle               # Gradle 빌드 스크립트 파일
├── settings.gradle            # Gradle 설정 파일
└── README.md                  # 프로젝트에 대한 설명이 담긴 마크다운 파일

``` 

## ERD 
https://drawsql.app/teams/teasun/diagrams/springblog-2
![image](https://github.com/thesun4sky/spring-blog/assets/17782941/01d76040-bc98-43da-b5bb-e234703d2862)



## API 명세

### Lv.2 API 명세
https://documenter.getpostman.com/view/530494/2s9XxwutWU
![image](https://github.com/thesun4sky/spring-blog/assets/17782941/5836a61a-f78b-4979-a1fb-c1a3c58dc727)

### Lv.3 API 명세
https://documenter.getpostman.com/view/530494/2s9Xxwutam
![image](https://github.com/thesun4sky/spring-blog/assets/17782941/e5803118-b3dc-45cb-afca-6a166c425ae0)

### Lv.4 API 명세
https://documenter.getpostman.com/view/530494/2s9Xxwutan
![image](https://github.com/thesun4sky/spring-blog/assets/17782941/11654826-9417-4976-b447-018130da0f03)


## Spring Security 인증

<img width="1000" alt="image (10)" src="https://github.com/thesun4sky/spring-blog/assets/17782941/5e134760-8ac2-499e-8aea-f0d411bd0bd0">
