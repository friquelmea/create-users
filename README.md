# create-users
Project for globallogic
This project was made with the help of Spring tool Suite (STS) for facility the programming.
For set up this project you can use STS and import the project, after that you select the option run as "Spring boot App" from the context menu of the project.
Another option is build and package the proyect with the grandle build command and  do the deployment manually in a server .
Once you have the project deployed, you can go to the next url:

http://localhost:8080/register/user

you can use Postman to make the request. In the body of the request you must send a json like this:

{
	"name": "Francisco",
	"email": "afcaa.alcas@gmail.vl",
	"password": "ABbbb22 ",
    	"phones":[{
		"number":"2233232332",
		"citycode":"STGO",
		"countrycode":"CL"
	}]
}

if the json sent meet the requirements of the project, you'll watch a response like this:

{
    "id": "034df283-acba-4134-9985-96f8f8005411",
    "created": "2020-01-29T12:18:07.671+0000",
    "modified": "2020-01-29T12:18:07.671+0000",
    "last_login": "2020-01-29T12:18:07.671+0000",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZmNhYW9hLmFsY2FzQGdtYWlsLmNvbSIsImV4cCI6MTU4MDMwMDg4N30.THNTifjMhrge4w-TfpXJWl-4TweiHlGrGS3amaSUBeC-rqZEWAOSvT6dgIIj21-jNmTqt6od87QtvAbxqz4ocA",
    "isActive": true
}

To complete the task of adding java 8 functions, i created another endpoint for get the users registered but only those who have phones records, the endpoint is this:

http://localhost:8080/users/


