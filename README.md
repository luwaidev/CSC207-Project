# CSC207 Project
1) The problem domain that our team is working on is Finance and Sports, specifically sports betting in the NBA.
2) We would like to create an application predicting which team is more likely to win the match, and for the users to bet accordingly.
4) Documentation of the API we will use: https://polygon.io/docs/stocks/getting-started
5) Using GET command on the API to view information on AAPL stock using Postman:
![image](https://github.com/luwaidev/CSC207/assets/118492882/18a1e0bc-7721-4e7b-b6c0-211ed01998fd)
 
7) Technical difficulties include :
     
     ![image](https://github.com/luwaidev/CSC207/assets/110574156/459a5a83-0c89-45b8-ba66-905271f8f68c)

Google Docs: [https://docs.google.com/document/d/1N5nsbEesMaH2Lt44tMoVu_1xxssDknp3evipAFkdZdE]

UI Diagram
```mermaid
graph TD;
	S(Signup Page)
	L(Login Page)
	M(Main Menu)
	P(Bet Prediction Page)
	
	
 
	S-->|After Creating Account|L
	S-->|Already Have Account|L
	L-->|Login|M
	L-->|Return to Signup|S
	S-->|Skip Login _DEV OPTION_|M
	M-->|Bet Prediction Selection|P
 

	

```