// PROTO_PATHvar PROTO_PATH = "C:/Lichee/Develop/workspace/webstorm/grpc-node/proto/Student.proto";
// var grpc = require("grpc");
// var grpcService = grpc.load(PROTO_PATH).grpc;

//run command: node app/dynamic/grpcServer.js
var PROTO_PATH = __dirname + '/../../../../src/main/proto/Student.proto';
var grpc = require("grpc");
var protoLoader = require('@grpc/proto-loader');
var packageDefinition = protoLoader.loadSync(
    PROTO_PATH,
    {
        keepCase: true,
        longs: String,
        enums: String,
        defaults: true,
        oneofs: true
    });
var grpcService = grpc.loadPackageDefinition(packageDefinition).grpc;

var server = new grpc.Server();
server.addService(grpcService.StudentService.service, {
    getRealnameByUsername: getRealnameByUsername,
    getStudentsByAge: getStudentsByAge,
    getStudentsWrapperByAges: getStudentsWrapperByAges,
    biTalk: biTalk
});
server.bind("localhost:8899", grpc.ServerCredentials.createInsecure());
server.start();
console.log("GRPC node server started by dynamic!")

function getRealnameByUsername(call, callback) {
    console.log("收到客户端的请求信息: " + call.request.username);
    callback(null, {realname: "Node dynamic server: 里奇"});
}

function getStudentsByAge() {

}

function getStudentsWrapperByAges() {

}

function biTalk() {

}