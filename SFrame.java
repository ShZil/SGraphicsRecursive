import java.awt.Graphics;

class SFrame {
	SPixelGrid pg;
	// this is still here so you can decide which array to keep
	SObject[] objects = new SObject[256];
	// the new array object,
	// courtesy of the apature labratories computer science department
	// SArray altArray = new SArray();

	public SFrame(int w, int h) {
		pg = new SPixelGrid(w, h);
	}


	// how about no
	// How about why not
	public void addObject(SObject obj) {
		SObject[] arr = SUtil.replaceSingleNull(this.objects, obj);
		if (arr == null) {
			// you could print that, or you could use an exception like normal people
			// System.out.println("The Array is Full! Increase the size or remove elements");
			// System.out.println(objects);
			// System.out.println(SUtil.arrayToString(objects));
		} else {
			this.objects = arr;
			// System.out.println("Item: "+obj.toString()+" was added successfully to Frame");
			// System.out.println(objects);
			// System.out.println(SUtil.arrayToString(objects));
		}
	}

	// ok this is better imo
	// public void add(SObject obj){
	// 	this.altArray.append(obj);
	// }

	public void evaluatePixelGrid() {
		for (SObject o : objects) {
			if (o == null) break;
			pg.drawObject(o);
			System.out.println("Object (" + o.toString() + ") was added.");
		}
	}

	public void render(Graphics gr) {
		// System.out.println("SFrame.render(): "+gr);
		System.out.println(pg.toString());
		pg.render(gr);
	}

	public SFrame copy() {
		int w = this.pg.width;
		int h = this.pg.height;
		SFrame frame = new SFrame(w, h);
		frame.objects = SUtil.copyArray(this.objects);
		return frame;
	}

	public void print(){
		// for (SObject obj : this.objects){
		// 	System.out.println(obj);
		// 	System.out.println(SUtil.arrayToString(obj)); }
		System.out.println(SUtil.arrayToString(this.objects));
		System.out.println("Click on the Frame to Repaint!");
	}
}
