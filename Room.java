public class Room {
	private boolean treasure;
	private boolean locked;
	private int keyLock;
	private boolean open;
	private String welcome;
	private Key[] keys;//unsure of use of this yet outside of storing key ids
	private String roomName;
	
  public Room(boolean a, boolean b, Key c,Key[]e,String g,String h) {
	  this.treasure = a;
	  this.locked = b;
	  this.keyLock = c.getID();
	  this.keys = e;
	  this.welcome = g;
	  this.roomName = h;
  }
  public boolean unlock(int key) {
	  if(key == keyLock) {
		  this.locked = false;
		  this.open = true;
		  return true;
	  }
	  else {
		  System.out.println("Not the right key");
		  return false;
	  }
  }
  public String getRoomName() {
	  return this.roomName;
  }
  public boolean getTreasure() {
	  return this.treasure;
  }
  public void setToLocked() {
	  this.locked = true;
  }
  public int getKeyLock() {
	  return this.keyLock;
  }
  public void printWelcome() {
	  System.out.println(this.welcome);
  }
  public boolean getLock() {
	  return this.locked;
  }
  public String available() {
	  if(this.locked == false) {
		  return "available";
	  }
	  return "locked";
  }
  public void printKeys() {
	  int i =0;
	  while(i<this.keys.length) {
		  System.out.println("You found key " + this.keys[i].getID());
		  i++;
	  }
  }
}
