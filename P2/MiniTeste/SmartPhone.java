class SmartPhone extends Device {
    long imei;
    public SmartPhone(double weight, long memory, long imei){
        super("Bravo de Esmolfe", weight, memory);
        this.imei=imei;
    }
    public long GetIMEI(){
        return imei;
    }
    public boolean isHeavy(){
        if(getWeight()>100){
            return true;
        }else{
            return false;
        }
    }



}
