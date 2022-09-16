
public class TV {
	boolean TVSwitch = false;
	int Channel = 1;
	int Volume = 5;
	static final int MAX_VOL = 10;
	static final int MAX_CHANNEL = 5;
	
	void pushPower() {
		if(TVSwitch == false) {
			System.out.println("TV를 켭니다.");
			TVSwitch = true;
		}
		else {
			System.out.println("TV를 끕니다.");
			TVSwitch = false;
		}
	}
	
	void channelUp() {
		if(Channel < MAX_CHANNEL) {
			System.out.println("채널 올림" + (Channel+1));
			Channel += 1;
		}
		else if(Channel == MAX_CHANNEL) {
			System.out.println("첫 채널로 돌아갑니다");
			Channel = 1;
		}
	}
	void channelDown() {
		if(Channel > 1) {
			System.out.println("채널 내림" + (Channel-1));
			Channel -= 1;
		}
		else if(Channel == 1) {
			System.out.println("끝 채널로 돌아갑니다");
			Channel = 5;
		}
	}
	
	void volumeUp() {
		if(Volume < MAX_VOL) {
			System.out.println("볼륨 올림" + (Volume + 1));
			Volume += 1;
		}
		else if(Volume == 10) {
			System.out.println("최대 볼륨에 도달하였습니다.");
			Volume = 10;
		}
	}
	
	void volumeDown() {
		if(Volume > 0) {
			System.out.println("볼륨 내림" + (Volume - 1));
			Volume -= 1;
		}
		else if(Volume == 0) {
			System.out.println("최소 볼륨에 도달하였습니다.");
			Volume = 0;
		}
	}
}
