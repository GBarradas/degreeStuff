public class Temperature {
    private double t=0.0;
    public void setCelsius(double t){
        this.t=t;
    }
    public double toFahrenheit(){
        return 1.8*t+32;
    }
    public void setFahrenheit(double fahrenheit){
        setCelsius((fahrenheit-32)/1.8);
    }
    public double toCelsius(){
        return t;
    }
    public static void main(String[] args){
        Temperature temp=new Temperature();
        temp.setCelsius(0);
        System.out.println("0ºC="+ temp.toFahrenheit()+ "ºF.");
        temp.setFahrenheit(32);
        System.out.println("32ºF="+ temp.toCelsius()+ "ºC.");
    }
}
