# API_Automated_Testing
This project is the automated test of an API using mockAPI, the end point can be found here:

<a href="https://637e9b555b1cc8d6f9310eca.mockapi.io/banktransactions" target="_blank">Endpoint</a>

In this project you will find the following test:

### Verify the Endpoint is empty 
If there is any data everything will be deleted

### Initialize the POJO with 10 random data 
Before the post request is executed it will be verified if there are any duplicated emails and the data will be excluded from the request, in this case 2 clients are assigned the same email to ensure the test iw working according to the expectations

### Verify that there are not duplicate emails.

### Update an existing AccountNumber
In this case the first client will be updated

### How to run this project
To run this project just go to the recourses folder located in the test directory and run the file suite.xml