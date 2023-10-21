package Engine;

public class Frames {
	private int frames,maxFrames,index,maxIndex;
	
	public Frames(int maxIndex,int maxFrames) {
		this.maxIndex=maxIndex;
		this.maxFrames=maxFrames;
	}
	
	public void setIndex(int index) {
		this.index=index;
	}
	
	public void setFrames(int frames) {
		this.frames=frames;
	}
	
	public int getFrames() {
		return frames;
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getMaxFrames() {
		return maxFrames;
	}
	
	public int getMaxIndex() {
		return maxIndex;
	}
	
	public void update() {
		setFrames(getFrames()+1);
		if(getFrames() >= getMaxFrames()) {
			setFrames(0);
			setIndex(getIndex()+1);
			if(getIndex() >= getMaxIndex()) {
				setIndex(0);
			}
		}
	}
}