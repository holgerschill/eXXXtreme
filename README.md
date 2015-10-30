# eXXXtreme
## Exercise 1 Infer a Java-class for each table in the h2 DB
The class H2MetaDataAccess provides a method getTableInfos that returns a list of TableInfo-Objects. Each object holds the name of a table and a list of ColumnInfos. Each ColumnInfo holds the name of a column and the corresponding Java-Type. 
Please try to infer a Java-Class for each TableInfo that has a field for each ColumnInfo and the corresponding accessors.
Open up a runtime Eclipse to see that your implemtation works right. We have provided a example project that already holds all necessary stuff and a test database. Please note that it is a good idea to use a markerinterface "org.eclipse.eXXXtreme.tutorial.ITable" as superType of the inferred class. 

## Exercise 2 Queries and Expressions - Infer a method for each query.
Inferring classes out of a db is only useful if you use them directly - so let's introduce a new concept in our grammar. A Query should have a name , a type (points to the classes that we just inferred) and an expression. The last one should be a XBlockExpression that comes with Xbase. When you are done don't forget to invoke the codegenerator.
Try to infer a class for the model and a method for each Query. Each method should have a parameter like this: List<TypeOfQuery>. Let's assume your query points to an inferred class with the name Person, then your parameter should have the type  List<Person>. Concider to name the parameter 'it' to make it an implicite reciever in the expression.
The methods body should be the expression of the query. The returntype of the method should be inferred.
Concider to comment in the stuff in the ProposalProvider in the UI-Plugin. This will do a trick to filter the proposals for the query's type. Now you should know why we introduced that markerinterface. ;-)

### Exercise 2.1 Bonus - Try to implement a validation
Currently it is not checked that the name of a query is unique. Please try to implement a validation for that.

## Exercise 3 Infer field that hold the tabledata
Currently we do not really have the possibility to access the db's data. Please try to infer a field for each query that holds the corresponding data. The type of a field should be List<TypeOfQuery>. To make it a little bit easier, we provided a class in the example project, that you should use as the superType of your inferred class "org.eclipse.eXXXtreme.tutorial.DBAccess". It provides two useful methods that should help. 
The first one is getConnection that takes the path to the database as parameter and returns a SQL-Connection.
The second one is loadTable. It takes a Connection and a Class as parameters and returns a list of Objects. The class should be the class that represents the table that we want to deal with - the querie's type. 
Please try to infer a field that holds the Connection. The initializer of the field should call getConnection with the path to the database. Please note that a initializer could be an expression or in this case a templateexpression '''getConnection("«path + "/" + model.h2Path»")'''. The first part of the path it the path of the project. Please find a local field in the inferrer with the name "path" that already holds that part. The second part is the project relativ path to a h2 db file. Our model obeject holds that information.
Try to call the method loadTable in the initializer for the fields that should hold the data. Please use a templateexpression to do that.

## Exercise 4 Infer a main method to finally execute the inferred code
So far we did not really execute our inferred code. Please try to infer a main method that calles all inferred querymethods. 
Try to directly execute the inferred code by right click in the editor -> Run as Java Application.
Hint: A main method's signature should be String[] varargs - typeRef(String).addArrayTypeDimension will do the trick.

## Exercise 5 Try to run queries against a bigger database
So far we dealed with a small database with only 2 tables. Please find a database with in the example project db/car.mv.db and and a template for queries car.h2db with explanation what we would like you to find out about the data. Please find a class that holds a test for each query to check if you did the right thing. Please try to make the tests green.
