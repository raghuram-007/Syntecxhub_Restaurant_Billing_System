
# 📜 Restaurant_Billing_System

## 📌 Project Overview
This is a **Java CLI-based Restaurant Billing System** developed as part of the **Syntecxhub Java Programming Internship (Project-3)**.  
The application enables users to manage restaurant orders efficiently, calculate bills with GST, and dynamically manage the menu.

---

## ✨ Features
- View the complete menu  
- Add new menu items dynamically  
- Remove menu items by ID  
- Place orders with multiple items and quantities  
- Calculate subtotal, GST (5%), and total amount  
- Print itemized receipts  
- Handles invalid inputs gracefully  

---

## 🛠 Technologies Used
- **Java**  
- **ArrayList** for menu and order storage  
- **Scanner** for user input handling  

---

## ▶ How to Run
1. Open terminal/PowerShell and navigate to the project folder.  
2. Compile the program:
```bash
javac *.java
````

3. Run the program:

```bash
java RestaurantBillingSystem
```

4. Follow the on-screen menu:

   * **1:** View Menu
   * **2:** Add Menu Item
   * **3:** Remove Menu Item
   * **4:** Place Order
   * **5:** Exit

---

## 🖥 Sample Output

```
--- Menu ---
1. Burger - ₹120.0
2. Pizza - ₹250.0
3. Pasta - ₹180.0
4. French Fries - ₹80.0

Enter item ID to order (0 to finish): 2
Enter quantity: 1

Enter item ID to order (0 to finish): 1
Enter quantity: 2

Enter item ID to order (0 to finish): 0

--- Bill ---
Item                 Qty        Price     
Pizza                1          250.00    
Burger               2          240.00    

Subtotal                        490.00
GST (5%)                        24.50
Total Amount                     514.50
```

---

## 📁 Project Structure

```
Syntecxhub_Restaurant_Billing_System/
│
├── MenuItem.java               # Menu item class
├── RestaurantBillingSystem.java # Main program (CLI)
└── README.md                   # Project description
```

---

## 👤 Author

**Raghu Ram** – Intern at Syntecxhub

---

## 📝 Notes

* This is a **console-based CLI application**, no GUI required.
* Menu and order data are stored **in memory using ArrayList**.
* Proper handling of **invalid inputs** ensures robust behavior.

```


