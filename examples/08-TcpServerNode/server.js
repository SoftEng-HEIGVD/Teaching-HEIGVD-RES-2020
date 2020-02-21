// This is an example for a simple echo server implemented in Node.js. It
// demonstrates how to write single-threaded, asynchronous code that allows
// one server to talk to several clients concurrently. 
//
// readline is a module that gives us the ability to consume a stream line
// by line

var net = require('net');
var readline = require('readline');

// let's create a TCP server
var server = net.createServer();

// it can react to events: 'listening', 'connection', 'close' and 'error'
// let's register our callback methods; they will be invoked when the events
// occur (everything happens on the same thread)
server.on('listening', callbackFunctionToCallWhenSocketIsBound);
server.on('connection', callbackFunctionToCallWhenNewClientHasArrived);

// we are ready, so let's ask the server to start listening on port 9907
server.listen(9907);

// This callback method is invoked after the socket has been bound and is in
// listening mode. We don't need to do anything special.
function callbackFunctionToCallWhenSocketIsBound() {
	console.log("The socket is bound and the server is listening for connection requests.");
	console.log("Socket value: %j", server.address());
}

// This callback method is invoked after a client connection has been accepted.
// We receive the socket as a parameter. We have to attach a callback function to the
// 'data' event that can be raised on the socket.
function callbackFunctionToCallWhenNewClientHasArrived(socket) {
	
	// We wrap a readline interface around the socket IO streams; every byte arriving
	// on the socket will be forwarded to the readline interface, which will take care
	// of buffering the data and will look for end-of-line separators. We will not register
	// a callback handler on the socket (it is a possibility), but rather on the readline
	// interface. The 'line' events are raised whenever a new line is available.
	var rl = readline.createInterface({
	  input: socket,
	  output: socket
	});
	
	rl.on('line', callbackFunctionToCallWhenNewDataIsAvailable);
	
	// This callback method is invoked when new data is available on the socket
	// We can process it, which in our case simply means dumping it to the console
	function callbackFunctionToCallWhenNewDataIsAvailable(data) {
		console.log("Client has sent: " + data);
		if (data.toString().toUpperCase() == 'BYE') {
			console.log("Client has sent 'bye', closing connection...");
			socket.end();
		} else {
			socket.write(data.toString().toUpperCase() + '\n');						
		}
	}

  console.log('A client has arrived: ' + socket.remoteAddress + ":" + socket.remotePort);

}

