<a href="https://codeclimate.com/github/rgalba/fibonacci-api/maintainability"><img src="https://api.codeclimate.com/v1/badges/c1d58ae6898cd8866e54/maintainability" /></a>
[![Build Status](https://travis-ci.org/rgalba/fibonacci-api.svg?branch=master)](https://travis-ci.org/rgalba/fibonacci-api)

# Fibonacci API

Simple API to calculate Fibonacci series for a given number.

## Credentials

In order to use the API, follow the credentials:

> username: admin  
> password: s3cr3t

## How to use 

> To calculate series for number 2  

```shell script
$ curl --request POST \
  --url http://localhost:8080/api/calculate/2 \
  --header 'accept: application/json' \
  --header 'authorization: Basic YWRtaW46czNjcjN0'

[
	1,
	1
]
```

> To health check  

```shell script
$ curl --request GET \
    --url http://localhost:8080/actuator/health \
    --header 'accept: application/json' \
    --header 'authorization: Basic YWRtaW46czNjcjN0'

{
	"status": "UP"
}
```

> To shutdown application for testing purposes

```shell script
$ curl --request POST \
  --url http://localhost:8080/actuator/shutdown \
  --header 'accept: application/json' \
  --header 'authorization: Basic YWRtaW46czNjcjN0'

{
	"message": "Shutting down, bye..."
}
```

## How to debug via API

You can use the `/actuator` API to get several information about the service. Just do a GET:

```shell script
$ curl --request GET \
  --url http://localhost:8080/actuator/ \
  --header 'accept: application/json' \
  --header 'authorization: Basic YWRtaW46czNjcjN0'

{
	"_links": {
		"self": {
			"href": "http://localhost:8080/actuator",
			"templated": false
		},
		"beans": {
			"href": "http://localhost:8080/actuator/beans",
			"templated": false
		},
		"caches-cache": {
			"href": "http://localhost:8080/actuator/caches/{cache}",
			"templated": true
		},
		"caches": {
			"href": "http://localhost:8080/actuator/caches",
			"templated": false
		},
		"health": {
			"href": "http://localhost:8080/actuator/health",
			"templated": false
		},
		"health-path": {
			"href": "http://localhost:8080/actuator/health/{*path}",
			"templated": true
		},
		"info": {
			"href": "http://localhost:8080/actuator/info",
			"templated": false
		},
		"conditions": {
			"href": "http://localhost:8080/actuator/conditions",
			"templated": false
		},
		"shutdown": {
			"href": "http://localhost:8080/actuator/shutdown",
			"templated": false
		},
		"configprops": {
			"href": "http://localhost:8080/actuator/configprops",
			"templated": false
		},
		"env": {
			"href": "http://localhost:8080/actuator/env",
			"templated": false
		},
		"env-toMatch": {
			"href": "http://localhost:8080/actuator/env/{toMatch}",
			"templated": true
		},
		"loggers": {
			"href": "http://localhost:8080/actuator/loggers",
			"templated": false
		},
		"loggers-name": {
			"href": "http://localhost:8080/actuator/loggers/{name}",
			"templated": true
		},
		"heapdump": {
			"href": "http://localhost:8080/actuator/heapdump",
			"templated": false
		},
		"threaddump": {
			"href": "http://localhost:8080/actuator/threaddump",
			"templated": false
		},
		"metrics": {
			"href": "http://localhost:8080/actuator/metrics",
			"templated": false
		},
		"metrics-requiredMetricName": {
			"href": "http://localhost:8080/actuator/metrics/{requiredMetricName}",
			"templated": true
		},
		"scheduledtasks": {
			"href": "http://localhost:8080/actuator/scheduledtasks",
			"templated": false
		},
		"mappings": {
			"href": "http://localhost:8080/actuator/mappings",
			"templated": false
		}
	}
}
```


## Useful Docker commands

- docker images
- docker container ls
- docker logs <container_name>
- docker container rm <container_name
- docker image rm <image_name
