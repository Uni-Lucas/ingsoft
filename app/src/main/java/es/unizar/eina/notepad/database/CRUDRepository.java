package es.unizar.eina.notepad.database;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import es.unizar.eina.notepad.database.entities.Pedido;
import es.unizar.eina.notepad.database.entities.Plato;

public class CRUDRepository {

    private CRUDDao mCRUDDao;
    private LiveData<List<Plato>> mAllPlatos;

    private LiveData<List<Pedido>> mAllPedidos;

    // Note that in order to unit test the NoteRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public CRUDRepository(Application application) {
        CRUDRoomDatabase db = CRUDRoomDatabase.getDatabase(application);
        mCRUDDao = db.CRUDDao();
        mAllPlatos = mCRUDDao.getAllPlatos();
        mAllPedidos = mCRUDDao.getAllPedidos();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Plato>> getAllPlatos() {
        return mAllPlatos;
    }

    public LiveData<List<Plato>> getOrderedPlatosBy(String filtro){return mCRUDDao.getOrderedPlatosBy(filtro);}
    /** Inserta una nota
     * @param plato
     * @return un valor entero largo con el identificador del plato que se ha creado.
     */
    public long insertPlato(Plato plato) {
        final long[] result = {0};
        // You must call this on a non-UI thread or your app will throw an exception. Room ensures
        // that you're not doing any long running operations on the main thread, blocking the UI.
        CRUDRoomDatabase.databaseWriteExecutor.execute(() -> {
            result[0] = mCRUDDao.insertPlato(plato);
        });
        return result[0];
    }

    /** Modifica una nota
     * @param plato
     * @return un valor entero con el número de filas modificadas.
     */
    public int updatePlato(Plato plato) {
        final int[] result = {0};
        CRUDRoomDatabase.databaseWriteExecutor.execute(() -> {
            result[0] = mCRUDDao.updatePlato(plato);
        });
        return result[0];
    }

    /** Elimina una nota
     * @param plato
     * @return un valor entero con el número de filas eliminadas.
     */
    public int deletePlato(Plato plato) {
        final int[] result = {0};
        CRUDRoomDatabase.databaseWriteExecutor.execute(() -> {
            result[0] = mCRUDDao.deletePlato(plato);
        });
        return result[0];
    }

    //Metodos para los pedidos
    public LiveData<List<Pedido>> getAllPedidos() {return mAllPedidos;}

    public LiveData<List<Pedido>> getOrderedPedidosBy(String filtro){return mCRUDDao.getOrderedPedidosBy(filtro);}
    /** Inserta una nota
     * @param pedido
     * @return un valor entero largo con el identificador del plato que se ha creado.
     */
    public long insertPedido(Pedido pedido) {
        final long[] result = {0};
        // You must call this on a non-UI thread or your app will throw an exception. Room ensures
        // that you're not doing any long running operations on the main thread, blocking the UI.
        CRUDRoomDatabase.databaseWriteExecutor.execute(() -> {
            result[0] = mCRUDDao.insertPedido(pedido);
        });
        return result[0];
    }

    /** Modifica una nota
     * @param pedido
     * @return un valor entero con el número de filas modificadas.
     */
    public int updatePedido(Pedido pedido) {
        final int[] result = {0};
        CRUDRoomDatabase.databaseWriteExecutor.execute(() -> {
            result[0] = mCRUDDao.updatePedido(pedido);
        });
        return result[0];
    }

    /** Elimina una nota
     * @param pedido
     * @return un valor entero con el número de filas eliminadas.
     */
    public int deletePedido(Pedido pedido) {
        final int[] result = {0};
        CRUDRoomDatabase.databaseWriteExecutor.execute(() -> {
            result[0] = mCRUDDao.deletePedido(pedido);
        });
        return result[0];
    }
}
