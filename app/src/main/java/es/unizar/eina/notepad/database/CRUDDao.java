package es.unizar.eina.notepad.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.unizar.eina.notepad.database.entities.Pedido;
import es.unizar.eina.notepad.database.entities.Plato;

/** Definición de un Data Access Object para las notas */
@Dao
public interface CRUDDao {
    //Metodos para la insercion, modificacion y eliminacion de un plato, ademas de su visualizacion
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertPlato(Plato plato);
    @Update
    int updatePlato(Plato plato);
    @Delete
    int deletePlato(Plato plato);
    @Query("DELETE FROM Plato")
    void deleteAllPlatos();
    @Query("SELECT * FROM Plato")
    LiveData<List<Plato>> getAllPlatos();
    @Query("SELECT * FROM Plato ORDER BY :filtro ASC")
    LiveData<List<Plato>> getOrderedPlatosBy(String filtro);

    //Metodos para la insercion, modificacion y eliminacion de un pedido, ademas de su visualizacion
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertPedido(Pedido pedido);
    @Update
    int updatePedido(Pedido pedido);
    @Delete
    int deletePedido(Pedido pedido);
    @Query("DELETE FROM Pedido")
    void deleteAllPedidos();
    @Query("SELECT * FROM Pedido")
    LiveData<List<Pedido>> getAllPedidos();
    @Query("SELECT * FROM Pedido ORDER BY :filtro ASC")
    LiveData<List<Pedido>> getOrderedPedidosBy(String filtro);
}

