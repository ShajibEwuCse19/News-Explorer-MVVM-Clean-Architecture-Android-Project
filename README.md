
# MVVM Clean Architecture – Android Project

A fully structured Android project implementing **MVVM (Model–View–ViewModel)** with **Clean Architecture principles**.
This project focuses on scalability, separation of concerns, and maintainable code structure.

---

## 📐 Architecture Overview

The project follows **MVVM + Clean Architecture**, separating responsibilities into independent layers:

```
app/
├── data/               # Data Layer
│   ├── api/            # Retrofit API interfaces
│   ├── model/          # Data models / DTOs
│   ├── repository/     # Repository implementations
│   └── local/          # Room database / local data sources
│
├── domain/             # Domain Layer (business logic)
│   ├── model/          # Domain entities
│   ├── repository/     # Repository interfaces (contracts)
│   └── usecase/        # Use cases / Interactors
│
└── presentation/       # Presentation Layer (UI)
    ├── view/           # Activities & Fragments
    ├── viewmodel/      # ViewModels
    └── adapter/        # RecyclerView Adapters
```

---

## 🧱 Layer Responsibilities

### 1️⃣ Data Layer

Responsible for handling all data sources (remote & local).

* **API**: Retrofit service interfaces for network communication
* **Repository Implementation**: Implements domain repository contracts
* **Local Source**: Room database & DAO definitions
* Maps DTO → Domain models

---

### 2️⃣ Domain Layer

Core business logic layer.

* Pure Kotlin (No Android framework dependencies)
* Defines repository interfaces
* Contains use cases (single responsibility per action)
* Completely independent and testable

---

### 3️⃣ Presentation Layer

Handles UI logic and user interaction.

* **ViewModel**: Manages UI state
* **Activity / Fragment**: Observes state and renders UI
* Uses `LiveData` / `StateFlow`
* No business logic inside UI

---

## 🔄 Data Flow

```
View (Activity/Fragment)
        ↓
ViewModel
        ↓
Use Case
        ↓
Repository Interface
        ↓
Repository Implementation
        ↓
Remote API / Local Database
```

Unidirectional flow ensures better testability and maintainability.

---

## 🛠️ Tech Stack

| Category             | Technology                |
| -------------------- | ------------------------- |
| Language             | Kotlin                    |
| Architecture         | MVVM + Clean Architecture |
| Dependency Injection | Dagger                    |
| Networking           | Retrofit + OkHttp         |
| Asynchronous         | Kotlin Coroutines + Flow  |
| UI State             | LiveData / StateFlow      |
| Local Database       | Room                      |
| Image Loading        | Glide                     |
| Testing              | JUnit                     |

---

## 📦 Key Concepts Implemented

### ✔ ViewModel

* Lifecycle-aware
* Survives configuration changes
* Exposes immutable UI state
* Uses `viewModelScope` for coroutines

```kotlin
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _users = MutableStateFlow<UiState<List<User>>>(UiState.Loading)
    val users: StateFlow<UiState<List<User>>> = _users

    fun fetchUsers() {
        viewModelScope.launch {
            getUsersUseCase().collect { result ->
                _users.value = result.toUiState()
            }
        }
    }
}
```

---

### ✔ Use Case

* Represents a single business action
* Decouples ViewModel from repository logic

```kotlin
class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<Result<List<User>>> {
        return repository.getUsers()
    }
}
```

---

### ✔ Repository Pattern

* Interface defined in domain layer
* Implementation lives in data layer

```kotlin
interface UserRepository {
    fun getUsers(): Flow<Result<List<User>>>
}

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserRepository {

    override fun getUsers(): Flow<Result<List<User>>> = flow {
        emit(Result.Success(apiService.getUsers().map { it.toDomain() }))
    }.catch {
        emit(Result.Error(it.message ?: "Unknown error"))
    }
}
```

---

## 🚀 Getting Started

1. Clone the repository:

```bash
git clone git@github.com:ShajibEwuCse19/mvvm-using-kotlin-practice1.git
```

2. Open in Android Studio
3. Sync Gradle
4. Run on emulator/device

---

## 🎯 Project Goals

* Practice scalable Android architecture
* Understand separation of concerns
* Implement clean dependency management
* Improve testability
* Work with structured coroutine flows

---
