## Demo Challenge

#### Instructions
1. Complete the project setup as listed below
2. Complete the Excerise
3. Email a synopsis of your work and the link to your git repo containing the completed exercise to: vladimir_pokhodnia@epam.com


#### Expectations
We will be evaluating
1. Naming conventions
2. Code readability
3. Code encapsulation
4. Code structure and organization
5. Quality of test cases
6. Variety  of testing types (examples: boundary, happy path, negative, etc) 


#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your git account in a public repo
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/


#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo

#### Test Cases:

####  Verify "Small 6 Slices - no toppings" happy path with Credit Card - ID_1
Steps to reproduce:

 1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
 2) Set quantity field with 1
 3) Put in the name field string value (example:"TestName")
 4) Put in the email field string value (example:"test@test.com")
 5) Put in the phone field string value (example:"0987654321")
 6) Select radio button "Credit card"
 7) Click on button "Place order"

 Expected result: Pop-up with text "Thank you for your order! TOTAL: 6.75 Small 6 Slices - no toppings" appears

####  Verify "mall 6 Slices - no toppings" happy path with Cash on Pickup - ID_2
Steps to reproduce:

1) Chose "mall 6 Slices - no toppings" in Pizza1 dropdown
2) Set quantity field with 1
3) Put in the name field string value (example:"TestName")
4) Put in the email field string value (example:"test@test.com")
5) Put in the phone field string value (example:"0987654321")
6) Select radio button "Credit card"
7) Click on button "Place order"

Expected result: Pop-up with text "Thank you for your order! TOTAL: 6.75 Small 6 Slices - no toppings" appears

####  Verify "Small 6 Slices - no toppings" happy path with one topping and Credit Card - ID_3
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option 
3) Set quantity field with 1
4) Put in the name field string value (example:"TestName")
5) Put in the email field string value (example:"test@test.com")
6) Put in the phone field string value (example:"0987654321")
7) Select radio button "Credit card"
8) Click on button "Place order"

Expected result: Pop-up with text "Thank you for your order! TOTAL: 6.75 Small 6 Slices - no toppings" appears


####  Verify "Small 6 Slices - no toppings" happy path with two topping and Credit Card - ID_4
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with 1
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"test@test.com")
7) Put in the phone field string value (example:"0987654321")
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result: Pop-up with text "Thank you for your order! TOTAL: 6.75 Small 6 Slices - no toppings" appears

Sorry do not want copy paste them.
Test cases from ID_1 to ID_4 should be used for all types of pizza in pizza1 dropdown, different will be only 
in final message.

####  Verify Reset button - ID_5
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with 1
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"test@test.com")
7) Put in the phone field string value (example:"0987654321")
8) Select radio button "Credit card"
9) Click on button "Reset"

Expected result: All fields, dropdowns and buttons should be in default state

####  Verify Quantity field with negative number - ID_6
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with negative number - "-12"
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"test@test.com")
7) Put in the phone field string value (example:"0987654321")
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result: Error message that quantity incorrect
and only possible value - positive integer

####  Verify Quantity field with string value - ID_7
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with string - "test quantity"
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"test@test.com")
7) Put in the phone field string value (example:"0987654321")
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result: Error message that quantity incorrect
and only possible value - positive integer

####  Verify Quantity field with value zero - ID_8
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with value - 0
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"test@test.com")
7) Put in the phone field string value (example:"0987654321")
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result: Error message that quantity incorrect
and only possible value - positive integer

####  Verify Quantity field with free spaces - ID_9
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with few free spaces
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"test@test.com")
7) Put in the phone field string value (example:"0987654321")
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result: Error message that quantity incorrect
and only possible value - positive integer

####  Verify Quantity field with double value - ID_10
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with value - 12.34
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"test@test.com")
7) Put in the phone field string value (example:"0987654321")
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result: Error message that quantity incorrect 
and only possible value - positive integer

####  Verify Quantity field with positive value - ID_11
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with value - 3
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"test@test.com")
7) Put in the phone field string value (example:"0987654321")
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result: Pop-up with text "Thank you for your order! TOTAL: 20.25 Small 6 Slices - no toppings" appears

####  Verify Name field with blank value - ID_12
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with value - 3
5) Leave "name" field empty
6) Put in the email field string value (example:"test@test.com")
7) Put in the phone field string value (example:"0987654321")
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result: Pop-up with text "Missing name" appears

####  Verify Name field with free spaces value - ID_13
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with value - 3
5) Add to the "name" field free spaces
6) Put in the email field string value (example:"test@test.com")
7) Put in the phone field string value (example:"0987654321")
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result: Spaces should be ignored. Pop-up with text "Missing name" appears

####  Verify Phone field with blank value - ID_14
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with value - 3
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"test@test.com")
7) Leave "phone" field empty
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result: Pop-up with text "Missing phone" appears

####  Verify Name field with free spaces value - ID_15
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with value - 3
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"test@test.com")
7) Put in the phone field few free spaces
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result: Spaces should be ignored. Pop-up with text "Missing phone" appears

####  Verify Name field with chars value not numbers - ID_16
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with value - 3
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"test@test.com")
7) Put in the phone field text - "phone number"
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result: Error message that phone incorrect
and only possible value - please use international phone format like (+380099332211)
