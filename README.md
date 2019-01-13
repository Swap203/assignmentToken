•	Token Generation is application developed using spring-boot, jsp and H2 database and follows MVC design pattern.
•	Application can be run by cloning this repository on machine and running standard maven spring commands at root directory of the repository  
•	Application will be served webpages developed using JSP as frontend (view)

•	Application has following URLs of Views 
1.	Generate Token: http://localhost:8087/token
2.	Display All Tokens Assigned to Counter: 	http://localhost:8087/token
3.	Display Token Assigned to Particular Counter: http://localhost:8087/counter

•	Privileged Customer are those who are having account in bank and status true as privileged.
•	Application will priorities Privileged customer over non Privileged customers based on logic mentioned in ViewController Class (Section : @PostMapping("/token") ) 
