

public class Player {
    String name;
    Player(String name){
        this.name = name;
    }
    int wins;
    int loses;
    String getName(){
        return name;
    }
    String getInformation(){
        return "Name: "+name+", Wins: "+wins+", Loses: "+loses;
    }
    void win(){
        System.out.println(getName()+" win!");
        wins++;
    }
    void lose(){
        loses++;
    }
}