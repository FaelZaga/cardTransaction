# Card Transaction
Project developed with spring boot for studying APIs

Spring Initializr configurations:
- Gladle Project
- Java Language
- Spring Boot version 2.3.4
- Dependencies: Spring Web + Spring Data JPA + H2 Database

## APIs

### **Create a new Card**

Route: http://<span></span>localhost:8080/card/create


![createCard](https://github.com/FaelZaga/cardTransaction/blob/main/img/PostAPICreate.png)


### **Get All Cards**

Route: http://<span></span>localhost:8080/card/getAll


![getAllCards](https://github.com/FaelZaga/cardTransaction/blob/main/img/GetAPIGetAllCards.png)


### **Transaction**

Route: http://<span></span>localhost:8080/transaction/{CARD NUMBER}


![createTransaction](https://github.com/FaelZaga/cardTransaction/blob/main/img/PostAPITransaction.png)

### **Get All Transactions**

Route: http://<span></span>localhost:8080/transaction/getAll


![getAllTransactions](https://github.com/FaelZaga/cardTransaction/blob/main/img/GetAPIGetAllTransactions.png)
