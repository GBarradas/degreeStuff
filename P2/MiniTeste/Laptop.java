

class Laptop extends Device{
    boolean RISC;
    boolean CISC;
    public Laptop(String brand, double weight, boolean risc){
        super(brand,weight,32768);
        if(risc){
            this.RISC=true;
            this.CISC=false;
        }else{
            this.RISC=false;
            this.CISC=true;
        }

    }
    public boolean isRISC(){
        return RISC;
    }
    public boolean  isHeavy(){
        if(getWeight()>750){
            return true;
        }else{
            return false;
        }
    }

}