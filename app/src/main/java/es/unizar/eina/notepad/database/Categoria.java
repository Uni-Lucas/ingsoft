package es.unizar.eina.notepad.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Categoria")
public class Categoria {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "Nombre")
    private @NonNull String nombre;

    public Categoria(@NonNull String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
