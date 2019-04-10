//package com.hashcode.movieapp.data
//
//import android.arch.persistence.room.Database
//import android.arch.persistence.room.Room
//import android.arch.persistence.room.RoomDatabase
//import android.content.Context
//import com.hashcode.movieapp.network.data.BookMarkData
//
//
//@Database(entities = [BookMarkData::class], version = 2)
//abstract class BookMarkDatabase : RoomDatabase() {
//
//    abstract fun todoDataDao(): MovieDataDao
//
//    companion object {
//        private var INSTANCE: BookMarkDatabase? = null
//
//        fun getInstance(context: Context): BookMarkDatabase? {
//            if (INSTANCE == null) {
//                synchronized(BookMarkDatabase::class) {
//                    INSTANCE = Room.databaseBuilder(context.applicationContext,
//                        BookMarkDatabase::class.java, "movie_app")
//                        .build()
//                }
//            }
//            return INSTANCE
//        }
//
//        fun destroyInstance() {
//            INSTANCE = null
//        }
//    }
//}