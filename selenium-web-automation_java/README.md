## Web-automation automated test cases



**Developed by Kushal Solanki**

**Process to run the Tests**

Steps to run code in your local environment:
1. Clone this repository
2. Import project in Eclipse or IntelliJ
3. Build maven project (to download all dependencies) => Clean and Install
4. Right click on 'testng.xml'
5. Run as TestNG suite

**Location of report :**

This is a html report, Please go to actual folder rather than viewing it in tools like Eclipse or IntelliJ
Report will be available in test-output -> Result.html

**Structure of the framework:**

At a high level The framework is divided into 3 Main components


 1. src/main/java------>common
 2. src/test/java-------> ui
 3. testng.xml
 

 **1. src/main/java------>common**
Under the package **common** I have created  4 different classes based on the functionality of the applications .
CreateEmployee
DeleteEmployee
SystemLogin
UpdateEmployee
I have followed a Page Object Model .All the web elements and methods pertaining to a particular functionality are defined in that class.This becomes very easy to understand for a new person coming in and It also becomes very convenient to maintain the code

 **2. src/test/java-------> ui**
Under the package **ui** I have created TestExecutable class. This class has all the test scenarios defined.The naming conventions of the methods are self explanatory which tells about what actions it is going to perform for eg. login.enterLoginDetails or Login.clickLoginButton.
It helps the person even with less or no experience in automation to understand the framework.
I have also made use of annotations of Testng like   @BeforeTest , @AfterTest. The benefits of using Testng are explained at later part of document.

  **3. testng.xml**
 This is where I have defined the parameters or test data that is being picked up or called by TestExecutable class. This helps in re-using the data and also prevents us from hardcoding the data in TestExecutable class.


**Main reasons for using Testng Framework.**


TestNG eliminates most of the limitations of the older framework and gives the developer the ability to write more flexible and powerful tests with help of easy annotations, grouping, sequencing & parameterizing.

**Major advantages of testng are:**

-   Logs can be generated
    
-   Annotations make code efficient and easy to manage
    
-   Ability to produce HTML Reports of execution
    
-   Test cases can be Grouped & Prioritized
    
-   Parallel testing is possible
    
-   Data Parameterization is possible


**Benefits of using annotations**
    

1.  TestNG identifies the methods that it is interested in by looking up annotations. Hence method names are not restricted to any pattern or format.
    
2.  We can pass additional parameters to annotations.
    
3.  Annotations are strongly typed, so the compiler will flag any mistakes right away.

 
**Scope of Improvement:**
No framework is perfect and the framework that I created is no exception. There is always a scope to improvise it further to the next level. Below are the points to be taken into consideration for making the framework better.

 1. **Wait synchronisation  issue:** We can make use of Explicitwait for some elements for a certain condition to occur like  ***elementToBeClickable*** or ***visibilityOfElementLocated*** before proceeding further in the code.
 2. **Use of Javascript Executor:** We can make use of Javascript executor .scrollIntoView(); function in order to locate the element of an employee to be updated or deleted. Currently I have used ***xpath following sibling method*** to identify the First employee in the list.
 3. **DataProvider:**** To cover more scenarios we can make use of **DataProvider** Annotation of Testng. This will help in running the same method with different set of data. ForEg Login Functionality. We do not need to create different methods for for different set of data. Just run one method with different set of inputs.




 






