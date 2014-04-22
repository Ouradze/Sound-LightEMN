package sound;

import ddf.minim.*;

public class MusicFile {
	private String path;
	
	public MusicFile(String path) {
		this.path = path;
	}

	public String getPath() {
		return this.path;
	}
}
