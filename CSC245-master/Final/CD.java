

public class CD extends Multimedia {
	private double AudioTime;

	public CD(Info info, boolean status, double audioTime) {
		super(info, status);
		AudioTime = audioTime;
	}

	public double getAudioTime() {
		return AudioTime;
	}

	public void setAudioTime(double audioTime) {
		AudioTime = audioTime;
	}

	@Override
	public String toString() {
		String a = "Type: CD\t";
		a += info + "\tAvailability: " + status + "\tAudio Time: " + AudioTime;
		return a;
	}
}
