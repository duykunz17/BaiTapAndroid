package se.iuh.baitap2;

import java.util.ArrayList;

public class Catalog extends Goods {
    private ArrayList<Product> listSp = null;
    public Catalog (String ma, String name){
        super(ma, name);
        this.listSp = new ArrayList<Product>();
    }

    public Catalog(){
        super();
        this.listSp = new ArrayList<Product>();
    }

    public boolean isDuplicate(Product p){
        for (Product p1: listSp) {
            if(p1.getId().trim().equalsIgnoreCase(p.getId().trim()))
                return true;
        }
        return false;
    }

    public boolean addProduct(Product p){
        boolean isDup = isDuplicate(p);
        if(!isDup){
            p.setDmuc(this);
            return listSp.add(p);
        }
        return !isDup;
    }

    public ArrayList<Product> getListProduct(){
        return this.listSp;
    }

    public int size(){
        return listSp.size();
    }

    public Product gte(int i){
        return listSp.get(i);
    }
}
