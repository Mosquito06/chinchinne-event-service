## :closed_book: 친친네 가계부_Event_Service(업데이트 중)

## :bulb: 개요

1. 시스템 구성도
<img src="https://user-images.githubusercontent.com/32257949/233838423-f7f16d7a-cdb1-460d-83fa-ca221ff7280d.jpeg"  width="750" height="370">
<img src="https://user-images.githubusercontent.com/32257949/233838425-47434a10-b0f1-4d82-97ec-c7c45d2382e4.jpeg"  width="750" height="370">

  * 모놀리식 아키텍처로 구현해도 무리없는 프로젝트이나 분산 아키텍처 개념 및 학습을 위해 (서비스 기반)분산 아키텍처로 구상하여 개발 진행 중
  * 모든 서비스는 이중화를 고려하여, 랜덤 포트를 사용하도록 구현
  * 모든 요청은 Gateway-Service를 통해 전달
  * 서비스 도메인을 철저히 분리하여 서비스 간 호출을 고려하지 않음
  * Global Transaction으로 MariaDB, MongoDB에 데이터 동시 저장
  * Global Transaction 사용을 위해 MongoDB는 Replica Set으로 구현
  * CQRS 패턴을 구현하여 Query 요청은 MongoDB에서 조회
  * 화면단 이벤트를 Apache Kafka를 통해 발행하고, Elasticsearch에 적재 및 시각화
  * (진행중) Spring Actuator를 통해 서버 메트릭을 Elasticsearch에 적재 및 시각화
  * (계획) Pinpoint 세팅 및 Locust를 통한 부하테스트

2. 구현 화면
<img src="https://github.com/Mosquito06/chinchinne-event-service/assets/32257949/c1036ad5-5bfa-404a-8f48-e1933fd9bb70"  width="750" height="370">
<img src="https://github.com/Mosquito06/chinchinne-event-service/assets/32257949/5ee5286a-ce09-41e3-a810-cc0be1fe846a"  width="750" height="370">

3. 기술 스택 및 설명
<div align="left">
  <img src="https://img.shields.io/badge/Java-6DB33F?style=for-the-badge">
  <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
  <img src="https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=JUnit5&logoColor=white">
  <img src="https://img.shields.io/badge/Spring Kafka-231F20?style=for-the-badge&logo=apachekafka&logoColor=white">
</div>

  * 친친네에서 사용할 가계부 Event 서비스
  * 모든 인증은 Gateway-service에서 처리함으로 별도의 인증 절차를 수행하지 않음

3. 구현(예정) 기능
  * 카프카 이벤트 프로듀서
