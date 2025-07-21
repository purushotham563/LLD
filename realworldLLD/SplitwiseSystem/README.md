
# Expense Splitter System

This project is a LLD for a group expense splitting application. It supports different split strategies (equal, exact amounts), group management, notifications, and balance settlements.

## 🧠 Design Patterns Used

- **Strategy Pattern**: For different split strategies (`EqualSplit`, `ExactAmountSplit`).
- **Observer Pattern**: To notify users of new expenses (`Notifier`, `NotifierManager`, `NewExpenseNotifier`).
- **Composition and Aggregation**: To model relationships between `Group`, `Expense`, `User`, etc.

## 📦 Class Overview

### `SplitStrategy` (Interface)
Defines the method to calculate expense splits.

### `EqualSplit`, `ExactAmountSplit`
Implements different splitting strategies.

### `User`
Represents a user with a unique ID, name, email, and friend list.

### `Expense`
Holds the information about an expense and how it’s split among participants.

### `Group`
Represents a group of users and their shared expenses. Manages members and expense notifications.

### `BalanceSheet`
Tracks how much each user owes to others.

### `Settlement`
Facilitates payment and balance updates between users.

### `Notifier` (Interface), `NewExpenseNotifier`
Implements the observer pattern for notifying users.

### `NotifierManager`
Manages notifier subscriptions and triggers notifications.

## 🖼️ UML Overview

- Groups contain multiple users and expenses.
- Expenses use a strategy to split costs among participants.
- The balance sheet tracks debts.
- The observer pattern is used to notify users when a new expense is added.

## 📄 UML Class Diagram

<img width="1152" height="1508" alt="Spliwise Management" src="https://github.com/user-attachments/assets/52a111bf-9d6c-4fc9-8be4-014bd8552af5" />
## Coded By 
Purushotham Reddy 
