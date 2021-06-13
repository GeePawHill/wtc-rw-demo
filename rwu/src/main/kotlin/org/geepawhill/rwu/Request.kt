package org.geepawhill.rwu


enum class Command {
    LAUNCH
    ;
}

open class Request(val robot: String,val command: Command,val arguments: Array<Any>)

class Launch(robot:String,kind:String,maxShields:Int,maxHits:Int) : Request(robot, Command.LAUNCH,arrayOf(kind,maxShields,maxHits))

enum class Result {
    OK,
    ERROR
}

enum class Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST
}

enum class Status {
    RELOADING,
    REPAIRING,
    SETMINE,
    NORMAL,
    DEAD
}

typealias Data = Map<String,Any>

class State(val x:Int,val y:Int,direction:Direction,shields:Int,shots:Int,status:Status)

open class Response(val result:Result, val data:Data,val state:State? = null)

class LaunchResponse(data:Data,state:State) : Response(Result.OK,data,state)

class ErrorResponse(msg:String) : Response(Result.ERROR,mapOf("message" to msg))

