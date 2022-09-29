public class TV {
    private String tvName;
    private boolean tvPower;
    private int tvChannel;
    private int tvVolume;

    public TV(String tvName){
        this.tvName = tvName;
        this.tvPower = false;
        this.tvChannel = 0;
        this.tvVolume = 5;
    }

    private String getTvName() {
        return tvName;
    }

    private boolean isTvPower() {
        return tvPower;
    }

    public void powerChange(){
        if(isTvPower()) {
            System.out.println(getTvName() + "TV를 끕니다");
            tvPower = false;
        }
        else {
            System.out.println(getTvName() + "TV를 켭니다");
            tvPower = true;
        }
    }

    private int getTvChannel() {
        return tvChannel;
    }

    private int getTvVolume() {
        return tvVolume;
    }

    public void channelUp(){
        if(isTvPower()){
            if(getTvChannel() >= 10)
                System.out.println("채널을 더 이상 올릴 수 없습니다.");
            else{
                this.tvChannel++;
                System.out.println("현재 TV 채널은 " + getTvChannel() + "입니다");
            }
        } else
            System.out.println("TV 전원이 꺼져 있습니다");
    }

    public void channelDown(){
        if(isTvPower()){
            if(getTvChannel() <= 0)
                System.out.println("채널을 더 이상 내릴 수 없습니다.");
            else{
                this.tvChannel--;
                System.out.println("현재 TV 채널은 " + getTvChannel() + "입니다");
            }
        } else
            System.out.println("TV 전원이 꺼져 있습니다");
    }

    public void volumeUp(){
        if(isTvPower()){
            if(getTvVolume() >= 10)
                System.out.println("볼륨을 더 이상 올릴 수 없습니다");
            else{
                this.tvVolume++;
                System.out.println("현재 TV 볼륨은 " + getTvVolume() +"입니다");
            }
        }
        else
            System.out.println("TV 전원이 꺼져 있습니다");
    }

    public void volumeDown(){
        if(isTvPower()){
            if(getTvVolume() <= 0)
                System.out.println("볼륨을 더 이상 낮출 수 없습니다.");
            else{
                this.tvVolume--;
                System.out.println("현재 TV 볼륨은 " + getTvVolume() + "입니다");
            }
        }
        else
            System.out.println("TV 전원이 꺼져 있습니다.");
    }
}
