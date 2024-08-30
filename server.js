const net = require("net")

// Create a TCP server
const server = net.createServer((socket) => {
    console.log("Client connected")

    // When data is received from the client
    socket.on("data", (data) => {
        const receivedMessage = data.toString().trim()
        console.log(`Received: ${receivedMessage}`)

        const responseMessage = `${receivedMessage} echo`
        socket.write(responseMessage + "\r\n")
    })

    // When the client disconnects
    socket.on("end", () => {
        console.log("Client disconnected")
    })

    // Handle errors
    socket.on("error", (err) => {
        console.error(`Error: ${err.message}`)
    })
})

// Start the server on port 8080
server.listen(8080, () => {
    console.log("Server listening on port 8080")
})
