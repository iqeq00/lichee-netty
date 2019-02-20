// PROTO_PATHvar PROTO_PATH = "C:/Lichee/Develop/workspace/webstorm/grpc-node/proto/Student.proto";
// var grpc = require("grpc");
// var grpcService = grpc.load(PROTO_PATH).grpc;

//run command: node app/dynamic/grpcClient.js
var PROTO_PATH = __dirname + '/../../../../src/main/proto/Student.proto';
var grpc = require('grpc');
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

var client = new grpcService.StudentService("localhost:8899", grpc.credentials.createInsecure());
client.getRealnameByUsername({username: "Node dynamic client: 里奇"}, function (error, respData) {
    console.log("收到服务器的返回信息: " + respData.realname);
    grpc.closeClient(client);
});