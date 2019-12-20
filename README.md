## CS153_Project

This is a subset of C language  
Except:  
- The built-in string type  
- No preprocessor, such as ‘include’ or ‘define’  
- No struct and union  
- No shortcut for initializing an array  
- No pointer, except when passing an array to function  
- Function prototype is not needed  
- Global variables can be placed anywhere outside of functions  
- Array cannot be the return type of functions  
- A few built-in function(printf, input stoi, stod, rand)  
- Local variables have function scope, not block scope  
#### Data Types
###### int
- Can be initialized.  
- Ex: int i = 0;  
###### double
- Can be initialized.  
- Ex: double d = 1.23;  
###### string
- Can be initialized.  
- Ex: string s = "abc";  
- Cannot be compared or concatenated with another string.  
###### void
- Can only be used for the return type of functions.  
#### Arrays
- All data types except void can be an array.  
- Ex: int a[10];  
- The dimension of array is not limited.  
#### Statements
###### block statment
- Series of statements surrounded by '{' and '}'.  
- Variables declared inside the statement is also valid outside of the statement.  
###### Assignment statement
- Consist of a variable, an equal sign, and an expression.  
###### Non-assignment statement
- Consist of only an expression.  
###### for statement
- Must be followed by block statement, {} cannot be omitted.  
- Variables declared inside the statement is also valid outside of the statement.  
###### while statement
- Must be followed by block statement, {} cannot be omitted.  
- Variables declared inside the statement is also valid outside of the statement.  
###### if statment
- Must be followed by block statement, {} cannot be omitted.  
- Variables declared inside the statement is also valid outside of the statement.  
###### break statement
- Works only within for or while.  
###### return statement
- Must be followed by either an expression or none.  
###### Increment and decrement statement
- ++ and -- can be placed before or after a variable.  
- Cannot be assigned to variable, that is, an assignment statement such as j = i++; does not work.  
#### Expressions
An expression can be one of these(the topmost one has the highest priority)  
- variable  
- integer number  
- double number  
- string  
- !(expression)  
- (expression)  
- function call  
- +expression or -expression  
- expression * or / or % expression  
- expression * or - expression  
- expression < or <= or > or >= expression  
- expression = or !=expression  
- expression && expression  
- expression || expression  
#### Main function
- There must be only one ‘main’ function.  
- Return type must be ‘int’.  
#### User-defined functions
- Return type must be either ‘int’, ‘double’, ‘string’ or ‘void’.  
- Argument type must be either ‘int’, ‘double’, ‘string’, or an array of one of those types.  
- Execution path must end with a ‘return’ statement.  
#### Built-in functions
###### printf
- Follows the rule of System.out.printf in Java.  
###### input 
- Receives a user input as a string.  
###### stoi
- Receives a string and convert it into the corresponding integer number.  
###### stod
- Receive a string and convert it into the corresponding double number.  
###### rand
- Generate a random number within the range of int.  
