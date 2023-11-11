package es.unizar.eina.notepad.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import es.unizar.eina.notepad.database.entities.Categoria;
import es.unizar.eina.notepad.database.entities.Estado;
import es.unizar.eina.notepad.database.entities.Pedido;
import es.unizar.eina.notepad.database.entities.Plato;

@Database(entities = {Plato.class, Categoria.class, Pedido.class, Estado.class}, version = 2, exportSchema = false)
public abstract class CRUDRoomDatabase extends RoomDatabase {

    public abstract CRUDDao CRUDDao();

    private static volatile CRUDRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static CRUDRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CRUDRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    CRUDRoomDatabase.class, "M16comidas_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more notes, just add them.
                CRUDDao dao = INSTANCE.CRUDDao();
                dao.deleteAllPlatos();

                Plato plato = new Plato("Spaghetti con tomate", "Spaghetti, tomate", 10.0, true);
                dao.insertPlato(plato);
            });
        }
    };

}
