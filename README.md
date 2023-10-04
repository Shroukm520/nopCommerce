# nopCommerce
Automate nopCommerce web App using Selenium Java, TestNG, and POM
The Features: Register, Login, Search, HoverCategories, Followus, and Wishlist
1- 
Register Scenario:	"Success message is displayed ""Your registration completed"" - the color of this message is green rgba(76, 177, 124, 1) - Note: we need to get the ""color"" not ""background-color"" using getCssValue command which is already explained in Selenium Commands Chapter"
2.1 - 
Valid Login Scenario	"Use soft assertion to verify the following- getCurrentUrl and verify it equals https://demo.nopcommerce.com/ - ""My account"" tab isDisplayed"
2.2 - Invalid Login Scenario: - " error message contains ""Login was unsuccessful."" -  the color of this message is red ""#e4434b"""
3 -
Search By SKU Scenario:	"After searching, you need to click on the product in search result - Use hard assertion to verify the following - get the sku shown in this page then make sure it contains the sku that you are using in search"
4- 
HooverCategorie, Scenario Select a sub category from a menu and assert that it will appear in the new page	" - in Home page, there are 3 main categories contains sub-categories [Computers, Electronics, Apparel] -  you need to select random one of the three main categories -  you should hover on the selected category
Note: there's a difference between click and hover command - after hovering, you need to select random one of the three sub cateogries like [Desktops, Notebooks, Software] 1- get the text of this sub-category - 2- click on it - after opening sub-category page, you need to get text of the page title
div[class=""page-title""] h1 - Assert that the sub-category title is (equal or contains) the one you get it while selecting random sub-category"
5 -  
FollowUs Scenario: "go to https://demo.nopcommerce.com/ - you will find ""Follow us"" links at the end of the page - you need to create scenario for each button to make sure it works properly - Scenario 1: user opens facebook link - Scenario 2: user opens twitter link - Scenario 3: user opens rss link - Scenario 4: user opens youtube link"
6- 
Add ti WishList Scenario :	"you will find 4 products in the middle of the home page [Build your own computer, Apple MacBook Pro 13-inch, HTC One M8 Android L 5.0 Lollipop, $25 Virtual Gift Card] - if you click on wishlist button ❤️ on this product ""HTC One M8 Android L 5.0 Lollipop"" - you will see success message ""The product has been added to your wishlist"" with green background color - Use Soft assertion to verify the following - success message is displayed background color is green - Note: if you choose to verify Hex value then you will have to convert the color from RGBA to Hex"
7-
Wishlist Scenario 2 : "go to https://demo.nopcommerce.com/ - you click on wishlist button ❤️ on same product ""HTC One M8 Android L 5.0 Lollipop"" - wait until this success message with green color to disappear then click on ""Wishlist"" Tab on the top of the page (beside ""Register"", ""Log in"" tabs) - Note: there's easier ways to handle success message like click on x button without having to wait but we will choose this way to use explicity wait - So you should use explicit wait in this step to wait until success message becomes invisible after that click on ""Wishlist"" tab - you should get Qty value and verify it's bigger than 0 or it equals 1 "
