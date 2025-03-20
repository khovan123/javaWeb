<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Chat App</title>
        <style>
            #chat-container {
                width: 800px;
                margin: 50px auto;
                display: flex;
            }
            #friends-list {
                width: 200px;
                border: 1px solid #ccc;
                padding: 10px;
            }
            #friends-list ul {
                list-style: none;
                padding: 0;
            }
            #friends-list li {
                cursor: pointer;
                padding: 5px;
            }
            #friends-list li:hover {
                background: #f0f0f0;
            }
            #chat-box {
                flex-grow: 1;
                height: 300px;
                border: 1px solid #ccc;
                overflow-y: scroll;
                padding: 10px;
            }
            input, button {
                margin: 5px 0;
                padding: 5px;
            }
        </style>
    </head>
    <body>
        <div id="chat-container">
            <div id="friends-list">
                <h3>Friends</h3>
                <ul>
                    <c:forEach var="friend" items="${friends}">
                        <li onclick="openChat('${friend.getId()}')">${friend.getUsername()}</li>
                    </c:forEach>
                </ul>
            </div>
            <div id="chat-box"></div>
            <input type="text" id="message" placeholder="Type a message">
            <button onclick="sendMessage()">Send</button>
        </div>
        <script>
            const currentUserId = ${userId};
            let ws = null;
            let currentRoomId = null;

            function openChat(friendId) {
                if (ws) {
                    ws.close(); // Đóng kết nối cũ nếu có
                }
                // Tạo roomId dựa trên currentUserId và friendId
                currentRoomId = "room_" + Math.min(currentUserId, friendId) + "_" + Math.max(currentUserId, friendId);
                ws = new WebSocket("ws://localhost:8080/WebSocketChat/chatendpoint/" + currentRoomId);

                ws.onopen = function () {
                    console.log("Connected to room: " + currentRoomId); // Debug
                };

                ws.onmessage = function (event) {
                    let chatBox = document.getElementById("chat-box");
                    chatBox.innerHTML += "<p>" + event.data + "</p>";
                    chatBox.scrollTop = chatBox.scrollHeight;
                };

                ws.onerror = function (error) {
                    console.error("WebSocket error: ", error); // Debug lỗi
                };

                document.getElementById("chat-box").innerHTML = ""; // Xóa nội dung chat cũ
            }

            function sendMessage() {
                let message = document.getElementById("message").value;
                if (ws && message) {
                    // Gửi tin nhắn với định dạng "currentUserId:content"
                    ws.send(currentUserId + ": " + message);
                    document.getElementById("message").value = "";
                } else {
                    console.log("WebSocket chưa sẵn sàng hoặc tin nhắn rỗng");
                }
            }
        </script>
    </body>
</html>