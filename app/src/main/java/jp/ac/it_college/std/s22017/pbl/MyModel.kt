package jp.ac.it_college.std.s22017.pbl

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class MyModel:RealmObject() {
    @PrimaryKey
    var id:Long = 0
    var name:String = ""
    var quantity:Long = 0
}