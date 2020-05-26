package luv.zoey.dotcom.Model


data class User(
    var UID : String,
    var ID : String,
    var PW : String,
    var Name : String,
    var PhoneNubmer : String,
    var Email : String,
    var UserPicture : String,
    var estimate : Estimate
)