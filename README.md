#  Custom Springboot Actuator metrics with Prometheus and Grafana

## Build Metrics App

```
.\gradlew bootJar
```

## Build docker image

```
docker compose build metrics
```

This will build docker image with tag ```metrics:latest```.

## Deploy to Docker

```
docker compose up
```

## Deploy using helm

```
cd helm
helm install metrics metrics
```

### Ports

|Service Name|Port|
|---|---|
|metrics|8080|
|prometheus|9090|
|grafana|3000|

Use port forward using kubectl and then access using http://localhost:PORT/.

### Uninstall helm release

```
helm uninstall metrics
```
