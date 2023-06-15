1. DB SETTINGS :

---------------> Login for H2 DB CONSOLE :

Go to your user directory, in my case, it is (C:\Users\ankit.rohilla)
Create a new file called test.mv.db and saved it under all file option like below.
http://localhost:8080/h2-console
url : jdbc:h2:~/test


 
---------------> create below TABLE user in hibernate. 
USER table== to store user name credentials
FILE_DATA table==  to store file storage location and to the user it is mapped.

DROP TABLE IF EXISTS USER;  

CREATE TABLE USER (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
username VARCHAR(50) NOT NULL, 
password VARCHAR(5000) NOT NULL,   
role VARCHAR(50) NOT NULL
);  

DROP TABLE IF EXISTS FILE_DATA ;  

CREATE TABLE FILE_DATA (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
name VARCHAR(50) NOT NULL, 
type VARCHAR(50) NULL,   
file_path VARCHAR(5000) NOT NULL,
username VARCHAR(50) NOT NULL
);  

2. REST API END POINTS

Create folder C:\\test\\ on your local machine.

---------------> REGISTRATION (POST) == http://localhost:8080/api/v1/signup
inside the BODY (RAW: JSON body)

{  
    "id": "002",  
    "username": "user",  
    "password": "password",  
    "role": "USER"  
}   

---------------> LOGIN (GET) == http://localhost:8080/home
under AUTHORISATION TAB, use BASIC AUTHENTICATION pass 
Username as "user" and Password as "password"
 
 
---------------> UPLOAD IMAGE (POST) == http://localhost:8080/fileSystem
under AUTHORISATION TAB, use BASIC AUTHENTICATION pass 
Username as "user" and Password as "password"
inside the BODY (form-data)

key : image 
value : <image_path>

key : user
value : <username>

---------------> DOWNLOAD IMAGE FROM IMAGE NAME (GET) == http://localhost:8080/fileSystem/{fileName}
fileName refers to name of the image.

under AUTHORISATION TAB, use BASIC AUTHENTICATION pass 
Username as "user" and Password as "password"


---------------> DOWNLOAD IMAGE FROM IMAGE NAME (GET) == http://localhost:8080/fileSystem/username/{username}
fileName refers to name of the user.

under AUTHORISATION TAB, use BASIC AUTHENTICATION pass 
Username as "user" and Password as "password"


---------------> FYI : Not able to use imgur.com as was having issue to connect to it from local system, so instead used local file system

