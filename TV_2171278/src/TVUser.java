
public class TVUser {
	public static void main(String[] args) {
		TV tel = new TV();
		
		tel.pushPower();
		
		for(int i = 0; i < 5; i++)
			tel.channelUp();
		for(int i = 0; i < 5; i++)
			tel.channelDown();
		
		for(int i = 0; i < 10; i++)
			tel.volumeUp();
		for(int i = 0; i < 11; i++)
			tel.volumeDown();
		
		tel.pushPower();
	}
}
