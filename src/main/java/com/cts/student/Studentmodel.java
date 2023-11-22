package com.cts.student;

public class Studentmodel {
	
		private int Id;    
		private String Name;
	    private double Score;
	    
		public Studentmodel(int Id, String Name, double Score) {
			this.Id = Id;
			this.Name = Name;
			this.Score = Score;
		}
		
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			this.Id = Id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			this.Name = Name;
		}
		public double getScore() {
			return Score;
		}
		public void setScore(double score) {
			this.Score = Score;
		}

}
