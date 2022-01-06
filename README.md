# shopify-inventory
Simple backend application to create, read, update, delete and filter inventory.

# Steps to run the application
The following environment needs to be setup in order to run the application.
1) Download the Java jdk 1.8 from the link https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html.
2) Download corresponding IntelliJ community edition from https://www.jetbrains.com/idea/download/#section=mac and install it. (Windows/Mac/Linux)
3) Download the Postman from https://www.postman.com/downloads/ and install it.
4) Download MySQL from https://www.mysql.com/downloads/ and download MySQL Workbench from https://dev.mysql.com/downloads/workbench/ and install them. Create a username and password in MySQL (something like username=root and password=Password). You need to give these details inside the application.properties in the code later.
5) Open MySQL Workbench and execute the below two lines (compy and paste) in a new Query which creates a schema named inventory.
```SQL
create database inventory;
use inventory;
```
6) Download the code from the repository and unzip it (https://github.com/nikhil-kagita/shopify-inventory). Open the downloaded project in IntelliJ.
7) Open application.properties file and set the username and password as your MySQL username and password.
8) Right click on the file InventoryApplication.java and click on Run 'InventoryApplication.main()'. This should start the application.
9) Now you can open the postman and create a new collection.

# CREATE inventory
-> In postman, select POST and give http://localhost:9191/inventories/addAll in the URL and select raw (JSON) in body and paste the following in the body and press Send.
```json
[
    {
        "name": "mobile",
        "quantity": 2,
        "price": 15000.0,
        "category": "technology"
    },
    {
        "name": "earphone",
        "quantity": 3,
        "price": 1000.0,
        "category": "technology"
    },
    {
        "name": "pin",
        "quantity": 1,
        "price": 11.0,
        "category": "stationery"
    },
    {
        "name": "pencil",
        "quantity": 5,
        "price": 5.0,
        "category": "stationery"
    },
    {
        "name": "pen",
        "quantity": 100,
        "price": 10.0,
        "category": "stationery"
    }
]
```
-> This request should add all the inventories in the database. You can also use http://localhost:9191/inventories/add and give single inventory to add a single inventory.

# GET all inventory
-> In postman, select GET and give http://localhost:9191/inventories in the URL and press Send. You should be able to see the list of all inventories that are present in the database. The id's are automatically generated. and you can use any single id and use the GET method with URL http://localhost:9191/inventories

# GET inventory by id
-> In postman, select GET and give http://localhost:9191/inventories/id/{id} in the URL and press Send. You should be able to see the inventory that is corresponding to the given id in place of {id}.

# GET inventory by name
-> In postman, select GET and give http://localhost:9191/inventories/name/{name} in the URL and press Send. You should be able to see the inventory that is corresponding to the given name in place of {name}. As name can be duplicate, this request can return list of inventories which has that particular name.

# UPDATE inventory
-> In postman, select PUT and give http://localhost:9191/inventories/update in the URL and press Send. You need to pass the inventory you want to update in the raw (JSON) body as below.
```json
{
     "id": 1,
     "name": "mobile",
     **"quantity": 10,**
     "price": 15000.0,
     "category": "technology"
}
```

# DELETE inventory by id
-> In postman, select DELETE and give http://localhost:9191/inventories/delete/{id} in the URL with the id required to be deleted in {id} and press Send. This will delete the corresponding inventory if it is present in the database.

# FILTER by quantity (Additional Feature)
-> Suppose you want to filter the inventory items that are less than or equal to a certain quantity, you can select GET method in postman and give URL http://localhost:9191/inventories?maxQuantity=2 in the URL and press Send. This request will return the inventory items which has quantity less than or equal to 2 which in our case will be as below.
```json
[
    {
        "id": 12,
        "name": "pin",
        "quantity": 1,
        "price": 11.0,
        "category": "stationery"
    },
    {
        "id": 10,
        "name": "mobile",
        "quantity": 2,
        "price": 15000.0,
        "category": "technology"
    }
]
```

This completes the assignment with basic CRUD features and one additional feature to filter the inventories based on Quantity. Thanks for giving me this opportunity and am eagerly looking forward to interviewing with Shopify.

# Contact details
email: nkagita@umass.edu
Phone: +1 (848) 256-2090
