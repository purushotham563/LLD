package CreationalPatterns.Builder;
public class BP {
    enum CarType{
        CITY_CAR,SPORTS_CAR,SUV
    }
    enum Transmission{
        SINGLE_SPEED,MANUAL,AUTOMATIC,SEMI_AUTOMATIC
    }
    static class Engine{
        private boolean start;
        private double mileage;
        private double volume;

        public Engine(double mileage, double volume) {
            this.mileage = mileage;
            this.volume = volume;
        }
        public void on(){ start=true;}
        public void off(){start=false;}
        public boolean isStarted(){return start;}

        public double getMileage() {
            return mileage;
        }

        public double getVolume() {
            return volume;
        }
        public void go(double mileage){
            if(start)this.mileage+=mileage;
            else System.err.println("cannot go you must start the engine");

        }
    }
    static class TripComputer{
        private Car car;
        public void setCar(Car car){this.car=car;}
        public void showFuel(){System.out.println("Fuel Level"+car.getFuel());}
        public void showStatus(){System.out.println("car is"+(this.car.getEngine().isStarted()?"stared":"not stared"));}

    }
    static class GPSNavigator{
        private String route;
        public GPSNavigator() { this.route = "221b, Baker Street, London to Scotland Yard, 8-10 Broadway, London"; }
        public GPSNavigator(String manualRoute) { this.route = manualRoute; }
        public String getRoute(){
            return route;
        }
    }

    static class Car{
        private final CarType carType;
        private final int seats;
        private final Engine engine;
        private final Transmission transmission;
        private final  TripComputer tripComputer;
        private final GPSNavigator gpsNavigator;
        private double fuel=0;

        private Car(CarType carType, int seats, Engine engine, Transmission transmission, TripComputer tripComputer, GPSNavigator gpsNavigator) {
            this.carType = carType;
            this.seats = seats;
            this.engine = engine;
            this.transmission = transmission;
            this.tripComputer = tripComputer;
            if (this.tripComputer != null) {
                this.tripComputer.setCar(this);
            }
            this.gpsNavigator = gpsNavigator;
        }

        public CarType getCarType() {
            return carType;
        }

        public int getSeats() {
            return seats;
        }

        public Engine getEngine() {
            return engine;
        }

        public Transmission getTransmission() {
            return transmission;
        }

        public TripComputer getTripComputer() {
            return tripComputer;
        }

        public GPSNavigator getGpsNavigator() {
            return gpsNavigator;
        }

        public double getFuel() {
            return fuel;
        }

        public void setFuel(double fuel) {
            this.fuel = fuel;
        }

    }
    static class Manual {
        private final CarType carType;
        private final int seats;
        private final Engine engine;
        private final Transmission transmission;
        private final TripComputer tripComputer;
        private final GPSNavigator gpsNavigator;

        public Manual(CarType carType, int seats, Engine engine, Transmission transmission,
                      TripComputer tripComputer, GPSNavigator gpsNavigator) {
            this.carType = carType;
            this.seats = seats;
            this.engine = engine;
            this.transmission = transmission;
            this.tripComputer = tripComputer;
            this.gpsNavigator = gpsNavigator;
        }

        public String print() {
            String info = "";
            info += "Type of car: " + carType + "\n";
            info += "Count of seats: " + seats + "\n";
            info += "Engine: volume - " + engine.getVolume() + "; mileage - " + engine.getMileage() + "\n";
            info += "Transmission: " + transmission + "\n";
            info += "Trip Computer: " + (this.tripComputer != null ? "Functional" : "N/A") + "\n";
            info += "GPS Navigator: " + (this.gpsNavigator != null ? "Functional" : "N/A") + "\n";
            return info;
        }
    }
    interface Builder{
        void setCarType(CarType type);
        void setSeats(int seats);
        void setEngine(Engine engine);
        void setTransmission(Transmission transmission);
        void setTripComputer(TripComputer tripComputer);
        void setGPSNavigator(GPSNavigator gpsNavigator);

    }
    static class carBuilder implements Builder{
        private CarType type;
        private int seats;
        private Engine engine;
        private Transmission transmission;
        private TripComputer tripComputer;
        private GPSNavigator gpsNavigator;

        public void setCarType(CarType type) { this.type = type; }
        public void setSeats(int seats) { this.seats = seats; }
        public void setEngine(Engine engine) { this.engine = engine; }
        public void setTransmission(Transmission transmission) { this.transmission = transmission; }
        public void setTripComputer(TripComputer tripComputer) { this.tripComputer = tripComputer; }
        public void setGPSNavigator(GPSNavigator gpsNavigator) { this.gpsNavigator = gpsNavigator; }
         public  Car getResult(){
            return new Car(type,seats,engine,transmission,tripComputer,gpsNavigator);
        }
    }
    static class CarManualBuilder implements Builder {
        private CarType type;
        private int seats;
        private Engine engine;
        private Transmission transmission;
        private TripComputer tripComputer;
        private GPSNavigator gpsNavigator;

        public void setCarType(CarType type) { this.type = type; }
        public void setSeats(int seats) { this.seats = seats; }
        public void setEngine(Engine engine) { this.engine = engine; }
        public void setTransmission(Transmission transmission) { this.transmission = transmission; }
        public void setTripComputer(TripComputer tripComputer) { this.tripComputer = tripComputer; }
        public void setGPSNavigator(GPSNavigator gpsNavigator) { this.gpsNavigator = gpsNavigator; }

        public Manual getResult() {
            return new Manual(type, seats, engine, transmission, tripComputer, gpsNavigator);
        }
    }
    static class Director{
        public void constructSportsCar(Builder builder){
            builder.setCarType(CarType.SPORTS_CAR);
            builder.setSeats(2);
            builder.setEngine(new Engine(3,0));
            builder.setTransmission(Transmission.SEMI_AUTOMATIC);
            builder.setTripComputer(new TripComputer());
            builder.setGPSNavigator(new GPSNavigator());

        }
        public void constructCityCar(Builder builder) {
            builder.setCarType(CarType.CITY_CAR);
            builder.setSeats(2);
            builder.setEngine(new Engine(1.2, 0));
            builder.setTransmission(Transmission.AUTOMATIC);
            builder.setTripComputer(new TripComputer());
            builder.setGPSNavigator(new GPSNavigator());
        }

        public void constructSUV(Builder builder) {
            builder.setCarType(CarType.SUV);
            builder.setSeats(4);
            builder.setEngine(new Engine(2.5, 0));
            builder.setTransmission(Transmission.MANUAL);
            builder.setGPSNavigator(new GPSNavigator());
        }
    }




    public static void main(String[] args) {
       Director director=new Director();

        carBuilder builder = new carBuilder();
        director.constructSportsCar(builder);
        Car sportsCar = builder.getResult();
        carBuilder car1=new carBuilder();

    }
}
