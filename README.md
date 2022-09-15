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

####  Verify the intersection of possible pizza parameters happy path with Credit Card - ID_1-ID_5
Steps to reproduce:

 1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
 2) Set quantity field with 1
 3) Put in the name field string value (example:"TestName")
 4) Put in the email field string value (example:"test@test.com")
 5) Put in the phone field string value (example:"0987654321")
 6) Select radio button "Credit card"
 7) Click on button "Place order"

 Expected result: Pop-up with text "Thank you for your order! TOTAL: 6.75 Small 6 Slices - no toppings" appears

####  Verify the intersection of possible pizza parameters happy path with Cash on Pickup - ID_6-ID_10
Steps to reproduce:

1) Chose "mall 6 Slices - no toppings" in Pizza1 dropdown
2) Set quantity field with 1
3) Put in the name field string value (example:"TestName")
4) Put in the email field string value (example:"test@test.com")
5) Put in the phone field string value (example:"0987654321")
6) Select radio button "Credit card"
7) Click on button "Place order"

Expected result: Pop-up with text "Thank you for your order! TOTAL: 6.75 Small 6 Slices - no toppings" appears

####  Verify Reset button - ID_11
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

####  Verify Quantity field with negative number - ID_12
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

####  Verify Quantity field with string value - ID_13
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

####  Verify Quantity field with value zero - ID_14
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

####  Verify Quantity field with empty value - ID_15
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with empty value
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"test@test.com")
7) Put in the phone field string value (example:"0987654321")
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result: Error message that quantity incorrect
and only possible value - positive integer

####  Verify Quantity field with double value - ID_16
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with double value
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"test@test.com")
7) Put in the phone field string value (example:"0987654321")
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result: Error message that quantity incorrect
and only possible value - positive integer

####  Verify Quantity field with free spaces value - ID_17
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

####  Verify Name field with empty value - ID_18
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

####  Verify Name field with free spaces value - ID_19
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

####  Verify Phone field with empty value - ID_20
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

####  Verify Phone field with free spaces value - ID_21
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

####  Verify phone field with text - ID_22
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

####  Verify email field with invalid format - ID_23
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with value - 3
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"InvalidEmail")
7) Put in the phone field value - "example:"0987654321"
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result: Error message - "Invalid email, please use next format - email@email.com"

####  Verify email field with free spaces value - ID_24
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with value - 3
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"InvalidEmail")
7) Put in the phone field value - "example:"0987654321"
8) Select radio button "Credit card"
9) Click on button "Place order"

Expected result:  Pop-up with text "Thank you for your order! TOTAL: 6.75 Small 6 Slices - no toppings" appears

####  Verify order creation without specified payment type - ID_25
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with value - 3
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"InvalidEmail")
7) Put in the phone field value - "example:"0987654321"
8) Click on button "Place order"

Expected result: Error message - "Please, chose one payment type - Credit card or Cash on Pickup"

####  Verify order creation with two specified payment type - ID_26
Steps to reproduce:

1) Chose "Small 6 Slices - no toppings" in Pizza1 dropdown
2) Click on by Toppings1 dropdown and Chose "Mushrooms" option
3) Click on by Toppings2 dropdown and Chose "Salami" option
4) Set quantity field with value - 3
5) Put in the name field string value (example:"TestName")
6) Put in the email field string value (example:"InvalidEmail")
7) Put in the phone field  value - "example:"0987654321"
8) Select radio button "Credit card"
9) Select radio button "Cash on Pickup"
10) Click on button "Place order"

Expected result: Error message - "Please, chose one payment type - Credit card or Cash on Pickup"

####  Verify order creation without any data accept name and phone - ID_27
Steps to reproduce:

1) Put in the name field string value (example:"TestName")
2) Put in the phone field value - "example:"0987654321"
3) Select radio button "Credit card"
4) Click on button "Place order"

Expected result: Error message - "Please, chose pizza type"


#### List of bugs:

1) Name field is obligatory so user shouldn't have possibility set name with - free spaces. Failed tests:
- ID_19
2) It is possible to create order without setting any data accept name and phone. It is no make sense. Such fields as 
Pizza Type, quantity, name, phone and Payment type should be obligatory. Failed tests:
- ID_27
- ID_25
3) It is possible create order with two payment type specified. It is no make sense from business logic. Failed tests:
- ID_26
4) Phone field is obligatory so user shouldn't have possibility set name with - free spaces, random text. Failed tests:
- ID_21
- ID_22
5) It is possible to create order with quantity value - negative number, random text, zero value, double value,
empty field, free spaces. It is no make sense from business perspective. Failed tests:
- ID_12
- ID_13
- ID_14
- ID_15
- ID_16
- ID_17
6) Reset button doesn't reset topping1 and topping2 dropdowns. Failed tests:
- ID_11

#### Issues - improvements necessary 

1) No verification for email field, it is possible to send invalid value,
to be user friendly it will be good to add messages as in test cases. Failed tests:
- ID_24
2) Name of items doesn't much the logic. There are pizza names with comment like "no toppings",
but user still can specify toppings if he wanted to do that. Same with other namings.
3) Currency specified only for default item in the pizza type dropdown, so if we complete order
with this item we will see currency - $, in all other cases there are no currency.