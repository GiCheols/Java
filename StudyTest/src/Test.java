public class Test {
    class Apple{
        private Apple fruit;
    }
    class Banana{
        private Banana banana;
    }
    class FruitBox{
        private Object fruit;
        public FruitBox(Object fruit){
            this.fruit = fruit;
        }

        public Object getFruit(){
            return fruit;
        }
    }

    public static void main(String[] args) {
        FruitBox appleBox = new FruitBox(new Apple());
        FruitBox bananaBox = new FruitBox(new Banana());

        Apple apple = (Apple) appleBox.getFruit();
        Banana banana = (Banana) bananaBox.getFruit();
    }
}
