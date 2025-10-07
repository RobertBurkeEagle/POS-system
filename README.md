# POS-System

**POS-System** Simple point of sale application.  
It demonstrates core POS features (sales, inventory, etc.)
This is not intended for production use, but rather as a learning artifact.

---

## Motivation / Purpose

The goal was to build a functional, working POS application demonstrating:

- CRUD operations (Create, Read, Update, Delete)  
- Data persistence (e.g. storing products, sales)  
- Basic business logic (e.g. calculating totals, stock reduction)  
- Simple UI / interface for interaction  
- Code structure, separation of concerns, and clean design  

This project served as a sandbox to explore full-stack development, data flow, and error handling.

---

## Features (What It Does)

Here are the features currently implemented:

- Add / edit / delete product items (name, price, stock)  
- Display inventory / product list  
- Create a “sale” transaction:  
  - Add items to the sale (a “cart”)  
  - Compute subtotals, totals  
  - Deduct stock quantities after sale  
- View past sales / transaction history  
- user login / simple authentication (if implemented)  
- Basic reporting (e.g. total sales, items sold)  
