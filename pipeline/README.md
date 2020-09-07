# CI/CD Pipeline

Full AWS based CI/CD pipeline.

## Stack
- AWS CodeCommit
- AWS CodeBuild
- AWS CodeDeploy
- AWS CodePipeline
- AWS ECR
- AWS ECS

## Steps

1. AWS CodeCommit replica from Github
2. Build java app (gradle via AWS CodeBuild)
3. Run tests via CodeBuild
4. Build docker image via CodeBuild?
5. Deploy docker image to AWS ECR (Fargate)
6. Create CodePipeline to manage all these tasks

## Step 1: Create AWS CodeCommit repository

```shell script
$ aws codecommit create-repository --repository-name FibonacciApp --repository-description "Simple Fibonacci functions as API"
{
    "repositoryMetadata": {
        "accountId": "ommited",
        "repositoryId": "3ca383d6-31cd-4391-8b76-58f3af3c293a",
        "repositoryName": "FibonacciApp",
        "repositoryDescription": "Simple Fibonacci functions as API",
        "lastModifiedDate": "2020-09-07T14:36:54.628000-03:00",
        "creationDate": "2020-09-07T14:36:54.628000-03:00",
        "cloneUrlHttp": "https://git-codecommit.us-east-1.amazonaws.com/v1/repos/FibonacciApp",
        "cloneUrlSsh": "ssh://git-codecommit.us-east-1.amazonaws.com/v1/repos/FibonacciApp",
        "Arn": "ommited"
    }
}
```

To add this repo as a new Git remote:

```shell script
git remote add codecommit ssh://git-codecommit.us-east-1.amazonaws.com/v1/repos/FibonacciApp
```