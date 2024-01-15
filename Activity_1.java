import java.util.*;

class Citizen{
    int age;
    Citizen(){
        this.age=new Random().nextInt(101);
    }
    
    public void new_citizen(int age){
        this.age=age;
    }
}

class City{
    List<Citizen> citizens;
    
    String cityName;
    City(String name,int num){
        this.citizens = new ArrayList<>();
        if(name == null || name.isEmpty()){
            this.cityName=generateName();
        }else{
            this.cityName=name;
        }
        
        for(int i=0;i<num;i++){
            citizens.add(new Citizen());
        }
    }
    
    public String generateName(){
        //generating random name
        StringBuilder randName = new StringBuilder();
        Random rand=new Random();
        
        for(int i=0;i<5;i++){
            char Char=(char) (rand.nextInt(26) + (int)'a');
            randName.append(Char);
        }
            return randName.toString();
    }
    
    public void addCitizen(){
        Citizen citizen = new Citizen();
        citizens.add(citizen);
    }
    
    public int totalCitizen(){
        return citizens.size();
    }
    
    
}

class World{
    List<City> cities;
    World(int num){
        this.cities=new ArrayList<>();
        for(int i=0;i<num;i++){
            cities.add(new City(null,num));
        }
    }
    
    public void addCity(String name,int num){
        City newCity=new City(name,num);
        cities.add(newCity);
    }
    
    public int totalCities(){
        return cities.size();
    }
}



class HelloWorld {
    public static void main(String[] args) {
        testForWorld();
        testTotalCity();
        testTotalCitizen();
        System.out.println("Test Passed");
        
    } 
        private static void testForWorld(){
            // number of cities passed
            World world=new World(5);
            assert world.totalCities()==5;
        }
        
        private static void testTotalCity(){
            World world=new World(5);
            // city name and number of citizen passed
            world.addCity("abcde",2);
            assert world.totalCities()==6;
        }
        
        private static void testTotalCitizen() {
            // city name and number of citizen passed
            City city = new City("TestCity",5);
            assert city.totalCitizen() ==5;
            // add citizen
            city.addCitizen();
            assert city.totalCitizen() ==6; 
        }
    
}