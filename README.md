# 💊 Medicare - Online Medical Store (File-Based)

**Medicare** is a file-handling-based web application for managing an online medical store. Built using Java Servlets and JSP, it supports role-based access, session management, medicine ordering, and invoice generation without using a database.

---

## 🧰 Tech Stack

- **Backend**: Java Servlets, JSP
- **Frontend**: HTML, CSS, JSP
- **Storage**: File Handling (`.txt` files for data persistence)
- **Session Management**: `HttpSession`
- **Server**: Apache Tomcat

---

## 🎯 Features

### 👥 Role-Based Access
- **Admin**
  - Add/Edit/Delete Medicines (stored in files)
  - View all customer orders
- **Customer**
  - Register/Login (credentials stored in file)
  - Browse available medicines
  - Add items to cart
  - Place orders
  - View invoice (generated on order)

### 💡 Core Functionalities
- ✅ Session-based login and logout
- ✅ File-based data storage (no database)
- ✅ Cart system using session
- ✅ Unique invoice generation (file-based)
- ✅ Input validation and error handling

---

## 🖼️ Screenshots

> *(Add screenshots of login page, admin panel, product list, invoice page, etc., if available)*

---

## 🚀 Getting Started

### Prerequisites

- JDK 8 or above
- Apache Tomcat 9+
- Any text editor (e.g., VS Code, IntelliJ, Eclipse)

### Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/randiranirman/Online-Medical-Store.git
