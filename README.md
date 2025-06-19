# Low Level Design (LLD) Patterns

A comprehensive collection of design patterns implemented in Java, demonstrating key principles of object-oriented design and software architecture.

## 📋 Table of Contents

- [Overview](#overview)
- [Design Patterns Implemented](#design-patterns-implemented)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Pattern Categories](#pattern-categories)
- [Contributing](#contributing)

## 🔍 Overview

This repository contains implementations of various design patterns that are essential for low-level design interviews and building scalable software systems. Each pattern is implemented with clear examples and follows best practices.

## 🎯 Design Patterns Implemented

### Behavioral Design Patterns
- **Command Pattern** - Encapsulates a request as an object
- **Iterator Pattern** - Provides sequential access to elements
- **Observer Pattern** - Defines one-to-many dependency between objects
- **State Pattern** - Allows object to alter behavior when internal state changes
- **Strategy Pattern** - Defines family of algorithms and makes them interchangeable
- **Template Method Pattern** - Defines skeleton of algorithm in base class

### Creational Design Patterns
- **Abstract Factory Pattern** - Creates families of related objects
- **Builder Pattern** - Constructs complex objects step by step
- **Factory Method Pattern** - Creates objects without specifying exact classes
- **Prototype Pattern** - Creates objects by cloning existing instances

### Structural Design Patterns
- **Adapter Pattern** - Allows incompatible interfaces to work together
- **Composite Pattern** - Composes objects into tree structures
- **Decorator Pattern** - Adds behavior to objects dynamically
- **Facade Pattern** - Provides simplified interface to complex subsystem
- **Proxy Pattern** - Provides placeholder/surrogate for another object

## 📁 Project Structure

```
LLDPATERNS/
├── src/
│   ├── BehaviouralDesignPattern/
│   │   ├── Command/
│   │   ├── Iterator/
│   │   ├── Observer/
│   │   ├── State/
│   │   ├── Strategy/
│   │   └── Template/
│   ├── CreationalPatterns/
│   │   ├── AbstractFactory/
│   │   ├── Builder/
│   │   ├── FactoryMethod/
│   │   └── Prototype/
│   └── StructuralDesignPattern/
│       ├── Adapter/
│       ├── Composite/
│       ├── Decorator/
│       ├── Facade/
│       └── Proxy/
├── .gitignore
└── README.md
```

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- IDE (IntelliJ IDEA, Eclipse, or VS Code)
- Basic understanding of Object-Oriented Programming

### Running the Code

1. Clone the repository:
```bash
git clone https://github.com/purushotham563/LLD.git
cd LLD
```

2. Open the project in your preferred IDE

3. Navigate to any pattern directory and run the main class to see the pattern in action

4. Each pattern contains:
   - Implementation classes
   - Example usage
   - Main method demonstrating the pattern

## 📚 Pattern Categories

### 🎭 Behavioral Patterns
Focus on communication between objects and the assignment of responsibilities between objects.

### 🏭 Creational Patterns  
Deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.

### 🏗️ Structural Patterns
Deal with object composition and typically identify simple ways to realize relationships between different objects.

## 💡 Key Learning Outcomes

- Understanding SOLID principles in practice
- Implementing design patterns for real-world scenarios
- Writing maintainable and extensible code
- Preparing for system design interviews
- Building scalable software architectures

## 🛠️ Technologies Used

- **Language**: Java
- **IDE**: IntelliJ IDEA
- **Version Control**: Git

## 📖 How to Use This Repository

1. **Study Each Pattern**: Start with the pattern category you're most interested in
2. **Run Examples**: Execute the main methods to see patterns in action
3. **Modify Code**: Try changing implementations to understand the flexibility
4. **Practice**: Implement variations or combine patterns for complex scenarios

## 🤝 Contributing

Contributions are welcome! If you'd like to add more patterns or improve existing implementations:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-pattern`)
3. Commit your changes (`git commit -m 'Add new pattern implementation'`)
4. Push to the branch (`git push origin feature/new-pattern`)
5. Open a Pull Request

## 📝 Notes

- Examples are designed to be simple yet comprehensive
- Code follows Java naming conventions and best practices
- Patterns are implemented to demonstrate core concepts clearly

## 🎯 Future Enhancements

- [ ] Add more behavioral patterns (Mediator, Chain of Responsibility)
- [ ] Include UML diagrams for each pattern
- [ ] Add real-world use case examples

## 📞 Contact

For questions or suggestions, feel free to reach out or create an issue in this repository.

---

⭐ **Star this repository if you find it helpful for your learning journey!**
