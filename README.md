# Bank Microservice Architecture

<p align="center">
<img src="https://i.imgur.com/NjmUyvT.png" >
</p>

# API Endpoints

## Customer Microservice 

- Port: 8000
- Endpoints:
> http://localhost:8000/customer
> http://localhost:8000/customer/{id}
> http://localhost:8000/customer/register
> http://localhost:8000/customer/customerWithAccount/{id}
> http://localhost:8000/customer/customerWithAccountTransactions/{customerId}/accountId/{accountId}

## Account Microservice 

- Port: 8080
- Endpoints:
> http://localhost:8080/account
> http://localhost:8080/account/{id}
> http://localhost:8080/account/customer/{customerId}
> http://localhost:8080/account/create
> http://localhost:8080/account/accountTx/{accountId}
> http://localhost:8080/accountActivities/deposit/customerId/{customerId}/accountId/{accountId}/{amount}
> http://localhost:8080/accountActivities/withdraw/customerId/{customerId}/accountId/{accountId}/{amount}
> http://localhost:8080/accountActivities/transfer/customerId/{customerId}/accountFrom/{accountFrom}/accountTo/{accountTo}/{amount}

## Transaction Microservice 

- Port: 8888
- Endpoints:
> http://localhost:8888/transaction
> http://localhost:8888/transaction/{id}
> http://localhost:8888/transaction/create
> http://localhost:8888/transaction/account/{accountId}

## Eureka Naming Server

- Port: 8761

## API Gateway

- Port: 8765
- Endpoints:
> http://localhost:8765/customer/**
> http://localhost:8765/account/**
> http://localhost:8765/accountActivities/**
> http://localhost:8765/transaction/**


### TODO: 

- Revise code
- Complete the CRUD operations for each microservice

