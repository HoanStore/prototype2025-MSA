
1. 구성1

```
api-gateway -> user-service
            -> order-service
```

이때 필요한 의존성은 아래
```
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
```

2. 구성2 (Eureka 사용)

- Eureka를 활용해 동적으로 라우팅하도록 변경

1. Eureka에 서비스 등록
```
API Gateway (api-gateway)
각 마이크로서비스 (user-service, order-service 등)
```

2. 필요한 의존성
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    <version>4.2.0</version>
</dependency>
```

3. 각 서비스의 Eureka 설정
```
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/  # Eureka Server 주소
  instance:
    prefer-ip-address: true  # 서비스 IP 기반으로 등록
```

4. API Gateway에서 Eureka를 활용한 동적 라우팅
- 기존의 고정 URL 대신 Eureka에서 서비스 정보를 가져와 동적으로 라우팅
```
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: lb://user-service  # Eureka에서 user-service 주소 조회
          predicates:
            - Path=/users/**
        - id: order-service
          uri: lb://order-service
          predicates:
            - Path=/orders/**
```