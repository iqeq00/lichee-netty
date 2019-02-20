//run command: node app/static/grpcClient.js
var messages = require("../../static_codegen/Student_pb");
var services = require("../../static_codegen/Student_grpc_pb");
var grpc = require('grpc');

var client = new services.StudentServiceClient("localhost:8899",grpc.credentials.createInsecure());
var request = new messages.HttpRequest();
request.setUsername("Node static client: 里奇");
client.getRealnameByUsername(request, function (err, response) {
    console.log(response.getRealname());
    grpc.closeClient(client);
});






// function main() {
//
//     var request = new messages.HelloRequest();
//     var user;
//     if (process.argv.length >= 3) {
//         user = process.argv[2];
//     } else {
//         user = 'world';
//     }
//     request.setName(user);
//     client.sayHello(request, function(err, response) {
//         console.log('Greeting:', response.getMessage());
//     });
// }
//
// main();