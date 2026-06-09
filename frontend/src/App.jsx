import { useState } from "react";
import axios from "axios";
import "./index.css";

function App() {

  const [message, setMessage] = useState("");
  const [messages, setMessages] = useState([]);

  const sendMessage = async () => {

    await axios.post("http://localhost:8080/messages", {
      content: message
    });

    setMessages([...messages, message]);
    setMessage("");
  };

  return (
    <div className="container">

      <h1>Chat Application</h1>

      <div className="chat-box">

        {messages.map((msg, index) => (
          <p key={index} className="message">
            {msg}
          </p>
        ))}

      </div>

      <div className="input-area">

        <input
          type="text"
          placeholder="Type Your Message"
          value={message}
          onChange={(e) => setMessage(e.target.value)}
          onKeyDown={(e) => {
            if (e.key === "Enter") {
              sendMessage();
            }
          }}
        />

        <button onClick={sendMessage}>
          Send
        </button>

      </div>

    </div>
  );
}

export default App;