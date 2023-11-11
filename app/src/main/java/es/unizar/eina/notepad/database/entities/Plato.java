package es.unizar.eina.notepad.database.entities;

import static androidx.room.ForeignKey.CASCADE;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/** Clase anotada como entidad que representa una nota y que consta de título y cuerpo */
@Entity(tableName = "Plato",
        foreignKeys = @ForeignKey(entity = Categoria.class,
        parentColumns = "Nombre",
        childColumns = "Categoria",
        onDelete = CASCADE),
        indices ={@Index("Categoria")}
        )
public class Plato {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int id;

    @NonNull
    @ColumnInfo(name = "Nombre")
    private String nombre;
    @NonNull
    @ColumnInfo(name = "Ingredientes")
    private String ingredientes;
    @NonNull
    @ColumnInfo(name = "Precio")
    private Double precio;
    @NonNull
    @ColumnInfo(name = "Visible")
    private Boolean visible;
    @ColumnInfo(name = "Categoria")
    private String categoria;



    public Plato(@NonNull String nombre,@NonNull String ingredientes
            ,@NonNull Double precio,@NonNull Boolean visible) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.precio = precio;
        this.visible = visible;
    }

    /** Devuelve el identificador de la nota */
    public int getId(){
        return this.id;
    }

    /** Devuelve el nombre de un plato*/
    public String getNombre(){
        return this.nombre;
    }

    /** Devuelve los ingredientes de un plato */
    public String getIngredientes(){
        return this.ingredientes;
    }

    /** Devuelve los ingredientes de un plato */
    public Double getPrecio(){ return this.precio; }

    /** Devuelve si un plato es visible o no */
    public Boolean getVisible(){
        return this.visible;
    }

    /** Devuelve la categoria de un plato */
    public String getCategoria(){
        return this.categoria;
    }

    /** Permite actualizar el identificador de una nota */
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre){this.nombre = nombre;}

    public void setIngredientes(String ingredientes){this.ingredientes = ingredientes;}

    public void setPrecio(Double precio){this.precio = precio;}

    public void setVisible(Boolean visible){this.visible = visible;}

    public void setCategoria(String categoria){this.categoria = categoria;}
}
