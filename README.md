# TestNG
TestNG Framework
![image](https://user-images.githubusercontent.com/111237893/212285494-1bd911be-9775-4f6a-8b2d-4a0821591f02.png)
📌 Automate different functionalities of an E-commerce website called "AutomationExercise"
🌐Website URL: https://www.automationexercise.com/
Screenshot 2022-12-30 175750

📝 The main Frameworks included in the project:
Selenium Webdriver
TestNG

🏗️ Project Design:
Page Object Model (POM) design pattern

Data Driven framework

Fluent design approach

Java Docs

🔍️ Covered Test cases in this project :
✅Test Case 1: Register User
Launch browser
Navigate to url 'http://automationexercise.com' 3.✏️Verify that home page is visible successfully
Click on 'Signup / Login' button
Verify 'New User Signup!' is visible
Enter name and email address
Click 'Signup' button 8.✏️Verify that 'ENTER ACCOUNT INFORMATION' is visible
Fill details: Title, Name, Email, Password, Date of birth
Select checkbox 'Sign up for our newsletter!'
Select checkbox 'Receive special offers from our partners!'
Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
Click 'Create Account button' 14.✏️Verify that 'ACCOUNT CREATED!' is visible
Click 'Continue' button 16.✏️Verify that 'Logged in as username' is visible
Click 'Delete Account' button 18.✏️Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

✅Test Case 2: Login User with correct email and password
Launch browser
Navigate to url 'http://automationexercise.com'
Verify that home page is visible successfully
Click on 'Signup / Login' button
Verify 'Login to your account' is visible
Enter correct email address and password
Click 'login' button
Verify that 'Logged in as username' is visible
Click 'Delete Account' button
Verify that 'ACCOUNT DELETED!' is visible

✅Test Case 3: Login User with incorrect email and password
Launch browser
Navigate to url 'http://automationexercise.com'
Verify that home page is visible successfully
Click on 'Signup / Login' button
Verify 'Login to your account' is visible
Enter incorrect email address and password
Click 'login' button
Verify error 'Your email or password is incorrect!' is visible

✅Test Case 4: Logout User
Launch browser
Navigate to url 'http://automationexercise.com'
Verify that home page is visible successfully
Click on 'Signup / Login' button
Verify 'Login to your account' is visible
Enter correct email address and password
Click 'login' button
Verify that 'Logged in as username' is visible
Click 'Logout' button
Verify that user is navigated to login page

✅Test Case 5: Register User with existing email
Launch browser
Navigate to url 'http://automationexercise.com'
Verify that home page is visible successfully
Click on 'Signup / Login' button
Verify 'New User Signup!' is visible
Enter name and already registered email address
Click 'Signup' button
Verify error 'Email Address already exist!' is visible

✅Test Case 6: Contact Us Form
Launch browser
Navigate to url 'http://automationexercise.com'
Verify that home page is visible successfully
Click on 'Contact Us' button
Verify 'GET IN TOUCH' is visible
Enter name, email, subject and message
Upload file
Click 'Submit' button
Click OK button
Verify success message 'Success! Your details have been submitted successfully.' is visible
Click 'Home' button and verify that landed to home page successfully

✅Test Case 8: Verify All Products and product detail page
Launch browser
Navigate to url 'http://automationexercise.com'
Verify that home page is visible successfully
Click on 'Products' button
Verify user is navigated to ALL PRODUCTS page successfully
The products list is visible
Click on 'View Product' of first product
User is landed to product detail page
Verify that detail detail is visible: product name, category, price, availability, condition, brand

✅Test Case 9: Search Product
Launch browser
Navigate to url 'http://automationexercise.com'
Verify that home page is visible successfully
Click on 'Products' button
Verify user is navigated to ALL PRODUCTS page successfully
Enter product name in search input and click search button
Verify 'SEARCHED PRODUCTS' is visible
Verify all the products related to search are visible

✅Test Case 10: Verify Subscription in home page
Launch browser
Navigate to url 'http://automationexercise.com'
Verify that home page is visible successfully
Scroll down to footer
Verify text 'SUBSCRIPTION'
Enter email address in input and click arrow button
Verify success message 'You have been successfully subscribed!' is visible
