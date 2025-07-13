# 💸 Expense Tracker API (Java Spring Boot)

A backend RESTful API for tracking personal expenses, built with Java and Spring Boot.  
Easily add, update, delete, and retrieve expenses — with category tagging and monthly summaries.  
Ideal for students, professionals, and budget-conscious users.

---

## 🚀 Features

- ✅ Add daily expenses with amount, category, and description
- ✏️ Edit or delete past expenses
- 📊 View total and category-wise expenses for a selected month
- 📅 Filter expenses by date range or category
- 🏷️ Tag expenses by category: Food, Travel, Utilities, etc.
- 📈 (Planned) Analytics: Monthly savings & overspending alerts
- 🔐 (Planned) JWT-based user authentication

---

## 📦 Tech Stack

- Java 17
- Spring Boot
- Spring Web + JPA + H2 Database
- Maven
- Swagger (OpenAPI UI)
- (Optional) PostgreSQL for persistent storage

---

## 🧪 API Endpoints

| Method | Endpoint             | Description                          |
|--------|----------------------|--------------------------------------|
| POST   | `/api/expenses`      | Add a new expense                    |
| GET    | `/api/expenses`      | Get all expenses                     |
| GET    | `/api/expenses/{id}` | Get specific expense by ID           |
| PUT    | `/api/expenses/{id}` | Update an existing expense           |
| DELETE | `/api/expenses/{id}` | Delete an expense                    |
| GET    | `/api/summary/month` | Get total/monthly/category summary   |

---

## 📘 Example JSON

### ➕ Add Expense

```json
POST /api/expenses

{
  "amount": 350.75,
  "category": "Food",
  "description": "Lunch with friends",
  "date": "2025-07-13"
}
