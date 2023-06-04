package models;

import java.io.Serializable;
import java.util.UUID;

public class ModeloBase implements Serializable {

    protected String id;

    public ModeloBase(){
        this.id = UUID.randomUUID().toString();
    }

    public ModeloBase clone(){
        ModeloBase clone = new ModeloBase();
        clone.id = this.id;
        return clone;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public boolean equals(Object o){
        //Verifica se os objetos comparados são da mesma classe E se possuem o mesmo id
        return o.getClass().equals(this.getClass()) && this.id.equals(((ModeloBase) o).getId());
    }

    @Override
    public String toString(){
        return "Id: " + this.id;
    }

}
