var regLogin ={
    "phoneNum" : /^1([3456789])[0-9]\d{8}$/,
    "password" : /^[a-zA-Z0-9\x21-\x2f\x3a-\x40\x5b-\x60\x7B-\x7F]{8,20}$/,
} ;
var regRegister ={
    "userName" : /^[a-zA-Z0-9_-]{4,16}$/,
    "phoneNum" : /^1([3456789])[0-9]\d{8}$/,
    "password" : /^[a-zA-Z0-9\x21-\x2f\x3a-\x40\x5b-\x60\x7B-\x7F]{8,20}$/,
    "email" : /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/,
} ;