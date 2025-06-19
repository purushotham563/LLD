package CreationalPatterns.Builder;

public class MAIN {

    interface Builder{
        Builder buildWalls();
        Builder buildRoof();

        Object getResult();
    }
    static class WoodenHouseBuilder implements Builder{
        private WoodenHouseBuilder house = new WoodenHouseBuilder();
        @Override
        public Builder buildWalls() {
            return null;
        }

        @Override
        public Builder buildRoof() {
            return null;
        }

        @Override
        public WoodenHouseBuilder getResult() {
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
