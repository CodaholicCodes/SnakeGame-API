
# 🐍 Snake Game (API Driven)

A modern take on the classic Snake Game where core logic such as movement, collision detection, and food generation are handled through APIs. This makes the game more modular and scalable for backend integration or multiplayer extension.

---

## 🚀 Features

- 🟢 Real-time Snake movement using keyboard input
- 🍎 Dynamic food spawning via API
- 🧱 Wall & self-collision detection handled through backend
- 💾 Game state saved & updated via RESTful APIs
- 📱 Responsive design – playable on mobile and desktop

---

## 🛠️ Tech Stack

| Frontend | Backend / API |
|----------|----------------|
| HTML, CSS, JavaScript | Node.js, Express.js |
| Canvas API | RESTful API Architecture |
| Axios (for HTTP calls) | JSON response handling |

---

## 📂 Project Structure

```
snake-game-api/
├── public/
│   ├── index.html
│   ├── style.css
│   └── script.js
├── server/
│   ├── app.js
│   └── routes/
│       └── game.js
├── README.md
└── package.json
```

---

## 📷 Demo

*Add your live demo or screenshots here.*

---

## 🧠 How It Works

- Player inputs are captured in real-time and sent to backend
- The backend responds with the new snake position, food, and collisions
- Game state is rendered frame-by-frame using updated data

---

## 🏁 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/snake-game-api
cd snake-game-api
```

### 2. Install Dependencies
```bash
npm install
```

### 3. Run Backend Server
```bash
node server/app.js
```

### 4. Open Frontend
Open `public/index.html` in your browser  
*(Ensure server is running on localhost:3000)*

---

## 🙋‍♂️ Author

**Kundan Singh**  
📫 [LinkedIn](https://www.linkedin.com/in/kundan-singh-27b93327a)  
🌐 [GitHub](https://github.com/CodaholicCodes)

---

## 📝 License

This project is licensed under the MIT License.
