


	public class Hosting {

	

		public Integer myId;
	    public Integer getMyId() {
			return myId;
		}

		public void setMyId(Integer myId) {
			this.myId = myId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getWebsites() {
			return websites;
		}

		public void setWebsites(long websites) {
			this.websites = websites;
		}

		public String name;
	    public long websites;

	    public Hosting(int id, String name, long websites) {
	        myId = id;
	        this.name = name;
	        this.websites = websites;
	    }
}
