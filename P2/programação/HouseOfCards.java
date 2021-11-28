public class HouseOfCards {
   public static void main(String[] Args){
       int numOfCards=24;
       int necessaryCards=0;
       int maxLevel=0;
       Floor level=new Floor(1);
       for(int i=1;necessaryCards<=numOfCards;i++){
           level.setFloor(i);
           necessaryCards=level.calcNumOfCards();
           if(necessaryCards<=numOfCards){
            maxLevel=i;
            }
       }
       System.out.println(maxLevel);
   }
}
class Floor{
    private int floor=0;
    public Floor(int nfloor){
       this.floor=nfloor;
    }
    public void setFloor(int floor){
        this.floor=floor;
    }
    public int calcNumOfCards(){
        int floor=this.floor;
        int necessaryCards=0;
        while(floor>0){
            necessaryCards+=2*floor+floor-1;
            floor--;
        }
        return necessaryCards;
    }
}
