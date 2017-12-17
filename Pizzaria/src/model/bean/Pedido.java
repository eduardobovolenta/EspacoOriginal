
package model.bean;

/**
 *
 * @author Samuelson
 */
public class Pedido {
    //Recebe os atributos do banco de dados
    public int id;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + '}';
    }
    
}
