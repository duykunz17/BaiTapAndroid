package se.iuh.baitap2;

public class Product extends Goods {
    private Catalog Dmuc;

    public Catalog getDmuc() {
        return Dmuc;
    }

    public void setDmuc(Catalog dmuc) {
        Dmuc = dmuc;
    }

    public Product(String id, String name, Catalog dmuc) {
        super(id, name);
        Dmuc = dmuc;
    }

    public Product(Catalog dmuc) {
        Dmuc = dmuc;
    }
    public Product(){
        super();
    }
}
