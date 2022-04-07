<h1 align="center">FOR FOUR PAW</h1>

### 목차

---

1. [프로젝트 소개](#프로젝트 소개)
2. [사용스택](#사용스택)
3. [Project Period](#Project Period)
4. [Contributors](#Contributors)
5. [프로젝트세팅](#프로젝트 세팅)
6. [ERD](#ERD)
7. [주요 기능](#주요 기능)
8. [주요 기술](#주요 기술)
9. [개발기록](#개발기록)





## 📖 프로젝트 소개

`For Four Paw`은 유기동물관련 웹 페이지입니다.

commit log: 싸피 외부 깃헙/깃랩 주소

🏠 j6e105.p.ssafy.io

📷 프로젝트 영상 : 영상주소

노션: https://sore-property-3e2.notion.site/For-Four-Paw-48c6686519e5478fbaf586b20ebc1de2



- 기획배경
  - FOR FOUR PAW (네 (동물의 발톱이 달린)발을 위해, 네 발 달린 동물을 위해서).
  - 코로나 시대로 반려동물과 함께 행복한 삶을 사는 가정이 많음.
  - 반려 동물을 기르는 가정은 늘어났지만 수명이 다할 때까지 옆을 지켜주는 가정은 단, 12%에 불가함.
  - 유기 동물 공고는 보통 2주 동안 올라옴. 2주가 지날 동안 분양되지 않는 유기 동물은 안락사가 됨.
  - 반려 동물을 계획없이 귀엽다는 이유로 분양을 결정하여 쉽게 버리고 있는 현 상황을 데이터 시각화로 보여줌.
  - 유기 동물들은 여전히 주인을 기다리고 있다는 것을 페이지를 통해 보여줌.

- 마스코트

  - ![포포](/exec/img/포포.png)

  - 이름 : 포포
  - 품좀 : 말티즈
  - 특징 : 유기견은 자신의 의사를 표현할 수 없으므로 입을 그리지 않음



### 사용스택

| 용도              | 스택                                                         | 버전               |
| ----------------- | ------------------------------------------------------------ | ------------------ |
| JS 편집           | <img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=plastic&logo=Visual Studio Code&logoColor=white"> | v1.64              |
| 서버 설계         | <img src="https://img.shields.io/badge/Spring-339933?style=plastic&logo=Spring&logoColor=white"> | sts-3.9.14.RELEASE |
| 배포서버          | <img src="https://img.shields.io/badge/Amazon AWS-232F3E?style=plastic&logo=Amazon%20AWS&logoColor=white"> |                    |
| DB                | <img src="https://img.shields.io/badge/MySQL-4169E1?style=plastic&logo=MySQL&logoColor=white"> | 5.7.x / 5.7.35     |
| 빅데이터 분산처리 | <img src="https://img.shields.io/badge/Apache Spark-E25A1C?style=plastic&logo=Apache%20Spark&logoColor=white"> | spark 3.1.3        |
| UI 개발           | <img src="https://img.shields.io/badge/Vue.js-4FC08D?style=plastic&logo=Vue.js&logoColor=white"> |                    |
| 형상관리          | <img src="https://img.shields.io/badge/git-F05032?style=plastic&logo=git&logoColor=white"> <img src="https://img.shields.io/badge/Jenkins-D24939?style=plastic&logo=Jenkins&logoColor=white"> <img src="https://img.shields.io/badge/Docker-2496ED?style=plastic&logo=Docker&logoColor=white"> |                    |





## **Project Period**

2022.02.21 - 2022.04.08 (6주)





## **Contributors**

| 팀원   | 역할                              | 비고           | 깃헙                              |
| ------ | --------------------------------- | -------------- | --------------------------------- |
| 정순일 | 팀장, 백엔드, Spark(Kmean)        | 실종 동물 매칭 | https://github.com/JUNGSOONIL     |
| 류기탁 | 백엔드, Spark(분석 서비스),DevOps | 데이터 시각화  | https://github.com/alwaysryu      |
| 우윤식 | 백엔드, 사용자 기반 추천          |                | https://github.com/Y1sik          |
| 윤찬호 | 프론트엔드                        |                | https://github.com/cmsj72         |
| 최상후 | 백엔드, 퍼블리싱                  |                | https://github.com/Neungji-Baksal |





## 프로젝트 세팅

### PROJECT BUILD 상세

---

  - FRONT BUILD

    - npm i
      ![npm_1](../exec/img/npm_1.PNG)

      

    - npm run serve -- --port 5500
      ![npm_2](../exec/img/npm_2.PNG)

      

  - BACKEND BUILD

    - 서버 시작
    - ![Spring_1](../exec/img/Spring_1.png)






### 배포 시 특이사항 기재

----

  - Jenkins
    - GitLab develop에 merge 시 자동 서버 배포
    - 약 2분 정도 시간이 걸림





### DB 접속 프로퍼티 파일 목록

---

exec/DB/

- DBProperty.PNG

  ![DB_Property](../exec/img/DB_Property.PNG)

- DB_PassWord : ffp1234!

- ForFourPaw.sql

- ForFourPaw.mwb



## ERD

![ERD](../exec/img/ERD.PNG)





## 사이트 상세

- 회원

  - 로그인 페이지

    ![Login_1](../exec/img/Login_1.PNG)

  - 구글 로그인

    ![Login_2](../exec/img/Login_2.PNG)

  - 카카오 로그인

    ![Login_kakao](../exec/img/Login_kakao.PNG)

  - 마이페이지

    - 개인 정보

      ![마이페이지](../exec/img/마이페이지.PNG)

    - 정보 수정, 삭제

      ![마이페이지_수정_삭제](../exec/img/마이페이지_수정_삭제.PNG)

      

- MainPage

  - 통계

    ![Main_통계](../exec/img/Main_통계.PNG)

    

  - 유기 동물 추천

    ![Main_유기동물추천](../exec/img/Main_유기동물추천.PNG)

    

  - 도움 사이트

    ![Main_도움사이트링크](../exec/img/Main_도움사이트링크.PNG)

  - UCC

    ![Main_UCC](../exec/img/Main_UCC.PNG)

- 유기 동물

  - 유기 동물 목록

  ![유기동물리스트](../exec/img/유기동물리스트.PNG)

  - 유기 동물 상세 페이지

    ![유기동물디테일](../exec/img/유기동물디테일.PNG)

  

- 실종 동물

  - 실종 동물 목록

    ![실종동물리스트](../exec/img/실종동물리스트.PNG)

  

  - 실종 동물 등록

    ![실종동물등록](../exec/img/실종동물등록.PNG)

  - 실종 동물 매칭

    ![실종동물매칭](../exec/img/실종동물매칭.PNG)

  - 실종 동물 댓글

    ![실종동물댓글](../exec/img/실종동물댓글.PNG)

  

- 데이터 분석

  - 메인 화면

    ![데이터분석_1](../exec/img/데이터분석_1.PNG)

    

  - 종류 별

    ![데이터분석_종류별](../exec/img/데이터분석_종류별.PNG)

  - 지역 별

    ![데이터분석_지역별](../exec/img/데이터분석_지역별.PNG)

    

  - 품종 별

    ![데이터분석_품종별](../exec/img/데이터분석_품종별.PNG)

    

  - 월 별

    ![데이터분석_월별](../exec/img/데이터분석_월별.PNG)

    

  - 연도 별

    ![데이터분석_연도별](../exec/img/데이터분석_연도별.PNG)

    

  - 무게 별

    ![데이터분석_무게별](../exec/img/데이터분석_무게별.PNG)

    

  


## 주요 기술

- Spark

  - 데이터 분산 처리
  - 통계 데이터

- Kmeans-cluster

  - 실종 동물 매칭 시스템

- User-Based Collaborative filtering

  - 사용자 기반 협업 추천 시스템

  





## 개발기록

노션 : https://sore-property-3e2.notion.site/02d47176f7644910845c6f922e96d895
