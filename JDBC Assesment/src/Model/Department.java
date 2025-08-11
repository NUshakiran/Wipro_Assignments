package Model;

public class Department {
			private int depId;
			private String depName;
			private String depLocation;
			
			
			public Department() {}

		    public Department(int deptId, String deptName, String location) {
		        this.depId = deptId;
		        this.depName = deptName;
		        this.depLocation = location;
		    }
			
			

			public int getDepId() {
				return depId;
			}
			public void setDepId(int depId) {
				this.depId = depId;
			}
			public String getDepName() {
				return depName;
			}
			public void setDepName(String depName) {
				this.depName = depName;
			}
			public String getDepLocation() {
				return depLocation;
			}
			public void setDepLocation(String depLocation) {
				this.depLocation = depLocation;
			}
			
			@Override
		    public String toString() {
				return "Department [deptId=" + depId + ", deptName=" + depName + ", location=" + depLocation + "]";
		    }
			
			
}

