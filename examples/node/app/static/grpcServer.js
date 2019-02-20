//run command: node app/static/grpcServer.js
var messages = require("../../static_codegen/Student_pb");
var services = require("../../static_codegen/Student_grpc_pb");
var grpc = require('grpc');

var server = new grpc.Server();
server.addService(services.StudentServiceService, {
    getRealnameByUsername: getRealnameByUsername,
    getStudentsByAge: getStudentsByAge,
    getStudentsWrapperByAges: getStudentsWrapperByAges,
    biTalk: biTalk
});
server.bind("localhost:8899", grpc.ServerCredentials.createInsecure());
server.start();
console.log("GRPC node server started by static!")

function getRealnameByUsername(call, callback) {
    console.log("收到客户端的请求信息: " + call.request.getUsername());
    var httpResponse = new messages.HttpResponse();
    httpResponse.setRealname("Node static server: 里奇")
    callback(null, httpResponse);
}

function getStudentsByAge() {

}

function getStudentsWrapperByAges() {

}

function biTalk() {

}