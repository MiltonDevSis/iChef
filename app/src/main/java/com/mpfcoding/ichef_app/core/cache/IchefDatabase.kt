package com.mpfcoding.ichef_app.core.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mpfcoding.ichef_app.core.cache.dao.LaunchDao
import com.mpfcoding.ichef_app.core.cache.entity.LaunchEntity

@Database(
    entities = [
        LaunchEntity::class
    ], version = 1, exportSchema = false
)
abstract class IchefDatabase : RoomDatabase() {

    abstract fun launchDao(): LaunchDao

    companion object {

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE tableName ADD COLUMN param TEXT NOT NULL DEFAULT ''")

                database.execSQL("ALTER TABLE tableName ADD COLUMN param INTEGER ")
                database.execSQL("ALTER TABLE tableName ADD COLUMN param TEXT")
            }
        }

        const val DATABASE_NAME: String = "ichef_db"
    }
}