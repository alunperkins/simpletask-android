package nl.mpcjanssen.simpletask.dao

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update

const val SCHEMA_VERSION = 1013
const val DB_FILE = "TodoFiles_v1.db"

@Entity
data class TodoFile(
    @PrimaryKey var contents: String,
    @ColumnInfo var name: String,
    @ColumnInfo var date: Long
)

@Dao
interface TodoFileDao {
    @Query("SELECT * FROM TodoFile")
    fun getAll(): List<TodoFile>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(contents: TodoFile): Long

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun update(contents: TodoFile)

    @Query("DELETE from TodoFile where date < :timestamp")
    fun removeBefore(timestamp: Long)

    @Query("DELETE from TodoFile")
    fun deleteAll()


}

@Database(entities = arrayOf(TodoFile::class), version = SCHEMA_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoFileDao(): TodoFileDao
}





